package com.datang;

import java.util.Scanner;

public class ChangeAdPwd {
	public static void changAdPwd() throws Exception{
		//AdminRetrievePwd
		/*先连接数据库
		 * 找回方式为2种
		 * 1.验证注册手机号
		 * 2.验证密保信息,提示密保问题
		 */
//		输入账号    不验证账号是否正确,提高安全性,防止知道账号猜密码,但要验证输入的账号是否为空
		
		System.out.println("请选择您要找回密码的方式:");
		System.out.println("1.验证注册手机号");
		System.out.println("2.验证密保信息");
		System.out.println("3.返回上一级");
		System.out.println("4.退出程序");
		Scanner input = new Scanner(System.in);
		String choose1 =input.nextLine();
		if (choose1.equals("1") ) {//用户选择1匹配数据库的账号信息&&密保都正确才可以
		ChangeByPhone changeByPhone = new ChangeByPhone();
		//changeByPhone.
		}else if (choose1.equals("2")) {//用户选择2匹配数据库的账号信息&&手机号都正确才可以
			
		}else if (choose1.equals("3")){
			System.out.println("请稍等...");
			Thread thread = new Thread();
			thread.sleep(200);//暂停0.2S
			System.out.println("OK!正在返回上一级");
			Adminsystem.adminSystem();;
		}else if (choose1.equals("4")){
			Thread thread = new Thread();
			thread.sleep(800);// 暂停0.8S
			System.out.println("系统退出成功!感谢您的使用!期待下次与您相伴!^_^");
			System.exit(-1);
		}else {
			System.err.println("请输入正确的选项(1-4),回车继续!");
			new Scanner(System.in).nextLine();//停顿一下
			changAdPwd();//若输入不在选项继续循环当前模块
		}
		
		
		//验证成功后提示修改密码Updata
		//修改成功提示修改成功并询问是否返回登录还是退出程序
	}
}
