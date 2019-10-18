package org.wsk.testsystem;
import java.security.*;
import java.util.*;
public class randomgiver {
	private qusetiongiver l1;
	private qusetiongiver l2;
	private qusetiongiver l3;
	private qusetiongiver l4;
	private qusetiongiver l5;
	private int num;
	SecureRandom sr = new SecureRandom();
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
		
			return checklist(sr.nextInt(num - 1));
		}
		
	}
	
	private qusetiongiver checklist (int listnum) {
		
		if(num == 1) {
			
			return l1;
			
		}if(num == 2) {
			
			return l2; 
			
		}if(num == 3) {
			
			return l3; 
			
		}if(num == 4) {
			
			return l4; 
			
		}if(num == 5) {
			
			return l5;
			
		}
		
		
		
	}

}
