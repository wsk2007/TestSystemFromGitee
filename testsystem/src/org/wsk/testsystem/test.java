package org.wsk.testsystem;

public class test {
	
	private String name;
	private boolean israndom;
	private qusetiongiver g;
	private randomgiver rg;
	
	public test(String tname, qusetiongiver tg) {
		g = tg;
		israndom = false;
		name = tname;
	}
	
	public test(String tname, randomgiver trg) {
		rg = trg;
		israndom = true;
		name = tname;
	}

	public String getName() {
		return name;
	}

	public boolean isIsrandom() {
		return israndom;
	}

	public qusetiongiver getG() {
		return g;
	}

	public randomgiver getRd() {
		return rg;
	}

}
