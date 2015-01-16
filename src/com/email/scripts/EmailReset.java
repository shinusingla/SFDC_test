package com.email.scripts;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class EmailReset {

	public static void main(String[] args) 
	{
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { EmailResetScript.class });
		testng.addListener(tla);
		testng.run();
	}
}
