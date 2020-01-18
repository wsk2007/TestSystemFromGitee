package org.wsk.testsystem;

import java.io.Serializable;

public class TestSystemException extends Exception implements Serializable{
	public TestSystemException (String ErrMsg){
		super(ErrMsg);
	}
	

}
