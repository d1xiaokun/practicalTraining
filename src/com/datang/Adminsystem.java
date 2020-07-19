package com.datang;

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
		System.out.println("2.注册管理员");
		System.out.println("3.修改或找回管理员密码");
		System.out.println("4.返回上一级");
		input = new Scanner(System.in);
		String choose=input.nextLine();
		if (choose.equals("1")) {
			Adminlogin adminlogin = new Adminlogin();
			Adminlogin.adminlogin();
		}else if (choose.equals("2")) {
			AdminRegister adminRegister = new  AdminRegister();
			adminRegister.adminRegister();
		}else if (choose.equals("3")) {
			//AdminRetrievePwd
			/*先连接数据库
			 * 找回方式为2种
			 * 1.验证注册手机号
			 * 2.验证密保信息,提示密保问题
			 * 
			 */
			System.out.println("请输入您要找回密码的账号:");
//			输入账号    不验证账号是否正确,提高安全性,防止知道账号猜密码,但要验证输入的账号是否为空
			
			System.out.println("请选择您要找回密码的方式:");
			System.out.println("1.验证注册手机号");
			System.out.println("2.验证密保信息");
			System.out.println("3.返回上一级");
			System.out.println("4.退出程序");
			//用户选择1
//			匹配数据库的账号信息&&密保都正确才可以
			//用户选择2
//			匹配数据库的账号信息&&手机号都正确才可以
			//验证成功后提示修改密码Updata
			//修改成功提示修改成功并询问是否返回登录还是退出程序
		}else if (choose.equals("4")){
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
