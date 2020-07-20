package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class RechangePwd {
	public void rechangePwd(String zhanghao) throws Exception {
		// 2.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.定义sql语句
		String sql1 = "update admin set acc_pwd=? where acc_number=?";
		// 5.获取sql语句的对象
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql1);
		System.out.println("请输入新密码:");
		Scanner input = new Scanner(System.in);
		String a = input.nextLine().trim();
		ps.setString(1, a);
		ps.setString(2, zhanghao);

		int res = ps.executeUpdate();
		if (res != 0) {
			System.out.println("修改成功");
			System.out.println("您的新密码为:"+a+"请牢记!");
		} else {
			System.out.println("修改失败");
			ChangeByPhone.changeAdPwd();
		}

		
	}
}
