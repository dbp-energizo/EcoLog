package domain;

import java.util.Date;

public class Calendar {
	private String id;
	private Date day;
	
	public Calendar() { }
	
	public Calendar(String id, Date day) {
		super();
		this.id = id;
		this.day = day;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + "Date=" + day +"]";
	}
	
	public void displayCalendar() {
		//����� �̵�
	}
	
	public void changeColor() {
		//�� ���ϱ�
		//�� ����. ���? - html�� �� ������ ����
	}
	
	public void saveCalendar() {
		//DB�� �����ؼ� DB�� ����. �޷� ���� ���� �� �Լ� ȣ���ϸ� ��.
	}
}
