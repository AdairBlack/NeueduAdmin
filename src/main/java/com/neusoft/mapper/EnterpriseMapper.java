package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;

public interface EnterpriseMapper {
	public Enterprise findEnterpriseById(int qid) throws Exception;
	public List<EnterpriseBranch> findAllBranch(int qid) throws Exception;
	public int updateEnterprise(Enterprise enterprise) throws Exception;
	public int saveImage(Map map) throws Exception;
	public int deleteBranch(int id) throws Exception;
	public EnterpriseBranch findBranchById(int id) throws Exception;
	public int updateBranch(EnterpriseBranch enterpriseBranch) throws Exception;
	public int saveBranch(EnterpriseBranch enterpriseBranch) throws Exception;
	public List<String> findAllBranchName(int qid) throws Exception;
	public List<Integer> findAllBranchId(int qid) throws Exception;
}
