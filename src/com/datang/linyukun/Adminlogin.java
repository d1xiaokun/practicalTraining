package com.datang.linyukun;

import java.util.Scanner;

import com.datang.model.Admin;

public class Adminlogin {
	public static void adminlogin() throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();
		// ��¼��֤����
		System.out.println("11���������¼�˺�(6-16λ):");
		String zhanghao = input.nextLine().trim();
		VerifyNumber verifyNumber = new VerifyNumber();
		int getverified = verifyNumber.verifyNumber(zhanghao);
		while(getverified == 0 || getverified == 1){
			if (getverified == 0) {
				System.err.println("22��ݔ����˺�Ϊ��!�������������˺�:");
				zhanghao = input.nextLine().trim();
				getverified = verifyNumber.verifyNumber(zhanghao);
			}else if (getverified == 1) {
				System.err.println("33��ݔ����˺ų��Ȳ�����!�������������˺�:");
				zhanghao = input.nextLine().trim();
				getverified = verifyNumber.verifyNumber(zhanghao);
			}
		}
		
		System.out.println("44����������(6-16λ):");
		String mima = input.nextLine().trim();
		int getverifiedm = verifyNumber.verifyNumber(mima);
		while(getverifiedm == 0 || getverifiedm == 1){
			if (getverifiedm == 0) {
				System.err.println("55��ݔ�������Ϊ��!����������������:");
				mima = input.nextLine().trim();
				getverifiedm = verifyNumber.verifyNumber(mima);
			
				
			}else if (getverifiedm == 1) {
				System.err.println("66��ݔ������볤�Ȳ�����!����������������:");
				mima = input.nextLine().trim();
				getverifiedm = verifyNumber.verifyNumber(mima);
				
				}
			}
		
		UnifiedAccountPassword uap = new UnifiedAccountPassword();
		int re=uap.verify(zhanghao, mima);
		while(re != 0){
			System.err.println("77��������˺Ż���������,����������!");
			System.out.println("18���������¼�˺�(6-16λ):");
			zhanghao = input.nextLine().trim();
			getverified = verifyNumber.verifyNumber(zhanghao);
			while(getverified == 0 || getverified == 1){
				if (getverified == 0) {
					System.err.println("89��ݔ����˺�Ϊ��!�������������˺�:");
					zhanghao = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(zhanghao);
				}else if (getverified == 1) {
					System.err.println("90��ݔ����˺ų��Ȳ�����!�������������˺�:");
					zhanghao = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(zhanghao);
				}
			}
			
			System.out.println("/1����������(6-16λ):");
			mima = input.nextLine().trim();
			 getverifiedm = verifyNumber.verifyNumber(mima);
			while(getverifiedm == 0 || getverifiedm == 1){
				if (getverifiedm == 0) {
					System.err.println("*2��ݔ�������Ϊ��!����������������:");
					mima = input.nextLine().trim();
					getverifiedm = verifyNumber.verifyNumber(mima);
					while(getverifiedm == 0 || getverifiedm == 1){
						if (getverifiedm == 0) {
							System.err.println("53��ݔ�������Ϊ��!����������������:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}else if (getverifiedm == 1) {
							System.err.println("65��ݔ������볤�Ȳ�����!����������������:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}
					}
				}else if (getverifiedm == 1) {
					System.err.println("-6��ݔ������볤�Ȳ�����!����������������:");
					mima = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(mima);
					while(getverifiedm == 0 || getverifiedm == 1){
						if (getverifiedm == 0) {
							System.err.println("5/��ݔ�������Ϊ��!����������������:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}else if (getverifiedm == 1) {
							System.err.println("6*��ݔ������볤�Ȳ�����!����������������:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}
					}
				}
			}
			
			re=uap.verify(zhanghao, mima);
		}
			System.out.println("��½�ɹ�!");

			LoginSuccess ls = new LoginSuccess();
			ls.loginSuccess();
			
		}
	
}
