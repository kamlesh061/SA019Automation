package blogspot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationPage {
WebDriver driver;

// Constructor
public AutomationPage(WebDriver driver) {
	this.driver=driver;
}

//1.Basic info
public void FillInfo() {
	WebElement uname=driver.findElement(By.id("name"));
	uname.sendKeys("kamlesh");
}

//2.Radio Button
public void selectAllRadio() throws InterruptedException {
	List<WebElement> radios=driver.findElements(By.xpath(""));
	for(WebElement radio : radios) {
		radio.click();
		Thread.sleep(200);
	}
	
}

}
