package org.wsk.testsystem;

import java.io.Serializable;

public class qusetiongiver implements Serializable {
	private qusetionlist list;
	private int num;
	
	public qusetiongiver(qusetionlist qlist){
		list = qlist;
		num = 0;
	}
	
	public qusetion nextqusetion(){
		qusetion q; 
		try {
			q = list.getqusetion(num);
		}catch(Exception ex){
			qusetion nq = new qusetion();
			try {
				nq.setname("no");
			} catch (TestSystemException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return nq;
		}
		
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
