package Driver_Package;

import Common_API_Methods.Common_Utility_Method;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class DynamicDriverClass {
	
	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		
		ArrayList<String> TestCasetoRun=Common_Utility_Method.ReadDataExcel("TestCase", "TCtoExecute");
		System.out.println(TestCasetoRun);
		
		
		int count=TestCasetoRun.size();
		for (int i=1; i<count; i++)
			
			
			
			{
			String TestCaseName=TestCasetoRun.get(i);
			System.out.println("Test Case to Execute is :"+TestCaseName+".");
			
			// call the testcaseclass on runtime by using java.lang.reflect package
			Class<?> testclassname=Class.forName("Test_Classes."+TestCaseName);
			
			// call the execute method belonging to test class captured in variable testclassname by using java.lang.reflect.method class
			Method executemethod=testclassname.getDeclaredMethod("extractor");
			
			//set the accessibility of method true 
			executemethod.setAccessible(true);
			
			//create the instance of testclass captured in variable name testclassname
			Object instanceoftestclass=testclassname.getDeclaredConstructor().newInstance();
			// execute the testclass captured in variable name testclass name
		    executemethod.invoke(instanceoftestclass);
			}
			}
			}

