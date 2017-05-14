/**
 * 
 */
package com.stocker.subcategory.task;

import com.stocker.category.SubCategoryEntity;
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
public class RetrieveSubCategoryByIdTask extends StockerBaseTask<SubCategoryEntity> {
	private int id;

	public RetrieveSubCategoryByIdTask(int id) {
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
	protected StockerBaseResult<SubCategoryEntity> execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		StockerBaseResult<SubCategoryEntity> result = new StockerBaseResult<SubCategoryEntity>();
		SubCategoryStorageManager instance = SubCategoryStorageManager.getInstance();
		SubCategoryEntity subCategoryEntity = instance.retrieveSubCategoryById(id, context);
		result.setResultedObject(subCategoryEntity);
		return result;
	}

}
