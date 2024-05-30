package testNGAnnotaions;

import org.testng.annotations.DataProvider;

public class DataProviderSupplier 
{
	@DataProvider
	public String[] dp1()
	{
		String[] str=new String[]
				{
					"mallu",
					"mani",
					"jai",
					"gu"	
				};
		return str;
	}
}
