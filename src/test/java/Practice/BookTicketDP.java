package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BookTicketDP 
{
	@Test(dataProvider = "dp_BookTicketTest")
	public void bookTicketTest(String src,String dest)
	{
		System.out.println("Book tickets from  "+src+ "  to  "+dest);
	}
	
	@DataProvider
	public Object[][] dp_BookTicketTest()
	{
		/*Object[][] obj=new Object[3][2];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Chennai";
		
		obj[1][0]="Bangalore";
		obj[1][1]="Delhi";
		
		obj[2][0]="Bangalore";
		obj[2][1]="TVM";
		return obj;*/
		
		return new Object[][] {{"Bangalore","Chennai"},{"Bangalore","Delhi"},{"Bangalore","TVM"}};
	}
	
}
