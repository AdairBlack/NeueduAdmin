package com.neusoft.test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

import com.mysql.cj.exceptions.RSAException;
import com.neusoft.bean.Order;
public class Demo {

	public static void main(String[] args) throws SQLException {
		
		JDBCutil db=new JDBCutil();
		db.getConnection();
		System.out.println("......Test......begin......");
		
		int minLesson = 1;
		int maxLesson = 11;
		int minBranch = 1;
		int maxBranch = 4;
		for(int j = 0; j < 10; j++) {
			
			for(int i = 0; i < 100 + j * 100; i++) {
				
				String sql="insert into neuedu.sorder(lid, actual, ordertime, qid, branchid, openid, total, transactionid, nickname, status, tel)\r\n" + 
						"values("+ (new Random().nextInt(maxLesson-minLesson)+minLesson) +", 10, '" + (2009 + j) + "-03-02', 1, "
						+ (new Random().nextInt(maxBranch-minBranch)+minBranch) +",'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', 10, 4200000133201806213004102392,'Adair', '已付款', '1234567890')\r\n";
				db.executeUpdate(sql);
			}
			
		}
		
		
		db.close();
		System.out.println("over");

	}

}
