package stepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import Utility.Base;
import io.cucumber.java.en.*;

public class Landing extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class);

	@Given("user redirects to site url")
	public void user_redirects_to_site_url() throws IOException {
		driver = initializeDriver();
		log.info("driver is been initialized");
		driver.get(prop.getProperty("url"));
		log.info("user is redirect to site url");
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
	}
	
	@Then("user validates site url")
	public void user_validates_site_url() {
	  String currentUrl = driver.getCurrentUrl();
	  Assert.assertEquals("https://www.demoblaze.com/",currentUrl);
	  log.info("site url is"+currentUrl);
	}
	
	@Then("user exits the browser")
	public void user_exits_the_browser() {
		driver.close();
		log.info("browser is closed");
	}
}
