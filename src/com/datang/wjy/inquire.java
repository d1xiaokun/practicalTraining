package com.datang.wjy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.datang.model.User;
public class inquire {
	public void inquire() throws Exception{
		Scanner input = new Scanner(System.in);
		User user = new User();
		Class.forName("com.mysql.jdbc.Driver");
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.定义sql语句
		String sql1 = "select * from jyxx ";
		
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql1);
		
		// 6.执行sql语句
		ResultSet eq1 = ps1.executeQuery();
		System.out.println("======欢迎进入查询界面======");
		System.out.println("请输入您要查找的订单号:");
        user.setNumber(input.nextLine().trim());
        String sql2 = "select * from jyxx where ddnumber=?";
        PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql2);
        ps2.setString(1,user.getNumber());
        ResultSet eq2 = ps2.executeQuery();
       if(eq2.next()){
	   System.out.println("甲方\t乙方\t订单号\t");
	    System.out.println(eq2.getString(1) + "\t" + eq2.getString(2)
			+ "\t" + eq2.getString(3) + "\t" );
       System.out.println("输入任意返回");
	   new Scanner(System.in).nextLine();
	   pet.pet();
     }
      System.err.println("数据库中无此用户,请返回重试");
      new Scanner(System.in).nextLine();
      pet.pet();
	            
}
}

