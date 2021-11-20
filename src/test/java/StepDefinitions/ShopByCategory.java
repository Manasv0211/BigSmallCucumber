package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ReusableComponents.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopByCategory extends BaseClass{

	@Given("^user hover on shp by category in homepage$")
	public void user_hover_on_shp_by_category_in_homepage() throws Throwable {
		driver = SearchingProduct_SearchBox.getdriver();
		homepage.logo().click();
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		WebElement move = shopbycat.shopbycat();
		a.moveToElement(move).build().perform();
	}

	@When("^selects jewellery from shop by category and clciks on next$")
	public void selects_jewellery_from_shop_by_category_and_clciks_on_next() throws Throwable {
		shopbycat.jewe().click();
		shopbycat.next().click();

	}

	@Then("^user searches for Morning Glory Semi-Precious Ring from jewe page and clicks on it$")
	    public void user_searches_for_morning_glory_semiprecious_ring_from_jewe_page_and_clicks_on_it() throws Throwable {
		for (int i = 0; i < shopbycat.jewpro().size(); i++) {
			if (shopbycat.jewpro().get(i).getText().contains("Morning Glory Semi-Precious Ring")) {
				Thread.sleep(2000);
				er.startTest("Successfully found Morning Glory Semi-Precious Ring");
				log.info("Successfully found Morning Glory Semi-Precious Ring");
				System.out.println("Product found!");
				log.info("Product found!");
				shopbycat.jewpro().get(i).click();
				break;
				// check the name of the least priced product
			}
		}
		
	    }
	@And("^user adds it to wishlist$")
		public void user_adds_it_to_wishlist() throws Throwable {
		productcmon.productwishlist().click();
		log.info("Adds jewellery product to wishlist");
		er.endTest();
		
	}

	public static WebDriver getdriver() {
		return driver;
	}

}
