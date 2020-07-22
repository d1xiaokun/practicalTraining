package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.Admin;
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
		Admin admin = new Admin();
		System.out.println("������������:");
		Scanner input = new Scanner(System.in);
		// ��֤����Ϸ���
		admin.setAcc_pwd(input.nextLine().trim());
		VerifyPwd verifyPwd = new VerifyPwd();
		int returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd());
		while (returnPwd == 0 || returnPwd == 1) {
			if (returnPwd == 0) {
				System.err.println("�����������Ϊ��,����������!");
				admin.setAcc_pwd(input.nextLine().trim());
				returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd());
			} else if (returnPwd == 1) {
				System.err.println("����������벻����6-16λ,����������!");
				admin.setAcc_pwd(input.nextLine().trim());
				returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd());
			}
		}
		ps.setString(1, admin.getAcc_pwd());
		ps.setString(2, zhanghao);
		int res = ps.executeUpdate();
		if (res != 0) {
			System.out.println("�޸ĳɹ�");
			System.out.println("������Ϊ:" + admin.getAcc_pwd() + "���μ�!");
		} else {
			System.out.println("�޸�ʧ��");
			ChangeByPhone.changeAdPwd();
		}
	}
}
