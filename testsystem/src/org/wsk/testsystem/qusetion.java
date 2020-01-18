package org.wsk.testsystem;
import java.*;
import java.io.Serializable;

import javax.*;
import sun.*;
import com.*;
public class qusetion implements Serializable{
	private String name;
	private int num;
	transient private boolean isright;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	private String awnser;
	private Boolean isawnsered;
	public Boolean getIsawnsered() {
		return isawnsered;
	}

	public void setIsawnsered(Boolean isawnsered) {
		this.isawnsered = isawnsered;
	}

	private Boolean ismarked;
	public Boolean getIsmarked() {
		return ismarked;
	}

	public void setIsmarked(Boolean ismarked) {
		this.ismarked = ismarked;
	}

	private Boolean canawnserbeempty;
	
	public Boolean getcanawnserbeempty() {
		return canawnserbeempty;
	}
	
	public void setcanawnserbeempty(Boolean qcanawnserbeempty) {
		
		canawnserbeempty = qcanawnserbeempty;
		
			
		
		
	}
	
	public String getawnser() {
		return awnser;
	}
	
	public void setawnser(String qawnser) throws TestSystemException {
		if(qawnser == ""){
			throw new TestSystemException("答案不能为空！Awnser cannot be empty!");
		}else{
			awnser = qawnser;
			
		}
		
	}
	
	private String yourawnser;
	
	public String getyourawnser() {
		return yourawnser;
	}
	
	public void setyourawnser(String qyourawnser) throws TestSystemException{
		if(canawnserbeempty == false){
			if (qyourawnser == ""){
				throw new TestSystemException("答案不能为空！Awnser cannot be empty!");
			}else{
				yourawnser = qyourawnser;
			}
		}else{
			yourawnser = qyourawnser;
		}
		if(yourawnser == ""){
			
		}else{
			isawnsered = true;
		}
	}
	
	public String getname(){
		return name;
	}
	
	public void setname(String qname) throws TestSystemException{
		if(qname == ""){
			throw new TestSystemException("题目名称不能为空！Title cannot be empty!");
		}else{
			name = qname;
		}
	}
	
	public Boolean checkawnser(){
		Boolean qisright;
		if(awnser.equals(yourawnser)){
			qisright = true;
			isright = true;
			return qisright;
				
		}else{
			qisright = false;
			isright = false;
			return qisright;
		}
		
	}

	public boolean isIsright() {
		return isright;
	}
	

}
