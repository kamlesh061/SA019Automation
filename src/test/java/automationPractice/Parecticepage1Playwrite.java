package automationPractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;



public class Parecticepage1Playwrite {

	public static void main(String[] args) {
		 // To use this code, you'll need to set up Playwright for Java in your project.
        // If you are using Maven, add the following dependency to your pom.xml:
        //
        // <dependency>
        //     <groupId>com.microsoft.playwright</groupId>
        //     <artifactId>playwright</artifactId>
        //     <version>1.44.0</version> <!-- Use the latest version -->
        // </dependency>

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.setViewportSize(1280, 720); // Setting a standard viewport for better visuals

            try {
                // Navigate to the specified URL
                page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
                page.waitForLoadState(LoadState.NETWORKIDLE);
                System.out.println("Navigated to the website successfully.");

                // 1. Radio Button Example
                System.out.println("--- 1. Radio Button Example ---");
                page.locator("input[value='radio2']").click();
                System.out.println("Clicked on Radio Button 2.");
                page.waitForTimeout(2000); // Wait to see the action

                // 2. Suggestion Class Example (Autosuggestive Dropdown)
                System.out.println("--- 2. Suggestion Class Example ---");
                page.locator("#autocomplete").fill("ind");
                page.waitForTimeout(2000); // Wait for suggestions to appear
                page.locator("//li[@class='ui-menu-item']/div[text()='India']").click();
               
                System.out.println("Selected 'India' from the autosuggestion.");
                page.waitForTimeout(2000);

                // 3. Dropdown Example
                System.out.println("--- 3. Dropdown Example ---");
                page.locator("#dropdown-class-example").selectOption("Option3");
                System.out.println("Selected 'Option3' from the dropdown.");
                page.waitForTimeout(2000);

                // 4. Checkbox Example
                System.out.println("--- 4. Checkbox Example ---");
                page.locator("#checkBoxOption1").check();
                System.out.println("Checked Checkbox Option1.");
                page.waitForTimeout(2000);

                // 5. Switch Window Example
                System.out.println("--- 5. Switch Window Example ---");
                Page newWindow = page.waitForPopup(() -> {
                    page.locator("#openwindow").click();
                });
                newWindow.waitForLoadState(LoadState.LOAD);
                System.out.println("Switched to the new window. Window title: " + newWindow.title());
                newWindow.close();
                System.out.println("Closed the new window.");
                page.bringToFront();
                System.out.println("Switched back to the original page.");
                page.waitForTimeout(2000);

                // 6. Switch Tab Example
                System.out.println("--- 6. Switch Tab Example ---");
                Page newTab = page.waitForPopup(() -> {
                    page.locator("#opentab").click();
                });
                newTab.waitForLoadState(LoadState.LOAD);
                System.out.println("Switched to the new tab. Tab title: " + newTab.title());
                newTab.close();
                System.out.println("Closed the new tab.");
                page.bringToFront();
                System.out.println("Switched back to the original page.");
                page.waitForTimeout(2000);

                // 7. Switch To Alert Example
                System.out.println("--- 7. Switch To Alert Example ---");
                page.locator("#name").fill("John Doe");

                // Set up the dialog listener to handle the alert
                page.onDialog(dialog -> {
                    System.out.println("Alert text: " + dialog.message());
                    dialog.accept();
                });
                page.locator("#alertbtn").click();
                System.out.println("Clicked the Alert button and accepted.");
                page.waitForTimeout(2000);

                // For the Confirm dialog, use a different listener
                page.onDialog(dialog -> {
                    System.out.println("Confirm text: " + dialog.message());
                    dialog.dismiss();
                });
                page.locator("#confirmbtn").click();
                System.out.println("Clicked the Confirm button and dismissed.");
                page.waitForTimeout(2000);
                page.offDialog(null); // Remove the listener

                // 8. Web Table Example
                System.out.println("--- 8. Web Table Example ---");
                Locator rows = page.locator("#product tr");
                System.out.println("Number of rows: " + rows.count());

                for (int i = 0; i < rows.count(); i++) {
                    Locator cells = rows.nth(i).locator("td");
                    for (int j = 0; j < cells.count(); j++) {
                        System.out.print(cells.nth(j).textContent().trim() + " | ");
                    }
                    System.out.println();
                }
                page.waitForTimeout(2000);

                // 9. Web Table Fixed Header Example
                System.out.println("--- 9. Web Table Fixed Header Example ---");
                Locator fixedHeaderTable = page.locator("div.table-display");
                Locator fixedRows = fixedHeaderTable.locator("tr");
                System.out.println("Number of rows in fixed header table: " + fixedRows.count());

                // Print the table headers
                Locator fixedHeaders = fixedHeaderTable.locator("th");
                for (int i = 0; i < fixedHeaders.count(); i++) {
                    System.out.print(fixedHeaders.nth(i).textContent().trim() + " | ");
                }
                System.out.println();
                page.waitForTimeout(2000);

                // 10. Mouse Hover Example
                System.out.println("--- 10. Mouse Hover Example ---");
                page.locator("#mousehover").hover();
                System.out.println("Mouse hovered over the element.");
                page.waitForTimeout(2000);
                page.locator("text=Top").click();
                System.out.println("Clicked on 'Top' link.");
                page.waitForTimeout(2000);

                System.out.println("All examples executed successfully!");

            } catch (PlaywrightException e) {
                System.err.println("Playwright operation failed: " + e.getMessage());
            } finally {
                // The try-with-resources block will automatically close the browser and Playwright context
            }
	}
	}
}
