package com.datang.wjy;

public class verifynumber {
	public int verifynumber(String number) {
		if (number.equals("")) {
			return 0;
		} else if (number.length() < 6 || number.length() > 16) {
			return 1;
		} else {
			return 2;
		}
	}
}
