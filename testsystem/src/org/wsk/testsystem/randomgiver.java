package org.wsk.testsystem;
import java.io.Serializable;
import java.security.*;
import java.util.*;
public class randomgiver implements Serializable{
	private qusetiongiver l1;
	private qusetiongiver l2;
	private qusetiongiver l3;
	private qusetiongiver l4;
	private qusetiongiver l5;
	private int num;
	transient SecureRandom sr = new SecureRandom();
	public randomgiver() {
		
		num = 1;
	}
	
	public randomgiver(qusetiongiver g ) {
		
		l1 = g;
		num = 2;
	}
	
	public void addgiver(qusetiongiver g) {
		if(num == 1) {
			l1 = g;
		}if(num == 2) {
			l2 = g;
		}if(num == 3) {
			l3 = g;
		}if(num == 4) {
			l4 = g;
		}if(num == 5) {
			l5 = g;
		}
		num = num + 1;
	}
	
	public qusetiongiver giverandom() throws TestSystemException{
		if(num ==1) {
			throw new TestSystemException("没有问题列表！ The list is empty!");
		}else {
			int listnum;
			listnum = sr.nextInt(num - 1);
			qusetiongiver rql = null;
			if(listnum == 1) {
				rql = l1;
			}if(listnum == 2) {
				rql = l2;
			}if(listnum == 3) {
				rql = l3;
			}if(listnum == 4) {
				rql = l4;
			}if(listnum == 5) {
				rql = l5;
			}
			return rql;
		}
		
	}
	


	public qusetiongiver getL1() {
		return l1;
	}

	public qusetiongiver getL2() {
		return l2;
	}

	public qusetiongiver getL3() {
		return l3;
	}

	public qusetiongiver getL4() {
		return l4;
	}

	public qusetiongiver getL5() {
		return l5;
	}

}
