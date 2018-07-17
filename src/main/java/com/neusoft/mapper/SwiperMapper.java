package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Swiper;

/**
 * Enterprise A
 * Teacher B
 * Moment C
 * @author gagai
 *
 */
public interface SwiperMapper {
	public List<String> findEnterpriseImages(int qid) throws Exception;
	public List<String> findTeacherImages(int qid) throws Exception;
	public List<String> findMomentImages(int qid) throws Exception;
	
	public int saveEnterpriseImage(Swiper swiper) throws Exception;
	public int saveTeacherImage(Swiper swiper) throws Exception;
	public int saveMomentImage(Swiper swiper) throws Exception;
	
	public int deleteEnterpriseImage(int qid) throws Exception;
	public int deleteTeacherImage(int qid) throws Exception;
	public int deleteMomentImage(int qid) throws Exception;
	
}
