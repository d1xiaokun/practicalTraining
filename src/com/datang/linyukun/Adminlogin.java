package com.datang.linyukun;

import java.util.Scanner;

import com.datang.model.Admin;

public class Adminlogin {
	public static void adminlogin() throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();
		// ��¼��֤����
		System.out.println("���������¼�˺�(6-16λ):");
		String zhanghao = input.nextLine().trim();
		VerifyNumber verifyNumber = new VerifyNumber();
		// �ж��˺��Ƿ�Ϸ�
		int getverified = verifyNumber.verifyNumber(zhanghao);
		while (getverified == 0 || getverified == 1) {
			if (getverified == 0) {
				System.err.println("��ݔ����˺�Ϊ��!�������������˺�:");
				zhanghao = input.nextLine().trim();
				getverified = verifyNumber.verifyNumber(zhanghao);
			} else if (getverified == 1) {
				System.err.println("��ݔ����˺ų��Ȳ�����!�������������˺�:");
				zhanghao = input.nextLine().trim();
				getverified = verifyNumber.verifyNumber(zhanghao);
			}
		}
		System.out.println("����������(6-16λ):");
		String mima = input.nextLine().trim();
		// �ж������Ƿ�Ϸ�
		int getverifiedm = verifyNumber.verifyNumber(mima);
		while (getverifiedm == 0 || getverifiedm == 1) {
			if (getverifiedm == 0) {
				System.err.println("��ݔ�������Ϊ��!����������������:");
				mima = input.nextLine().trim();
				getverifiedm = verifyNumber.verifyNumber(mima);
			} else if (getverifiedm == 1) {
				System.err.println("��ݔ������볤�Ȳ�����!����������������:");
				mima = input.nextLine().trim();
				getverifiedm = verifyNumber.verifyNumber(mima);

			}
		}
		// �ж��˺������Ƿ�ͳһ
		UnifiedAccountPassword uap = new UnifiedAccountPassword();
		int re = uap.verify(zhanghao, mima);
		while (re != 0) {
			System.err.println("��������˺Ż���������,�����������¼�˺�(6-16λ):");
			zhanghao = input.nextLine().trim();
			getverified = verifyNumber.verifyNumber(zhanghao);
			while (getverified == 0 || getverified == 1) {
				if (getverified == 0) {
					System.err.println("��ݔ����˺�Ϊ��!�������������˺�:");
					zhanghao = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(zhanghao);
				} else if (getverified == 1) {
					System.err.println("��ݔ����˺ų��Ȳ�����!�������������˺�:");
					zhanghao = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(zhanghao);
				}
			}

			System.out.println("����������(6-16λ):");
			mima = input.nextLine().trim();
			getverifiedm = verifyNumber.verifyNumber(mima);
			while (getverifiedm == 0 || getverifiedm == 1) {
				if (getverifiedm == 0) {
					System.err.println("��ݔ�������Ϊ��!����������������:");
					mima = input.nextLine().trim();
					getverifiedm = verifyNumber.verifyNumber(mima);
					while (getverifiedm == 0 || getverifiedm == 1) {
						if (getverifiedm == 0) {
							System.err.println("��ݔ�������Ϊ��!����������������:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						} else if (getverifiedm == 1) {
							System.err.println("��ݔ������볤�Ȳ�����!����������������:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}
					}
				} else if (getverifiedm == 1) {
					System.err.println("��ݔ������볤�Ȳ�����!����������������:");
					mima = input.nextLine().trim();
					getverified = verifyNumber.verifyNumber(mima);
					while (getverifiedm == 0 || getverifiedm == 1) {
						if (getverifiedm == 0) {
							System.err.println("��ݔ�������Ϊ��!����������������:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						} else if (getverifiedm == 1) {
							System.err.println("��ݔ������볤�Ȳ�����!����������������:");
							mima = input.nextLine().trim();
							getverifiedm = verifyNumber.verifyNumber(mima);
						}
					}
				}
			}
			// �ж��Ƿ��˳�whileѭ��
			re = uap.verify(zhanghao, mima);
		}
		// ��½�ɹ��������Ա����ģ��
		System.out.println("��½�ɹ�!");
		LoginSuccess ls = new LoginSuccess();
		ls.loginSuccess();

	}

}
