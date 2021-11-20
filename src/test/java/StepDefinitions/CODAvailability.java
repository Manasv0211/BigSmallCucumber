package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ReusableComponents.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CODAvailability extends BaseClass{
	

    @Given("^user hovers on official merchandise$")
    public void user_hovers_on_official_merchandise() throws Throwable {
    	driver = ShopByCategory.getdriver();
    	homepage.logo().click();
		Actions a = new Actions(driver);
		WebElement move = homepage.officialM();
		a.moveToElement(move).build().perform();
    }

    @When("^user clicks on Official harry potter merchandise$")
    public void user_clicks_on_official_harry_potter_merchandise() throws Throwable {
    	homepage.harryPotter().click();
    }
    
    @And("^user searches for Hedwig Owl mug from Official harry potter merchandise page and clicks on it$")
    public void user_searches_for_hedwig_owl_mug_from_official_harry_potter_merchandise_page_and_clicks_on_it() throws Throwable {
    	officialMerchandise.getProdname();
		for (int i = 0; i < officialMerchandise.getProdname().size(); i++) {
			if (officialMerchandise.getProdname().get(i).getText().contains("Hedwig Owl mug")) {
				er.startTest("Successfully found Hedwig Owl mug");
				System.out.println("Product found!");
				Thread.sleep(2000);
				officialMerchandise.getProdname().get(i).click();
				break;
			}

		}
    }

    @Then("^user enters pincode in cod textbox (.*) , clicks on check and prints the text$")
    public void user_enters_pincode_in_cod_textbox_clicks_on_check_and_prints_the_text(String pincode) throws Throwable {
    	Thread.sleep(2000);
		officialMerchandise.getPinCode().sendKeys(pincode);
		officialMerchandise.getCheckBtn().click();
		Thread.sleep(2000);
		System.out.println(officialMerchandise.getValidateText().getText());
		er.endTest();
    }
    public static WebDriver getdriver() {
		return driver;
	}

    

}
