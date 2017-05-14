/**
 * 
 */
package com.stocker.category.task;

import java.util.List;

import com.stocker.category.CategoryEntity;
import com.stocker.category.CategoryStorageManager;
import com.stocker.core.StockerBaseResult;
import com.stocker.core.StockerBaseTask;
import com.stocker.core.StockerSession;
import com.stocker.core.StockerStorageContext;
import com.stocker.exception.StockerCoreException;

/**
 * @author amar
 *
 */
public class RetrieveAllCategoryDataTask extends StockerBaseTask<List<CategoryEntity>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.stocker.core.StockerBaseTask#validateParameter(com.stocker.core.
	 * StockerSession, com.stocker.core.StockerStorageContext)
	 */
	@Override
	protected void validateParameter(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.stocker.core.StockerBaseTask#execute(com.stocker.core.StockerSession,
	 * com.stocker.core.StockerStorageContext)
	 */
	@Override
	protected StockerBaseResult<List<CategoryEntity>> execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		StockerBaseResult<List<CategoryEntity>> result = new StockerBaseResult<List<CategoryEntity>>();
		CategoryStorageManager instance = CategoryStorageManager.getInstance();
		List<CategoryEntity> retrieveAllCategoriesResult = instance.retrieveAllCategories(context);
		result.setResultedObject(retrieveAllCategoriesResult);
		return null;
	}

}
