package org.wsk.testsystem;

public class qusetiongiver {
	private qusetionlist list;
	private int num;
	
	public qusetiongiver(qusetionlist qlist){
		list = qlist;
		num = 0;
	}
	
	public qusetion nextqusetion(){
		qusetion q = list.getqusetion(num);
		num++;
		return q;
	}
	
	public int getnum() {
		return num;
	}

	public qusetionlist getList() {
		return list;
	}
	
	public void reset() {
		num = 0;
	}

}
