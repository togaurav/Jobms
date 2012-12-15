package com.framework.core.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.framework.core.querybuilder.hql.model.query.QueryCriterion;
import com.framework.core.querybuilder.hql.model.sort.SortCriterion;
import com.framework.core.querybuilder.hql.pagination.PaginationSupport;


/**
 * 功能:HibernateTemplate包装类
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20095:20:17 PM
 */
public class DefaultHibernateTemplate extends HibernateTemplate {
	private static final Log log = LogFactory.getLog(DefaultHibernateTemplate.class);
	
	public DefaultHibernateTemplate(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
    
	//-------------------------------------------------------------------------
	// Convenience methods for executeUpdate
	//-------------------------------------------------------------------------
	
	public int executeUpdate(final String queryString) throws DataAccessException {
		return ((Integer) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				return new Integer(queryObject.executeUpdate());
			}
		})).intValue();
	}
	
	public int executeUpdate(final String queryString, final Object[] values) throws DataAccessException {
		return ((Integer) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
					}
				}
				return new Integer(queryObject.executeUpdate());
			}
		})).intValue();
	}
    
	public int executeUpdate(final String queryString, final String[] paramNames, final Object[] values)
			throws DataAccessException {
		Assert.assertTrue("Length of paramNames array must match length of values array",paramNames.length == values.length);
		return ((Integer) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(paramNames[i], values[i]);
					}
				}
				return new Integer(queryObject.executeUpdate());
			}
		})).intValue();
	}
	
	//-------------------------------------------------------------------------
	// Convenience methods for remove/load Object
	//-------------------------------------------------------------------------
	
	public Object loadById(Class entityClass, Serializable id) throws DataAccessException {
		return id != null ? super.load(entityClass, id) : null;
	}
	
	public List loadById(final Class entityClass, final Serializable[] ids) throws DataAccessException {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		return (List) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				return session.createCriteria(entityClass)
					.add(Restrictions.in(session.getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName(), ids))
					.list();
	        }
	    });
	}
	
	public List loadById(final Class entityClass, final List ids) throws DataAccessException {
		if (ids == null || ids.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		return (List) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				return session.createCriteria(entityClass)
					.add(Restrictions.in(session.getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName(), ids))
					.list();
	        }
	    });
	}
	
	public void remove(Class entityClass, Serializable id) throws DataAccessException {
		if (id == null) {
			return;
		}
		Object entity = loadById(entityClass, id);
		if (null != entity) {
			super.delete(entity);
		}
	}
	
	public void remove(final Class entityClass, final Serializable[] ids) throws DataAccessException {
		executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO switch to Bulk DELETE 
				if (ids != null && ids.length > 0) {
					for (int i = 0; i < ids.length; i++) {
						remove(entityClass, ids[i]);
					}
				}
				return null;
			}
		});
	}
	
    //-------------------------------------------------------------------------
	// Convenience finder methods for persistent Class
	//-------------------------------------------------------------------------

	public List findAllSorted(final Class entityClass, final String sortField) throws DataAccessException {
		return (List) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(entityClass);
				prepareCriteria(criteria);
	            criteria.addOrder(Order.asc(sortField));
	            return criteria.list();
	        }
	    });
	}
	
	public List findAllSorted(final Class entityClass, final SortCriterion sortCriterion)
			throws DataAccessException {
		return (List) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(entityClass);
				prepareCriteria(criteria);
				if (sortCriterion != null) {
					criteria.addOrder(sortCriterion.isAscending()
							? Order.asc(sortCriterion.getField())
							: Order.desc(sortCriterion.getField()));
				}
				return criteria.list();
			}
		});
	}
	
	public List find(final Class entityClass, final PaginationSupport ps) throws DataAccessException {
        return (List) executeWithNativeSession(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                String shortClassName = StringUtils.uncapitalize(ClassUtils.getShortClassName(entityClass));
                String queryString = applyPaginationSorter(ps, "from " + entityClass.getName() + " " + shortClassName);
                
                Query queryObject = session.createQuery(queryString);
                prepareQuery(queryObject);
                applyPagination(ps, queryObject, count(applyCountPrefix(queryString), null));

                return queryObject.list();
            }
        });
    }
	
    //-------------------------------------------------------------------------
	// Convenience finder methods for HQL strings
	//-------------------------------------------------------------------------
	
	public List find(final String queryString, final Object[] values, final PaginationSupport ps)
			throws DataAccessException {
        return (List) executeWithNativeSession(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
            	String queryStringValue = applyPaginationSorter(ps, queryString);
            	
            	Query queryObject = session.createQuery(queryStringValue);
            	prepareQuery(queryObject);
                if (values != null) {
                    for (int i = 0; i < values.length; i++) {
                        queryObject.setParameter(i, values[i]);
                    }
                }
                
                // set ps#setTotalCount() explicitly
                applyPagination(ps, queryObject);
                return queryObject.list();
            }
        });
    }
	
	public List find(final String queryString, final PaginationSupport ps) throws DataAccessException {
		return (List) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String queryStringValue = applyPaginationSorter(ps, queryString);
				Query queryObject = session.createQuery(queryStringValue);
				prepareQuery(queryObject);

				// set ps#setTotalCount() explicitly
				applyPagination(ps, queryObject);
				return queryObject.list();
			}
		});
	}
	
	public List find(final QueryCriterion queryCriterion, final PaginationSupport ps) throws DataAccessException {
		Assert.assertNotNull(queryCriterion);
		return (List) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query queryObject = session.createQuery(applyPaginationSorter(ps, queryCriterion.getQueryString()));
				Query countObject = session.createQuery(queryCriterion.getCountString());
                applyQueryCriteriaToQuery(queryObject, queryCriterion);
                applyQueryCriteriaToQuery(countObject, queryCriterion);
                
//				applyPagination(ps, queryObject, ((Integer) countObject.iterate().next()).intValue());
                // change from Integer to Long
				applyPagination(ps, queryObject, ((Long) countObject.iterate().next()).intValue());
                
				return queryObject.list();
			}
		});
	}
	
	public List find(final QueryCriterion queryCriterion) throws DataAccessException {
		Assert.assertNotNull(queryCriterion);
		return (List) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query queryObject = session.createQuery(queryCriterion.getQueryString());
                applyQueryCriteriaToQuery(queryObject, queryCriterion);
				return queryObject.list();
			}
		});
	}
	
	public List findByNamedParam(final String queryString, final String[] paramNames, final Object[] values, final PaginationSupport ps)
			throws DataAccessException {
		Assert.assertTrue( "Length of paramNames array must match length of values array",paramNames.length == values.length);
		return (List) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				String queryStringValue = applyPaginationSorter(ps, queryString);
				Query queryObject = session.createQuery(queryStringValue);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						applyNamedParameterToQuery(queryObject, paramNames[i], values[i]);
					}
				}
				
				applyPagination(ps, queryObject);
				return queryObject.list();
			}
		});
	}
	
    //-------------------------------------------------------------------------
	// Convenience finder methods for named queries
	//-------------------------------------------------------------------------
	
	public List findByNamedQuery(final String queryName, final Object[] values, final PaginationSupport ps) {
		return (List) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				String queryString = applyPaginationSorter(ps, session.getNamedQuery(queryName).getQueryString());
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				
				if (values != null) {
                    for (int i = 0; i < values.length; i++) {
                        queryObject.setParameter(i, values[i]);
                    }
                }
                
                // set ps#setTotalCount() explicitly
                applyPagination(ps, queryObject);
				return queryObject.list();
			}
		});
	}
	
	//-------------------------------------------------------------------------
	// Convenience query methods for iteration
	//-------------------------------------------------------------------------

	public Iterator iterateByNamedQuery(final String queryName, final Object[] values) throws DataAccessException {
		return (Iterator) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.getNamedQuery(queryName);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
					}
				}
				return queryObject.iterate();
			}
		});
	}

    //-------------------------------------------------------------------------
	// Convenience counter methods for HQL strings
	//-------------------------------------------------------------------------
    
	public int countByNamedParam(final String queryString, final String[] paramNames, final Object[] values)
			throws DataAccessException {
		Assert.assertTrue( "Length of paramNames array must match length of values array",paramNames.length == values.length);

        // change from Integer to Long
    	return ((Long) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						applyNamedParameterToQuery(queryObject, paramNames[i], values[i]);
					}
				}
				return (Long) queryObject.iterate().next();
			}
		})).intValue();
    }
	
	public int countByNamedQuery(final String queryName, final Object[] values)
			throws DataAccessException {
        // change from Integer to Long
		return ((Long) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.getNamedQuery(queryName);
				prepareQuery(queryObject);
				if (values != null) {
                    for (int i = 0; i < values.length; i++) {
                        queryObject.setParameter(i, values[i]);
                    }
                }
				return (Long) queryObject.iterate().next();
			}
		})).intValue();
	}
	
	public int count(final String queryString) throws DataAccessException {
        // change from Integer to Long
    	return ((Long) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
		        return (Long) queryObject.iterate().next();
	        }
	    })).intValue();
    }
	
	public int count(final String queryString, final Object[] values) throws DataAccessException {
        // change from Integer to Long
		return ((Long) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
					}
				}
				return (Long) queryObject.iterate().next();
			}
		})).intValue();
	}
    
    public int count(final QueryCriterion queryCriterion) throws DataAccessException {
        Assert.assertNotNull(queryCriterion);
        // change from Integer to Long
        return ((Long) executeWithNativeSession(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query queryObject = session.createQuery(queryCriterion.getCountString());
                applyQueryCriteriaToQuery(queryObject, queryCriterion);
                return (Long) queryObject.iterate().next();
            }
        })).intValue();
    }
    
    //-------------------------------------------------------------------------
	// miscellaneous methods
	//-------------------------------------------------------------------------
    
    protected String applySorter(String queryString, SortCriterion sorter) {
    	if (null == sorter || StringUtils.isBlank(sorter.getField())) {
    		return queryString;
    	}
    	if (queryString.toLowerCase().indexOf("order by") > -1) {
    		// TODO queryString �к��� order by using regular pattern, just return
    		return queryString;
    	} else {
    		return new StringBuffer(queryString)
    			.append(" order by ")
    			.append(sorter.getField())
    			.append(" ")
    			.append(sorter.getOrder())
    			.toString();
    	}
    }
    
    protected String applyPaginationSorter(PaginationSupport ps, String queryString) {
    	if (null != ps && ps.isSortingEnabled()) {
			SortCriterion sorter = ps.getSorter();
			queryString = applySorter(queryString, sorter);
		}

    	if (log.isDebugEnabled()) {
    		log.debug("after applySorter queryString=" + queryString);
    	}
    	return queryString;
    }
    
    private String applyCountPrefix(String queryString) {
    	int start = queryString.indexOf("from");
    	return "select count(*) " + queryString.substring(start, queryString.length());
    }

    private void applyPagination(PaginationSupport ps, Query queryObject) {
    	applyPagination(ps, queryObject, -1);
    }
    
    private void applyPagination(PaginationSupport ps, Query queryObject, int totalCount) {
    	if (ps == null) return;
    	Assert.assertNotNull(queryObject);
    	
    	if (log.isDebugEnabled()) {
			log.debug(ps);
		}
    	
    	if (totalCount > -1) {
    		// if totalCount = -1, totalCount will be set explicitly
    		ps.setTotalCount(totalCount);
    	}
    	queryObject.setFirstResult(ps.getStartIndex());
    	queryObject.setMaxResults(ps.getCountOnEachPage());
    }
    
    private void applyQueryCriteriaToQuery(Query queryObject, QueryCriterion queryCriterion) {
        if (log.isDebugEnabled()) {
            log.debug(queryCriterion);
        }
        prepareQuery(queryObject);
        
        // using namedParam query
        Map nameValuePairs = queryCriterion.getQueryParams();
        if (log.isDebugEnabled()) {
            log.debug("nameValuePairs=" + nameValuePairs);
        }
        
        if (null != nameValuePairs && !nameValuePairs.isEmpty()) {
            for (Iterator it = nameValuePairs.keySet().iterator(); it.hasNext();) {
                String key = (String) it.next();
                applyNamedParameterToQuery(queryObject, key, nameValuePairs.get(key));
            }
        }
    }
    
}
