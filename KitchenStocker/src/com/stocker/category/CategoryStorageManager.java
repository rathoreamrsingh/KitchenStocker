/**
 * 
 */
package com.stocker.category;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.stocker.core.StockerStorageContext;
import com.stocker.exception.StockerCoreException;

/**
 * @author amar
 *
 */
public class CategoryStorageManager {

	private static CategoryStorageManager instance = null;

	private CategoryStorageManager() {

	}

	public static CategoryStorageManager getInstance() {
		if (instance == null) {
			synchronized (CategoryStorageManager.class) {
				if (instance == null) {
					instance = new CategoryStorageManager();
				}
			}
		}
		return instance;
	}

	public Integer insertCategoryData(CategoryEntity categoryEntity, StockerStorageContext context)
			throws StockerCoreException {
		Integer result = null;
		try {
			Session hibernateSession = context.getHibernateSession();
			result = (Integer) hibernateSession.save(categoryEntity);
			hibernateSession.flush();
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}
		return result;
	}

	public void deleteCategoryData(int id, StockerStorageContext context) throws StockerCoreException {
		try {
			Session hibernateSession = context.getHibernateSession();
			CategoryEntity categoryEntity = new CategoryEntity();
			categoryEntity.setId(id);
			hibernateSession.delete(categoryEntity);
			hibernateSession.flush();
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}
	}

	public List<CategoryEntity> retrieveAllCategories(StockerStorageContext context) throws StockerCoreException {
		List<CategoryEntity> result = null;
		try {
			Session hibernateSession = context.getHibernateSession();
			result = (List<CategoryEntity>) hibernateSession.createCriteria(CategoryEntity.class).list();
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}

		return result;
	}

	public CategoryEntity retrieveCategoryById(int id, StockerStorageContext context) throws StockerCoreException {
		CategoryEntity result = null;
		try {
			Session hibernateSession = context.getHibernateSession();
			result = (CategoryEntity) hibernateSession.get(CategoryEntity.class, id);
			hibernateSession.evict(result);
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}

		return result;
	}

	public CategoryEntity updateCategoryData(CategoryEntity categoryEntity, StockerStorageContext context)
			throws StockerCoreException {
		CategoryEntity result;
		try {
			Session hibernateSession = context.getHibernateSession();
			hibernateSession.update(categoryEntity);
			hibernateSession.flush();
			hibernateSession.evict(categoryEntity);
			result = categoryEntity;
		} catch (HibernateException hbe) {
			throw new StockerCoreException(hbe);
		}

		return result;
	}

}
