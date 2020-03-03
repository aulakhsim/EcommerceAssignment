package com.ECommerceAssignment.test;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BuyProduct {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aulak\\Desktop\\chromedriver_win32 (4)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void BuyShirt() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("training.qaprep@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Testing123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.xpath("//a[@class='sf-with-ul']")).click();
		Actions action =new Actions(driver);
		WebElement women =driver.findElement(By.xpath("//a[@class='sf-with-ul']"));
		action.moveToElement(women).perform();
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
		
		WebElement img=driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']"));
		action.moveToElement(img).perform();
		driver.findElement(By.xpath("//span[text()='More']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")).click();
		
		Select size = new Select(driver.findElement(By.xpath("//*[@id='group_1']")));
		size.selectByIndex(2);
		
		driver.findElement(By.id("color_14")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
		//Thread.sleep(2000);
		driver.findElement(By.id("cgv")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'bankwire')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
		String title =driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
		System.out.println("title: " +title);
		
		Assert.assertTrue(title.contains("Your order on My Store is complete."));
		
		driver.close();
		
		
		
		
		
	
		
		
	}

}
