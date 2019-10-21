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
		System.out.println("第一题： ");
		String message;
		message = rug.nextqusetion().getname();	
		getinput(message);
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
