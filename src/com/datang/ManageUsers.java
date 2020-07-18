package com.datang;

import java.util.Scanner;

public class ManageUsers {
	public void manageUsers() throws Exception{
		System.out.println("管理员管理用户界面");
		System.out.println("1.返回上一级");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		if (choose.equals("1")) {
			Adminlogin adminlogin = new Adminlogin();
			adminlogin.adminlogin();
		}
	}
}
