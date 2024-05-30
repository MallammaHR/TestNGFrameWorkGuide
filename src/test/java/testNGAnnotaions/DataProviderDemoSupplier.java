package testNGAnnotaions;

import org.testng.annotations.DataProvider;

public class DataProviderDemoSupplier 
{

	@DataProvider(name="TestData")
	public Object[][] testWithDataProvider()
	{
		Object[][] data=new Object[2][2];
		
		data[0][0]="Mallu";
		data[0][1]="mallu";
		
		data[1][0]="roopa";
		data[1][1]="roopadasd";
		
		return data;
	}

	
}
