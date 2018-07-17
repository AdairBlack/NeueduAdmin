package com.neusoft.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	private static SqlSessionFactory ssf = null;
	static{
		InputStream is = null;
		try{
			is = Resources.getResourceAsStream("SqlMapConfig.xml");
		} catch(IOException e){
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		ssf = sfb.build(is);
	}
	public static SqlSession getSession(){
		SqlSession session=ssf.openSession();
		return session;
	}
}
