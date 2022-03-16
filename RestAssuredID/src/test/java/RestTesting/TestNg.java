package RestTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg {


@BeforeSuite
public void BS()
{
	System.out.println("This is going to execute first");
}

//if i have many test and if i want to execute any pre-requite before i can use before test
@BeforeTest
public void BT()
{
	System.out.println("This one will excute after Before suite");
}

@BeforeClass
public void BC()
{
	System.out.println("This one will excute before the class gets executed");
}
//This will execute before every @Test Method
@BeforeMethod
public void BM()
{
	System.out.println("This will execute before every Test Method");
}

@Test
public void testcase1()
{
	System.out.println("This is the first test method");
}
@Test
public void testcase2()
{
	System.out.println("This is the second test method");
}
@AfterMethod
public void AM()
{
	System.out.println("After executing each test method");
}

@AfterClass
public void AC()
{
	System.out.println("This will excute after the class");
}

@AfterTest
public void AT()
{
	System.out.println("This will excute after all the test is executed");
}

@AfterSuite
public void AS()
{
	System.out.println("This will execute after evertything at the end");
}}

