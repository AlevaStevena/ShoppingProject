/**
 * 
 */
package stepsDefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * @author Aleva
 *
 */
public class Test_Stpes {
	public WebDriver driver;
	public int random;
	
	@Given("^I am on the Homepage$")
	public void i_am_on_the_Homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.carguruji.com/shop/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@And("^I click on My Account Link$")
	public void i_click_on_My_Account_Link() throws Throwable {
		driver.findElement(By.id("tdb3")).click();
	
	}

	@And("^I see a welcome message banner$")
	public void i_see_a_welcome_message_banner() throws Throwable {
	    String ExpectedMessage = "Welcome, Please Sign In";
		System.out.println(driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1")).getText());
		String ActualMessage = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1")).getText();
		Assert.assertEquals(ExpectedMessage, ActualMessage);
	}

	@When("^I enter a valid username$")
	public void i_enter_a_valid_username() throws Throwable {
	    driver.findElement(By.name("email_address")).sendKeys("st.eromonsele@gmx.at");
	}

	@And("^I enter a valid password$")
	public void i_enter_a_valid_password() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='bodyContent']/div[2]/div/form/table/tbody/tr[2]/td[2]/input")).sendKeys("Avictor&1");
}

	@And("^I click the sign in button$")
	public void i_click_the_sign_in_button() throws Throwable {
	    driver.findElement(By.xpath(".//*[@id='tdb5']")).click();
}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Throwable {
		String ExpectedMessage = "My Account Information";
		System.out.println(driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1")).getText());
		String ActualMessage = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1")).getText();
		Assert.assertEquals(ExpectedMessage, ActualMessage);
	}

	
	@When("^I click my change my password button$")
	public void i_click_my_change_my_password_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='bodyContent']/div/div[1]/ul/li[3]/a")).click();
	 }

	@And("^I enter my current password$")
	public void i_enter_my_current_password() throws Throwable {
		driver.findElement(By.name("password_current")).sendKeys("Avictor&1");
	}

	@When("^I enter my new pssword$")
	public void i_enter_my_new_pssword() throws Throwable {
		driver.findElement(By.name("password_new")).sendKeys("Avictor1");
	}

	@When("^I enter my password confirmation$")
	public void i_enter_my_password_confirmation() throws Throwable {
		driver.findElement(By.name("password_confirmation")).sendKeys("Avictor1");
	}

	@When("^I click the continue button$")
	public void i_click_the_continue_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='tdb5']")).click();  
	}

	@Then("^my password should be chnged$")
	public void my_password_should_be_chnged() throws Throwable {
		String ExpectedMessage = "My Account Information";
		System.out.println(driver.findElement(By.xpath(".//*[@id='bodyContent']/h1")).getText());
		String ActualMessage = driver.findElement(By.xpath(".//*[@id='bodyContent']/h1")).getText();
		Assert.assertEquals(ExpectedMessage, ActualMessage);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/ShoppingProject.png"));
		
	
		System.out.println("Project Screenshot taken");	
	}
	
	@When("^I enter all the user data in the registration form$")
	public void i_enter_all_the_user_data_in_the_registration_form() throws Throwable {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.id("tdb4")).click();
		driver.findElement(By.name("gender")).click();
		driver.findElement(By.name("firstname")).sendKeys("Pete");
		driver.findElement(By.name("lastname")).sendKeys("Pete");
		driver.findElement(By.id("dob")).click();
		driver.findElement(By.id("dob")).sendKeys("05/05/1990");

		// *****************Generating Random Email Address****************************
		random = 100 + (int) (Math.random() * ((1000 - 1) + 1));
		System.out.println(random);
		driver.findElement(By.name("email_address")).sendKeys("maxwell" + random + "@yahoo.com");
		Thread.sleep(1000);

		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[3]/table/tbody/tr/td[2]/input")).sendKeys("Aleva ltd");
		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[1]/td[2]/input")).sendKeys("11 Rounders Court");
		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[2]/td[2]/input")).sendKeys("Dag");
		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[3]/td[2]/input")).sendKeys("RM9 6BW");
		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[4]/td[2]/input")).sendKeys("Dagenham");
		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[5]/td[2]/input")).sendKeys("Essex");
		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[6]/td[2]/select")).click();
		driver.findElement(By.cssSelector("#bodyContent > form > div > div:nth-child(6) > table > tbody > tr:nth-child(6) > td.fieldValue > select > option:nth-child(222)")).click();
		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[5]/table/tbody/tr[1]/td[2]/input")).sendKeys("076598214");
		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[6]/table/tbody/tr[1]/td[2]/input")).sendKeys("Avictor1");
		driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[6]/table/tbody/tr[2]/td[2]/input")).sendKeys("Avictor1");
		driver.findElement(By.xpath(".//*[@id='tdb4']")).click();
		
	}

	@Then("^my account should be created$")
	public void my_account_should_be_created() throws Throwable {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1")).getText());

		String ExpectedMessage = "My Account Information";
		String ActualMessage = driver.findElement(By.xpath(".//*[@id=\"bodyContent\"]/h1")).getText();

		Assert.assertEquals(ExpectedMessage, ActualMessage);  
	}

	@Then("^I log off$")
	public void i_log_out() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='tdb4']/span")).click(); 
	}
	
	@When("^I enter a \"([^\"]*)\" detail$")
	public void i_enter_a_detail(String email) throws Throwable {
		driver.findElement(By.name("email_address")).sendKeys(email);
	}

	@When("^I enter a \"([^\"]*)\" for the user$")
	public void i_enter_a_for_the_user(String passw) throws Throwable {
		driver.findElement(By.name("password")).sendKeys(passw);
		
	}
	
	@Then("^I should see error message$")
	public void i_should_see_error_message() throws Throwable {
		String ErrorMessage =  driver.findElement(By.xpath(".//*[@id='bodyContent']/table/tbody/tr/td")).getText();
		System.out.println(driver.findElement(By.xpath(".//*[@id='bodyContent']/table/tbody/tr/td")).getText());
	}
	@Given("^I click on the Checkout Link$")
	public void i_click_on_the_Checkout_Link() throws Throwable {
		driver.findElement(By.id("tdb2")).click();
	}

	@Given("^I click on the continue button$")
	public void i_click_on_the_continue_button() throws Throwable {
		driver.findElement(By.id("tdb5")).click();
	}

	@Given("^I picked my item$")
	public void i_picked_my_item() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"columnLeft\"]/div[4]/div[2]/a[1]/img")).click();  
		
	}

	@Given("^I add to Cart$")
	public void i_add_to_Cart() throws Throwable {
		driver.findElement(By.id("tdb5")).click();
	}
	
	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id=\"tdb6\"]/span[2]")).click();
	}
@When("^I click continue button$")
	public void i_clickthe_add_to_cart_button() throws Throwable {
		driver.findElement(By.id("tdb6")).click();

}
@When("^I click payment method$")
public void i_click_payment_method() throws Throwable {
    		//driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[4]/table[1]/tbody/tr/td[2]/input")).click();
	}

@When("^I click the Confirm Order button$")
	public void i_click_the_Confirm_Order_button() throws Throwable {
		driver.findElement(By.id("tdb5")).click();
	}

	@Then("^I should see your order has been processed$")
	public void i_should_see_your_order_has_been_processed() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='bodyContent']/h1")).click();
	}


@After
public void TearDown() { 
driver.quit();
}

}
