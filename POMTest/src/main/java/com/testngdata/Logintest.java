package com.testngdata;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logintest {
WebDriver driver;

@BeforeMethod
public void setup(){
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
	
	driver = new ChromeDriver();	
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.get("https://www.facebook.com");
}

	@Test
	public void loginTest(String username, String password){
		
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		
	
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
	WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",loginbtn);
		
		
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
}
