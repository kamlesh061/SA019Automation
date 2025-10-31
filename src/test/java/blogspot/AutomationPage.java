package blogspot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AutomationPage {
WebDriver driver;

// Constructor
public AutomationPage(WebDriver driver) {
	this.driver=driver;
}

//1.Basic info
public void FillInfo() throws InterruptedException {
	System.out.println("Url is testautomationpractice.blogspot.com/" );
	WebElement uname=driver.findElement(By.id("name"));
	uname.sendKeys("kamlesh");
	
	WebElement uemail=driver.findElement(By.id("email"));
	uemail.sendKeys("kamlesh@gmail.com");
	
	WebElement uphone=driver.findElement(By.id("phone"));
	uphone.sendKeys("9810245788");
	
	WebElement uadd=driver.findElement(By.id("textarea"));
	uadd.sendKeys("just in time matunga east mumbai ,pin code 400019");
	System.out.println("Basic form fields populated.");
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
   /*List<WebElement> checkBoxes= driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
	for(WebElement checkBox:checkBoxes) {
		checkBox.click();
		Thread.sleep(500);
	}
	*/
	//or
	driver.findElement(By.id("monday")).click();
	driver.findElement(By.id("tuesday")).click();
	System.out.println("Days is selected Monday and Tuesday");
	 Thread.sleep(1000);
}

  //4.Dropdown (Country:)
public void selectDropDown() throws InterruptedException {
	Select countrySelect = new Select(driver.findElement(By.id("country")));
    countrySelect.selectByVisibleText("Canada");
    System.out.println("Country selected is Canada.");
	Thread.sleep(500);
	}
	

//5.Color	
public void selectColour() throws InterruptedException {
	Select selectcolor = new Select(driver.findElement(By.id("colors")));
	selectcolor.selectByVisibleText("Red");
	System.out.println("Selected colour is Red");
    Thread.sleep(500);
}
//Sorted List:
public void selectSortList() throws InterruptedException {
	Select selectSortedList=new Select(driver.findElement(By.id("animals")));
	selectSortedList.selectByVisibleText("Cheetah");
	System.out.println("Selected Sorted list cheetah");
	Thread.sleep(1000);
}

// Date Picker Interactions
public void selectDate() throws InterruptedException {
	//Date Picker 1: Direct SendKeys (Easiest method if field is editable)
    WebElement datePickerInput = driver.findElement(By.id("datepicker"));
    datePickerInput.clear();
    datePickerInput.sendKeys("10/31/2025");
    System.out.println("Date Picker 1: Date set using SendKeys to 12/31/2025.");
    Thread.sleep(1500);
    
 // Date Picker 2: UI Interaction (Selecting a future date)
    datePickerInput.click(); // Open the calendar
    System.out.println("Date Picker 2: Opened calendar UI.");
    Thread.sleep(800);
    
    // Click the 'Next' button twice to move two months forward
    for (int i = 0; i < 2; i++) {
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(200);
    }
    
 // Select the 25th day of the visible month
    driver.findElement(By.xpath("//a[text()='25']")).click();
    System.out.println("   Date selected by navigating and clicking '25'.");
    Thread.sleep(1500);
}



}
