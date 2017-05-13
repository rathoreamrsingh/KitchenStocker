/**
 * 
 */
package com.stocker.department.tasks;

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
public class RetrieveDepartmentByIdTask extends StockerBaseTask<DepartmentEntity> {
	private int id;

	public RetrieveDepartmentByIdTask(int id) {
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
	protected StockerBaseResult<DepartmentEntity> execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		StockerBaseResult<DepartmentEntity> result = new StockerBaseResult<DepartmentEntity>();
		DepartmentStorageManager instance = DepartmentStorageManager.getInstance();

		DepartmentEntity departmentEntity = instance.retrieveDepartmentById(id, context);
		result.setResultedObject(departmentEntity);
		return result;
	}

}
