package com.datang;

import java.util.Scanner;

public class Adminlogin {
public static void adminlogin() throws Exception{
	// TODO Auto-generated method stub
			for (int i = 0; i < 30; i++) {
				System.out.print("=");
			}
			System.out.println();
			System.out.println("��ѡ������ѡ��:");
			System.out.println("1.�û�����");
			System.out.println("2.���ｻ��ģ�����");
			System.out.println("3.�˳���¼,���ع���Ա��¼����");
			System.out.println("4.�˳�����");
			Scanner input= new Scanner(System.in);
			String change = input.nextLine(); 
			
			//��¼δ�����˺�����
			if (change.equals("1")) {
				//��������û�����
				
				ManageUsers manageUsers = new ManageUsers();
				manageUsers.manageUsers();
				
			} else if (change.equals("2")) {
				//������ｻ��ģ��
				
				ManagePetTrade managePetTrade = new ManagePetTrade();
				managePetTrade.managePetTrade();
			} else if (change.equals("3")) {
				Thread thread = new Thread();
				
				thread.sleep(200);//��ͣ0.2S
				System.out.println("OK!���ڷ�����һ��");
				Adminsystem.adminSystem ();
			} else if (change.equals("4")) {
				Thread thread = new Thread();
				
				thread.sleep(800);//��ͣ0.8S
				System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
				System.exit(-1);
			}else {
				System.err.println("��������ȷ��ѡ��!(1-4)");
				new Scanner(System.in).nextLine();//ͣ��һ��
				adminlogin();;//�����벻��ѡ�����ѭ����ǰģ��
			}
}
}
