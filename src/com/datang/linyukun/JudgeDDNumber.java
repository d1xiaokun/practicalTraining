package com.datang.linyukun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.datang.model.PetTrade;
import com.mysql.jdbc.PreparedStatement;

public class JudgeDDNumber {
	public String judgeDDNumber() throws Exception{
	Class.forName("com.mysql.jdbc.Driver");
	// 3.��ȡ���ݿ�����
	Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/superone", "root", "root");
	// ����sql���
	String select = "select * from jyxx where ddnumber=?";
	PreparedStatement ps1 = (PreparedStatement) con
			.prepareStatement(select);
	PetTrade pt = new PetTrade();
	Scanner input = new Scanner(System.in);
	System.out.println("1��������ӵĶ���:");
	pt.setDdnumber(input.nextLine().trim());
	if(pt.getDdnumber().equals("")){
		System.err.println("������Ķ���Ϊ��,����������!");
		judgeDDNumber() ;
	}
	ps1.setString(1, pt.getDdnumber());
	ResultSet eq = ps1.executeQuery();
	if(eq.next()){// ���ж��Ƿ��˺��Ƿ�ע��
			System.out.println("2��Ǹ,��������˺��ѱ�ע��!����������!");
			judgeDDNumber();
	}
	return pt.getDdnumber();
}
}