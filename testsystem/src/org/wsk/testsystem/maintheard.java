package org.wsk.testsystem;

import java.io.*;
import java.util.*;



public class maintheard implements Serializable{
	static boolean debug;
	public void test() {
		qusetion q1 = new qusetion();
		try {
			q1.setname("123");
			q1.setawnser("123");
			q1.setcanawnserbeempty(true);
		} catch (TestSystemException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		qusetion q2 = new qusetion();
		try {
			q2.setname("456");
			q2.setawnser("456");
			q2.setcanawnserbeempty(true);
		} catch (TestSystemException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		qusetionlist list = new qusetionlist("l1");
		list.addqusetion(q1);
		list.addqusetion(q2);
		qusetiongiver qg = new qusetiongiver(list);
		testhelper th = new testhelper("th1", qg);
		th.start();
		
				
	}
		

	public static void main(String[] args) {
		if (args.length == 0) {}
		else {
			if (args[0].equals("debug")){
				debug = true;
			}
		}
		try {
			FileInputStream ifs = new FileInputStream(args[1]);
			ObjectInputStream ios = new ObjectInputStream(ifs);
			Object o = ios.readObject();
			testhelper test = (testhelper) o;
			ios.close();
			test.start();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		

	}

}
