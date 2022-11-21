package model;

public class Post {
	private String category;
	private String title;
	private String text;
	
	public Post() {} 				//생성자
	
	public Post(String category, String title, String text) {
		this.category = category;
		this.title = title;
		this.text = text;
	} 

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
