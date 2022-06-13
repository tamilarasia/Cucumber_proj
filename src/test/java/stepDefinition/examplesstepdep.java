package stepDefinition;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.adaction.baseclass.BaseClass;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.After;//
import io.cucumber.java.Before;//
import io.cucumber.java.Scenario;//
import io.cucumber.java.Status;//
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pom.adaction_loginpage;
import runner.examplerunnerclass;

public class examplesstepdep extends BaseClass {
	public static WebDriver driver = examplerunnerclass.driver;
	 adaction_loginpage page1;
	 @Before
	 public void beforeHooks(	Scenario scenario) {
		 String name = scenario.getName();
		 System.out.println("ScenarioName:"+name);
}
	@After 
	public void afterHooks(Scenario scenario) throws IOException {
		Status status = scenario.getStatus();
		System.out.println("ScenarioStatus:"+status);
		if(scenario.isFailed()) {
			takescreenshot(scenario.getName());
			}
		}
	 @Given("user launches the hotel  application")
	 public void user_launches_the_hotel_application() {
    //browser_Launch(25);
	//geturl("https://adactinhotelapp.com/");
}
	@When("user enters the login detail")
	public void user_enters_the_login_detail(DataTable dataTable) {
		List<Map<String, String>> asmaps=dataTable.asMaps(String.class,String.class);
		
		String username= asmaps.get(0).get("username");
		String password = asmaps.get(0).get("password");
		page1= new  adaction_loginpage(driver);
		waitwe(page1.getusername(),username);
		waitwe(page1.getpassword(),password);
		
	}
	//@When("user enters the valid {string} in the username field")
	//public void user_enters_the_valid_in_the_username_field(String string) {
		//page1= new  adaction_loginpage(driver);
		//waitwe(page1.getusername(),string);
		//}
	
	//@When("user enters the valid {string} in the password field")
	//public void user_enters_the_valid_in_the_password_field(String string) {
		//waitwe(page1.getpassword(),string);
	    //}
	
       //@When("user enters the valid username in the username field")
	//public void user_enters_the_valid_username_in_the_username_field() {
//page1= new  adaction_loginpage(driver);
   //page1.getusername().sendKeys("tamilsaran");
	   // }
	
 // @When("user enters the valid password in the password field")
	//public void user_enters_the_valid_password_in_the_password_field(){
	 // page1= new  adaction_loginpage(driver);
	  // page1.getpassword().sendKeys("021694");
	     // }
	
    @When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		page1= new  adaction_loginpage(driver);
		page1.getlogin().click();
	      }
  // @Then("user verifies Homepage navigates to the Search Hotel page")
   // public void user_verifies_homepage_navigates_to_the_search_hotel_page() {
   // boolean displayed = page1.getusername().isDisplayed();
	//Assert.assertEquals(true, displayed);
	   }


  


