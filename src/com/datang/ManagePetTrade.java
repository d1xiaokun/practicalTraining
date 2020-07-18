package com.datang;

import java.util.Scanner;

public class ManagePetTrade {
	public void managePetTrade() throws Exception {
		System.out.println("管理宠物交易模块");
		System.out.println("1.返回上一级");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		if (choose.equals("1")) {
			Adminlogin adminlogin = new Adminlogin();
			adminlogin.adminlogin();
	}
}
}