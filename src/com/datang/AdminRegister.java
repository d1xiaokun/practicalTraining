package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminRegister {//����Աע��
	public void adminRegister() {
		Scanner input = new Scanner(System.in);
		System.out.println("��������ӵĹ���Ա�˺�:");//����֤����Ա�˺��Ƿ����ݿ��д�����executeQuery()�������ݿ���������˺���Ϣ,
												//Ȼ����ѭ����������˺���ƥ��,���û��һ�����˺ž��ܲ�����Ϣ�����ݿ�,�������������˺�
		String acc_number = input.nextLine();
		System.out.println("��������ӵĹ���Ա����:");
		String acc_pwd = input.nextLine();
		System.out.println("��������ӵĹ���Ա�ֻ���:");
		String phone = input.nextLine().trim();
		
		
		
		
		
		
		
		
		
		
		System.out.println("��������ӵĹ���Ա�ܱ�����:");
		String mibao_Q = input.nextLine();
		System.out.println("��������ӵĹ���Ա�ܱ���:");
		String mibao = input.nextLine();

		try {
			// 2.ע������
			Class.forName("com.mysql.jdbc.Driver");
			// 3.��ȡ���ݿ�����
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.����sql���	
			String sql = "INSERT INTO admin(acc_number,acc_pwd,phone,mibao_Q,mibao)VALUE(?,?,?,?,?);";
			//ɾ delete from admin where xxxx
			 //�� update admin set xxx where xxx
			  //�� select * from admin
			//5.��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			//6.ִ��sql���
			ps.setString(1, acc_number);
			ps.setString(2, acc_pwd);
			ps.setString(3, phone);
			ps.setString(4, mibao_Q);
			ps.setString(5, mibao);
			int res =ps.executeUpdate();
			 System.out.println(res);
			//7.�鿴���ؽ��
			 
				// while(res != 0||change != "1"){
					if(res != 0 ){
				 System.out.println("����Աע��ɹ�!");
						System.out.println("�Ƿ񷵻ص�¼����Ա�˺�?");
						System.out.println("1.���ع���Ա��¼");
						System.out.println("2.����������");
						System.out.println("3.�˳�ϵͳ");
						Scanner admininput = new Scanner(System.in);
						String change =admininput.nextLine();
						if (change.equals("1")) {
							Adminlogin.adminlogin();
						} else if (change.equals("2")) {
							
							Main.Login();
						} else if (change.equals("3")) {
							Thread thread = new Thread();
							
							thread.sleep(800);//��ͣ0.8S
							System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
							System.exit(-1);
						} else {
							System.err.println("��������ȷ��ѡ��!(1-3)");
							new Scanner(System.in).nextLine();//ͣ��һ��
							//Login();//�����벻��ѡ�����ѭ����ǰģ��
						}
					}else {
						System.err.println("����Աע��ʧ��!");
						System.out.println("������������ע��");
						adminRegister();
					//}
				 }
				
			//8.�ͷ���Դ
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
