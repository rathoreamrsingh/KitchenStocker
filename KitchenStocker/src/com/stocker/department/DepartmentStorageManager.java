/**
 * 
 */
package com.stocker.department;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.stocker.core.StockerStorageContext;
import com.stocker.exception.StockerCoreException;

/**
 * @author amar
 *
 */
public class DepartmentStorageManager {

	private DepartmentStorageManager() {

	}

	private static DepartmentStorageManager instance;

	public static DepartmentStorageManager getInstance() {
		if (instance == null) {
			synchronized (DepartmentStorageManager.class) {
				if (instance == null) {
					instance = new DepartmentStorageManager();
				}
			}
		}

		return instance;
	}

	/**
	 * Adds new department entry in the system.
	 * 
	 * @param departmentEntity
	 * @param context
	 * @return
	 * @throws StockerCoreException
	 */
	public Integer addNewDepartment(DepartmentEntity departmentEntity, StockerStorageContext context)
			throws StockerCoreException {
		Integer id = 0;
		try {
			Session hibernateSession = context.getHibernateSession();
			id = (Integer) hibernateSession.save(departmentEntity);
			hibernateSession.flush();
			hibernateSession.evict(departmentEntity);
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}
		return id;
	}

	public void deleteDepartment(int id, StockerStorageContext context) throws StockerCoreException {
		try {
			Session hibernateSession = context.getHibernateSession();
			DepartmentEntity departmentEntity = new DepartmentEntity();
			departmentEntity.setId(id);
			hibernateSession.delete(departmentEntity);
			hibernateSession.flush();
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}
	}

	public List<DepartmentEntity> retrieveDepartments(StockerStorageContext context) throws StockerCoreException {
		List<DepartmentEntity> result = null;
		try {
			Session hibernateSession = context.getHibernateSession();
			result = hibernateSession.createCriteria(DepartmentEntity.class).list();
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}
		return result;
	}

	public DepartmentEntity retrieveDepartmentById(int id, StockerStorageContext context) throws StockerCoreException {
		DepartmentEntity result = null;
		try {
			Session hibernateSession = context.getHibernateSession();
			result = (DepartmentEntity) hibernateSession.get(DepartmentEntity.class, id);
			hibernateSession.evict(result);
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}
		return result;
	}

	public DepartmentEntity updateDeapartmentData(DepartmentEntity departmentEntity, StockerStorageContext context)
			throws StockerCoreException {
		DepartmentEntity result = null;
		try {
			Session hibernateSession = context.getHibernateSession();
			hibernateSession.update(departmentEntity);
			hibernateSession.flush();
			hibernateSession.evict(departmentEntity);
			result = departmentEntity;
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}

		return result;
	}
}
