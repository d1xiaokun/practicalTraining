package com.datang.linyukun;

public class VerifyPwd {
	public int  verifyPwd(String password) {
		if (password.equals("")) {
			return 0;
		}else if (password.length()<6||password.length()>16) {
			return 1;
		}else {
			return 2;
		}
	}
}
