package org.wsk.testsystem;
import java.util.*;
public class testhelper {
	
	private String name;
	private boolean israndom;
	private qusetiongiver g;
	private randomgiver rg;
	private boolean isstart;
	private UUID u = new UUID(1 , 5);
	private String testuuid;
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
		System.out.println("�����ڽ��е��� " + name + "����");
		if(israndom == true) {
			try {
				rug =  rg.giverandom();
				System.out.println("���ο��Բ��������⣬��������ǣ� " + rug.getList().getName());
				testing2(rug);
			} catch (TestSystemException e) {
				// TODO �Զ����ɵ� catch ��
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
		for(int i = 0; i <= rug.getnum(); i++) {
			num = i + 1;
			System.out.println("��" + num + "�⣺ ");
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
			    // TODO �Զ����ɵ� catch ��
			    e.printStackTrace();
		    }
		    q.checkawnser();
		    if(i == rug.getnum() - 1) {
		    	break;
		    }
		}
		finish(rug);
	}
	
	private void finish(qusetiongiver rug){
		int wholenum = rug.getnum();
		int correctnum = 0;
		rug.reset();
		boolean isright;
		for(int i = 0; i <= rug.getnum(); i++) {
			isright = rug.nextqusetion().isIsright();
			if(isright == true) {
				correctnum++;
			}else {
				
			}
		}
		System.out.println("���Խ���");
		System.out.println("��ķ�����:" + wholenum + "/" + correctnum);
	}
	
	
	private String getinput(String inputtext) {
		String input = null;
		Scanner s = new Scanner(System.in);
		System.out.print(inputtext);
		try {
		    
		    
		    input = s.next();
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		s.close();
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
