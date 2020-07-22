package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.datang.model.Admin;
import com.datang.model.TS;
import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class UserRegister {
	public void userRegister() throws Exception {

		// 2.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.定义sql语句
		String sql = "INSERT INTO user(yonghu,phone,password)VALUE(?,?,?);";
		// 5.获取sql语句的对象
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		User user = new User();
		Scanner input = new Scanner(System.in);
		JudgeUserNumber jun = new JudgeUserNumber();
		String Number = jun.judgeUserNumber();
		// 密码注册验证内容部分
		System.out.println("请输入添加的用户密码(6-16位):");
		// admin.setAcc_pwd(input.nextLine().trim());
		user.setPassword(input.nextLine().trim());
		VerifyPwd verifyPwd = new VerifyPwd();
		int returnPwd = verifyPwd.verifyPwd(user.getPassword());
		while (returnPwd == 0 || returnPwd == 1) {
			if (returnPwd == 0) {
				System.err.println("您输入的密码为空,请重新输入!");
				// admin.setAcc_pwd(input.nextLine().trim());
				user.setPassword(input.nextLine().trim());
				returnPwd = verifyPwd.verifyPwd(user.getPassword());
			} else if (returnPwd == 1) {
				System.err.println("您输入的密码不满足6-16位,请重新输入!");
				// admin.setAcc_pwd(input.nextLine().trim());
				user.setPassword(input.nextLine().trim());
				// returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
				returnPwd = verifyPwd.verifyPwd(user.getPassword());
			}
		}
		System.out.println("请再输入一次要添加的用户密码:");
		String verifyConfirm = input.nextLine().trim();
		while (!user.getPassword().equals(verifyConfirm)) {
			System.err.println("两次输入的密码不一致,请重新输入第一次密码!");
			user.setPassword(input.nextLine().trim());
			verifyPwd = new VerifyPwd();
			returnPwd = verifyPwd.verifyPwd(user.getPassword());
			while (returnPwd == 0 || returnPwd == 1) {
				if (returnPwd == 0) {
					System.err.println("您输入的密码为空,请重新输入!");
					// admin.setAcc_pwd(input.nextLine().trim());
					user.setPassword(input.nextLine().trim());
					returnPwd = verifyPwd.verifyPwd(user.getPassword());
				} else if (returnPwd == 1) {
					System.err.println("您输入的密码不满足6-16位,请重新输入!");
					// admin.setAcc_pwd(input.nextLine().trim());//
					user.setPassword(input.nextLine().trim());
					// returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
					returnPwd = verifyPwd.verifyPwd(user.getPassword());
				}
			}
			System.out.println("请再输入一次要添加的用户密码:");
			verifyConfirm = input.nextLine().trim();
		}
		// 手机号注册验证内容部分
		System.out.println("请输入添加的用户手机号:");
		// admin.setPhone(input.nextLine().trim()) ;
		user.setPhone(input.nextLine().trim());
		VerifyPhone verifyPhone = new VerifyPhone();
		int returnNumber = verifyPhone.verifyPhone(user.getPhone());
		while (returnNumber == 0 || returnNumber == 1 || returnNumber == 2) {
			if (returnNumber == 0) {
				System.err.println("您输入的手机号为空!请重新输入:");
				// admin.setPhone(input.nextLine().trim()) ;
				user.setPhone(input.nextLine().trim());
				returnNumber = verifyPhone.verifyPhone(user.getPhone());
			} else if (returnNumber == 1) {
				System.err.println("您输入的手机号不为11位!请重新输入:");
				user.setPhone(input.nextLine().trim());
				returnNumber = verifyPhone.verifyPhone(user.getPhone());
			} else if (returnNumber == 2) {
				System.err.println("您输入的不是真实手机号!请重新输入:");
				user.setPhone(input.nextLine().trim());
				returnNumber = verifyPhone.verifyPhone(user.getPhone());
			} else {

			}
		}
		// 6.执行sql语句
		ps.setString(1, Number);
		ps.setString(2, user.getPhone());
		ps.setString(3, user.getPassword());
		int res = ps.executeUpdate();
		// System.out.println(res);
		// 7.查看返回结果
		if (res != 0) {
			System.out.println("==================================");
			System.out.println("用户注册成功!请提醒牢记用户信息!");
			System.out.println("用户账号为:" + Number);
			System.out.println("用户密码为:" + user.getPassword());
			System.out.println("用户注册手机号为:" + user.getPassword());
			System.out.println("==================================");
			TS ts = new TS();
			ts.tS();
			Scanner admininput = new Scanner(System.in);
			String change = admininput.nextLine();
			if (change.equals("1")) {
				userRegister();
			} else if (change.equals("2")) {
				ManageUsers.manageUsers();
			} else if (change.equals("3")) {
				Thread thread = new Thread();
				thread.sleep(800);// 暂停0.8S
				System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
				System.exit(-1);
			} else {
				while (!change.equals("1") && !change.equals("2")
						&& !change.equals("3")) {
					System.err.println("请输入正确的选项!(1-3)");
					ts.tS();
					change = input.nextLine().trim();
					if (change.equals("1")) {
						userRegister();
					} else if (change.equals("2")) {
						ManageUsers.manageUsers();
					} else if (change.equals("3")) {
						Thread thread = new Thread();
						thread.sleep(800);// 暂停0.8S
						System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
						System.exit(-1);
					}
				}
			}

		} else {
			// 执行sql语句失败
			System.err.println("用户注册失败!");
			System.out.println("即将返回重新注册");
			userRegister();
		}
	}
}