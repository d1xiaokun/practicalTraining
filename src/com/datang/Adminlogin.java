package com.datang;

import java.util.Scanner;

import com.datang.model.Admin;

public class Adminlogin {
	public static void adminlogin() throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();
		// 登录验证部分
		System.out.println("11请您输入登录账号(6-16位):");
		String zhanghao = input.nextLine().trim();
		VerifyNumber verifyNumber = new VerifyNumber();
		int getverified = verifyNumber.verifyNumber(zhanghao);
		while(getverified == 0 || getverified == 1){
			if (getverified == 0) {
				System.err.println("22您輸入的账号为空!请您重新输入账号:");
				zhanghao = input.nextLine().trim();
				getverified = verifyNumber.verifyNumber(zhanghao);
			}else if (getverified == 1) {
				System.err.println("33您輸入的账号长度不符合!请您重新输入账号:");
				zhanghao = input.nextLine().trim();
				getverified = verifyNumber.verifyNumber(zhanghao);
			}
		}
		
		System.out.println("44请输入密码(6-16位):");
		String mima = input.nextLine().trim();
		int getverifiedm = verifyNumber.verifyNumber(mima);
		while(getverifiedm == 0 || getverifiedm == 1){
			if (getverifiedm == 0) {
				System.err.println("55您輸入的密码为空!请您重新输入密码:");
				mima = input.nextLine().trim();
				getverifiedm = verifyNumber.verifyNumber(mima);
			
				
			}else if (getverifiedm == 1) {
				System.err.println("66您輸入的密码长度不符合!请您重新输入账号:");
				mima = input.nextLine().trim();
				getverifiedm = verifyNumber.verifyNumber(mima);
				
				}
			}
		
		UnifiedAccountPassword uap = new UnifiedAccountPassword();
		int re=uap.verify(zhanghao, mima);
		while(re != 0){
			System.err.println("77您输入的账号或密码有误,请重新输入!");
			System.out.println("18请您输入登录账号(6-16位):");
			zhanghao = input.nextLine().trim();
			getverified = verifyNumber.verifyNumber(zhanghao);
			while(getverified == 0 || getverified == 1){
				if (getverified == 0) {
					System.err.println("89您輸入的账号为空!请您重新输入账号:");
					zhanghao = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(zhanghao);
				}else if (getverified == 1) {
					System.err.println("90您輸入的账号长度不符合!请您重新输入账号:");
					zhanghao = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(zhanghao);
				}
			}
			
			System.out.println("/1请输入密码(6-16位):");
			mima = input.nextLine().trim();
			 getverifiedm = verifyNumber.verifyNumber(mima);
			while(getverifiedm == 0 || getverifiedm == 1){
				if (getverifiedm == 0) {
					System.err.println("*2您輸入的密码为空!请您重新输入密码:");
					mima = input.nextLine().trim();
					getverifiedm = verifyNumber.verifyNumber(mima);
					while(getverifiedm == 0 || getverifiedm == 1){
						if (getverifiedm == 0) {
							System.err.println("53您輸入的密码为空!请您重新输入密码:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}else if (getverifiedm == 1) {
							System.err.println("65您輸入的密码长度不符合!请您重新输入密码:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}
					}
				}else if (getverifiedm == 1) {
					System.err.println("-6您輸入的密码长度不符合!请您重新输入密码:");
					mima = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(mima);
					while(getverifiedm == 0 || getverifiedm == 1){
						if (getverifiedm == 0) {
							System.err.println("5/您輸入的密码为空!请您重新输入密码:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}else if (getverifiedm == 1) {
							System.err.println("6*您輸入的密码长度不符合!请您重新输入密码:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}
					}
				}
			}
			
			re=uap.verify(zhanghao, mima);
		}
			System.out.println("登陆成功!");

			for (int i = 0; i < 30; i++) {
				System.out.print("=");
			}
			System.out.println();
			System.out.println("请选择您的选项:");
			System.out.println("1.用户管理");
			System.out.println("2.宠物交易模块管理");
			System.out.println("3.退出登录,返回管理员登录界面");
			System.out.println("4.退出程序");

			String change = input.nextLine();

			if (change.equals("1")) {
				// 管理管理用户界面

				ManageUsers manageUsers = new ManageUsers();
				manageUsers.manageUsers();

			} else if (change.equals("2")) {
				// 管理宠物交易模块

				ManagePetTrade managePetTrade = new ManagePetTrade();
				managePetTrade.managePetTrade();
			} else if (change.equals("3")) {
				Thread thread = new Thread();

				thread.sleep(200);// 暂停0.2S
				System.out.println("OK!正在返回上一级");
				Adminsystem.adminSystem();
			} else if (change.equals("4")) {
				Thread thread = new Thread();

				thread.sleep(800);// 暂停0.8S
				System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
				System.exit(-1);
			} else {
				System.err.println("请输入正确的选项!(1-4)");
				new Scanner(System.in).nextLine();// 停顿一下
				adminlogin();
				;// 若输入不在选项继续循环当前模块
			}
		}
	
}
