package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.PetTrade;
import com.mysql.jdbc.PreparedStatement;

public class ManagePetTrade {
	
	public static void managePetTrade() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// 3.获取数据库连接
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/superone", "root", "root");
		// 4.定义sql语句
		String sql1 = "select * from jyxx ";
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql1);
		// 6.执行sql语句
		ResultSet eq1 = ps1.executeQuery();
		System.out.println("===========管理宠物交易订单模块========");
		System.out.println("请输入您的选项:");
		System.out.println("1.显示所有订单的信息");
		System.out.println("2.根据订单号查找特定订单信息");
		System.out.println("3.删除订单信息");
		System.out.println("4.返回上一级");
		System.out.println("5.退出程序");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		PetTrade pt = new PetTrade();
		if (choose.equals("1")) {
			System.out.println("=========订单表=========");
			System.out.println("订单号\t卖主\t\t买主");
			while (eq1.next()) {
				System.out.println(eq1.getString(1) + "\t" + eq1.getString(2)+ "\t\t" + eq1.getString(3));
				}
			System.out.println("输入任意返回!");
			new Scanner(System.in).nextLine();// 停顿一下
			managePetTrade();
		}else if (choose.equals("2")) {
			System.out.println("请输入您要查找的订单号:");
			pt.setDdnumber(input.nextLine().trim());
			String sql2 = "select * from jyxx where ddnumber=?";
			PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql2);
			ps2.setString(1, pt.getDdnumber());
			ResultSet eq2 = ps2.executeQuery();
			if(eq2.next()){
				System.out.println("订单号\t卖主\t\t买主");
				System.out.println(eq2.getString(1) + "\t" + eq2.getString(2)+ "\t\t" + eq2.getString(3));
			System.out.println("输入任意返回!");
				new Scanner(System.in).nextLine();// 停顿一下
				managePetTrade();
			}
			System.err.println("数据库中无此信息,请输入任意返回,确认后重试!");
			new Scanner(System.in).nextLine();// 停顿一下
			managePetTrade();
		}else if (choose.equals("3")) {
			DdDelete dd = new DdDelete();
			dd.ddDelete();
		}else if (choose.equals("4")) {
			LoginSuccess.loginSuccess();
		}else if (choose.equals("5")) {
			Thread thread = new Thread();
			thread.sleep(800);//暂停0.8S
			System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
			System.exit(-1);
		}else {
			System.err.println("请输入正确的选项!(1-5)!输入任意返回订单模块!");
			new Scanner(System.in).nextLine();// 停顿一下
			managePetTrade();
		}
	}
}