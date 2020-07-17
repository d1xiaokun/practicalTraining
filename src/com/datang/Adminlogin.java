package com.datang;

import java.util.Scanner;

public class Adminlogin {
public static void adminlogin() throws Exception{
	// TODO Auto-generated method stub
			for (int i = 0; i < 30; i++) {
				System.out.print("=");
			}
			System.out.println();
			System.out.println("请选择您的选项:");
			System.out.println("1.用户管理");
			System.out.println("2.宠物交易模块管理");
			System.out.println("3.返回上一级");
			Scanner input= new Scanner(System.in);
			String change = input.nextLine(); 
			
			//登录未输入账号密码
			if (change.equals("1")) {
				//管理管理用户界面
				System.out.println("管理员管理用户界面");
			} else if (change.equals("2")) {
				//管理宠物交易模块
				System.out.println("管理宠物交易模块");
			} else if (change.equals("3")) {
				Thread thread = new Thread();
				
				thread.sleep(200);//暂停0.2S
				System.out.println("OK!正在返回上一级");
				Adminsystem.adminSystem ();
			} else {
				System.err.println("请输入正确的选项!(1-3)");
				new Scanner(System.in).nextLine();//停顿一下
				adminlogin();;//若输入不在选项继续循环当前模块
			}
}
}
