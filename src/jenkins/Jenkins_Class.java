package jenkins;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Jenkins_Class {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void openURL() {
		driver.get("https://the-internet.herokuapp.com/");

		driver.manage().window().maximize();

		WebElement inputsLink = driver.findElement(By.linkText("Dropdown"));
		inputsLink.click();

		String actualTitle = "The Internet";

		System.out.println(driver.getTitle());

		Assert.assertEquals(driver.getTitle(), actualTitle);

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("E:\\Angie Selenium Java\\JenkinsTest\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}