package com.datang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.datang.model.Admin;
import com.mysql.jdbc.PreparedStatement;

public class AdminRegister {//����Աע��
	public void adminRegister() {
		Admin admin = new Admin();
		Scanner input = new Scanner(System.in);
		System.out.println("��������ӵĹ���Ա�˺�:");//����֤����Ա�˺��Ƿ����ݿ��д�����executeQuery()�������ݿ���������˺���Ϣ,
											//Ȼ����ѭ����������˺���ƥ��,���û��һ�����˺ž��ܲ�����Ϣ�����ݿ�,�������������˺�
		String acc_number = input.nextLine();
		
		//����ע����֤���ݲ���
		System.out.println("��������ӵĹ���Ա����:");
		admin.setAcc_pwd(input.nextLine().trim());
		VerifyPwd verifyPwd = new VerifyPwd();
		int returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
		while(returnPwd == 0 || returnPwd == 1 ){
			if (returnPwd == 0) {
				System.err.println("�����������Ϊ��,����������!");
				admin.setAcc_pwd(input.nextLine().trim());
				returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
			}else if(returnPwd == 1){
				System.err.println("����������벻����6-16λ,����������!");
				admin.setAcc_pwd(input.nextLine().trim());
				returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
			}
		}
		System.out.println("��������һ��Ҫ��ӵĹ���Ա����:");
		String verifyConfirm = input.nextLine().trim();
		while(!admin.getAcc_pwd().equals(verifyConfirm)){
			System.err.println("������������벻һ��,�����������һ������!1");
			//System.out.println("����������1:");
			admin.setAcc_pwd(input.nextLine().trim());
			verifyPwd = new VerifyPwd();
			returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
			while(returnPwd == 0 || returnPwd == 1 ){
				if (returnPwd == 0) {
					System.err.println("1�����������Ϊ��,����������!");
					admin.setAcc_pwd(input.nextLine().trim());
					returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
				}else if(returnPwd == 1){
					System.err.println("1����������벻����6-16λ,����������!");
					admin.setAcc_pwd(input.nextLine().trim());
					returnPwd = verifyPwd.verifyPwd(admin.getAcc_pwd()) ;
				}
			}
			System.out.println("1��������һ��Ҫ��ӵĹ���Ա����:");
			verifyConfirm = input.nextLine();
		}
		
		
		//�ֻ���ע����֤���ݲ���
		System.out.println("��������ӵĹ���Ա�ֻ���:");
		admin.setPhone(input.nextLine().trim()) ;
		VerifyPhone verifyPhone = new VerifyPhone();
		int returnNumber = verifyPhone.verifyPhone(admin.getPhone()) ;
		while(returnNumber == 0 || returnNumber == 1 || returnNumber == 2){
			if(returnNumber == 0 ){
				System.err.println("��������ֻ���Ϊ��!����������:");
				admin.setPhone(input.nextLine().trim()) ;
				returnNumber = verifyPhone.verifyPhone(admin.getPhone()) ;
			}else if(returnNumber == 1 ){
				System.err.println("��������ֻ��Ų�Ϊ11λ!����������:");
				admin.setPhone(input.nextLine().trim()) ;
				returnNumber = verifyPhone.verifyPhone(admin.getPhone()) ;
				
			}else if (returnNumber == 2) {
				System.err.println("������Ĳ�����ʵ�ֻ���!����������:");
				admin.setPhone(input.nextLine().trim()) ;
				returnNumber = verifyPhone.verifyPhone(admin.getPhone()) ;
			}else {
				
			}
		}
		
		//�ܱ����ֲ���Ҫ��֤����
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
			ps.setString(2, admin.getAcc_pwd());
			ps.setString(3, admin.getPhone());
			ps.setString(4, mibao_Q);
			ps.setString(5, mibao);
			int res =ps.executeUpdate();
			 //System.out.println(res);
			//7.�鿴���ؽ��
			 
				// while(res != 0||change != "1"){
					if(res != 0 ){
						System.out.println("==================================");
						System.out.println("����Աע��ɹ�!���μ�������Ϣ!");
						//��ʾһ�¹���Աע����Ϣ
						System.out.println("���Ĺ���Ա�˺�Ϊ:"+acc_number);
						System.out.println("��������Ϊ:"+admin.getAcc_pwd());
						System.out.println("����ע���ֻ���Ϊ:"+admin.getPhone());
						System.out.println("�����ܱ���Ϊ"+mibao);
						System.out.println("==================================");
				 
						System.out.println("�Ƿ񷵻ص�¼����Ա�˺�?");
						System.out.println("1.���ع���Ա��¼");
						System.out.println("2.����������");
						System.out.println("3.�˳�ϵͳ");
						Scanner admininput = new Scanner(System.in);
						String change =admininput.nextLine();
						if (change.equals("1")) {
							Adminsystem.adminSystem();
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
						//ִ��sql���ʧ��
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
