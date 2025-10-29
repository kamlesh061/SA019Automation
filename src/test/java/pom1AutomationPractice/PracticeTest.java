package pom1AutomationPractice;

public class PracticeTest extends BaseTest  {

	public static void main(String[] args) throws Exception {
		
        PracticeTest test = new PracticeTest();
        test.runTests();
    }

    public void runTests() throws Exception {
        setUp(); // Launch browser
        PracticePage practice = new PracticePage(driver);

        practice.selectAllRadioButtons();
        practice.selectSuggestion("India");
        practice.selectDropdown("Option2");
        practice.selectAllCheckboxes();
        practice.switchWindow();
        practice.switchTab();
        practice.handleAlerts();
        practice.printWebTable();
        practice.checkElementDisplayed();
        practice.printFixedHeaderTable();
        practice.mouseHover();

        tearDown(); // Close browser
    }

	
}

