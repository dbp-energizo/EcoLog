package model.domain;

import java.sql.Date;

public class Post {
	private int postNo;			//�Խñ� ��ȣ
	private int viewCount;		//��ȸ��
	private String writer;		
	private String category;	
	private String title;		
	private String text;		//�� ����
	private String file;		
	private Date date;		//�� ��¥
	
	// getter & setter
	public int getPostNo() { return postNo; }
	public void setPostNo(int postNo) { this.postNo = postNo; }
	public int getViewCount() { return viewCount; }
	public void setViewCount(int viewCount) { this.viewCount = viewCount; }
	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getText() { return text; }
	public void setText(String text) { this.text = text; }
	public String getFile() { return file; }
	public void setFile(String file) { this.file = file; }
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	
	void showPost(int postNo, int viewCount, String writer, String category, 
			String title, String text, String file, Date date) { 
		this.postNo = postNo; 
		this.viewCount = viewCount;
		this.writer = writer; 
		this.category = category; 
		this.title = title;
		this.text = text; 
		this.file = file; 
		this.date = date; 
	}
	
	void addBookmark(int postNo) {
		this.postNo = postNo; 
	}
}
