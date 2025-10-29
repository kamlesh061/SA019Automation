package pom1AutomationPractice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeTestTestNG extends BaseTest {
    PracticePage practice;

    @BeforeClass
    public void initPage() {
        practice = new PracticePage(driver);
    }

    @Test(priority = 1)
    public void testRadioButtons() throws Exception {
        practice.selectAllRadioButtons();
    }

    @Test(priority = 2)
    public void testSuggestionBox() throws Exception {
        practice.selectSuggestion("India");
    }

    @Test(priority = 3)
    public void testDropdown() {
        practice.selectDropdown("Option2");
    }

    @Test(priority = 4)
    public void testCheckboxes() throws InterruptedException {
        practice.selectAllCheckboxes();
    }

    @Test(priority = 5)
    public void testSwitchWindow() {
        practice.switchWindow();
    }

    @Test(priority = 6)
    public void testSwitchTab() {
        practice.switchTab();
    }

    @Test(priority = 7)
    public void testAlerts() throws InterruptedException {
        practice.handleAlerts();
    }

    @Test(priority = 8)
    public void testWebTable() {
        practice.printWebTable();
    }

    @Test(priority = 9)
    public void testElementDisplayed() {
        practice.checkElementDisplayed();
    }

    @Test(priority = 10)
    public void testFixedHeaderTable() {
        practice.printFixedHeaderTable();
    }

    @Test(priority = 11)
    public void testMouseHover() throws InterruptedException {
        practice.mouseHover();
    }


}
