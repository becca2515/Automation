package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Magento {
	
	@Test(priority=1, enabled=false)
	public void negative_login() throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		driver.get("http://magento.com");
		
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[8]/a/span[1]/i")).click();
		driver.findElement(By.name("login[username]")).sendKeys("becca2515@live.com");
		driver.findElement(By.id("pass")).sendKeys("hello");
		driver.findElement(By.name("send")).click();
		Thread.sleep(5000);
		String error=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
		System.out.println(error);
		if(error.equals("Invalid login or password."))
		{
		System.out.println("TestCase Pass");
		}
		else
		{
		System.out.println("TestCase Fail");
	}
		driver.quit();
}
	@Test(priority = 2)
	public void register() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[8]/a/span[1]/i")).click();
		driver.findElement(By.name("login[username]")).sendKeys("becca2515@live.com");
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("First");
		driver.findElement(By.id("lastname")).sendKeys("last");
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		Select type = new Select(driver.findElement(By.id("company_type")));
	type.selectByIndex(2);
// type.selectByValue("development");
	
// type.selectByVisibleText("Develops Magento extensions");
	Select role = new Select(driver.findElement(By.id("individual_role")));
	role.selectByValue("technical/developer");
	Select country = new Select(driver.findElement(By.className("country")));
	country.deselectByVisibleText("USA");
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys("welcome");
	
	if(!driver.findElement(By.id("agree_terms")).isSelected())
	{
		driver.findElement(By.id("agree_terms")).click();
		
	}
	}
}