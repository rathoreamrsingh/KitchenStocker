/**
 * 
 */
package com.stocker.subcategory.task;

import com.stocker.category.SubCategoryStorageManager;
import com.stocker.core.StockerBaseResult;
import com.stocker.core.StockerBaseTask;
import com.stocker.core.StockerSession;
import com.stocker.core.StockerStorageContext;
import com.stocker.exception.StockerCoreException;

/**
 * @author amar
 *
 */
public class DeleteSubCategoryDataTask extends StockerBaseTask {
	private int id;

	public DeleteSubCategoryDataTask(int id) {
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
		SubCategoryStorageManager instance = SubCategoryStorageManager.getInstance();
		instance.deleteSubCategory(id, context);
		return new StockerBaseResult();
	}

}
