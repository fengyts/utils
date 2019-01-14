	@Override
	public List<${tableEntityClassName}> selectBatchByPrimaryKey(List<${primaryKeyModelClassSimpleName}> pkLists) throws DAOException {
		checkNullOrEmptyParam(pkLists);
		return getSqlSession().selectList(getStatement("selectBatchByPrimaryKey"), pkLists);
	}

	@Override
	public int insertBatch(List<${tableEntityClassName}> records) throws DAOException {
		checkNullOrEmptyParam(records);
		return getSqlSession().insert(getStatement("insertBatch"), records);
	}

	@Override
	public int updateBatchByPrimaryKey(List<${tableEntityClassName}> records) throws DAOException {
		checkNullOrEmptyParam(records);
		return getSqlSession().update(getStatement("updateBatchByPrimaryKey"), records);
	}

	@Override
	public int deleteBatchByPrimaryKey(List<${primaryKeyModelClassSimpleName}> pkLists) throws DAOException {
		checkNullOrEmptyParam(pkLists);
		return getSqlSession().delete(getStatement("deleteBatchByPrimaryKey"), pkLists);
	}
