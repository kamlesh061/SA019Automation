package blogspot;

public class AutomationTest extends BaseAutomation {
	
	

	public static void main(String[] args) {
		AutomationTest test = new AutomationTest();
		test.runTests();
	}

	private void runTests() {
		setUp();
		AutomationPage practice= new AutomationPage(driver);
		
		
		practice.FillInfo();
	}

}
