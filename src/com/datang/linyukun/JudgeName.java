package com.datang.linyukun;

import java.util.Scanner;

public class JudgeName {
	public String judgeJName(){
		System.out.println("������׷�����:");
		Scanner input = new Scanner(System.in);
		String jf =input.nextLine().trim();
		while(jf.equals("")){
			System.err.println("�׷����Ʋ���Ϊ��!");
			System.out.println("������׷�����:");
			 jf =input.nextLine().trim();
		}
		System.out.println("�׷�����ͨ��!");
		return jf;
	}
	public String judgeYName(){
		System.out.println("�������ҷ�����:");
		Scanner input = new Scanner(System.in);
		String yf =input.nextLine().trim();
		while(yf.equals("")){
			System.err.println("�ҷ����Ʋ���Ϊ��!");
			System.out.println("�������ҷ�����:");
			 yf =input.nextLine().trim();
		}
		System.out.println("�ҷ�����ͨ��!");
		return yf;
		
	}
	
}
