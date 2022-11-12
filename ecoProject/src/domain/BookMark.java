package domain;

public class BookMark {
	int postNo;

	// getter & setter
	public int getPostNo() { return postNo; }
	public void setPostNo(int postNo) { this.postNo = postNo; }
	
	void deleteBookmark(int postNo) { 
		this.postNo = postNo;
	}
	
	int quantityBookmark() { 
		return postNo;
	}

}
