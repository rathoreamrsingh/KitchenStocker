/**
 * 
 */
package com.stocker.category;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.HbmBinder;
import org.hibernate.criterion.Restrictions;

import com.stocker.core.StockerStorageContext;
import com.stocker.exception.StockerCoreException;

/**
 * @author amar
 *
 */
public class SubCategoryStorageManager {
	private static SubCategoryStorageManager instance = null;

	private SubCategoryStorageManager() {

	}

	public static SubCategoryStorageManager getInstance() {
		if (instance == null) {
			synchronized (SubCategoryStorageManager.class) {
				if (instance == null) {
					instance = new SubCategoryStorageManager();
				}
			}
		}

		return instance;
	}

	public Integer addNewSubCategory(SubCategoryEntity subCategoryEntity, StockerStorageContext context)
			throws StockerCoreException {
		Integer result = 0;
		try {
			Session hibernateSession = context.getHibernateSession();
			result = (Integer) hibernateSession.save(subCategoryEntity);
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}

		return result;
	}

	public void deleteSubCategory(int id, StockerStorageContext context) throws StockerCoreException {
		try {
			SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
			subCategoryEntity.setId(id);
			Session hibernateSession = context.getHibernateSession();
			hibernateSession.delete(subCategoryEntity);
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}
	}

	public List<SubCategoryEntity> retrieveAllSubCategoryBasedOnCatId(int categoryId, StockerStorageContext context)
			throws StockerCoreException {
		List<SubCategoryEntity> result = null;
		try {
			Session hibernateSession = context.getHibernateSession();
			Criteria cr = hibernateSession.createCriteria(SubCategoryEntity.class);
			cr.add(Restrictions.eq("parentCategoryId", categoryId));
			result = (List<SubCategoryEntity>) cr.list();
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}

		return result;
	}

	public SubCategoryEntity retrieveSubCategoryById(int subCatId, StockerStorageContext context)
			throws StockerCoreException {
		SubCategoryEntity result = null;
		try {
			Session hibernateSession = context.getHibernateSession();
			result = (SubCategoryEntity) hibernateSession.get(SubCategoryEntity.class, subCatId);
			hibernateSession.evict(result);
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}

		return result;
	}

	public SubCategoryEntity updateSubCategoryData(SubCategoryEntity subCategoryEntity, StockerStorageContext context)
			throws StockerCoreException {
		SubCategoryEntity result = null;
		try {
			Session hibernateSession = context.getHibernateSession();
			hibernateSession.update(subCategoryEntity);
			hibernateSession.evict(subCategoryEntity);
			result = subCategoryEntity;
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}
		return result;
	}
}
