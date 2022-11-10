package domain;

import java.util.ArrayList;

public class Item {
	//DB에서 한번에 가지고 와서 저장해두면 좋을듯.없어도 되고.
	 ArrayList<String> itemList; 
	 ArrayList<Integer> pointList; 
	 
	 public ArrayList<String> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<String> itemList) {
		this.itemList = itemList;
	}


	public ArrayList<Integer> getPointList() {
		return pointList;
	}


	public void setPointList(ArrayList<Integer> pointList) {
		this.pointList = pointList;
	}
	//아님 DB에만 itemPoint 값 저장해두고 가져오는걸로 할까
}
