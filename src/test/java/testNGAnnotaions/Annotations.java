package testNGAnnotaions;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations 
{	@BeforeMethod
	public void beforeMethod()
	{
	Reporter.log("before each and every test method",true);
	}
	@AfterMethod
	public void afterMethod()
	{
	Reporter.log("after each and every test method",true);
	}
	@BeforeClass
	public void beforeClass()
	{
	Reporter.log("before each and every test class",true);
	}
	@AfterClass
	public void afterClass()
	{
	Reporter.log("after each and every test class",true);
	}
	@BeforeTest
	public void beforeTest()
	{
	Reporter.log("before each and every test block/runner",true);
	}
	@AfterTest
	public void afterTest()
	{
	Reporter.log("after each and every test block/runner",true);
	}
	@BeforeSuite
	public void beforeSuite()
	{
	Reporter.log("before test suite",true);
	}
	@AfterSuite
	public void afterSuite()
	{
	Reporter.log("after test suite",true);
	}
	
	class DemoA extends Annotations
	{
	@Test
	public void testA()
	{
	Reporter.log("testA...",true);
	}
	}
	class DemoB extends Annotations
	{
	@Test
	public void testB() 
	{
	Reporter.log("testB....",true);
	}
	@Test
	public void testC() 
	{
	Reporter.log("testC....",true);
	}
	}
	
}
