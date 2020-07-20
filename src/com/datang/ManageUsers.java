package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class ManageUsers {
	public static void manageUsers() throws Exception {
		// 2.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.定义sql语句
		String sql1 = "select * from user ";
		
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql1);
		
		// 6.执行sql语句
		ResultSet eq1 = ps1.executeQuery();
		
		
		// System.out.println(res);
		System.out.println("=======管理员管理用户界面======");
		System.out.println("请输入您的选项:");
		System.out.println("1.显示所有用户的信息");
		System.out.println("2.查找特定用户信息");
		System.out.println("3.添加新用户");
		System.out.println("4.删除用户的信息");
		System.out.println("5.返回上一级");
		System.out.println("6.退出程序");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		User user = new User();
		if (choose.equals("1")) {
			System.out.println("=========用户表=========");
			System.out.println("用户名\t\t手机号\t\t密码\t\t注册时间");
			while (eq1.next()) {
				System.out.println(eq1.getString(1) + "\t" + eq1.getString(2)
						+ "\t" + eq1.getString(3) + "\t" + eq1.getString(4));
				
			}
			System.out.println("输入任意返回");
				new Scanner(System.in).nextLine();// 停顿一下
				manageUsers();
		} else if (choose.equals("2")) {
			System.out.println("请输入您要查找的用户账号:");
			user.setNumber(input.nextLine().trim());
			String sql2 = "select * from user where yonghu=?";
			PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql2);
			ps2.setString(1,user.getNumber());
			ResultSet eq2 = ps2.executeQuery();
			if(eq2.next()){
				System.out.println("用户名\t\t手机号\t\t密码\t\t注册时间");
				System.out.println(eq2.getString(1) + "\t" + eq2.getString(2)
						+ "\t" + eq2.getString(3) + "\t" + eq2.getString(4));
			System.out.println("输入任意返回");
				new Scanner(System.in).nextLine();// 停顿一下
				manageUsers();
			}
			System.err.println("数据库中无此用户,请返回重试");
			new Scanner(System.in).nextLine();// 停顿一下
			manageUsers();
			
		} else if (choose.equals("3")) {
			UserRegister ur = new UserRegister();
			ur.userRegister();
		} else if (choose.equals("4")) {
			DeleteUser du = new DeleteUser();
			du.deleteuser();
		} else if (choose.equals("5")) {
			LoginSuccess.loginSuccess();
		}else if (choose.equals("6")) {
			Thread thread = new Thread();
			
			thread.sleep(800);//暂停0.8S
			System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
			System.exit(-1);
		} 
		else {
			System.err.println("请输入正确的选项!(1-5)输入回车继续");
			new Scanner(System.in).nextLine();// 停顿一下
			manageUsers();
		}

	}
}
