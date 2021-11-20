package StepDefinitions;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import ReusableComponents.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignIn extends BaseClass {

	@Given("The user is on sign in page")
	public void the_user_is_on_sign_in_page() throws Throwable {
		driver = OpenBrowser.getdriver();
		homepage.sigin().click();
		log.info("Successfully clicked on Sign in button");
	}

	@When("user enters the email and password")
	public void user_enters_the_email_and_password() throws Throwable {

		ArrayList<String> data1 = ex.getData("username");
		ArrayList<String> data2 = ex.getData("password");
		for (int i = 1; i < data1.size(); i++) {
			signin.customeremailid().sendKeys(data1.get(i));
			Thread.sleep(2000);
			signin.customerpass().sendKeys(data2.get(i));
			Thread.sleep(2000);
			er.startTest("Successfully entered url and signedin");
			signin.customeremailid().clear();
			signin.customerpass().clear();
			Thread.sleep(2000);
		}
		
		log.info("System clicked on sign in button");
		log.debug("Successfully opened sign in page");

	}

	@Then("system should accept signin data")
	public void system_should_accept_signin_data() throws Throwable {
		er.endTest();
	}
	
	public static WebDriver getdriver() {
		return driver;
	}

}