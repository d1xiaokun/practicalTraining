package com.datang;

import java.util.Scanner;

import com.datang.model.Admin;

public class ChangeByMb {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		changeAdPwd();

	}
	public static void changeAdPwd() throws Exception{
		System.out.println("a��������Ҫ����������˺�:");
		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();
		admin.setAcc_number(input.nextLine().trim());
		
		//��֤�˺��Ƿ���ڴ��ڼ������ܱ�����,�����ڵĻ���ʾû�д��˺�+
		UnifiedAccount ua = new UnifiedAccount();
		String a =ua.unifiedAccount(admin.getAcc_number());
		while(a.equals("noon")){
			System.out.println("��������˺���δע��!�Ƿ�������������˺�(y or n)?");
				String choose = input.nextLine().trim();
				//System.out.println(choose);
				if (choose.equals("y") || choose.equals("Y")) {
					System.out.println("3n��������Ҫ����������˺�:");
					admin.setAcc_number(input.nextLine().trim());
					a =ua.unifiedAccount(admin.getAcc_number());
		
		}else if (choose.equals("n") || choose.equals("N")) {
			ChangeAdPwd.changAdPwd();

		} else {
			System.err.println("pp��������ȷ��ѡ��!");
			System.err.println("2m�Ƿ����������y,�������������� :");
			choose = input.nextLine().trim();
			//System.out.println(choose);
			if (choose.equals("y") || choose.equals("Y")) {
				changeAdPwd();
			}else{
				ChangeAdPwd.changAdPwd();
			}
		}
		System.out.println("�����ܱ�����Ϊ:"+a);
		System.out.println("�����������ܱ���:");
		String answer=input.nextLine().trim();
		System.out.println("���ڽ�����֤...");
		UnifiedMM umm = new UnifiedMM();
		int b = umm.unifiedMM(admin.getAcc_number(), a, answer);
		while(b != 0){
			System.err.println("��������ܱ��𰸲���ȷ!");
			System.out.println("�����ܱ�����Ϊ:"+a);
			System.out.println("�����������ܱ���:");
			answer=input.nextLine().trim();
			System.out.println("���ڽ�����֤...");
			
			 b = umm.unifiedMM(admin.getAcc_number(), a, answer);
		}
		
		
		
	}
		System.out.println("�����ܱ�����Ϊ:"+a);
		System.out.println("�����������ܱ���:");
		String answer=input.nextLine().trim();
		System.out.println("���ڽ�����֤...");
		UnifiedMM umm = new UnifiedMM();
		int b = umm.unifiedMM(admin.getAcc_number(), a, answer);
		while(b != 0){
			System.err.println("��������ܱ��𰸲���ȷ!");
			System.out.println("�����ܱ�����Ϊ:"+a);
			System.out.println("�����������ܱ���:");
			answer=input.nextLine().trim();
			System.out.println("���ڽ�����֤...");
			
			 b = umm.unifiedMM(admin.getAcc_number(), a, answer);
		}
		System.out.println("�����֤�ɹ�!");
		System.out.println("��������Ҫ�޸ĵ�����:");
		RechangePwd rp = new RechangePwd();
		rp.rechangePwd(admin.getAcc_number());
		System.out.println("����������ѡ��:");
		System.out.println("1.���ع���Ա��¼");
		System.out.println("2.�˳�����");
		String choose1 =input.nextLine().trim();
		while(!choose1.equals("1")||!choose1.equals("2")){
			System.err.println("����ѡ������,������ѡ��!");
			System.out.println("����������ѡ��:");
			System.out.println("1.���ع���Ա��¼");
			System.out.println("2.�˳�����");
			choose1 =input.nextLine().trim();
		}
		if (choose1.equals("1")) {
			Adminlogin.adminlogin();
		}else {
			Thread thread = new Thread();

			thread.sleep(800);// ��ͣ0.8S
			System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
			System.exit(-1);
		}
}
}