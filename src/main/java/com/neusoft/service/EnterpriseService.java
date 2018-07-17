package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;

public interface EnterpriseService {
	public Enterprise findEnterpriseById(int qid) throws Exception;
	public List<EnterpriseBranch> findAllBranch(int qid) throws Exception;
	public boolean updateEnterprise(Enterprise enterprise) throws Exception;
	public boolean deleteBranch(int id) throws Exception;
	public EnterpriseBranch findBranchById(int id) throws Exception;
	public boolean updateBranch(EnterpriseBranch enterpriseBranch) throws Exception;
	public boolean saveBranch(EnterpriseBranch enterpriseBranch) throws Exception;
	public boolean deleteOldImages(int qid) throws Exception;
}
