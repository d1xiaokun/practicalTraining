package com.datang;

import java.util.Scanner;

public class Exp1 { 

	private static Scanner log;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʾ���
		
		System.out.println();
		System.out.println("��ѡ����Ҫִ�еĲ���");
		System.out.println("1.����Ա��¼");
		System.out.println("2.�û���¼");
		System.out.println("3.�˳�ϵͳ");
		log = new Scanner(System.in);
		int cho = log.nextInt();//���������ַ�����
		if(cho == 1) {

			
		}else if(cho == 2){
			System.out.print("�𾴵��û�����!"); 
			//�û�ѡ��
		
			
		}
		else if (cho == 3) {
			System.out.println("��л����ʹ��!�ڴ��´��������!");
			System.exit(-1);
		}else {
			System.out.println("��������ȷ��ѡ��");
		}	
		
		
		
	}

}
