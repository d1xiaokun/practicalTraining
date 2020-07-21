package com.datang.linyukun;
	import java.util.Scanner;
	import com.datang.wjy.main;
import com.datang.wjy.main;
public class Main {
	
		private static Scanner input;

		public static void main(String[] args) throws Exception {
			
			for (int i = 0; i < 30; i++) {
				System.out.print("=");
			}
			System.out.println();
			System.out.println("欢迎使用林佳涵宠物信息管理系统");
			System.out.println("\t\tversion 1.0");
			for (int i = 0; i < 30; i++) {
				System.out.print("=");
			}
			System.out.println();
			Login();

			input.close();
		}

		public static void Login() throws Exception {
			
			input = new Scanner(System.in);
			System.out.println("请选择您要执行的操作");
			System.out.println("1.管理员登录程序");
			System.out.println("2.用户登录程序");
			System.out.println("3.退出系统");
			String change = input.nextLine(); 
			
			if (change.equals("1")) {
				System.out.println("\n你好管理员,欢迎回来!");
				Adminsystem.adminSystem();

			} else if (change.equals("2")) {
				System.out.print("尊敬的用户您好!");
				// 用户选项
				//王佳媛、万玉涵内容
				//UserSystem userSystem = new UserSystem();
				//userSystem.usersystem();
				//Login();
				main  a = new main();
				a.main();
			} else if (change.equals("3")) {
				Thread thread = new Thread();
				
				thread.sleep(800);//暂停0.8S
				System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
				System.exit(-1);
			} else {
				System.err.println("请输入正确的选项!(1-3)!");
				//new Scanner(System.in).nextLine();//停顿一下
				Login();//若输入不在选项继续循环当前模块
			}

		}
	/*
	 * 7.16:输入验证没有练习
	 */

}
