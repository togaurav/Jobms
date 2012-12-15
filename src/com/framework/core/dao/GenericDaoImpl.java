package com.framework.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.framework.core.vo.PagineBean;
import com.framework.util.Constants;

public class GenericDaoImpl<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDao<T, ID> {

	private final Log log = LogFactory.getLog(GenericDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		if (id == null) {
			return null;
		}
		return (T) getHibernateTemplate().get(getPersistentClass(), id);
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, Class clazz) {
		if (id == null || clazz == null) {
			return null;
		}
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		if (id == null) {
			return null;
		}
		T entity;
		if (lock) {
			entity = (T) getHibernateTemplate().load(getPersistentClass(), id, LockMode.UPGRADE);
		} else {
			entity = (T) getHibernateTemplate().load(getPersistentClass(), id);
		}

		return entity;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock, Class clazz) {
		if (id == null || clazz == null) {
			return null;
		}
		T entity;
		if (lock) {
			entity = (T) getHibernateTemplate().load(clazz, id, LockMode.UPGRADE);
		} else {
			entity = (T) getHibernateTemplate().load(clazz, id);
		}

		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return findByCriteria(null);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(final T exampleInstance) {
		if (exampleInstance == null) {
			return new ArrayList<T>();
		}
		return findByExample(exampleInstance, new String[0]);
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByExample(final T exampleInstance, Class clazz) {
		if (exampleInstance == null || clazz == null) {
			return new ArrayList<T>();
		}
		return findByExample(exampleInstance, new String[0], clazz);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(final T exampleInstance, final String[] excludeProperty) {
		if (exampleInstance == null) {
			return new ArrayList<T>();
		}
		List<T> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(getPersistentClass());
				Example example = Example.create(exampleInstance);
				for (String exclude : excludeProperty) {
					example.excludeProperty(exclude);
				}
				crit.add(example);
				return crit.list();
			}
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByExample(final T exampleInstance, final String[] excludeProperty, final Class clazz) {
		if (exampleInstance == null || clazz == null) {
			return new ArrayList<T>();
		}
		List<T> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(clazz);
				Example example = Example.create(exampleInstance);
				for (String exclude : excludeProperty) {
					example.excludeProperty(exclude);
				}
				crit.add(example);
				return crit.list();
			}
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	public T makePersistent(T entity) {
		if (entity == null) {
			return null;
		}
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	public Object makePersistent(String entityName, Object entity) {
		if (entity == null) {
			return null;
		}
		if (entityName == null) {
			getHibernateTemplate().saveOrUpdate(entity);
		} else {
			getHibernateTemplate().saveOrUpdate(entityName, entity);
		}
		return entity;
	}

	public void makeTransient(T entity) {
		if (entity == null) {
			return;
		}
		getHibernateTemplate().delete(entity);
	}

	public void makeTransient(String entityName, Object entity) {
		if (entity == null) {
			return;
		}
		if (entityName == null) {
			getHibernateTemplate().delete(entity);
		} else {
			getHibernateTemplate().delete(entityName, entity);
		}
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(final Order order, final Criterion... criterion) {
		return findByCriteria(-1, -1, order, criterion);
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(final int curPage, final int pageSize, final Order order,
			final Criterion... criterion) {
		List<T> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(getPersistentClass());
				for (Criterion c : criterion) {
					crit.add(c);
				}

				if (curPage >= 0 && pageSize >= 0) {
					crit.setFirstResult(curPage * pageSize);
					crit.setMaxResults(pageSize);
				}
				if (order != null) {
					crit.addOrder(order);
				}
				return crit.list();
			}
		});
		return list;
	}

	protected Integer execute(final String hql, final Object... parameters) {
		if (hql == null) {
			return null;
		}
		Integer result = (Integer) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
				Integer result = query.executeUpdate();
				return result;
			}

		});
		return result;
	}

	@SuppressWarnings("unchecked")
	protected <E> List<E> findByHql(Class<E> resultClass, final int curPage, final int pageSize, final String hql,
			final Object... parameters) {
		if (hql == null) {
			return null;
		}
		List<E> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
				if (curPage >= 0 && pageSize >= 0) {
					query.setFirstResult(curPage * pageSize);
					query.setMaxResults(pageSize);
				}
				List list = query.list();
				return list;
			}
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	public <E> List<E> findByHqlLimit(Class<E> resultClass, final int startIndex, final int pageSize, final String hql,
			final Object... parameters) {
		if (hql == null) {
			return null;
		}
		List<E> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
				if (startIndex >= 0 && pageSize >= 0) {
					query.setFirstResult(startIndex);
					query.setMaxResults(pageSize);
				}
				List list = query.list();
				return list;
			}
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	public <E> List<E> findByHql(Class<E> resultClass, String hql, Object... parameters) {
		if (hql == null) {
			return null;
		}
		return getHibernateTemplate().find(hql, parameters);
	}

	@SuppressWarnings("unchecked")
	protected Long countByCondition(String hql, Object... parameters) {
		if (hql == null) {
			return null;
		}
		List list = getHibernateTemplate().find(hql, parameters);
		Long result = 0L;
		if (null != list && list.size() > 0) {
			result = Long.valueOf(list.get(0).toString());
		}
		return result;

	}

	@SuppressWarnings("unchecked")
	protected <E> List<E> findBySql(GenericRowMapping<E> mappper, String sql, Object[] parameters, int[] argTypes) {
		if (sql == null) {
			return null;
		}
		return jdbcTemplate.query(sql, parameters, argTypes, mappper);
	}

	@SuppressWarnings("unchecked")
	protected <E> List<E> findBySql(GenericRowMapping<E> mappper, String sql, Object[] parameters, Integer[] argTypes) {
		if (sql == null) {
			return null;
		}
		int[] argT = ArrayUtils.toPrimitive(argTypes);
		return jdbcTemplate.query(sql, parameters, argT, mappper);
	}

	@SuppressWarnings("unchecked")
	protected List<Map<String, Object>> findBySql(String sql, Object[] eterspa, int[] argTypargTypeses) {
		if (sql == null) {
			return null;
		}
		return jdbcTemplate.queryForList(sql, eterspa, argTypargTypeses);
	}

	@SuppressWarnings("unchecked")
	protected List<Map<String, Object>> findBySql(String sql, Object[] parameters, Integer[] argTypes) {
		if (sql == null) {
			return null;
		}
		int[] argT = ArrayUtils.toPrimitive(argTypes);

		return jdbcTemplate.queryForList(sql, parameters, argT);
	}

	@SuppressWarnings("unchecked")
	protected List<Map<String, Object>> findBySql(String sql, Object[] parameters, Integer[] argTypes, int curPage,
			int pageSize) {
		if (sql == null) {
			return null;
		}
		int[] argT = ArrayUtils.toPrimitive(argTypes);
		if (curPage >= 0 && pageSize > 0) {
			long lastRowNum = ((long) curPage) * pageSize;
			long size = pageSize;
			sql = sql + " LIMIT " + lastRowNum + ", " + size;
		}
		return jdbcTemplate.queryForList(sql, parameters, argT);
	}

	@SuppressWarnings("unchecked")
	protected <E> List<E> findBySql(GenericRowMapping<E> mappper, String sql, Object[] parameters, int[] argTypes,
			int curPage, int pageSize) {
		if (sql == null) {
			return null;
		}
		if (curPage < 0 || pageSize < 0) {
			return findBySql(mappper, sql, parameters, argTypes);
		}

		// oracle实现
		// long firstRowNum = currPage.longValue() * pageSize.longValue() + 1;
		// long endRowNum = firstRowNum + pageSize.longValue();
		// sql = "select * from (select rownum rn,t.* from (" + sql
		// + ") t) where rn>=" + firstRowNum + " and rn<" + endRowNum;

		// mysql实现
		long lastRowNum = ((long) curPage) * pageSize;
		long size = pageSize;
		sql = sql + " LIMIT " + lastRowNum + ", " + size;

		return jdbcTemplate.query(sql, parameters, argTypes, mappper);
	}

	@SuppressWarnings("unchecked")
	protected <E> List<E> findBySql(GenericRowMapping<E> mappper, String sql, Object[] parameters, Integer[] argTypes,
			int curPage, int pageSize) {
		if (sql == null) {
			return null;
		}
		int[] argT = ArrayUtils.toPrimitive(argTypes);

		if (curPage < 0 || pageSize < 0) {
			return findBySql(mappper, sql, parameters, argT);
		}

		// oracle实现
		// long firstRowNum = currPage.longValue() * pageSize.longValue() + 1;
		// long endRowNum = firstRowNum + pageSize.longValue();
		// sql = "select * from (select rownum rn,t.* from (" + sql
		// + ") t) where rn>=" + firstRowNum + " and rn<" + endRowNum;

		// mysql实现
		long lastRowNum = ((long) curPage) * pageSize;
		long size = pageSize;
		sql = sql + " LIMIT " + lastRowNum + ", " + size;

		return jdbcTemplate.query(sql, parameters, argT, mappper);
	}

	protected void executeBySql(final String sql, final Object[] parameters) {
		if (sql == null) {
			return;
		}
		jdbcTemplate.update(sql, parameters);
	}

	@SuppressWarnings("unchecked")
	protected Long countBySql(String sql, Object[] parameters, int[] argTypes) {
		if (sql == null) {
			return null;
		}
		Long length = Long.valueOf(0);
		List list = jdbcTemplate.queryForList(sql, parameters, argTypes);
		if (list != null && list.size() > 0) {
			Map map = (Map) list.get(0);
			Iterator it = map.keySet().iterator();
			length = (Long) map.get(it.next());
		}
		return length;
	}

	@SuppressWarnings("unchecked")
	protected Long countBySql(String sql, Object[] parameters, Integer[] argTypes) {
		if (sql == null) {
			return null;
		}
		Long length = Long.valueOf(0);
		int[] argT = new int[argTypes.length];
		for (int i = 0; i < argTypes.length; i++) {
			argT[i] = argTypes[i].intValue();
		}
		List list = jdbcTemplate.queryForList(sql, parameters, argT);
		if (list != null && list.size() > 0) {
			Map map = (Map) list.get(0);
			Iterator it = map.keySet().iterator();
			length = (Long) map.get(it.next());
		}
		return length;
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

	/**
	 * 保存或更新(如果对象已存在)
	 * 
	 * @param object
	 *            C
	 */
	public T saveOrUpdate(T object) {
		return (T) getHibernateTemplate().merge(object);
	}

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 批量删除
	 * 
	 * @param objects
	 *            Collection
	 */
	public void deleteBatch(Collection<T> objects) {
		getHibernateTemplate().deleteAll(objects);
	}

	/**
	 * 批量保存或更新
	 * 
	 * @param objects
	 *            Collection
	 */
	public void saveOrUpdateAll(Collection<T> objects) {
		getHibernateTemplate().saveOrUpdateAll(objects);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.framework.core.dao.GenericDao#saveEntity(java.lang.Object)
	 */
	public ID saveEntity(T entity) {
		return (ID) getHibernateTemplate().save(entity);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.framework.core.dao.GenericDao#updateEntity(java.lang.Object)
	 */
	public void updateEntity(T entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * get the count query language from select hql or sql<br>
	 * add by Mazhy
	 * 
	 * @param ql
	 *            String format: select (***) from * order by
	 * @return
	 */
	private final String getCQL(final String ql, final String countFields) {
		if (ql == null || ql.length() == 0) {
			String error = "the parameter{ql} cannot be null";
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		String lowerHql = ql.toLowerCase();
		int fromIndex = lowerHql.indexOf("from");
		if (fromIndex < 0) {
			String error = "the parameter{ql} must contain 'from' ";
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		int orderIndex = lowerHql.lastIndexOf("order by");
		String query = (orderIndex > 0 ? ql.substring(fromIndex, orderIndex) : ql.substring(fromIndex));
		if (StringUtils.isBlank(countFields)) {
			return "select count(*) " + query;
		} else {
			return "select count( " + countFields + " ) " + query;
		}
	}

	/**
	 * 私有方法，根据HQL或SQL执行分页查询<br>
	 * add by Mazhy
	 * 
	 * @param ql
	 * @param params
	 * @param curPage
	 * @param pageSize
	 * @param isHQL
	 * @return PagineBean
	 */
	private PagineBean pagineByQL(final String ql, final Object params[], final Long curPage, final Long pageSize,
			final Boolean isHQL, final String countFields) {
		if (ql == null || ql.length() == 0) {
			throw new IllegalArgumentException("the argument hql/sql cannot be null");
		}
		if (params == null) {
			throw new IllegalArgumentException("the argument params cannot be null");
		}
		Object result = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session arg0) throws HibernateException, SQLException {
				String cql = getCQL(ql, countFields);
				Query countQuery = isHQL ? arg0.createQuery(cql) : arg0.createSQLQuery(cql);
				for (int i = 0; i < params.length; i++) {
					countQuery.setParameter(i, params[i]);
				}
				Long totalCount = isHQL ? (Long) countQuery.uniqueResult() : ((BigInteger) countQuery.uniqueResult())
						.longValue();
				long ps = (pageSize != null && pageSize > 0) ? pageSize : Constants.PAGESIZE_DEFAULT;
				Long totalPages = (totalCount % ps != 0) ? (totalCount / ps + 1) : totalCount / ps;
				long cp = (curPage != null && curPage > Constants.FIRST_PAGE_NUMBER) ? (curPage <= totalPages ? curPage
						: totalPages) : Constants.FIRST_PAGE_NUMBER;
				int firstResult = new Long((cp - 1) * ps).intValue();
				int maxResult = new Long(ps).intValue();
				Query itemQuery = isHQL ? arg0.createQuery(ql) : arg0.createSQLQuery(ql);
				for (int i = 0; i < params.length; i++) {
					itemQuery.setParameter(i, params[i]);
				}
				itemQuery.setFirstResult(firstResult);
				itemQuery.setMaxResults(maxResult);
				List<Object> dataList = itemQuery.list();
				PagineBean pb = new PagineBean();
				long prePage = (cp > Constants.FIRST_PAGE_NUMBER) ? (cp - 1) : Constants.FIRST_PAGE_NUMBER;
				long nextPage = (cp < totalPages) ? (cp + 1) : totalPages;
				pb.setCur_page_num(cp);
				pb.setPrePage(prePage);
				pb.setNextPage(nextPage);
				pb.setTotalPages(totalPages);
				pb.setPage_size(ps);// .setPageSize(ps);
				pb.setTotal_page_num(totalCount);
				pb.setStartSerial(new Long(firstResult + 1));
				pb.setIsFirstPage((cp == Constants.FIRST_PAGE_NUMBER) ? true : false);
				pb.setIsLastPage(cp == totalPages || totalPages == 0 ? true : false);
				pb.setDataList(dataList);
				return pb;
			}
		});
		return (PagineBean) result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baidu.rigel.util.dao.GenericDao#pagineByHQL(java.lang.String,
	 * java.lang.Object[], java.lang.Long, java.lang.Long)
	 */
	public PagineBean pagineByHQL(final String hql, final Object params[], final Long curPage, final Long pageSize) {
		return pagineByQL(hql, params, curPage, pageSize, true, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baidu.rigel.util.dao.GenericDao#pagineByHQL(java.lang.String,
	 * java.lang.Object[], java.lang.Long, java.lang.Long, java.lang.String)
	 */
	public PagineBean pagineByHQL(final String hql, final Object params[], final Long curPage, final Long pageSize,
			String countFields) {
		return pagineByQL(hql, params, curPage, pageSize, true, countFields);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baidu.rigel.util.dao.GenericDao#pagineBySQL(java.lang.String,
	 * java.lang.Object[], java.lang.Long, java.lang.Long)
	 */
	public PagineBean pagineBySQL(final String sql, final Object params[], final Long curPage, final Long pageSize) {
		return pagineByQL(sql, params, curPage, pageSize, false, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baidu.rigel.util.dao.GenericDao#pagineBySQL(java.lang.String,
	 * java.lang.Object[], java.lang.Long, java.lang.Long, java.lang.String)
	 */
	public PagineBean pagineBySQL(final String sql, final Object params[], final Long curPage, final Long pageSize,
			String countFields) {
		return pagineByQL(sql, params, curPage, pageSize, false, countFields);
	}

	/**
	 * 执行hql语句查询，如果上面的那些方法都不可用的话
	 * 
	 * @param hql
	 *            String
	 * @param pageParam
	 *            Integer[]
	 * @return Collection
	 */
	@SuppressWarnings("unchecked")
	public List queryByHQL(final String hql, final Map params) {

		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query resultQuery = session.createQuery(hql);
				resultQuery = setParams(resultQuery, params);

				List reval = resultQuery.list();
				/**
				 * 本次查询结束，清除HQl及参数变量
				 */
				return reval;
			}
		});

	}

	private Query setParams(Query resultQuery, Map queryParam) {
		// 设置查询参数
		for (Map.Entry<String, Object> entry : (Set<Map.Entry<String, Object>>) queryParam.entrySet()) {
			resultQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return resultQuery;
	}

	public int bulkUpdate(String hql) {
		return getHibernateTemplate().bulkUpdate(hql);
	}

	public int bulkUpdate(String hql, Object param) {
		return getHibernateTemplate().bulkUpdate(hql, param);
	}

	public int bulkUpdate(String hql, Object[] params) {
		return getHibernateTemplate().bulkUpdate(hql, params);
	}

	@SuppressWarnings("unchecked")
	protected <E> List<E> findBySql2(GenericRowMapping<E> mappper, String sql, Object[] parameters, Integer[] argTypes) {
		if (sql == null) {
			return null;
		}
		int[] argT = ArrayUtils.toPrimitive(argTypes);

		return jdbcTemplate.query(sql, parameters, argT, mappper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baidu.rigel.util.dao.GenericDao#findByHql(java.lang.String,
	 * java.lang.Object[])
	 */
	public List findByHql(String hql, Object... objects) {
		if (hql == null) {
			return null;
		}
		return getHibernateTemplate().find(hql, objects);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baidu.rigel.util.dao.GenericDao#getTableName(java.lang.Class)
	 */
	public String getTableName(Class clazz) {
		if (clazz == null) {
			return null;
		}
		Map<String, AbstractEntityPersister> map = getSessionFactory().getAllClassMetadata();
		String tableName = clazz.getName();
		AbstractEntityPersister entity = map.get(tableName);
		if (entity != null) {
			return entity.getTableName();
		} else {
			return null;
		}
	}

}