/**
 * 
 */
package com.stocker.department.tasks;

import java.util.List;

import com.stocker.core.StockerBaseResult;
import com.stocker.core.StockerBaseTask;
import com.stocker.core.StockerSession;
import com.stocker.core.StockerStorageContext;
import com.stocker.department.DepartmentEntity;
import com.stocker.department.DepartmentStorageManager;
import com.stocker.exception.StockerCoreException;

/**
 * @author amar
 *
 */
public class RetrieveDepartementsTaks extends StockerBaseTask<List<DepartmentEntity>> {
	public RetrieveDepartementsTaks() {
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
	protected StockerBaseResult<List<DepartmentEntity>> execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		StockerBaseResult<List<DepartmentEntity>> result = new StockerBaseResult<List<DepartmentEntity>>();
		result.setResultedObject(DepartmentStorageManager.getInstance().retrieveDepartments(context));
		return result;
	}

}
