package testNGAnnotaions;

import org.testng.annotations.Test;

public class PriorityDemo 
{
	@Test(priority = (int) 0.5)
	public void testA()
	{
		System.out.println("Mani");
	}
	@Test
	public void testB()
	{
		System.out.println("Manni");
		
	}
}
