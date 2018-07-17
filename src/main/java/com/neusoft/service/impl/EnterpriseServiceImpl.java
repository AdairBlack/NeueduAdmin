package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Swiper;
import com.neusoft.mapper.EnterpriseMapper;
import com.neusoft.mapper.SwiperMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.service.EnterpriseService;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
	
	private static final String imagePath = "/upload/image/";
	private static final String videoPath = "/upload/video/";

	@Autowired
	private EnterpriseMapper enterpriseMapper;
	@Autowired
	private SwiperMapper swiperMapper;

	@Override
	public Enterprise findEnterpriseById(int qid) throws Exception {
		System.out.println("......EnterpriseServiceImpl......findEnterpriseById()......");
		Enterprise enterprise = null;
		
		enterprise = enterpriseMapper.findEnterpriseById(qid);
		List<String> list = swiperMapper.findEnterpriseImages(qid);
		enterprise.setImageFilenames(list);
		
		return enterprise;
	}
	
	@Override
	public List<EnterpriseBranch> findAllBranch(int qid) throws Exception {
		System.out.println("......EnterpriseServiceImpl......findAllBranch()......");
		List<EnterpriseBranch> enterpriseBranches = null;
		enterpriseBranches = enterpriseMapper.findAllBranch(qid);
		
		return enterpriseBranches;
	}

	@Override
	public boolean updateEnterprise(Enterprise enterprise) throws Exception {
		System.out.println("......EnterpriseServiceImpl......updateEnterprise()......");
		enterpriseMapper.updateEnterprise(enterprise);
		
		swiperMapper.deleteEnterpriseImage(enterprise.getQid());
		List<String> list = enterprise.getImageFilenames();
		for(int i = 0; i < list.size(); i++) {
			Swiper swiper = new Swiper();
			swiper.setQid(enterprise.getQid());
			swiper.setImgurl(list.get(i));
			swiperMapper.saveEnterpriseImage(swiper);
		}
		
		return true;
	}

	@Override
	public boolean deleteBranch(int id) throws Exception {
		System.out.println("......EnterpriseServiceImpl......deleteBranch()......");
		enterpriseMapper.deleteBranch(id);
		return true;
	}

	@Override
	public EnterpriseBranch findBranchById(int id) throws Exception {
		System.out.println("......EnterpriseServiceImpl......findBranchById()......");
		return enterpriseMapper.findBranchById(id);
	}

	@Override
	public boolean updateBranch(EnterpriseBranch enterpriseBranch) throws Exception {
		System.out.println("......EnterpriseServiceImpl......updateEnterprise()......");
		enterpriseMapper.updateBranch(enterpriseBranch);
		return true;
	}

	@Override
	public boolean saveBranch(EnterpriseBranch enterpriseBranch) throws Exception {
		System.out.println("......EnterpriseServiceImpl......saveEnterprise()......");
		enterpriseMapper.saveBranch(enterpriseBranch);
		return true;
	}

	@Override
	public boolean deleteOldImages(int qid) throws Exception {
		swiperMapper.deleteEnterpriseImage(qid);
		return true;
	}
	
	

}
