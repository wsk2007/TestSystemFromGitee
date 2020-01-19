package org.wsk.testsystem;

import java.io.*;
import java.util.*;



public class maintheard implements Serializable{
	static boolean debug;
	static Scanner s;
	public static void Write(){
		List<qusetion> ql = new ArrayList<>();
		s = new Scanner(System.in);
		int i = 0;
		for(;;) {
			if (getinput("More qusetion?").equals("yes")) {
				
				
			    ql.add(new qusetion());
			    try {
					ql.get(i).setname(getinput("Name:"));
					ql.get(i).setawnser(getinput("Awnser:"));
					ql.get(i).setcanawnserbeempty(true);
				} catch (TestSystemException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			    i++;
			}else {
				break;
			}
				
			
			
		}
		qusetionlist list = new qusetionlist("l1");
		for(qusetion q : ql) {
			list.addqusetion(q);
		}
		qusetiongiver qg = new qusetiongiver(list);
        testhelper th = new testhelper(getinput("Test name:"), qg);
		System.out.println("Please open debug mode and do this test");
		th.start();
		
		
		
		
		
				
	}
	
	private static String getinput(String inputtext) {
		String input = null;
		System.out.print(inputtext);
		try {
		    
		    
		    input = s.next();
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static void Read(String l) {
		try {
			FileInputStream ifs = new FileInputStream(l);
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
	
	public static void WriteRandom() {
		ArrayList<qusetion>[] qll = new ArrayList[5];
	
		s = new Scanner(System.in);
		qusetionlist[] list = new qusetionlist[5];
		qusetiongiver[] qgl = new qusetiongiver[5];
		int i = 0;
		int ln;
		for (int j = 0; j <= 4; j++) {
			qll[i] = new ArrayList<>();
			i = 0;
			ln = j + 1;
			System.out.println("List " + ln);
			
			for(;;) {
				
				
				if (getinput("More qusetion?").equals("yes")) {
					
					
				    qll[i].add(new qusetion());
				    try {
				    	qll[i].get(i).setname(getinput("Name:"));
				    	qll[i].get(i).setawnser(getinput("Awnser:"));
				    	qll[i].get(i).setcanawnserbeempty(true);
					} catch (TestSystemException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				    i++;
				}else {
					break;
				}
		    }
			
			list[j] = new qusetionlist("1");
			for(qusetion q : qll[i]) {
				list[j].addqusetion(q);
			}
			qgl[j] = new qusetiongiver(list[j]);
			try {
				qgl[j].getList().setName("1");
			} catch (TestSystemException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		randomgiver rg = new randomgiver();
		for(qusetiongiver qg : qgl) {
			rg.addgiver(qg);
		}
        testhelper th = new testhelper(getinput("Test name:"), rg);
		System.out.println("Please open debug mode and do this test");
		th.start();
		
	}
		
		

		public static void main(String[] args) {
		if (args.length == 0) {}
		else {
			if (args[0].equals("debug")){
				debug = true;
			}
		}
		if(args[1].equals("read")) {
			Read(args[2]);
			
		}
		if(args[1].equals("write")) {
			Write();
			
			
		}
		if(args[1].equals("writerandom")) {
			WriteRandom();
		}
		
		
		}
		
		
		
		

	

}
