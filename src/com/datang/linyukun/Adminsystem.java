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
		System.out.println("��ѡ������ѡ��:");
		System.out.println("1.��¼");
		//System.out.println("2.ע�����Ա");
		System.out.println("2.�޸Ļ��һع���Ա����");
		System.out.println("3.������һ��");
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
			System.out.println("���Ե�...");
			Thread thread = new Thread();
			thread.sleep(200);//��ͣ0.2S
			System.out.println("OK!���ڷ�����һ��");
			Main.Login();
		}else {
			System.err.println("��������ȷ��ѡ��(1-4),�س�����!");
			new Scanner(System.in).nextLine();//ͣ��һ��
			adminSystem ();//�����벻��ѡ�����ѭ����ǰģ��
		}
			
		}

	
	

}
