package com.datang;

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
				System.err.println("66��ݔ������볤�Ȳ�����!�������������˺�:");
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

			for (int i = 0; i < 30; i++) {
				System.out.print("=");
			}
			System.out.println();
			System.out.println("��ѡ������ѡ��:");
			System.out.println("1.�û�����");
			System.out.println("2.���ｻ��ģ�����");
			System.out.println("3.�˳���¼,���ع���Ա��¼����");
			System.out.println("4.�˳�����");

			String change = input.nextLine();

			if (change.equals("1")) {
				// ��������û�����

				ManageUsers manageUsers = new ManageUsers();
				manageUsers.manageUsers();

			} else if (change.equals("2")) {
				// ������ｻ��ģ��

				ManagePetTrade managePetTrade = new ManagePetTrade();
				managePetTrade.managePetTrade();
			} else if (change.equals("3")) {
				Thread thread = new Thread();

				thread.sleep(200);// ��ͣ0.2S
				System.out.println("OK!���ڷ�����һ��");
				Adminsystem.adminSystem();
			} else if (change.equals("4")) {
				Thread thread = new Thread();

				thread.sleep(800);// ��ͣ0.8S
				System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
				System.exit(-1);
			} else {
				System.err.println("��������ȷ��ѡ��!(1-4)");
				new Scanner(System.in).nextLine();// ͣ��һ��
				adminlogin();
				;// �����벻��ѡ�����ѭ����ǰģ��
			}
		}
	
}
