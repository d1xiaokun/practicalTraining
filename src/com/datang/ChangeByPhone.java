package com.datang;

import java.util.Scanner;

import com.datang.model.Admin;

public class ChangeByPhone {
	public static void main(String[] args) throws Exception {
		changeAdPwd();
	}

	public static void changeAdPwd() throws Exception {
		System.out.println("a��������Ҫ����������˺�:");
		Scanner input = new Scanner(System.in);
		String number = input.nextLine().trim();
		System.out.println("b����������ʱע�����ֻ���:");
		String phone = input.nextLine().trim();
		UnifiedAccountPhone uap = new UnifiedAccountPhone();
		int re = uap.unifiedAccountPhone(number, phone);
		int i = 3;
		while (re != 0) {
			int a = i;
			while (a >= 0) {
				if (a == 0) {
					System.err.println("c������Ĵ����Ѵ��������ڷ�����һ��!");
					ChangeAdPwd.changAdPwd();
				}
				a = --i;
				if (a!=0) {
					System.err.println("1d��������˺Ż��ֻ�������!,��ǰʣ�ೢ�Դ���:" + a);
				System.err.println("2�Ƿ����?������(y or n):");
				String choose = input.nextLine().trim();
				//System.out.println(choose);
				if (choose.equals("y") || choose.equals("Y")) {
					System.out.println("3h��������Ҫ����������˺�:");
					number = input.nextLine().trim();
					System.out.println("4o����������ʱע�����ֻ���:");
					phone = input.nextLine().trim();
					re = uap.unifiedAccountPhone(number, phone);
				} else if (choose.equals("n") || choose.equals("N")) {
					ChangeAdPwd.changAdPwd();

				} else {
					System.err.println("pp��������ȷ��ѡ��!");
					System.err.println("2m�Ƿ����?������(y or n):");
					choose = input.nextLine().trim();
					System.out.println(choose);
					if (choose.equals("y") || choose.equals("Y")) {
						System.out.println("3n��������Ҫ����������˺�:");
						number = input.nextLine().trim();
						System.out.println("4i����������ʱע�����ֻ���:");
						phone = input.nextLine().trim();
					}
				}
				}
				
			}

		}
		System.out.println("�����֤�ɹ�!");
		System.out.println("��������Ҫ�޸ĵ�����:");
	}
}