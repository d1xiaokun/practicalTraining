package com.datang;

import java.util.Scanner;

import com.datang.model.Admin;

public class Adminlogin {
public static void adminlogin() throws Exception{
	// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		Admin admin = new Admin();
		//登录验证部分
	System.out.println("请您输入登录账号:");
	String zhanghao = input.nextLine().trim();
	VerifyNumber verifyNumber = new VerifyNumber();
		int getverified =verifyNumber.verifyNumber(zhanghao);
		if (getverified == 0) {
			System.err.println("3您输入的账号为空,请重新输入!");
			//System.out.println(admin.getAcc_number());
			adminlogin();

		} else if (getverified == 1) {
			System.err.println("6您输入的账号不满足6-16位,请重新输入!");
			//System.out.println(admin.getAcc_number());
			adminlogin();
		}
		System.out.println("请您输入密码:");
		String pwd = input.nextLine();
		UnifiedAccountPassword uap = new UnifiedAccountPassword();
		int zp = uap.verify(zhanghao, pwd);
		if(zp == 0){
			adminlogin();
		}
		//登录成功
		
			for (int i = 0; i < 30; i++) {
				System.out.print("=");
			}
			System.out.println();
			System.out.println("请选择您的选项:");
			System.out.println("1.用户管理");
			System.out.println("2.宠物交易模块管理");
			System.out.println("3.退出登录,返回管理员登录界面");
			System.out.println("4.退出程序");
			
			String change = input.nextLine(); 
			
			if (change.equals("1")) {
				//管理管理用户界面
				
				ManageUsers manageUsers = new ManageUsers();
				manageUsers.manageUsers();
				
			} else if (change.equals("2")) {
				//管理宠物交易模块
				
				ManagePetTrade managePetTrade = new ManagePetTrade();
				managePetTrade.managePetTrade();
			} else if (change.equals("3")) {
				Thread thread = new Thread();
				
				thread.sleep(200);//暂停0.2S
				System.out.println("OK!正在返回上一级");
				Adminsystem.adminSystem ();
			} else if (change.equals("4")) {
				Thread thread = new Thread();
				
				thread.sleep(800);//暂停0.8S
				System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
				System.exit(-1);
			}else {
				System.err.println("请输入正确的选项!(1-4)");
				new Scanner(System.in).nextLine();//停顿一下
				adminlogin();;//若输入不在选项继续循环当前模块
			}
}
}
