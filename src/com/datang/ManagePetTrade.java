package com.datang;

import java.util.Scanner;

public class ManagePetTrade {
	public void managePetTrade() throws Exception {
		System.out.println("===========������ｻ�׶���ģ��========");
		System.out.println("����������ѡ��:");
		System.out.println("1.��ʾ���ж�������Ϣ");
		System.out.println("2.���ݶ����Ų����ض�������Ϣ");
		System.out.println("3.����¶���");
		System.out.println("4.ɾ��������Ϣ");
		System.out.println("5.������һ��");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		if (choose.equals("1")) {
			LoginSuccess.loginSuccess();
		}else if (choose.equals("2")) {
			
		}else if (choose.equals("3")) {
			
		}else if (choose.equals("4")) {
			
		}else if (choose.equals("5")) {
			
		}else {
			System.err.println("��������ȷ��ѡ��!(1-4)����س�����");
			new Scanner(System.in).nextLine();// ͣ��һ��
			managePetTrade();
		}
		
	}

}