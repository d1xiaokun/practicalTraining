package com.datang.wjy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class establish {
	public void establish() throws Exception{
		System.out.println("��ӭ���봴����������");
		Scanner userInput =new Scanner(System.in);
		deal deal=new deal();  
		System.out.println("������׷���");
		deal.setJyjf(userInput.nextLine().trim());
		int num=0;
		while(deal.getJyjf().equals("")) {
			if(num>=3){
				System.err.println("�׷�����������࣬�����Żس���ϵͳ��ҳ��");
				enter enter=new enter();
				enter.enter();		
			}
			System.err.println("������׷���Ϊ�գ����������룡");
			deal.setJyjf(userInput.nextLine().trim());
			num++;
			}
		System.out.println("�������ҷ���");
		deal.setJyyf(userInput.nextLine().trim()); 
		int num1=0;
		while(deal.getJyjf().equals("")) {
			if(num1>=3){
				System.err.println("�ѷ�����������࣬�����Żس���ϵͳ��ҳ��");
				enter enter=new enter();
				enter.enter();		
			}
			System.err.println("�������ѷ���Ϊ�գ����������룡");
			deal.setJyjf(userInput.nextLine().trim());
			num1++;
			}		
		System.out.println("�����붩���źţ�");
		deal.setDdnumber(userInput.nextLine().trim());  
	    System.out.println("���Դ����ݿ�");
	    try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/superone","root","root");
	        String sql="INSERT INTO jyxx(jyjf,jyyf,ddnumber)VALUE(?,?,?)";
	        PreparedStatement ps=con.prepareStatement(sql);
	        ps.setString(1, deal.getJyjf());
	        ps.setString(2, deal.getJyyf());
	        ps.setString(3, deal.getDdnumber());
	        int res=ps.executeUpdate();
	         if(res!=0){
	        	System.out.println("�����ɹ�����ת����ҳ�棡");
	        	pet pet=new pet();
	        	pet.pet();
	         }
	        else{
	       	System.err.println("����ʧ�ܣ�");
	       	pet pet=new pet();
        	pet.pet();
	        }
			
	        con.close();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	   
}
