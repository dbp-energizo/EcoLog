package domain;

import java.util.List;

public class Character {
	private String id;
	private int grade; //totalPoint �����ͼ� grade�� ��� �� ĳ���ͷ� �ϸ� �ɵ�.
	private String nickname;
	private List<String> imageList;
	
	public Character(String id, int grade) {
		super();
		this.id = id;
		this.grade = grade;
	}
	
	public Character(String id, String nickname) {
		super();
		this.id = id;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", grade=" + grade + "]";
	}
	
	public void growCharacter(Customer user) {
		int point = user.getPoint();
		//���� ����Ʈ�� �ش� grade ���� �̻��̸� ���׷��̵� ���ֱ�
		//imageView() ȣ��
	}
	
	public void imageView(Customer user, List<String> img, int grade) {
		//image�� �ش� �ܰ�� ����. imageList[grade - 1]�� view�� �� �ְ��ϰ� ������ ȣ���ؼ� ���ŵǰ�.
	}
}
