package automationPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PracticePage1 {

	public static void main(String[] args) {
		 // Step 1: Set the path to the ChromeDriver executable.
        // On most modern systems, this is not strictly necessary as Selenium
        // can manage the driver automatically. However, it is good practice to
        // include it for older setups.
        // System.setProperty("webdriver.chrome.driver", "/path/to/your/chromedriver");

        // Step 2: Initialize a new instance of the Chrome WebDriver.
        WebDriver driver = new ChromeDriver();

        // Optional: Set an implicit wait to handle dynamic elements.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 3: Navigate to the desired URL.
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        System.out.println("Navigating to URL: " + url);
        driver.get(url);

        // Step 4: Maximize the browser window for better visibility.
        driver.manage().window().maximize();
        

        try {
            // Navigate to the specified URL
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            System.out.println("Navigated to the website successfully.");

            // 1. Radio Button Example
            System.out.println("--- 1. Radio Button Example ---");
           // WebElement radio2 = driver.findElement(By.cssSelector("input[value='radio2']"));
           //radio2.click();
          // System.out.println("Clicked on Radio Button 2.");
            
            //OR
            
            WebElement radioButton = driver.findElement(By.xpath("//input[@value='radio2']"));
            radioButton.click();
            System.out.println("Clicked on Radio Button 2. Is it selected? " + radioButton.isSelected()); 
            Thread.sleep(2000); // Wait to see the action
      
            
            
            // 2. Suggession Class Example (Autosuggestive Dropdown)
           /* System.out.println("--- 2. Suggestion Class Example ---");
            WebElement countryInput = driver.findElement(By.id("autocomplete"));
            countryInput.sendKeys("ind");
            Thread.sleep(2000); // Wait for suggestions to appear
            WebElement suggestion = driver.findElement(By.xpath("//li[@class='ui-menu-item']/div[text()='India']"));
            suggestion.click();
            System.out.println("Selected 'India' from the autosuggestion.");
            Thread.sleep(2000);
            */
            
            //OR
            WebElement suggestionInput = driver.findElement(By.id("autocomplete"));
            String country = "India";
            suggestionInput.sendKeys(country);
            Thread.sleep(2000); // Wait for suggestions to appear
            driver.findElement(By.xpath("//div[text()='" + country + "']")).click();
            System.out.println("Typed '" + country + "' and selected it from the suggestions.");
            Thread.sleep(2000); // Wait for suggestions to appear
            
            
            

            // 3. Dropdown Example
            System.out.println("--- 3. Dropdown Example ---");
            WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
            Select select = new Select(dropdown);
            select.selectByVisibleText("Option3");
            System.out.println("Selected 'Option3' from the dropdown.");
            Thread.sleep(2000);
            
            

            // 4. Checkbox Example
            System.out.println("--- 4. Checkbox Example ---");
            WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
            checkbox1.click();
            //System.out.println("Checked Checkbox Option1.");
            //OR
            System.out.println("Clicked Checkbox Option 1. Is it selected? " + checkbox1.isSelected());          
            Thread.sleep(2000);
            
            

            // 5. Switch Window Example
       /*     System.out.println("--- 5. Switch Window Example ---");
            String parentWindowHandle = driver.getWindowHandle();
            WebElement openWindowButton = driver.findElement(By.id("openwindow"));
            openWindowButton.click();
            System.out.println("Clicked on 'Open Window' button.");

            // Get all window handles
            Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> iterator = allWindowHandles.iterator();
            while (iterator.hasNext()) {
                String childWindowHandle = iterator.next();
                if (!parentWindowHandle.equalsIgnoreCase(childWindowHandle)) {
                    driver.switchTo().window(childWindowHandle);
                    System.out.println("Switched to the new window. Window title: " + driver.getTitle());
                    // Perform an action on the new window, e.g., print the title and close
                    driver.close();
                    System.out.println("Closed the new window.");
                }
            }
            driver.switchTo().window(parentWindowHandle);
            System.out.println("Switched back to the parent window.");
            Thread.sleep(2000);
        */
             //OR
            System.out.println("\n--- 5. Switch Window Example ---");
            String originalWindowHandle = driver.getWindowHandle();
            driver.findElement(By.id("openwindow")).click();
            
            // Get all window handles
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();
            String childWindowHandle = iterator.next(); // First is the original, second is the new window
            if(childWindowHandle.equals(originalWindowHandle)) {
                childWindowHandle = iterator.next();
            }
         // Switch to the new window
            driver.switchTo().window(childWindowHandle);
            System.out.println("Switched to the new window. Title: " + driver.getTitle());
            driver.close(); // Close the new window
            driver.switchTo().window(originalWindowHandle); // Switch back to original
            System.out.println("Switched back to the original window. Title: " + driver.getTitle());
            Thread.sleep(2000);
            
            
            // 6. Switch Tab Example
          /*  System.out.println("--- 6. Switch Tab Example ---");
            String parentTabHandle = driver.getWindowHandle();
            WebElement openTabButton = driver.findElement(By.id("opentab"));
            openTabButton.click();
            System.out.println("Clicked on 'Open Tab' button.");

            Set<String> allTabHandles = driver.getWindowHandles();
            iterator = allTabHandles.iterator();
            while (iterator.hasNext()) {
                String childTabHandle = iterator.next();
                if (!parentTabHandle.equalsIgnoreCase(childTabHandle)) {
                    driver.switchTo().window(childTabHandle);
                    System.out.println("Switched to the new tab. Tab title: " + driver.getTitle());
                    // Perform an action on the new tab
                    driver.close();
                    System.out.println("Closed the new tab.");
                }
            }
            driver.switchTo().window(parentTabHandle);
            System.out.println("Switched back to the parent tab.");
            Thread.sleep(2000);
        */
            // OR
            System.out.println("\n--- 6. Switch Tab Example ---");
            driver.findElement(By.id("opentab")).click();
            
            // Get all tab handles (same method as windows)
            Set<String> tabHandles = driver.getWindowHandles();
            iterator = tabHandles.iterator();
            String childTabHandle = iterator.next();
            if(childTabHandle.equals(originalWindowHandle)) {
                childTabHandle = iterator.next();
            }

            // Switch to the new tab
            driver.switchTo().window(childTabHandle);
            System.out.println("Switched to the new tab. Title: " + driver.getTitle());
            driver.close(); // Close the new tab
            driver.switchTo().window(originalWindowHandle); // Switch back to original
            System.out.println("Switched back to the original tab.");
            Thread.sleep(2000);
            
            
            // 7. Switch To Alert Example
           /* System.out.println("--- 7. Switch To Alert Example ---");
            WebElement nameInput = driver.findElement(By.id("name"));
            nameInput.sendKeys("John Doe");
            WebElement alertButton = driver.findElement(By.id("alertbtn"));
            alertButton.click();
            System.out.println("Clicked the Alert button.");
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            System.out.println("Accepted the alert.");
            Thread.sleep(2000);

            // Confirm example (optional, but good to include)
            WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
            confirmButton.click();
            System.out.println("Clicked the Confirm button.");
            Thread.sleep(2000);
            Alert confirmAlert = driver.switchTo().alert();
            System.out.println("Confirm alert text: " + confirmAlert.getText());
            confirmAlert.dismiss();
            System.out.println("Dismissed the confirm alert.");
            Thread.sleep(2000);
            */
            //OR
            System.out.println("\n--- 7. Switch To Alert Example ---");
            String name = "Test User";
            driver.findElement(By.id("name")).sendKeys(name);
            driver.findElement(By.id("alertbtn")).click();
            String alertMessage = driver.switchTo().alert().getText();
            System.out.println("Alert message: " + alertMessage);
            driver.switchTo().alert().accept();
            System.out.println("Alert accepted.");
            Thread.sleep(2000);
            
            driver.findElement(By.id("name")).clear();
            driver.findElement(By.id("name")).sendKeys(name);
            driver.findElement(By.id("confirmbtn")).click();
            String confirmMessage = driver.switchTo().alert().getText();
            System.out.println("Confirm message: " + confirmMessage);
            driver.switchTo().alert().dismiss();
            System.out.println("Confirm dismissed.");
            Thread.sleep(2000);
            

            // 8. Web Table Example
           /* System.out.println("--- 8. Web Table Example ---");
            WebElement table = driver.findElement(By.id("product"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            System.out.println("Number of rows: " + rows.size());

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + " | ");
                }
                System.out.println(); // New line for each row
            }
            Thread.sleep(2000);
           */ 
            //OR
            System.out.println("\n--- 8. Web Table Example ---");
            WebElement table = driver.findElement(By.id("product"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            System.out.println("Number of rows in the table: " + rows.size());

            // Iterate through rows and columns to print content
            for (int i = 0; i < rows.size(); i++) {
                List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
                for (int j = 0; j < cells.size(); j++) {
                    System.out.print(cells.get(j).getText() + "\t");
                }
                System.out.println();
            }
            Thread.sleep(2000);
            
         // --- 9. Element Displayed Example ---
            System.out.println("\n--- 9. Element Displayed Example ---");
            WebElement displayedText = driver.findElement(By.id("displayed-text"));
            System.out.println("Is element displayed initially? " + displayedText.isDisplayed());

            driver.findElement(By.id("hide-textbox")).click();
            System.out.println("Clicked 'Hide'. Is element displayed now? " + displayedText.isDisplayed());

            driver.findElement(By.id("show-textbox")).click();
            System.out.println("Clicked 'Show'. Is element displayed again? " + displayedText.isDisplayed());
            Thread.sleep(2000);

            
            

            // 10. Web Table Fixed Header Example
          /*  System.out.println("--- 10. Web Table Fixed Header Example ---");
            WebElement fixedHeaderTable = driver.findElement(By.className("table-display"));
            List<WebElement> fixedRows = fixedHeaderTable.findElements(By.tagName("tr"));
            System.out.println("Number of rows in fixed header table: " + fixedRows.size());
            // Print the table headers
            List<WebElement> fixedHeader = fixedHeaderTable.findElements(By.tagName("th"));
            for (WebElement header : fixedHeader) {
                System.out.print(header.getText() + " | ");
            }
            System.out.println();
            Thread.sleep(2000);
            */
            //OR
            System.out.println("\n--- 10. Web Table Fixed Header ---");
            WebElement fixedHeaderTable = driver.findElement(By.cssSelector(".table-display.table-display-div"));
            List<WebElement> fixedRows = fixedHeaderTable.findElements(By.cssSelector("div.tableFixHead tbody tr"));
            System.out.println("Number of rows in fixed header table: " + fixedRows.size());
            
            // Print the content of the fixed header table
            for (WebElement row : fixedRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + "\t");
                }
                System.out.println();
            }
            Thread.sleep(2000);
            

            // 11. Mouse Hover Example
            System.out.println("--- 11. Mouse Hover Example ---");
            WebElement mouseHover = driver.findElement(By.id("mousehover"));
            Actions actions = new Actions(driver);
            actions.moveToElement(mouseHover).perform();
            System.out.println("Mouse hovered over the element.");
            Thread.sleep(2000);
           /* 
             // Click a hidden link that appears on hover
            WebElement topLink = driver.findElement(By.xpath("//a[text()='Top']"));
            topLink.click();
            System.out.println("Clicked on 'Top' link.");
            Thread.sleep(2000);
            System.out.println("All examples executed successfully!");
           */
            
            // Click a hidden link that appears on hover
            WebElement topLink = driver.findElement(By.xpath("//a[text()='Top']"));
            actions.moveToElement(topLink).click().perform();
            System.out.println("Clicked on 'Top' link after mouse hover.");
            Thread.sleep(2000);
            
            
            } 
        catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
           }
        finally {
            // Close the browser window
            driver.quit();
            System.out.println("Browser closed.");
        }
	}
}
