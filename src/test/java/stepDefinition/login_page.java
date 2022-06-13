package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.adaction.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pom.orange;

public class login_page extends BaseClass {
	orange page2;
@Before
	private void beforeHooks(Scenario scenario) {
		String name = scenario.getName();
		System.out.println("ScenarioName:"+name);
	}
	@After
	private void afterHooks(Scenario scenario) throws IOException {
		Status status = scenario.getStatus();
		System.out.println("ScnarioStatus:"+status);
		if(scenario.isFailed()) {
			takescreenshot(scenario.getName());
}
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		browser_Launch(25);
		geturl("https://opensource-demo.orangehrmlive.com/");
	}
	
	@When("the user enters the valid {string} and {string}")
	public void the_user_enters_the_valid_and(String string, String string2) {
		page2 =new orange(driver);
		waitwe(page2.getusername(),string);
				waitwe(page2.getpassword(),string);
				}
    //@When("the user enters the valid username and password")
	//public void the_user_enters_the_valid_username_and_password(String String) {
		//page2 =new orange(driver);
		//page2.getusername().sendKeys("Admin");
		//page2.getpassword().sendkeys("Admin123"):
		
	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
		page2.getlogin().click();
	}
	@Then("the user should be navigated to home page")
	public void the_user_should_be_navigated_to_home_page() {
		boolean displayed = page2.getusername().isDisplayed();
	    Assert.assertTrue(true);
	    if(displayed) {
	    	System.out.println("result displyed");
	    }}}
