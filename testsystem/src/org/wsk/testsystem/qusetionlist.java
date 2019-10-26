package org.wsk.testsystem;
import java.util.*;
public class qusetionlist {
	private List<qusetion> qlist = new ArrayList<>();
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) throws TestSystemException{
		if(this.name == ""){
			throw new TestSystemException("�б����Ʋ���Ϊ�գ�");
		}else{
			this.name = name;
		}
			
		
	}

	
	public qusetionlist(String name){
		try {
			setName(this.name);
		} catch (TestSystemException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public void addqusetion(qusetion q){
		qlist.add(q);
	}
	public void addqusetion(Collection<qusetion> c){
		qlist.addAll(c);
	}
	public void removequsetion(Object o){
		qlist.remove(o);
	}
	public qusetion getqusetion(int index){
		return qlist.get(index);
	}
	public int getleanth() {
		return qlist.size();
	}

}
