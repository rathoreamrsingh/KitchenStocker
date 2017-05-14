/**
 * 
 */
package com.stocker.category.task;

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
public class DeleteCategoryDataTask extends StockerBaseTask {
	private int id;

	public DeleteCategoryDataTask(int id) {
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
	protected StockerBaseResult execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		CategoryStorageManager instance = CategoryStorageManager.getInstance();
		instance.deleteCategoryData(id, context);
		return new StockerBaseResult();
	}

}
