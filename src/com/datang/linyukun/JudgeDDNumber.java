package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.PetTrade;
import com.mysql.jdbc.PreparedStatement;

public class JudgeDDNumber {
	public String judgeDDNumber() throws Exception{
	Class.forName("com.mysql.jdbc.Driver");
	// 3.获取数据库连接
	Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/superone", "root", "root");
	// 定义sql语句
	String select = "select * from jyxx where ddnumber=?";
	PreparedStatement ps1 = (PreparedStatement) con
			.prepareStatement(select);
	PetTrade pt = new PetTrade();
	Scanner input = new Scanner(System.in);
	System.out.println("1请输入添加的订单:");
	pt.setDdnumber(input.nextLine().trim());
	if(pt.getDdnumber().equals("")){
		System.err.println("您输入的订单为空,请重新输入!");
		judgeDDNumber() ;
	}
	ps1.setString(1, pt.getDdnumber());
	ResultSet eq = ps1.executeQuery();
	if(eq.next()){// 先判断是否账号是否被注册
			System.out.println("2抱歉,您输入的账号已被注册!请重新输入!");
			judgeDDNumber();
	}
	return pt.getDdnumber();
}
}