package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.Admin;
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
		Admin admin = new Admin();
		System.out.println("请输入新密码:");
		Scanner input = new Scanner(System.in);
		// 验证密码合法性
		admin.setAcc_pwd(input.nextLine().trim());
		VerifyPwd verifyPwd = new VerifyPwd();
		int returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd());
		while (returnPwd == 0 || returnPwd == 1) {
			if (returnPwd == 0) {
				System.err.println("您输入的密码为空,请重新输入!");
				admin.setAcc_pwd(input.nextLine().trim());
				returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd());
			} else if (returnPwd == 1) {
				System.err.println("您输入的密码不满足6-16位,请重新输入!");
				admin.setAcc_pwd(input.nextLine().trim());
				returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd());
			}
		}
		ps.setString(1, admin.getAcc_pwd());
		ps.setString(2, zhanghao);
		int res = ps.executeUpdate();
		if (res != 0) {
			System.out.println("修改成功");
			System.out.println("新密码为:" + admin.getAcc_pwd() + "请牢记!");
		} else {
			System.out.println("修改失败");
			ChangeByPhone.changeAdPwd();
		}
	}
}
