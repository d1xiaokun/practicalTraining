package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.datang.model.User;
import com.mysql.jdbc.PreparedStatement;

public class DdRegister {
	public void ddRegister() throws Exception{
		/*
		 * ����Ա��Ӷ����������Ƴ�
		 */
			// 2.ע������
			Class.forName("com.mysql.jdbc.Driver");
			// 3.��ȡ���ݿ�����
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/superone", "root", "root");
			// 4.����sql���	
			String sql = "INSERT INTO jyxx(ddnumber,jyjf,jyyf)VALUE(?,?,?);";
			//5.��ȡsql���Ķ���
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			//PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(select);
			User user = new User();
			Scanner input = new Scanner(System.in);
			JudgeDDNumber jd = new JudgeDDNumber();
			String ddn=jd.judgeDDNumber();
			//String jf = input.nextLine().trim();
			JudgeName jn = new JudgeName();
			String jfn = jn.judgeJName();
			String yfn = jn.judgeYName();
			//6.ִ��sql���
			ps.setString(1, ddn);
			ps.setString(2, jfn);
			ps.setString(3, yfn);
			int res =ps.executeUpdate();
			 //System.out.println(res);
			//7.�鿴���ؽ��
					if(res != 0 ){
						System.out.println("==================================");
						System.out.println("��������ɹ�!");
						//��ʾһ�¹���Աע����Ϣ
						System.out.println("������Ϊ:"+ddn);
						System.out.println("�׷�Ϊ:"+jfn);
						System.out.println("�ҷ�Ϊ:"+yfn);
						System.out.println("==================================");
						System.out.println("�Ƿ񷵻ش�������?");
						System.out.println("1.���ؼ�����������");
						System.out.println("2.���س��ﶩ������");
						System.out.println("3.�˳�ϵͳ");
						Scanner admininput = new Scanner(System.in);
						String change =admininput.nextLine();
						while(!change.equals("1" )||!change.equals("1") ||!change.equals("3")){
							if (change.equals("1")) {
							ddRegister();
						} else if (change.equals("2")) {
							ManagePetTrade.managePetTrade();
						} else if (change.equals("3")) {
							Thread thread = new Thread();
							thread.sleep(800);//��ͣ0.8S
							System.out.println("ϵͳ�˳��ɹ�!��л����ʹ��!�ڴ��´��������!^_^");
							System.exit(-1);
						} else {
							System.err.println("��������ȷ��ѡ��!(1-3)");
							//new Scanner(System.in).nextLine();//ͣ��һ��
							change =admininput.nextLine();
							//Login();//�����벻��ѡ�����ѭ����ǰģ��
						}
						}
					}else {
						//ִ��sql���ʧ��
						System.err.println("��������ʧ��!");
						System.out.println("�����������´���");
						ddRegister();
				 }				
	}
}
