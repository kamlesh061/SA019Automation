package blogspot;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseAutomation {
	  WebDriver driver;
	  
	     public void setUp() {
	         //System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
	         driver = new ChromeDriver();
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	         driver.manage().window().maximize();
	         driver.get("https://testautomationpractice.blogspot.com/");
	     }
	
	     public void tearDown() {
	         if (driver != null) {
	             driver.quit();
	         }
}
}
/*
 * git init
 * git add .
 * git commit -m "Your descriptive commit message"
 * git push -u origin <BRANCH_NAME>
 */
