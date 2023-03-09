package com.MailUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMain {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/ramendrakumar/Downloads/chromedriver_mac_arm64/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://phptravels.com/demo/");
		driver.close();
		

	}

}
