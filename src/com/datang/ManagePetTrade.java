package com.datang;

import java.util.Scanner;

public class ManagePetTrade {
	public void managePetTrade() throws Exception {
		System.out.println("===========管理宠物交易订单模块========");
		System.out.println("请输入您的选项:");
		System.out.println("1.显示所有订单的信息");
		System.out.println("2.根据订单号查找特定订单信息");
		System.out.println("3.添加新订单");
		System.out.println("4.删除订单信息");
		System.out.println("5.返回上一级");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		if (choose.equals("1")) {
			LoginSuccess.loginSuccess();
		}else if (choose.equals("2")) {
			
		}else if (choose.equals("3")) {
			
		}else if (choose.equals("4")) {
			
		}else if (choose.equals("5")) {
			
		}else {
			System.err.println("请输入正确的选项!(1-4)输入回车继续");
			new Scanner(System.in).nextLine();// 停顿一下
			managePetTrade();
		}
		
	}

}