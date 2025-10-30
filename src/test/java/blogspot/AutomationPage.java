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
public void FillInfo() throws InterruptedException {
	WebElement uname=driver.findElement(By.id("name"));
	uname.sendKeys("kamlesh");
	
	WebElement uemail=driver.findElement(By.id("email"));
	uemail.sendKeys("kamlesh@gmail.com");
	
	WebElement uphone=driver.findElement(By.id("phone"));
	uphone.sendKeys("9810245788");
	
	WebElement uadd=driver.findElement(By.id("textarea"));
	uadd.sendKeys("just in time matunga east mumbai ,pin code 400019");
	Thread.sleep(400);
}


//2.Radio Button (Gender:)
public void selectAllRadio() throws InterruptedException {
	List<WebElement> radios=driver.findElements(By.xpath("//*[@type='radio']"));
	for(WebElement radio : radios) {
		radio.click();
		Thread.sleep(500);
	}
	
}

// 3. Check Boxes (Days:)
public void selectAllCheckBox() throws InterruptedException {
   List<WebElement> checkBoxes= driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
	for(WebElement checkBox:checkBoxes) {
		checkBox.click();
		Thread.sleep(500);
	}
	//or
	driver.findElement(By.id("monday")).click();
}

  //4.Dropdown (Country:)
public void selectDropDown() throws InterruptedException {
	driver.findElement(By.id("country")).click();
	List<WebElement> dropDowns=driver.findElements(By.partialLinkText(""));
	for(WebElement dropDown:dropDowns) {
		dropDown.click();
		Thread.sleep(500);
	}
	//or 
	WebElement country=driver.findElement(By.partialLinkText("canada"));
	country.click();
}

//5.colour	
public void selectColour() throws InterruptedException {
WebElement colour=driver.findElement(By.partialLinkText("green"));
colour.click();
Thread.sleep(400);
}
}
