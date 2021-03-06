package com.datang.linyukun;

import java.util.Scanner;

public class LoginSuccess {
	public static void loginSuccess() throws Exception {
		for (int i = 0; i < 30; i++) {
			System.out.print("=");
		}
		System.out.println();
		System.out.println("请选择您的选项:");
		System.out.println("0.注册新管理员");
		System.out.println("1.用户管理");
		System.out.println("2.宠物交易订单管理");
		System.out.println("3.退出登录,返回管理员登录界面");
		System.out.println("4.退出程序");
		Scanner input = new Scanner(System.in);
		String change = input.nextLine();
		if (change.equals("1")) {
			// 管理管理用户界面
			ManageUsers manageUsers = new ManageUsers();
			manageUsers.manageUsers();
		} else if (change.equals("2")) {
			// 管理宠物交易模块
			ManagePetTrade managePetTrade = new ManagePetTrade();
			managePetTrade.managePetTrade();
		} else if (change.equals("3")) {
			Thread thread = new Thread();
			thread.sleep(200);// 暂停0.2S
			System.out.println("OK!正在返回上一级");
			Adminsystem.adminSystem();
		} else if (change.equals("4")) {
			Thread thread = new Thread();
			thread.sleep(800);// 暂停0.8S
			System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
			System.exit(-1);
		} else if (change.equals("0")) {
			AdminRegister adminRegister = new AdminRegister();
			adminRegister.adminRegister();
		} else {
			System.err.println("请输入正确的选项!(0-4)输入任意继续");
			new Scanner(System.in).nextLine();// 停顿一下
			loginSuccess();// 若输入不在选项继续循环当前模块
		}
	}
}
