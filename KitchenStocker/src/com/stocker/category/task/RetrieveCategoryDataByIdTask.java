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
public class RetrieveCategoryDataByIdTask extends StockerBaseTask<CategoryEntity> {
	private int id;

	public RetrieveCategoryDataByIdTask(int id) {
		this.id = id;
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
		CategoryEntity retrieveCategoryByIdResult = instance.retrieveCategoryById(id, context);
		result.setResultedObject(retrieveCategoryByIdResult);
		return result;
	}

}
