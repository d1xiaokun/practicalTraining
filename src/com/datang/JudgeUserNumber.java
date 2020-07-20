package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.datang.model.Admin;
import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class JudgeUserNumber {
 public String judgeUserNumber() throws Exception{
	 Class.forName("com.mysql.jdbc.Driver");
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 定义sql语句
		String select = "select * from user where yonghu=?";
		// 获取获取sql语句的对象
		PreparedStatement ps1 = (PreparedStatement) con
				.prepareStatement(select);
		User user = new User();
		Scanner input = new Scanner(System.in);
//		Admin admin = new Admin();
//		Scanner input = new Scanner(System.in);
		
		
		System.out.println("1请输入添加的用户账号(6-16位):");
		user.setNumber(input.nextLine().trim());
		
//		admin.setAcc_number(input.nextLine().trim());
//		System.out.println(admin.getAcc_number()+" 1");
//执行sql语句
		ps1.setString(1, user.getNumber());
		//ps1.setString(1, admin.getAcc_number());
		ResultSet eq = ps1.executeQuery();
		if(eq.next()){// 先判断是否账号是否被注册
			//while (eq.getString(2).equals(admin.getAcc_number())) {
				System.out.println("2抱歉,您输入的账号已被注册!请重新输入!");
				
				//System.out.println(admin.getAcc_number()+" 2");
				return judgeUserNumber();
			//}
		}
/*
* 存在问题
*/
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnunum = verifyNumber.verifyNumber(user.getNumber());
		
		if (returnunum == 0) {
			System.out.println("3您输入的账号为空,请重新输入!");
			//System.out.println(admin.getAcc_number()+" 3 ");
			return judgeUserNumber();

		} else if (returnunum == 1) {
			System.out.println("6您输入的账号不满足6-16位,请重新输入!");
			//System.out.println(admin.getAcc_number()+" 4");
			return judgeUserNumber();
		}else {
			return user.getNumber();
		}
 }
}
