package com.datang;

import java.util.Scanner;

public class ManageUsers {
	public void manageUsers() throws Exception{
		System.out.println("����Ա�����û�����");
		System.out.println("1.������һ��");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		if (choose.equals("1")) {
			Adminlogin adminlogin = new Adminlogin();
			adminlogin.adminlogin();
		}
	}
}
