package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class UnifiedAccount {
	public String unifiedAccount(String zhanghao) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.����sql���
		String sql = "select * from admin where acc_number = ?";
		// ��ȡ��ȡsql���Ķ���
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, zhanghao);
		// ִ��sql���
		System.out.println();
		ResultSet eq = ps.executeQuery();
		while (eq.next()) {// ���ж��Ƿ��˺��Ƿ�ע��
			if (eq.getString(2).equals(zhanghao)) {
				System.out.println(eq.getString(5));
				return eq.getString(5);
			}

		}
		return "noon";
	}

}
