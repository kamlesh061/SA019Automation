package blogspot;

public class AutomationTest extends BaseAutomation {
	
	

	public static void main(String[] args) throws InterruptedException {
		AutomationTest test = new AutomationTest();
		test.runTests();
	}

	private void runTests() throws InterruptedException {
		setUp();
		AutomationPage practice= new AutomationPage(driver);
		
		
		practice.FillInfo();
		practice.selectAllRadio();
		practice.selectAllCheckBox();
		practice.selectDropDown();
		practice.selectColour();
		practice.selectSortList();
		practice.selectDate();
		
		
	}

}
