package com.datang;

import java.util.Scanner;

import com.datang.model.Admin;

public class ChangeByPhone {
	public static void main(String[] args) throws Exception {
		changeAdPwd();
	}

	public static void changeAdPwd() throws Exception {
		System.out.println("��������Ҫ����������˺�:");
		Scanner input = new Scanner(System.in);
		String number = input.nextLine().trim();
		System.out.println("����������ʱע�����ֻ���:");
		String phone = input.nextLine().trim();
		UnifiedAccountPhone uap = new UnifiedAccountPhone();
		int re = uap.unifiedAccountPhone(number, phone);
		int i = 5;
		while (re != 0) {
			 int a = --i;
			
			System.err.println("1��������˺Ż��ֻ�������!,��ǰʣ�ೢ�Դ���:" + a);
			System.err.println("2�Ƿ����?������(y or n):");
			String choose = input.nextLine().trim();
			System.out.println(choose);
			if (choose.equals("y") || choose.equals("Y")) {
				System.out.println("3��������Ҫ����������˺�:");
				number = input.nextLine().trim();
				System.out.println("4����������ʱע�����ֻ���:");
				phone = input.nextLine().trim();
				re = uap.unifiedAccountPhone(number, phone);
			} else if (choose.equals("n") || choose.equals("N") || a ==0) {
				ChangeAdPwd.changAdPwd();
			} else {
				System.err.println("��������ȷ��ѡ��!");
				System.err.println("2�Ƿ����?������(y or n):");
				choose = input.nextLine().trim();
				System.out.println(choose);
				if (choose.equals("y") || choose.equals("Y")) {
					System.out.println("3��������Ҫ����������˺�:");
					number = input.nextLine().trim();
					System.out.println("4����������ʱע�����ֻ���:");
					phone = input.nextLine().trim();
				}
			}
		}
		System.out.println("�����֤�ɹ�!");
		System.out.println("��������Ҫ�޸ĵ�����:");
	}
}