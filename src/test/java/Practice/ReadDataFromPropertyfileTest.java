package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertyfileTest 
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		
		p.getProperty("browser");
		String url = p.getProperty("url");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("password"));
		Thread.sleep(5000);
		driver.findElement(By.id("submitButton")).click();
		driver.close();


	}

}
