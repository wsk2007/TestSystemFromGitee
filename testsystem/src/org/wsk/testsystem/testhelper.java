package org.wsk.testsystem;
import java.util.*;
import java.io.*;
public class testhelper implements Serializable{
	
	private String name;
	private boolean israndom;
	private qusetiongiver g;
	private randomgiver rg;
	private boolean isstart;
	private UUID u = new UUID(1 , 5);
	private String testuuid;
	Scanner s = new Scanner(System.in);
	public testhelper(String tname, qusetiongiver tg) {
		g = tg;
		israndom = false;
		name = tname;
		isstart = false;
	}
	
	public testhelper(String tname, randomgiver trg) {
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
		qusetiongiver rug;
		System.out.println("您现在进行的是 " + name + "考试");
		if(israndom == true) {
			try {
				rug =  rg.giverandom();
				System.out.println("本次考试采用随机题库，您的题库是： " + rug.getList().getName());
				testing2(rug);
			} catch (TestSystemException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else {
			testing2(g);
		}
	}
	
	private void testing2(qusetiongiver rug) {
		String message;
		String awnser = null;
		qusetion q;
		int num;
		for(int i = 0; i <= rug.getList().getleanth(); i++) {
			num = i + 1;
			System.out.println("第" + num + "题： ");
		    q = rug.nextqusetion();	
		    if(q.getname() == "no") {
		    	finish(rug);
		    	return;
		    }else {
		    	message = q.getname();
		        awnser = getinput(message);
		    }
		    
		    try {
			    q.setyourawnser(awnser);
		    } catch (TestSystemException e) {
			    e.printStackTrace();
		    }
		    q.checkawnser();
		 
		}
		finish(rug);
	}
	
	private void finish(qusetiongiver rug){
		int wholenum = rug.getList().getleanth();
		int correctnum = 0;
		rug.reset();
		boolean isright;
		for(int i = 0; i <= rug.getList().getleanth(); i++) {
			isright = rug.nextqusetion().isIsright();
			if(isright == true) {
				correctnum++;
			}else {
				
			}
		}
		s.close();
		System.out.println("考试结束");
		System.out.println("你的分数是:" + wholenum + "/" + correctnum);
	}
	
	
	private String getinput(String inputtext) {
		String input = null;
		System.out.print(inputtext);
		try {
		    
		    
		    input = s.next();
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		isstart = false;
		return input;
	}
	
	public void savetest() {
		
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
