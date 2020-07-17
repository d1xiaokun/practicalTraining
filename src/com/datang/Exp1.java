package com.datang;

import java.util.Scanner;

public class Exp1 { 

	private static Scanner log;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//提示语句
		
		System.out.println();
		System.out.println("请选择您要执行的操作");
		System.out.println("1.管理员登录");
		System.out.println("2.用户登录");
		System.out.println("3.退出系统");
		log = new Scanner(System.in);
		int cho = log.nextInt();//输入其他字符报错
		if(cho == 1) {

			
		}else if(cho == 2){
			System.out.print("尊敬的用户您好!"); 
			//用户选项
		
			
		}
		else if (cho == 3) {
			System.out.println("感谢您的使用!期待下次与您相伴!");
			System.exit(-1);
		}else {
			System.out.println("请输入正确的选项");
		}	
		
		
		
	}

}
