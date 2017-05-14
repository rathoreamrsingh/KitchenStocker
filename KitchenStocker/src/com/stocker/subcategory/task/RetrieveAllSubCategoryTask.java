/**
 * 
 */
package com.stocker.subcategory.task;

import java.util.List;

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
public class RetrieveAllSubCategoryTask extends StockerBaseTask<List<SubCategoryEntity>> {
	private int categoryId;

	public RetrieveAllSubCategoryTask(int categoryId) {
		this.categoryId = categoryId;
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
	protected StockerBaseResult<List<SubCategoryEntity>> execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		StockerBaseResult<List<SubCategoryEntity>> result = new StockerBaseResult<List<SubCategoryEntity>>();
		SubCategoryStorageManager instance = SubCategoryStorageManager.getInstance();
		List<SubCategoryEntity> retrieveResult = instance.retrieveAllSubCategoryBasedOnCatId(categoryId, context);
		result.setResultedObject(retrieveResult);
		return result;
	}

}
