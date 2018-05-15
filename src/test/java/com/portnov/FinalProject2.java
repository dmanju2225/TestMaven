package com.portnov;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FinalProject2 {
private WebDriver driver;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/login");
		WebElement user=driver.findElement(By.id("username"));
		user.sendKeys("tomsmith");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		WebElement login=driver.findElement(By.className("radius"));
		login.click();
		WebElement loggedin=driver.findElement(By.id("flash"));
		System.out.println(loggedin.getText());
		
		assertEquals("You logged into a secure area!\n×" ,loggedin.getText());
		
		WebElement logout=driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
		logout.click();
		WebElement loggedout=driver.findElement(By.id("flash"));
		System.out.println(loggedout.getText());
		assertEquals("You logged out of the secure area!\n×",loggedout.getText());
		
	}

}
