package com.datang;

import java.util.Scanner;

import com.datang.model.Admin;

public class ChangeByPhone {
	public static void main(String[] args) throws Exception {
		changeAdPwd();
	}

	public static void changeAdPwd() throws Exception {
		System.out.println("a请输入您要更改密码的账号:");
		Scanner input = new Scanner(System.in);
		String number = input.nextLine().trim();
		System.out.println("b请输入您当时注册用手机号:");
		String phone = input.nextLine().trim();
		UnifiedAccountPhone uap = new UnifiedAccountPhone();
		int re = uap.unifiedAccountPhone(number, phone);
		int i = 3;
		while (re != 0) {
			int a = i;
			while (a >= 0) {
				if (a == 0) {
					System.err.println("c您输入的错误已达上限正在返回上一级!");
					ChangeAdPwd.changAdPwd();
				}
				a = --i;
				if (a!=0) {
					System.err.println("1d您输入的账号或手机号有误!,当前剩余尝试次数:" + a);
				System.err.println("2是否继续?请输入(y or n):");
				String choose = input.nextLine().trim();
				//System.out.println(choose);
				if (choose.equals("y") || choose.equals("Y")) {
					System.out.println("3h请输入您要更改密码的账号:");
					number = input.nextLine().trim();
					System.out.println("4o请输入您当时注册用手机号:");
					phone = input.nextLine().trim();
					re = uap.unifiedAccountPhone(number, phone);
				} else if (choose.equals("n") || choose.equals("N")) {
					ChangeAdPwd.changAdPwd();

				} else {
					System.err.println("pp请输入正确的选项!");
					System.err.println("2m是否继续?请输入(y or n):");
					choose = input.nextLine().trim();
					System.out.println(choose);
					if (choose.equals("y") || choose.equals("Y")) {
						System.out.println("3n请输入您要更改密码的账号:");
						number = input.nextLine().trim();
						System.out.println("4i请输入您当时注册用手机号:");
						phone = input.nextLine().trim();
					}
				}
				}
				
			}

		}
		System.out.println("身份验证成功!");
		System.out.println("请输入您要修改的密码:");
	}
}