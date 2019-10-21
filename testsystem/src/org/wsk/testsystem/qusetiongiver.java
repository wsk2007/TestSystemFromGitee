package org.wsk.testsystem;

public class qusetiongiver {
	private qusetionlist list;
	private int num;
	
	public qusetiongiver(qusetionlist qlist){
		list = qlist;
		num = 0;
	}
	
	public qusetion nextqusetion(){
		num = num +1;
		return list.getqusetion(num - 1);
		
	}
	
	public int getnum() {
		return num;
	}

	public qusetionlist getList() {
		return list;
	}

}
