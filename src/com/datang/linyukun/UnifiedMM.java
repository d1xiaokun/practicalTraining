package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class UnifiedMM {
	public int unifiedMM(String zhanghao, String mibaoQ, String mibao)
			throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.定义sql语句
		String sql = "select * from admin where acc_number = ?";
		// 获取获取sql语句的对象
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, zhanghao);
		// 执行sql语句
		ResultSet eq = ps.executeQuery();
		while (eq.next()) {// 先判断是否账号是否被注册
			if (eq.getString(5).equals(mibaoQ) && eq.getString(6).equals(mibao)) {
				return 0;
			} else {
				return 1;
			}

		}
		return 2;

	}

}
