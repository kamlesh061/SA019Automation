package blogspot;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebElementsDemo {
	 public static void main(String[] args) {
	        // Step 1: Initialize WebDriver and Actions
	        // Example: System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

	        WebDriver driver = new ChromeDriver();
	        Actions actions = new Actions(driver);
	        
	        // Set an implicit wait for better stability
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        driver.manage().window().maximize();

	        // Step 2: Navigate to the target URL
	        String url = "https://testautomationpractice.blogspot.com/";
	        System.out.println("Navigating to: " + url);
	        driver.get(url);

	        try {
	            // ==========================================================
	            // Section 1: Form & Basic GUI Elements (ID, XPath, TagName)
	            // ==========================================================
	            
	            // 1. Input Fields (Name, Email, Phone, Address)
	            driver.findElement(By.id("name")).sendKeys("Gemini Tester");
	            driver.findElement(By.id("email")).sendKeys("test@full-script.com");
	            driver.findElement(By.id("phone")).sendKeys("9998887770");
	            driver.findElement(By.tagName("textarea")).sendKeys("123 Expanded Automation Drive");
	            System.out.println("1. Basic form fields populated.");
	            Thread.sleep(1000);

	            // 2. Radio Button & Checkboxes
	            driver.findElement(By.xpath("//input[@id='male']")).click();
	            driver.findElement(By.id("sunday")).click();
	            driver.findElement(By.id("tuesday")).click(); // Selecting a different one for variety
	            System.out.println("2. Gender and days selected.");
	            Thread.sleep(1000);

	            // 3. Simple Dropdown (Country)
	            Select countrySelect = new Select(driver.findElement(By.id("country")));
	            countrySelect.selectByVisibleText("Canada");
	            System.out.println("3. Country selected: Canada.");
	            Thread.sleep(1000);


	            // ==========================================================
	            // Section 2: Dropdowns & Slider
	            // ==========================================================

	            // 4. Scrolling DropDown (Speed)
	            WebElement speedDropdownElement = driver.findElement(By.id("speed"));
	            Select speedSelect = new Select(speedDropdownElement);
	            speedSelect.selectByValue("Fast"); // Select by value
	            System.out.println("4. Speed selected: Fast.");
	            Thread.sleep(1000);

	            // 5. Slider (Requires Actions Class)
	            WebElement slider = driver.findElement(By.id("slider"));
	            // Move slider 50 units (pixels) to the right. Adjust offset as needed for desired value.
	            actions.dragAndDropBy(slider, 50, 0).build().perform();
	            System.out.println("5. Slider moved by 50 units using Actions class.");
	            Thread.sleep(1500);

	            // ==========================================================
	            // Section 3: Alerts & Popups (Basic and Confirmation)
	            // ==========================================================

	            // 6. Simple Alert (Already covered, but repeating for completeness)
	            driver.findElement(By.xpath("//button[text()='Alert']")).click();
	            driver.switchTo().alert().accept();
	            System.out.println("6. Handled standard Alert (Accepted).");
	            Thread.sleep(1000);

	            // 7. Confirmation Pop-up (Dismiss)
	            driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
	            driver.switchTo().alert().dismiss();
	            System.out.println("7. Handled Confirmation Box (Dismissed).");
	            Thread.sleep(1000);


	            // ==========================================================
	            // Section 4: Mouse Interactions (Hover, Double Click, Drag & Drop)
	            // ==========================================================

	            // 8. Mouse Hover
	            WebElement hoverElement = driver.findElement(By.id("div-hover"));
	            actions.moveToElement(hoverElement).perform();
	            System.out.println("8. Mouse hovered over 'Automation Testing' section.");
	            Thread.sleep(1000);

	            // 9. Double Click
	            WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
	            actions.doubleClick(doubleClickButton).perform();
	            // Check if the text was copied to the adjacent field
	            WebElement field = driver.findElement(By.id("field2"));
	            String copiedText = field.getAttribute("value");
	            System.out.println("9. Double-clicked. Copied Text: " + copiedText);
	            Thread.sleep(1500);

	            // 10. Drag and Drop
	            WebElement source = driver.findElement(By.id("draggable"));
	            WebElement target = driver.findElement(By.id("droppable"));
	            actions.dragAndDrop(source, target).build().perform();
	            System.out.println("10. Dragged 'Drag me to my target' into the target box.");
	            Thread.sleep(1500);


	            // ==========================================================
	            // Section 5: Tabs and File Upload
	            // ==========================================================

	            // 11. Tabs
	            // Click the tab header using partial link text for the 'Tab 2' link
	            WebElement tab2Link = driver.findElement(By.partialLinkText("Tab 2"));
	            tab2Link.click();
	            Thread.sleep(1000);
	            
	            // Locate an element unique to Tab 2 to confirm switch (e.g., text inside the tab)
	            WebElement tab2Content = driver.findElement(By.xpath("//div[@id='tabs-2']/p"));
	            System.out.println("11. Switched to Tab 2. Content snippet: " + tab2Content.getText().substring(0, 30) + "...");
	            Thread.sleep(1000);
	            
	            // Switch back to Tab 1
	            driver.findElement(By.partialLinkText("Tab 1")).click();
	            Thread.sleep(1000);

	            // 12. Upload Files
	            // NOTE: Create a dummy file for upload test
	            File dummyFile = new File("dummy_upload.txt");
	            if (!dummyFile.exists()) {
	                dummyFile.createNewFile();
	            }
	            
	            WebElement uploadInput = driver.findElement(By.id("uploadfile"));
	            // Send the absolute path of the file to the input element
	            uploadInput.sendKeys(dummyFile.getAbsolutePath());
	            System.out.println("12. File uploaded: " + dummyFile.getName());
	            // Clean up the dummy file
	            dummyFile.delete();
	            Thread.sleep(1500);


	            // ==========================================================
	            // Section 6: Dynamic Web Tables and Pagination
	            // ==========================================================

	            // 13. Dynamic Web Table - Reading a specific cell (e.g., the price of "Master In Selenium")
	            // Locate the row for "Master In Selenium"
	            String bookName = "Master In Selenium";
	            String priceXPath = String.format("//table[@name='BookTable']/tbody/tr/td[text()='%s']/following-sibling::td[2]", bookName);
	            
	            WebElement priceElement = driver.findElement(By.xpath(priceXPath));
	            System.out.println("13. Dynamic Table Read: Price for '" + bookName + "' is " + priceElement.getText());
	            Thread.sleep(1000);

	            // 14. Pagination Web Table - Navigating to a page (clicking '2')
	            // Locate the pagination link for page '2'
	            WebElement pageTwoLink = driver.findElement(By.xpath("//a[text()='2']"));
	            pageTwoLink.click();
	            System.out.println("14. Pagination: Clicked to navigate to page 2.");
	            Thread.sleep(2000);
	            
	            // Read a row from page 2 to verify navigation (e.g., the last row of the table)
	            List<WebElement> rowsPageTwo = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
	            WebElement lastRow = rowsPageTwo.get(rowsPageTwo.size() - 1);
	            System.out.println("   Verification: Last product on page 2: " + lastRow.findElement(By.xpath("./td[2]")).getText());
	            Thread.sleep(1000);
	            
	            // Switch back to page 1
	            driver.findElement(By.xpath("//a[text()='1']")).click();
	            Thread.sleep(1000);


	            // ==========================================================
	            // Section 7: Labels, Links, and Info Areas
	            // ==========================================================

	            // 15. Labels and Links (Get Label Text)
	            // Locating the main title "Practice Automation" which is an H1
	            WebElement mainTitle = driver.findElement(By.cssSelector("h1.title"));
	            System.out.println("15. Retrieved Main Label Text: " + mainTitle.getText());
	            
	            // 16. Visitors / Blog Stats
	            // Locating the "Blog Stats" header
	            WebElement blogStatsHeader = driver.findElement(By.xpath("//h2[text()='Blog Stats']"));
	            System.out.println("16. Located Blog Stats header: " + blogStatsHeader.getText());
	            Thread.sleep(1000);

	            // 17. Footer Links (e.g., "Blogger")
	            WebElement bloggerLink = driver.findElement(By.linkText("Blogger"));
	            System.out.println("17. Located Footer Link: " + bloggerLink.getText());
	            // Note: We don't click it to keep the current window open.
	            Thread.sleep(1000);

	            // ==========================================================
	            // Section 8: Date Picker Interactions
	            // ==========================================================
	            
	            // 18. Date Picker 1: Direct SendKeys (Easiest method if field is editable)
	            WebElement datePickerInput = driver.findElement(By.id("datepicker"));
	            datePickerInput.clear();
	            datePickerInput.sendKeys("12/31/2025");
	            System.out.println("18. Date Picker 1: Date set using SendKeys to 12/31/2025.");
	            Thread.sleep(1500);
	            
	            // 19. Date Picker 2: UI Interaction (Selecting a future date)
	            datePickerInput.click(); // Open the calendar
	            System.out.println("19. Date Picker 2: Opened calendar UI.");
	            Thread.sleep(500);

	            // Click the 'Next' button twice to move two months forward
	            for (int i = 0; i < 2; i++) {
	                driver.findElement(By.xpath("//span[text()='Next']")).click();
	                Thread.sleep(200);
	            }
	            
	            // Select the 25th day of the visible month
	            driver.findElement(By.xpath("//a[text()='25']")).click();
	            System.out.println("   Date selected by navigating and clicking '25'.");
	            Thread.sleep(1500);
	            
	            // 20. Date Picker 3: Reading final date (e.g., after selection)
	            String selectedDate = datePickerInput.getAttribute("value");
	            System.out.println("20. Date Picker 3: Final selected date read from input field: " + selectedDate);
	            Thread.sleep(1000);


	            System.out.println("\n--- All 20 sections of interaction completed successfully. ---");
	           
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            System.err.println("Script interrupted: " + e.getMessage());
	        } catch (Exception e) {
	            System.err.println("\n--- An error occurred during execution: " + e.getMessage() + " ---");
	            e.printStackTrace();
	        } finally {
	            // Final Step: Quit the driver
	            if (driver != null) {
	                driver.quit();
	            }
	        }
	    }
	
}
