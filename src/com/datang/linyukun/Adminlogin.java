package com.datang.linyukun;

import java.util.Scanner;

import com.datang.model.Admin;

public class Adminlogin {
	public static void adminlogin() throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();
		// 登录验证部分
		System.out.println("请您输入登录账号(6-16位):");
		String zhanghao = input.nextLine().trim();
		VerifyNumber verifyNumber = new VerifyNumber();
		// 判断账号是否合法
		int getverified = verifyNumber.verifyNumber(zhanghao);
		while (getverified == 0 || getverified == 1) {
			if (getverified == 0) {
				System.err.println("您輸入的账号为空!请您重新输入账号:");
				zhanghao = input.nextLine().trim();
				getverified = verifyNumber.verifyNumber(zhanghao);
			} else if (getverified == 1) {
				System.err.println("您輸入的账号长度不符合!请您重新输入账号:");
				zhanghao = input.nextLine().trim();
				getverified = verifyNumber.verifyNumber(zhanghao);
			}
		}
		System.out.println("请输入密码(6-16位):");
		String mima = input.nextLine().trim();
		// 判断密码是否合法
		int getverifiedm = verifyNumber.verifyNumber(mima);
		while (getverifiedm == 0 || getverifiedm == 1) {
			if (getverifiedm == 0) {
				System.err.println("您輸入的密码为空!请您重新输入密码:");
				mima = input.nextLine().trim();
				getverifiedm = verifyNumber.verifyNumber(mima);
			} else if (getverifiedm == 1) {
				System.err.println("您輸入的密码长度不符合!请您重新输入密码:");
				mima = input.nextLine().trim();
				getverifiedm = verifyNumber.verifyNumber(mima);

			}
		}
		// 判断账号密码是否统一
		UnifiedAccountPassword uap = new UnifiedAccountPassword();
		int re = uap.verify(zhanghao, mima);
		while (re != 0) {
			System.err.println("您输入的账号或密码有误,请重新输入登录账号(6-16位):");
			zhanghao = input.nextLine().trim();
			getverified = verifyNumber.verifyNumber(zhanghao);
			while (getverified == 0 || getverified == 1) {
				if (getverified == 0) {
					System.err.println("您輸入的账号为空!请您重新输入账号:");
					zhanghao = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(zhanghao);
				} else if (getverified == 1) {
					System.err.println("您輸入的账号长度不符合!请您重新输入账号:");
					zhanghao = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(zhanghao);
				}
			}

			System.out.println("请输入密码(6-16位):");
			mima = input.nextLine().trim();
			getverifiedm = verifyNumber.verifyNumber(mima);
			while (getverifiedm == 0 || getverifiedm == 1) {
				if (getverifiedm == 0) {
					System.err.println("您輸入的密码为空!请您重新输入密码:");
					mima = input.nextLine().trim();
					getverifiedm = verifyNumber.verifyNumber(mima);
					while (getverifiedm == 0 || getverifiedm == 1) {
						if (getverifiedm == 0) {
							System.err.println("您輸入的密码为空!请您重新输入密码:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						} else if (getverifiedm == 1) {
							System.err.println("您輸入的密码长度不符合!请您重新输入密码:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}
					}
				} else if (getverifiedm == 1) {
					System.err.println("您輸入的密码长度不符合!请您重新输入密码:");
					mima = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(mima);
					while (getverifiedm == 0 || getverifiedm == 1) {
						if (getverifiedm == 0) {
							System.err.println("您輸入的密码为空!请您重新输入密码:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						} else if (getverifiedm == 1) {
							System.err.println("您輸入的密码长度不符合!请您重新输入密码:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}
					}
				}
			}
			// 判断是非退出while循环
			re = uap.verify(zhanghao, mima);
		}
		// 登陆成功进入管理员管理模块
		System.out.println("登陆成功!");
		LoginSuccess ls = new LoginSuccess();
		ls.loginSuccess();

	}

}
