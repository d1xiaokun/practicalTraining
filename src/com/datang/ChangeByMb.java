package com.datang;

import java.util.Scanner;

import com.datang.model.Admin;

public class ChangeByMb {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		changeAdPwd();

	}
	public static void changeAdPwd() throws Exception{
		System.out.println("a请输入您要更改密码的账号:");
		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();
		admin.setAcc_number(input.nextLine().trim());
		
		//验证账号是否存在存在即返回密保问题,不存在的话提示没有此账号+
		UnifiedAccount ua = new UnifiedAccount();
		String a =ua.unifiedAccount(admin.getAcc_number());
		while(a.equals("noon")){
			System.out.println("你输入的账号尚未注册!是否继续重新输入账号(y or n)?");
				String choose = input.nextLine().trim();
				//System.out.println(choose);
				if (choose.equals("y") || choose.equals("Y")) {
					System.out.println("3n请输入您要更改密码的账号:");
					admin.setAcc_number(input.nextLine().trim());
					a =ua.unifiedAccount(admin.getAcc_number());
		
		}else if (choose.equals("n") || choose.equals("N")) {
			ChangeAdPwd.changAdPwd();

		} else {
			System.err.println("pp请输入正确的选项!");
			System.err.println("2m是否继续请输入y,返回请输入任意 :");
			choose = input.nextLine().trim();
			//System.out.println(choose);
			if (choose.equals("y") || choose.equals("Y")) {
				changeAdPwd();
			}else{
				ChangeAdPwd.changAdPwd();
			}
		}
		System.out.println("您的密保问题为:"+a);
		System.out.println("请输入您的密保答案:");
		String answer=input.nextLine().trim();
		System.out.println("正在进行验证...");
		UnifiedMM umm = new UnifiedMM();
		int b = umm.unifiedMM(admin.getAcc_number(), a, answer);
		while(b != 0){
			System.err.println("您输入的密保答案不正确!");
			System.out.println("您的密保问题为:"+a);
			System.out.println("请输入您的密保答案:");
			answer=input.nextLine().trim();
			System.out.println("正在进行验证...");
			
			 b = umm.unifiedMM(admin.getAcc_number(), a, answer);
		}
		
		
		
	}
		System.out.println("您的密保问题为:"+a);
		System.out.println("请输入您的密保答案:");
		String answer=input.nextLine().trim();
		System.out.println("正在进行验证...");
		UnifiedMM umm = new UnifiedMM();
		int b = umm.unifiedMM(admin.getAcc_number(), a, answer);
		while(b != 0){
			System.err.println("您输入的密保答案不正确!");
			System.out.println("您的密保问题为:"+a);
			System.out.println("请输入您的密保答案:");
			answer=input.nextLine().trim();
			System.out.println("正在进行验证...");
			
			 b = umm.unifiedMM(admin.getAcc_number(), a, answer);
		}
		System.out.println("身份验证成功!");
		System.out.println("请输入您要修改的密码:");
		RechangePwd rp = new RechangePwd();
		rp.rechangePwd(admin.getAcc_number());
		System.out.println("请输入您的选项:");
		System.out.println("1.返回管理员登录");
		System.out.println("2.退出程序");
		String choose1 =input.nextLine().trim();
		while(!choose1.equals("1")||!choose1.equals("2")){
			System.err.println("您的选项有误,请重新选择!");
			System.out.println("请输入您的选项:");
			System.out.println("1.返回管理员登录");
			System.out.println("2.退出程序");
			choose1 =input.nextLine().trim();
		}
		if (choose1.equals("1")) {
			Adminlogin.adminlogin();
		}else {
			Thread thread = new Thread();

			thread.sleep(800);// 暂停0.8S
			System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
			System.exit(-1);
		}
}
}