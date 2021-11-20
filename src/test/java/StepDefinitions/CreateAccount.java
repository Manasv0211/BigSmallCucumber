package StepDefinitions;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import ReusableComponents.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccount extends BaseClass {

	@Given("^user is on sign in page$")
	public void user_is_on_sign_in_page() throws Throwable {
		driver = PersonalizedGifts.getdriver();
		homepage.logo().click();
		homepage.sigin().click();

	}

	@And("^clicks on create account button$")
	public void clicks_on_create_account_button() throws Throwable {
		createAcc.getCreateAcc().click();

	}

	@When("^user enters firstname, lastname, emailid and password1$")
	public void user_enters_firstname_lastname_emailid_and_password1() throws Throwable {
		ArrayList<String> data1 = ex.getData("firstname");
		ArrayList<String> data2 = ex.getData("lastname");
		ArrayList<String> data3 = ex.getData("emailid");
		ArrayList<String> data4 = ex.getData("password1");
		
		for (int i = 1; i < data1.size(); i++) {
			createAcc.getfname().sendKeys(data1.get(i));
			//Thread.sleep(2000);
			createAcc.getlname().sendKeys(data2.get(i));
			//Thread.sleep(2000);
			createAcc.getEmail().sendKeys(data3.get(i));
			//Thread.sleep(2000);
			createAcc.getPassword().sendKeys(data4.get(i));
			Thread.sleep(2000);
			er.startTest("Successfully entered firstname,lastname,emailid and password");
			log.info("Successfully entered firstname,lastname,emailid and password");
			createAcc.getfname().clear();
			createAcc.getlname().clear();
			createAcc.getEmail().clear();
			createAcc.getPassword().clear();
			log.info("cleared");
		}
	}

	@Then("^system should accept data$")
	public void system_should_accept_data() throws Throwable {
		System.out.println(createAcc.getValidate().getText());
	}

	public static WebDriver getdriver() {
		return driver;
	}

}
