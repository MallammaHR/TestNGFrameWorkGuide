package testNGAnnotaions;

import org.testng.annotations.DataProvider;

public class ParametrizationTestNGWithDataProviderSuuplier 
{
	@DataProvider(name="logindata")
	public Object[][] testLoginWithData()
	{
		Object[][] data=new Object[2][2];
		 
		data[0][0]="mallusreddy@gmail.com";
		data[0][1]="mallumani";
		
		data[1][0]="mallusreddy@gmail.com";
		data[1][1]="mallumani123";
		
		return data;
	}
}
