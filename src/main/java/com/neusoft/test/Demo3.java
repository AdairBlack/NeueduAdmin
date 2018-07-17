package com.neusoft.test;

import java.util.Random;

public class Demo3 {

	public static void main(String[] args) {
	        //打印 30到50之间的随机数
	        int min = 30;
	        int max = 51;
	        int minLesson = 1;
			int maxLesson = 11;
			int minBranch = 1;
			int maxBranch = 4;
	        for(int i=0;i<100;i++){
	        	String sql="insert into neuedu.sorder(lid, actual, ordertime, qid, branchid)\r\n" + 
						"values("+ (new Random().nextInt(maxLesson-minLesson)+minLesson) +", 10, '2018-03-02', 1, "
						+ (new Random().nextInt(maxBranch-minBranch)+minBranch) +")\r\n";
	            System.out.println(sql);
	        }

	}

}
