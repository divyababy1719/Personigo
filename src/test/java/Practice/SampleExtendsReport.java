package Practice;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Mobicentrum.GenericUtility.BaseClass;

public class SampleExtendsReport extends BaseClass {
public WebDriver driver;

	@Test
	public void testA()
	{
		System.out.println("TestA implemented");
		
	}
	
	@Test
	public void testB()
	{
		System.out.println("TestB implemented");
	}
	@Test
	public void testC()
	{
		System.out.println("TestC Implemeted");
		Assert.fail();
	}
}
