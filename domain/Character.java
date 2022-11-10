package domain;

import java.util.List;

public class Character {
	private String id;
	private int grade; //totalPoint 가져와서 grade로 계산 후 캐릭터로 하면 될듯.
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
		//만약 포인트가 해당 grade 범위 이상이면 업그레이드 해주기
		//imageView() 호출
	}
	
	public void imageView(Customer user, List<String> img, int grade) {
		//image를 해당 단계로 설정. imageList[grade - 1]로 view할 수 있게하고 뭔가를 호출해서 갱신되게.
	}
}
