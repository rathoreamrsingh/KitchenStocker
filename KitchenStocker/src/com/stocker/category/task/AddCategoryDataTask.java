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
public class AddCategoryDataTask extends StockerBaseTask<Integer> {
	private CategoryEntity categoryEntity;

	public AddCategoryDataTask(CategoryEntity categoryEntity) {
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
	protected StockerBaseResult<Integer> execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		StockerBaseResult<Integer> result = new StockerBaseResult<Integer>();
		CategoryStorageManager instance = CategoryStorageManager.getInstance();

		Integer id = instance.insertCategoryData(categoryEntity, context);
		result.setResultedObject(id);
		return result;
	}

}
