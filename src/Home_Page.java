import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Home_Page {

	public static void main(String[] args) {
// testng : ng (next generation)
//	sendkeys only take string
//	variable names start with small letter
		
		System.setProperty("webdriver.chrome.driver", "G:\\my new driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		String username = "standard_user";
		String password = "secret_sauce";
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
//		if (actualTitle==expectedTitle) {
//		System.out.println("passed");
//	}
//	else {
//		System.out.println("failed");
//	}

		int expectedAddedNumber = 6;
		List<WebElement> myButtons = driver.findElements(By.className("btn"));
		
		for(int i=0 ; i < myButtons.size();i++) {
			
			myButtons.get(i).click();
		}
		
		String actualItemAdded = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		
		System.out.println(actualItemAdded);
		
		int realAddedNumber=Integer.parseInt(actualItemAdded);
		
		
		Assert.assertEquals(realAddedNumber, expectedAddedNumber);
		
	
	}

}
