package domain;

import java.util.Date;

public class Calendar {
	private String id;
	private int year;
	private int month;
	private int day;
	
	public Calendar() { }
	
	public Calendar(String id, int year, int month, int day) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void changeColor() {
		//색 정하기
		//색 저장. 어떻게? - html에 색 저장해 전달?
	}
	
	@Override
	public String toString() {
		return "Calendar [id=" + id + ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
}
