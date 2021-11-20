package ReusableComponents;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import PageObjects.CreateAccount;
import PageObjects.GiftCardPage;
import PageObjects.Gifts;
import PageObjects.HomePage;
import PageObjects.OfficialMerchandise;
import PageObjects.PersonalisedGifts;
import PageObjects.ProductPage;
import PageObjects.ShopByCatPage;
import PageObjects.SigninPage;
import PageObjects.WhatsNew;
import Utilities.ConfigsProvider;
import Utilities.Excel;
import Utilities.Extentreports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseClass {

	public static WebDriver driver;
	public static Logger log;
	public static ConfigsProvider config;
	// public static ExtentReports reporter;
	public static ExtentTest test;
	public static Extentreports er;

	public static HomePage homepage;
	public static SigninPage signin;
	public static GiftCardPage giftcard;
	public static ProductPage productcmon;
	public static OfficialMerchandise officialMerchandise;
	public static ShopByCatPage shopbycat;
	public static CreateAccount createAcc;
	public static WhatsNew whatsnew;
	public static Gifts gift;
	public static PersonalisedGifts personalGifts;
	public Excel ex = new Excel();

	public void startup() throws IOException {

		log = Logger.getLogger(getClass());
		config = new ConfigsProvider();
	}

	public void beforeClass() {
		driver = WebDriverHelper.driverInitializer(driver, config.getBrowser(), config.implicitWait());
		log.info("Driver Initialised");
		er = new Extentreports(driver);

		homepage = new HomePage(driver);
		signin = new SigninPage(driver);
		giftcard = new GiftCardPage(driver);
		productcmon = new ProductPage(driver);
		officialMerchandise = new OfficialMerchandise(driver);
		shopbycat = new ShopByCatPage(driver);
		createAcc = new CreateAccount(driver);
		whatsnew = new WhatsNew(driver);
		gift = new Gifts(driver);
		personalGifts = new PersonalisedGifts(driver);

	}

	public void classTeardown() {
		WebDriverHelper.quitDriver(driver);
		log.info("Driver Closed");
	}

}
