package com.neusoft.test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.neusoft.bean.Order;
public class Demo2 {

	public static void main(String[] args) throws SQLException {
		
		JDBCutil db=new JDBCutil();
		db.getConnection();
		String sql="select *\r\n" + 
				"from neuedu.sorder\r\n" + 
				"order by ordertime desc\r\n" + 
				"limit 1";
		ResultSet rs=db.executeQuery(sql);
		System.out.println("......Test......begin......");
		
		
		while(rs.next()){
			Order order = new Order();
			order.setOid(rs.getInt("oid"));
			order.setLid(rs.getInt("lid"));
			order.setOpenid(rs.getString("openid"));
			order.setTotal(rs.getDouble("total"));
			order.setCid(rs.getInt("cid"));
			order.setActual(rs.getDouble("actual"));
			order.setStatus(rs.getString("status"));
			order.setOrderTime(rs.getTimestamp("ordertime"));
			order.setQid(rs.getInt("qid"));
			order.setTransactionId(rs.getString("transactionid"));
			order.setNickname(rs.getString("nickname"));
			order.setTel(rs.getLong("tel"));
			order.setBranchid(rs.getInt("branchid"));
			
			Timestamp ts = order.getOrderTime();
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date(ts.getTime()));
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			System.out.println("ordertime: " + order.getOrderTime());
			System.out.println("year in int: " + year);
		}
		rs.close();
		db.close();
		System.out.println("over");

	}

}
