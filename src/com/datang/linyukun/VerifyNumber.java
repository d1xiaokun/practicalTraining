package com.datang.linyukun;

public class VerifyNumber {
	public int verifyNumber(String number) {
		if (number.equals("")) {
			return 0;
		} else if (number.length() < 6 || number.length() > 16) {
			return 1;
		} else {
			return 2;
		}
	}
}