package org.wsk.testsystem;
import java.util.*;
public class test {
	
	private String name;
	private boolean israndom;
	private qusetiongiver g;
	private randomgiver rg;
	private boolean isstart;
	private UUID u = new UUID(1 , 5);
	private UUID testuuid;
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
		testuuid = u.randomUUID();
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

	public UUID getTestuuid() {
		return testuuid;
	}

}
