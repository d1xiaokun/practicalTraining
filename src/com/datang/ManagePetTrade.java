package com.datang;

import java.util.Scanner;

public class ManagePetTrade {
	public void managePetTrade() throws Exception {
		System.out.println("������ｻ��ģ��");
		System.out.println("1.������һ��");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		if (choose.equals("1")) {
			Adminlogin adminlogin = new Adminlogin();
			adminlogin.adminlogin();
	}
}
}