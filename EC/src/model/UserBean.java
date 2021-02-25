package model;

import java.io.Serializable;

public class UserBean implements Serializable {
	//1.user情報を入れるためid,name,ageをカプセル化する
	private int userId;
	private String loginId = "";
	private String loginPw = "";

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPw() {
		return loginPw;
	}
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

}
