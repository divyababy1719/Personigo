package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BookTicketDPWith3Arg {

	@Test(dataProvider = "dp_BookTicketDPWith3ArgTest")
	public void BookTicketDPWith3ArgTest(String src,String dest,int ticket)
	
	{
		System.out.println("Book ticket from "+src+"to "+dest+"  for "+ticket+" Tickets");
	}
	@DataProvider
	public Object[][] dp_BookTicketDPWith3ArgTest()
	{
		/*Object[][] obj=new Object[3][3];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Mumbai";
		obj[0][2]=2;
		
		obj[1][0]="Bangalore";
		obj[1][1]="Hydrabad";
		obj[1][2]=4;
		
		obj[2][0]="Bangalore";
		obj[2][1]="Calicut";
		obj[2][2]=3;
		return obj;*/
		
		
		return new Object[][] {{"Bangalore","Mumbai",2},{"Bangalore","Hydrabad",4}};
		
	}
}
