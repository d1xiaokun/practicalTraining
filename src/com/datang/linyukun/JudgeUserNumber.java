package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.datang.model.Admin;
import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class JudgeUserNumber {
	public String judgeUserNumber() throws Exception {
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
		System.out.println("请输入添加的用户账号(6-16位):");
		user.setNumber(input.nextLine().trim());
		// 执行sql语句
		ps1.setString(1, user.getNumber());
		ResultSet eq = ps1.executeQuery();
		if (eq.next()) {// 先判断是否账号是否被注册
			System.err.println("抱歉,您输入的账号已被注册!请重新输入!");
			return judgeUserNumber();
		}
		VerifyNumber verifyNumber = new VerifyNumber();
		int returnunum = verifyNumber.verifyNumber(user.getNumber());
		if (returnunum == 0) {
			System.err.println("您输入的账号为空,请重新输入!");
			return judgeUserNumber();
		} else if (returnunum == 1) {
			System.err.println("您输入的账号不满足6-16位,请重新输入!");
			return judgeUserNumber();
		} else {
			return user.getNumber();
		}
	}
}
