package domain;

import java.util.ArrayList;

public class Item {
	//DB���� �ѹ��� ������ �ͼ� �����صθ� ������.��� �ǰ�.
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
	//�ƴ� DB���� itemPoint �� �����صΰ� �������°ɷ� �ұ�
}
