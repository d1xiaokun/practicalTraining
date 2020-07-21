package com.datang.linyukun;

import java.util.Scanner;

public class JudgeName {
	public String judgeJName(){
		System.out.println("请输入甲方名称:");
		Scanner input = new Scanner(System.in);
		String jf =input.nextLine().trim();
		while(jf.equals("")){
			System.err.println("甲方名称不能为空!");
			System.out.println("请输入甲方名称:");
			 jf =input.nextLine().trim();
		}
		System.out.println("甲方名称通过!");
		return jf;
	}
	public String judgeYName(){
		System.out.println("请输入乙方名称:");
		Scanner input = new Scanner(System.in);
		String yf =input.nextLine().trim();
		while(yf.equals("")){
			System.err.println("乙方名称不能为空!");
			System.out.println("请输入乙方名称:");
			 yf =input.nextLine().trim();
		}
		System.out.println("乙方名称通过!");
		return yf;
		
	}
	
}
