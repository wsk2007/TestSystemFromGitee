package org.wsk.testsystem;
import java.util.*;
public class test {
	
	private String name;
	private boolean israndom;
	private qusetiongiver g;
	private randomgiver rg;
	private boolean isstart;
	private UUID u = new UUID(1 , 5);
	private String testuuid;
	public test(String tname, qusetiongiver tg) {
		g = tg;
		israndom = false;
		name = tname;
		isstart = false;
	}
	
	public test(String tname, randomgiver trg) {
		rg = trg;
		israndom = true;
		name = tname;
		isstart = false;
	}
	
	public void start() {
		isstart = true;
		testuuid = u.randomUUID().toString().replace("-", "").toLowerCase();
		echo();
		testing();
	}
	
	private void echo() {
		System.out.println("Starting test test " + name);
		System.out.println("The UUID of this test is: " + testuuid);
		System.out.println("Random qusetion list: " + israndom);
	}
	
	private void testing() {
		
	}
	
	private String getinput(String inputtext) {
		Scanner s = new Scanner(System.in);
		String input;
		System.out.print(inputtext);
		input = s.next();
		return input;
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

	public boolean isIsstart() {
		return isstart;
	}

	public String getTestuuid() {
		return testuuid;
	}

}
