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
			System.out.println("��ӭʹ���ּѺ�������Ϣ����ϵͳ");
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
			System.out.println("��ѡ����Ҫִ�еĲ���");
			System.out.println("1.����Ա��¼����");
			System.out.println("2.�û���¼����");
			System.out.println("3.�˳�ϵͳ");
			String change = input.nextLine(); 
			
			if (change.equals("1")) {
				System.out.println("\n��ù���Ա,��ӭ����!");
				Adminsystem.adminSystem();

			} else if (change.equals("2")) {
				System.out.print("�𾴵��û�����!");
				// �û�ѡ��
				//�����¡���������
				//UserSystem userSystem = new UserSystem();
				//userSystem.usersystem();
				//Login();
				main  a = new main();
				a.main();
			} else if (change.equals("3")) {
				Thread thread = new Thread();
				
				thread.sleep(800);//��ͣ0.8S
				System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
				System.exit(-1);
			} else {
				System.err.println("��������ȷ��ѡ��!(1-3)!");
				//new Scanner(System.in).nextLine();//ͣ��һ��
				Login();//�����벻��ѡ�����ѭ����ǰģ��
			}

		}
	/*
	 * 7.16:������֤û����ϰ
	 */

}
