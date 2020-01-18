package org.wsk.testsystem;
import java.io.Serializable;
import java.util.*;

public class maintheard implements Serializable{
	static boolean debug;
	public void test() throws TestSystemException{
		qusetion q1 = new qusetion();
		q1.setawnser("123");
		q1.setname("123");
		q1.setcanawnserbeempty(true);
	    qusetion q2 = new qusetion();
	    q2.setawnser("456");
	    q2.setname("456");
	    q2.setcanawnserbeempty(false);
	    qusetionlist ql = new qusetionlist("qlist");
	    ql.addqusetion(q1);
	    ql.addqusetion(q2);
	    qusetiongiver qg = new qusetiongiver(ql);
	    testhelper test1 = new testhelper("test", qg);
	    test1.start();
	}
		

	public static void main(String[] args) {
		if (args.length == 0) {}
		else {
			if (args[0].equals("debug")){
				debug = true;
			}
		}
		try {
			new maintheard().test();
		} catch (TestSystemException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// TODO 自动生成的方法存根

	}

}
