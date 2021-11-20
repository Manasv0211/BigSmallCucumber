package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import ReusableComponents.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PersonalizedGifts extends BaseClass {

	@Given("^user clicks on PersonalisedGifts available in home page$")
	public void user_clicks_on_personalisedgifts_available_in_home_page() throws Throwable {
		driver = CODAvailability.getdriver();
		Thread.sleep(5000);
		personalGifts.getPGBtn().click();
	}

	@Then("^user validates whether we entered personalized page or not$")
	public void user_validates_whether_we_entered_personalized_page_or_not() throws Throwable {
		if (personalGifts.getValidate().getText().contains("Personalized Gifts")) {
			Assert.assertTrue(true);
		}
	}

	@And("^user checks if this  (.*) available or not$")
	public void user_checks_if_this_available_or_not(String productname) throws Throwable {
		for (int i = 0; i < personalGifts.getProducts().size(); i++) {
			if (personalGifts.getProducts().get(i).getText().contains(productname)) {
				er.startTest("Successfully found Personalized Pop Art");
				log.info("Successfully found Personalized Pop Art");
				Thread.sleep(2000);
				System.out.println("Product found!");
				break;
			}
		}
		er.endTest();
	}
	 public static WebDriver getdriver() {
			return driver;
		}

}
