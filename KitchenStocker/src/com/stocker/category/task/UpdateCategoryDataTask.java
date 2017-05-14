/**
 * 
 */
package com.stocker.category.task;

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
public class UpdateCategoryDataTask extends StockerBaseTask<CategoryEntity> {
	private CategoryEntity categoryEntity;

	public UpdateCategoryDataTask(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

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
	protected StockerBaseResult<CategoryEntity> execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		StockerBaseResult<CategoryEntity> result = new StockerBaseResult<CategoryEntity>();
		CategoryStorageManager instance = CategoryStorageManager.getInstance();
		CategoryEntity updateCategoryDataResult = instance.updateCategoryData(categoryEntity, context);
		result.setResultedObject(updateCategoryDataResult);
		return result;
	}

}
