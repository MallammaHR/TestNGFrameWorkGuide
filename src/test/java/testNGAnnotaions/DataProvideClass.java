package testNGAnnotaions;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideClass 
{
	@Test(dataProvider="dp1")
	public void testStringData(String str2) throws IOException
	{
		System.out.println(str2);
	}
	
	@DataProvider(indices = {1,3})
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
