package com.datang;

import java.util.Scanner;

public class ChangeAdPwd {
	public static void changAdPwd() throws Exception{
		//AdminRetrievePwd
		/*���������ݿ�
		 * �һط�ʽΪ2��
		 * 1.��֤ע���ֻ���
		 * 2.��֤�ܱ���Ϣ,��ʾ�ܱ�����
		 */
//		�����˺�    ����֤�˺��Ƿ���ȷ,��߰�ȫ��,��ֹ֪���˺Ų�����,��Ҫ��֤������˺��Ƿ�Ϊ��
		
		System.out.println("��ѡ����Ҫ�һ�����ķ�ʽ:");
		System.out.println("1.��֤ע���ֻ���");
		System.out.println("2.��֤�ܱ���Ϣ");
		System.out.println("3.������һ��");
		System.out.println("4.�˳�����");
		Scanner input = new Scanner(System.in);
		String choose1 =input.nextLine();
		if (choose1.equals("1") ) {//�û�ѡ��1ƥ�����ݿ���˺���Ϣ&&�ܱ�����ȷ�ſ���
		ChangeByPhone changeByPhone = new ChangeByPhone();
		//changeByPhone.
		}else if (choose1.equals("2")) {//�û�ѡ��2ƥ�����ݿ���˺���Ϣ&&�ֻ��Ŷ���ȷ�ſ���
			
		}else if (choose1.equals("3")){
			System.out.println("���Ե�...");
			Thread thread = new Thread();
			thread.sleep(200);//��ͣ0.2S
			System.out.println("OK!���ڷ�����һ��");
			Adminsystem.adminSystem();;
		}else if (choose1.equals("4")){
			Thread thread = new Thread();
			thread.sleep(800);// ��ͣ0.8S
			System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
			System.exit(-1);
		}else {
			System.err.println("��������ȷ��ѡ��(1-4),�س�����!");
			new Scanner(System.in).nextLine();//ͣ��һ��
			changAdPwd();//�����벻��ѡ�����ѭ����ǰģ��
		}
		
		
		//��֤�ɹ�����ʾ�޸�����Updata
		//�޸ĳɹ���ʾ�޸ĳɹ���ѯ���Ƿ񷵻ص�¼�����˳�����
	}
}
