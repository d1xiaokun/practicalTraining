package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class RechangePwd {
	public void rechangePwd(String zhanghao) throws Exception {
		// 2.ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 3.��ȡ���ݿ�����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.����sql���
		String sql1 = "update admin set acc_pwd=? where acc_number=?";
		// 5.��ȡsql���Ķ���
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql1);
		System.out.println("������������:");
		Scanner input = new Scanner(System.in);
		String a = input.nextLine().trim();
		ps.setString(1, a);
		ps.setString(2, zhanghao);

		int res = ps.executeUpdate();
		if (res != 0) {
			System.out.println("�޸ĳɹ�");
			System.out.println("����������Ϊ:"+a+"���μ�!");
		} else {
			System.out.println("�޸�ʧ��");
			ChangeByPhone.changeAdPwd();
		}

		
	}
}
