package com.framework.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.framework.core.dao.GenericDaoImpl;
import com.framework.core.querybuilder.hql.model.query.QueryCriterion;
import com.framework.core.querybuilder.hql.model.sort.SortCriterion;
import com.framework.core.querybuilder.hql.pagination.PaginationSupport;


/**
 * 功能:基础DAO实现(扩展加强GenericDaoImpl)
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20095:13:16 PM
 */
public abstract class BaseHibernateDAO<T, ID extends Serializable> extends GenericDaoImpl<T, ID> {
	private static final Log log = LogFactory.getLog(BaseHibernateDAO.class);
	
	/**
	 * Create a HibernateTemplate for the given SessionFactory.
	 * Only invoked if populating the DAO with a SessionFactory reference!
	 * with different configuration, or a custom HibernateTemplate subclass.
	 * @param sessionFactory the Hibernate SessionFactory to create a HibernateTemplate for
	 * @return the new DefaultHibernateTemplate instance
	 * @see org.springframework.orm.hibernate3.support#createHibernateTemplate
	 * @see org.springframework.orm.hibernate3.support#setSessionFactory
	 */
	protected final HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
		return new DefaultHibernateTemplate(sessionFactory);
	}
	
	/**
	 * Return the DefaultHibernateTemplate for this DAO,
	 * pre-initialized with the SessionFactory or set explicitly.
	 */
	public final DefaultHibernateTemplate getDefaultHibernateTemplate() {
		return (DefaultHibernateTemplate) getHibernateTemplate();
	}
	
	//-------------------------------------------------------------------------
	// Convenience methods for executeUpdate
	//-------------------------------------------------------------------------
	
	/**
	 * Execute the update or delete statement
	 * @param queryString a query expressed in Hibernate's query language
	 * @return The number of entities updated or deleted
	 * @see org.hibernate.Query#executeUpdate
	 */
	public int executeUpdate(String queryString) {
		return getDefaultHibernateTemplate().executeUpdate(queryString);
	}
	
	/**
	 * Execute the update or delete statement
	 * @param queryString a query expressed in Hibernate's query language
	 * @param value the value of the parameter
	 * @return The number of entities updated or deleted
	 * @see org.hibernate.Query#executeUpdate
	 */
	public int executeUpdate(String queryString, Object value) {
		return executeUpdate(queryString, new Object[] {value});
	}
	
	/**
	 * Execute the update or delete statement
	 * @param queryString a query expressed in Hibernate's query language
	 * @param values the values of the parameter
	 * @return The number of entities updated or deleted
	 * @see org.hibernate.Query#executeUpdate
	 */
	public int executeUpdate(String queryString, Object[] values) {
		return getDefaultHibernateTemplate().executeUpdate(queryString, values);
	}
	
	/**
	 * Execute the update or delete statement
	 * @param queryString a query expressed in Hibernate's query language
	 * @param paramName the name of the parameter
	 * @param value the value of the parameter
	 * @return The number of entities updated or deleted
	 * @see org.hibernate.Query#executeUpdate
	 */
	public int executeUpdate(String queryString, String paramName, Object value) {
		return executeUpdate(queryString, new String[] {paramName}, new Object[] {value});
	}
	
	/**
	 * Execute the update or delete statement
	 * @param queryString a query expressed in Hibernate's query language
	 * @param paramNames the names of the parameters
	 * @param values the values of the parameter
	 * @return The number of entities updated or deleted
	 * @see org.hibernate.Query#executeUpdate
	 */
	public int executeUpdate(String queryString, String[] paramNames, Object[] values) {
		return getDefaultHibernateTemplate().executeUpdate(queryString, paramNames, values);
	}

    
    /**
	 * Return the persistent instance of the given entity class
	 * with the given identifier, or null if not found.
	 * @param entityClass a persistent class
	 * @param id an identifier of the persistent instance
	 * @return the persistent instance, or null if not found
	 * @see org.hibernate.Session#get(Class, java.io.Serializable)
	 * @see org.springframework.orm.hibernate3.HibernateTemplate#get(Class, java.io.Serializable)
	 */
    public Object getById(Class entityClass, Serializable id) {
        return getHibernateTemplate().get(entityClass, id);
    }
    
    public boolean exist(Class entityClass, Serializable id) {
		return getById(entityClass, id) != null;
	}
    
    
    /**
     * Execute a query for all persistent instances of the given persistent class.
     * @param entityClass a persistent class
     * @param sortField the field name to be sorted, by default the field will be sort ascending
     * @return all instances of the given persistent class
     */
    public List findAllSorted(Class entityClass, String sortField) {
        return getDefaultHibernateTemplate().findAllSorted(entityClass, sortField);
    }
    
    public List findAllSorted(Class entityClass, SortCriterion sortCriterion) {
    	return getDefaultHibernateTemplate().findAllSorted(entityClass, sortCriterion);
    }
	
    /**
     * Execute a query for persistent instances of the given persistent class.
     * The result will be pageable. The ps's totalCount will be set automatically
     * @param entityClass a persistent class
     * @param ps the PaginationSupport Object. 
     * @return instances of the given persistent class of one page
     */
    public List find(Class entityClass, PaginationSupport ps) {
    	return getDefaultHibernateTemplate().find(entityClass, ps);
    }
    
    //-------------------------------------------------------------------------
	// Convenience finder methods for HQL strings
	//-------------------------------------------------------------------------
    
    /**
	 * Execute a query for persistent instances.
	 * @param queryString a query expressed in Hibernate's query language
	 * @return a List containing 0 or more persistent instances
	 * @see org.springframework.orm.hibernate3.HibernateTemplate#find(java.lang.String)
	 */
	public List find(String queryString) {
		return getHibernateTemplate().find(queryString);
	}
	
	/**
	 * Execute a query for persistent instances.
	 * @param queryString a query expressed in Hibernate's query language
	 * @param value the value of the parameter
	 * @return a List containing 0 or more persistent instances
	 * @see org.springframework.orm.hibernate3.HibernateTemplate#find(java.lang.String, java.lang.Object)
	 */
	public List find(String queryString, Object value) {
		return getHibernateTemplate().find(queryString, value);
	}
	
	/**
	 * Execute a query for persistent instances, binding a
	 * number of values to "?" parameters in the query string.
	 * @param queryString a query expressed in Hibernate's query language
	 * @param values the values of the parameters
	 * @return a List containing 0 or more persistent instances
	 * @see org.springframework.orm.hibernate3.HibernateTemplate#find(java.lang.String, java.lang.Object[])
	 */
	public List find(String queryString, Object[] values) {
		return getHibernateTemplate().find(queryString, values);
	}
    
	/**
	 * Execute a query for persistent instances. The result will be pageable.
	 * The ps's totalCount must be set explicitly.
	 * Call<code>BaseHibernateDao#count(String)</code> before this method.
	 * @param queryString a query expressed in Hibernate's query language
	 * @param ps the PaginationSupport Object
	 * @return a List containing 0 or more persistent instances
	 * @see BaseHibernateDao#count(String)
	 */
	public List find(String queryString, PaginationSupport ps) {
		return getDefaultHibernateTemplate().find(queryString, ps);
	}
	
	/**
	 * Execute a query for persistent instances. The result will be pageable.
	 * The ps's totalCount must be set explicitly.
	 * Call<code>BaseHibernateDao#count(String, Object)</code> before this method.
	 * @param queryString a query expressed in Hibernate's query language
	 * @param value the value of the parameter
	 * @param ps the PaginationSupport Object
	 * @return a List containing 0 or more persistent instances
	 * @see BaseHibernateDao#count(String, Object)
	 */
    public List find(String queryString, Object value, PaginationSupport ps) {
        return find(queryString, new Object[] {value}, ps);
    }
    
    /**
     * Execute a query for persistent instances. The result will be pageable.
     * The ps's totalCount must be set explicitly.
     * Call<code>BaseHibernateDao#count(String, Object[])</code> before this method.
     * @param queryString a query expressed in Hibernate's query language
     * @param values the values of the parameter
     * @param ps the PaginationSupport Object
     * @return a List containing 0 or more persistent instances
     * @see BaseHibernateDao#count(String, Object[])
     */
    public List find(String queryString, Object[] values, PaginationSupport ps) {
    	return getDefaultHibernateTemplate().find(queryString, values, ps);
    }
    
    /**
     * Execute a query for persistent instances,binding a
     * number of values to ":" named parameters in the query string.
     * The queryString & countString will be retrieve from the queryCriterion Object
     * if countString return null, the result will not paginated.
     * @param queryCriterion the queryCriterion 
     * @param ps the PaginationSupport Object
     * @return a List containing 0 or more persistent instances
     * @see QueryCriterion
     */
    public List find(QueryCriterion queryCriterion, PaginationSupport ps) {
    	return getDefaultHibernateTemplate().find(queryCriterion, ps);
    }

    /**
     * Execute a query for persistent instances,binding a
     * number of values to ":" named parameters in the query string.
     * The queryString will be retrieve from the queryCriterion Object,
     * the QueryCriterion#getCountString will not be called
     * @param queryCriterion the queryCriterion 
     * @return a List containing 0 or more persistent instances
     * @see QueryCriterion
     */
    public List find(QueryCriterion queryCriterion) {
    	return getDefaultHibernateTemplate().find(queryCriterion);
    }

    /**
	 * Execute a query for persistent instances, binding
	 * one value to a ":" named parameter in the query string.
	 * @param queryString a query expressed in Hibernate's query language
	 * @param paramName the name of parameter
	 * @param value the value of the parameter
	 * @return a List containing 0 or more persistent instances
	 * @see org.hibernate.Session#getNamedQuery(String)
	 * @see org.springframework.orm.hibernate3.HibernateTemplate#findByNamedParam(java.lang.String, java.lang.String, java.lang.Object)
	 */
    public List findByNamedParam(String queryString, String paramName, Object value) {
    	return getHibernateTemplate().findByNamedParam(queryString, paramName, value);
    }
    
    /**
	 * Execute a query for persistent instances, binding a
	 * number of values to ":" named parameters in the query string.
	 * @param queryString a query expressed in Hibernate's query language
	 * @param paramNames the names of the parameters
	 * @param values the values of the parameters
	 * @return a List containing 0 or more persistent instances
	 * @see org.hibernate.Session#getNamedQuery(String)
	 * @see org.springframework.orm.hibernate3.HibernateTemplate#findByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
    public List findByNamedParam(String queryString, String[] paramNames, Object[] values) {
    	return getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
    }
    
    /**
     * Execute a query for persistent instances, binding a
     * number of values to ":" named parameters in the query string.
     * The result will be pageable.
     * The ps's totalCount must be set explicitly.
     * Call<code>BaseHibernateDao#countByNamedParam(String, String, Object)</code> before this method.
     * @param queryString a query expressed in Hibernate's query language
     * @param paramName the name of the parameter
     * @param value the value of the parameter
     * @param ps the PaginationSupport Object
     * @return a List containing 0 or more persistent instances
     * @see org.hibernate.Session#getNamedQuery(String)
     * @see BaseHibernateDao#countByNamedParam(String, String, Object)
     */
    public List findByNamedParam(String queryString, String paramName, Object value, PaginationSupport ps) {
    	return findByNamedParam(queryString, new String[] {paramName}, new Object[] {value}, ps);
    }
    
    /**
     * Execute a query for persistent instances, binding a
     * number of values to ":" named parameters in the query string.
     * The result will be pageable.
     * The ps's totalCount must be set explicitly.
     * Call<code>BaseHibernateDao#countByNamedParam(String, String[], Object[])</code> before this method.
     * @param queryString a query expressed in Hibernate's query language
     * @param paramNames the names of the parameters
     * @param values the values of the parameters
     * @param ps the PaginationSupport Object
     * @return a List containing 0 or more persistent instances
     * @see org.hibernate.Session#getNamedQuery(String)
     * @see BaseHibernateDao#countByNamedParam(String, String[], Object[])
     */
    public List findByNamedParam(String queryString, String[] paramNames, Object[] values, PaginationSupport ps) {
    	return getDefaultHibernateTemplate().findByNamedParam(queryString, paramNames, values, ps);
    }
    
    //-------------------------------------------------------------------------
	// Convenience finder methods for named queries
	//-------------------------------------------------------------------------

	/**
	 * Execute a named query for persistent instances.
	 * A named query is defined in a Hibernate mapping file.
	 * @param queryName the name of a Hibernate query in a mapping file
	 * @return a List containing 0 or more persistent instances
	 * @see org.hibernate.Session#getNamedQuery(String)
	 */
    public List findByNamedQuery(String queryName) {
    	return getHibernateTemplate().findByNamedQuery(queryName);
    }
	
    /**
	 * Execute a named query for persistent instances, binding
	 * one value to a "?" parameter in the query string.
	 * A named query is defined in a Hibernate mapping file.
	 * @param queryName the name of a Hibernate query in a mapping file
	 * @return a List containing 0 or more persistent instances
	 * @see org.hibernate.Session#getNamedQuery(String)
	 */
    public List findByNamedQuery(String queryName, Object value) {
    	return getHibernateTemplate().findByNamedQuery(queryName, value);
    }
	
    /**
	 * Execute a named query for persistent instances, binding a
	 * number of values to "?" parameters in the query string.
	 * A named query is defined in a Hibernate mapping file.
	 * @param queryName the name of a Hibernate query in a mapping file
	 * @param values the values of the parameters
	 * @return a List containing 0 or more persistent instances
	 * @see org.hibernate.Session#getNamedQuery(String)
	 */
    public List findByNamedQuery(String queryName, Object[] values) {
    	return getHibernateTemplate().findByNamedQuery(queryName, values);
    }
    
    /**
     * Execute a named query for persistent instances.
     * A named query is defined in a Hibernate mapping file.
     * @param queryName the name of a Hibernate query in a mapping file
     * @param ps the PaginationSupport Object
     * @return a List containing 0 or more persistent instances
     * @see org.hibernate.Session#getNamedQuery(String)
     */
    public List findByNamedQuery(String queryName, PaginationSupport ps) {
    	return findByNamedQuery(queryName, (Object[]) null, ps);
    }
    
    /**
     * Execute a named query for persistent instances, binding
     * one value to a "?" parameter in the query string.
     * A named query is defined in a Hibernate mapping file.
     * @param queryName the name of a Hibernate query in a mapping file
     * @param ps the PaginationSupport Object
     * @return a List containing 0 or more persistent instances
     * @see org.hibernate.Session#getNamedQuery(String)
     */
    public List findByNamedQuery(String queryName, Object value, PaginationSupport ps) {
    	return findByNamedQuery(queryName, new Object[] {value}, ps);
    }
    
    /**
     * Execute a named query for persistent instances, binding a
     * number of values to "?" parameters in the query string.
     * A named query is defined in a Hibernate mapping file.
     * @param queryName the name of a Hibernate query in a mapping file
     * @param values the values of the parameters
     * @param ps the PaginationSupport Object
     * @return a List containing 0 or more persistent instances
     * @see org.hibernate.Session#getNamedQuery(String)
     */
    public List findByNamedQuery(String queryName, Object[] values, PaginationSupport ps) {
    	return getDefaultHibernateTemplate().findByNamedQuery(queryName, values, ps);
    }
	
    //-------------------------------------------------------------------------
	// Convenience query methods for iteratation
	//-------------------------------------------------------------------------
    
    /**
	 * Execute a query for persistent instances.
	 * <p>Returns the results as Iterator. Entities returned are initialized
	 * on demand. See Hibernate docs for details.
	 * @param queryString a query expressed in Hibernate's query language
	 * @return a List containing 0 or more persistent instances
	 */
    public Iterator iterate(String queryString) {
    	return getHibernateTemplate().iterate(queryString);
    }

	/**
	 * Execute a query for persistent instances, binding one value
	 * to a "?" parameter in the query string.
	 * <p>Returns the results as Iterator. Entities returned are initialized
	 * on demand. See Hibernate docs for details.
	 * @param queryString a query expressed in Hibernate's query language
	 * @param value the value of the parameter
	 * @return a List containing 0 or more persistent instances
	 */
    public Iterator iterate(String queryString, Object value) {
		return getHibernateTemplate().iterate(queryString, value);
	}

	/**
	 * Execute a query for persistent instances, binding a number of
	 * values to "?" parameters in the query string.
	 * <p>Returns the results as Iterator. Entities returned are initialized
	 * on demand. See Hibernate docs for details.
	 * @param queryString a query expressed in Hibernate's query language
	 * @param values the values of the parameters
	 * @return a List containing 0 or more persistent instances
	 */
    public Iterator iterate(String queryString, Object[] values) {
    	return getHibernateTemplate().iterate(queryString, values);
    }
    
    /**
	 * Execute a query for persistent instances.
	 * <p>Returns the results as Iterator. Entities returned are initialized
	 * on demand. See Hibernate docs for details.
	 * A named query is defined in a Hibernate mapping file.
	 * @param queryName the name of a Hibernate query in a mapping file
	 */
    public Iterator iterateByNamedQuery(String queryName) {
    	return iterateByNamedQuery(queryName, (Object[]) null);
    }
    /**
     * Execute a query for persistent instances.
     * <p>Returns the results as Iterator. Entities returned are initialized
     * on demand. See Hibernate docs for details.
     * A named query is defined in a Hibernate mapping file.
     * @param queryName the name of a Hibernate query in a mapping file
     * @param value the value of the parameter
     */
    public Iterator iterateByNamedQuery(String queryName, Object value) {
    	return iterateByNamedQuery(queryName, new Object[] {value});
    }
    
    /**
     * Execute a query for persistent instances.
     * <p>Returns the results as Iterator. Entities returned are initialized
     * on demand. See Hibernate docs for details.
     * A named query is defined in a Hibernate mapping file.
     * @param queryName the name of a Hibernate query in a mapping file
     * @param values the values of the parameters
     */
    public Iterator iterateByNamedQuery(String queryName, Object[] values) {
    	return getDefaultHibernateTemplate().iterateByNamedQuery(queryName, values);
    }
    
    //-------------------------------------------------------------------------
	// Convenience counter methods for HQL strings
	//-------------------------------------------------------------------------
    
    /**
     * Execute a query for the number of entities satisfy the query condition
     * @param queryString a query expressed in Hibernate's query language
     * @param paramName the name of the parameter
     * @param value the value of the parameter
     * @return The number of entities satisfy the query
     */
    public int countByNamedParam(String queryString, String paramName, Object value) {
    	return countByNamedParam(queryString, new String[] {paramName}, new Object[] {value});
    }
    
    /**
     * Execute a query for the number of entities satisfy the query condition
     * @param queryString a query expressed in Hibernate's query language
     * @param paramNames the names of the parameters
     * @param values the values of the parameters
     * @return The number of entities satisfy the query
     */
    public int countByNamedParam(String queryString, String[] paramNames, Object[] values) {
    	return getDefaultHibernateTemplate().countByNamedParam(queryString, paramNames, values);
    }
    
    /**
     * Execute a query for the number of entities satisfy the query condition
     * @param queryName the name of a Hibernate query in a mapping file
     * @return The number of entities satisfy the query
     */
    public int countByNamedQuery(String queryName) {
    	return countByNamedQuery(queryName, (Object[]) null);
    }
    
    /**
     * Execute a query for the number of entities satisfy the query condition
     * @param queryName the name of a Hibernate query in a mapping file
     * @param value the value of the parameter
     * @return The number of entities satisfy the query
     */
    public int countByNamedQuery(String queryName, Object value) {
    	return countByNamedQuery(queryName, new Object[] {value});
    }

    /**
     * Execute a query for the number of entities satisfy the query condition
     * @param queryName the name of a Hibernate query in a mapping file
     * @param values the values of the parameters
     * @return The number of entities satisfy the query
     */
    public int countByNamedQuery(String queryName, Object[] values) {
    	return getDefaultHibernateTemplate().countByNamedQuery(queryName, values);
    }
    
    /**
     * Execute a query for the number of entities satisfy the query condition
     * @param queryString a query expressed in Hibernate's query language
     * @return The number of entities satisfy the query
     */
    public int count(String queryString) {
        return getDefaultHibernateTemplate().count(queryString);
    }
    
    /**
     * Execute a query for the number of entities satisfy the query condition
     * @param queryString a query expressed in Hibernate's query language
     * @param value the value of the parameter
     * @return The number of entities satisfy the query
     */
    public int count(String queryString, Object value) {
        return count(queryString, new Object[] {value});
    }
    
    /**
     * Execute a query for the number of entities satisfy the query condition
     * @param queryString a query expressed in Hibernate's query language
     * @param values the values of the parameters
     * @return The number of entities satisfy the query
     */
    public int count(String queryString, Object[] values) {
    	return getDefaultHibernateTemplate().count(queryString, values);
    }
    
    public int count(QueryCriterion queryCriterion) {
        return getDefaultHibernateTemplate().count(queryCriterion);
    }
    
    //-------------------------------------------------------------------------
	// miscellaneous methods
	//-------------------------------------------------------------------------
    
    /**
     * If <code>results</code> is not null and has one element then the element will
     * be return, otherwise null will be returned.
     * @param results
     * @return this first Object in <code>results</code>
     */
    public Object findSingleObject(List results) {
        if (results != null && results.size() == 1) {
            return results.get(0);
        }
        if (results != null && results.size() > 1) {
            log.error("Found more than one object when single object requested: " + results);
        }
        return null;
    }
    
    /**
     * Return the first Object in the list if <code>results<code> has any elements
     * or null if the <code>results<code> is null or its size is 0
     * @param results
     * @return the first Object
     */
    public Object findFirstObject(List results) {
        if (results != null && results.size() > 0) {
            return results.get(0);
        }
        return null;
    }
    
    /**
     * Return the first Object in the Iterator if <code>it<code> has any elements
     * or null if the <code>Iterator<code> doesn't has next value.
     * @param it
     * @return
     */
    public Object findFirstObject(Iterator it) {
    	return it.hasNext() ? it.next() : null;
    }
    
    
}
