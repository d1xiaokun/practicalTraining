package com.datang.linyukun;

import java.util.Scanner;

import javax.security.auth.login.LoginContext;

public class Adminsystem {

	private static Scanner input;

	public static void adminSystem () throws Exception{
		// TODO Auto-generated method stub
		for (int i = 0; i < 30; i++) {
			System.out.print("=");
		}
		System.out.println();
		System.out.println("请选择您的选项:");
		System.out.println("1.登录");
		//System.out.println("2.注册管理员");
		System.out.println("2.修改或找回管理员密码");
		System.out.println("3.返回上一级");
		input = new Scanner(System.in);
		String choose=input.nextLine();
		if (choose.equals("1")) {
			Adminlogin adminlogin = new Adminlogin();
			Adminlogin.adminlogin();
			}
		else if (choose.equals("2")) {
			ChangeAdPwd changeAdPwd = new ChangeAdPwd();
			changeAdPwd.changAdPwd();
			
		}else if (choose.equals("3")){
			System.out.println("请稍等...");
			Thread thread = new Thread();
			thread.sleep(200);//暂停0.2S
			System.out.println("OK!正在返回上一级");
			Main.Login();
		}else {
			System.err.println("请输入正确的选项(1-4),回车继续!");
			new Scanner(System.in).nextLine();//停顿一下
			adminSystem ();//若输入不在选项继续循环当前模块
		}
			
		}

	
	

}
