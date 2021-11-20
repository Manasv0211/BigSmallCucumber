package StepDefinitions;

import org.junit.Assert;

import ReusableComponents.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WhatsNewPage extends BaseClass{

	@Given("^user clicks on whatsNew button$")
	    public void user_clicks_on_whatsnew_button() throws Throwable {
		driver = GiftPage.getdriver();
		homepage.logo().click();
		whatsnew.getBtn().click();
		er.startTest("Navigated to whatsnew page");
		Thread.sleep(2000);
	    }

	@Then("^user enters whatsnew page and checks whether we are in whatsnew pageor not$")
	public void user_enters_whatsnew_page_and_checks_whether_we_are_in_whatsnew_pageor_not() throws Throwable {
		if (whatsnew.getValidate().getText().contains("What'S New")) {
			Assert.assertTrue(true);
			log.info("Successfully validated about whatsnew page");
			Thread.sleep(5000);
			er.endTest();
			classTeardown();
			
		}
	}
	

}
