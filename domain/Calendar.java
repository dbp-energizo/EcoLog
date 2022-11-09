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
		//계산기로 이동
	}
	
	public void changeColor() {
		//색 정하기
		//색 저장. 어떻게? - html에 색 저장해 전달
	}
	
	public void saveCalendar() {
		//DB와 연결해서 DB에 저장. 달력 끄기 전에 이 함수 호출하면 됨.
	}
}
