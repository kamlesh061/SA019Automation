package pom1AutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PracticePage {
    WebDriver driver;

    // Constructor
    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }
 // 1. Radio Button Example
    public void selectAllRadioButtons() throws InterruptedException {
        List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement radio : radios) {
            radio.click();
            Thread.sleep(300);
        }
    }

 // 2. Suggestion Class Example
    public void selectSuggestion(String country) throws InterruptedException {
        WebElement suggestionBox = driver.findElement(By.id("autocomplete"));
        suggestionBox.sendKeys(country.substring(0, 3)); // enter partial text
        Thread.sleep(1000);
        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item div"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(country)) {
                option.click();
                break;
            }
        }
    }

 // 3. Dropdown Example
    public void selectDropdown(String option) {
        driver.findElement(By.id("dropdown-class-example")).click();
        driver.findElement(By.xpath("//option[text()='" + option + "']")).click();
    }

 // 4. Checkbox Example
    public void selectAllCheckboxes() throws InterruptedException {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
            Thread.sleep(300);
        }
    }

    // 5. Switch Window Example
    public void switchWindow() {
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.id("openwindow")).click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Child Window Title: " + driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }

 // 6. Switch Tab Example
    public void switchTab() {
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.id("opentab")).click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("New Tab Title: " + driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
  
    }
    
    // 7. Switch To Alert Example
    public void handleAlerts() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Rahul");
        driver.findElement(By.id("alertbtn")).click();
        System.out.println("Alert Text: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        Thread.sleep(500);
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();
    }


 // 8. Web Table Example
    public void printWebTable() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
    }

 // 9. Element Displayed Example
    public void checkElementDisplayed() {
        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        WebElement showButton = driver.findElement(By.id("show-textbox"));
        WebElement displayBox = driver.findElement(By.id("displayed-text"));

        hideButton.click();
        System.out.println("Textbox displayed after hide? " + displayBox.isDisplayed());
        showButton.click();
        System.out.println("Textbox displayed after show? " + displayBox.isDisplayed());
    }

 // 10. Web Table Fixed header
    public void printFixedHeaderTable() {
        List<WebElement> fixedRows = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr"));
        for (WebElement row : fixedRows) {
            System.out.println(row.getText());
        }
    }

    // 11. Mouse Hover Example
    public void mouseHover() throws InterruptedException {
        WebElement hoverBtn = driver.findElement(By.id("mousehover"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverBtn).perform();
        Thread.sleep(500);
        driver.findElement(By.linkText("Top")).click();
    }

    
}
