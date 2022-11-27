package model;

import java.util.List;
/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
public class User {
	private String userId;
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birth;
	private String nickName; 
	private int point; 
	private int regDate; 
	//private Character ch = new Character(id, nickName);
	private List<String> imageList;
	
	public User(java.lang.String userId, java.lang.String password, java.lang.String name, java.lang.String phoneNumber,
			java.lang.String email, String address, java.lang.String birth, java.lang.String nickName, int point,
			/*List<Meeting> meeting,*/ int regDate) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.nickName = nickName;
		this.point = point;
	//	this.meeting = meeting;
		this.regDate = regDate;
	}
	public User(String userId, String password, String name, String nickName, 
			String birth, String email, String phoneNumber) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.birth = birth;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getphoneNumber() {
		return phoneNumber;
	}

	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getnickName() {
		return nickName;
	}

	public void setnickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	/*
	 * public List<Meeting> getMeeting() { return meeting; }
	 * 
	 * public void setMeeting(List<Meeting> meeting) { this.meeting = meeting; }
	 */
	public int getRegDate() {
		return regDate;
	}

	public void setRegDate(int regDate) {
		this.regDate = regDate;
	}

//	public Character getCh() {
//		return ch;
//	}
//
//	public void setCh(Character ch) {
//		this.ch = ch;
//	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	/* 비밀번호 검사 */
	public boolean matchPW(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}
	
	public boolean isSameUser(String userid) {
        return this.userId.equals(userid);
    }

	@java.lang.Override
	public String toString() {
		return "user [userId=" + userId + ", password=" + password + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", address=" + address + ", birth=" + birth + ", nickName=" + nickName + ", point=" + point
				+ ", regDate=" + regDate + "]";
	}
	
}