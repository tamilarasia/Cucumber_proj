package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orange {
WebDriver driver1;
	
	public orange(WebDriver driver) {
		this.driver1=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//input[@name='txtUsername']") public static WebElement  txtUsername;
		
		public static WebElement getusername() {
			return  txtUsername;
			}
		@FindBy(id="txtPass") public static WebElement txtpassword;
		//txtPassword
		public static WebElement getpassword() {
			return txtpassword;
		
	    }

		@FindBy(id="btnLogin") public static WebElement  btnlogin;
		//btnLogin
		public static WebElement getlogin() {
			return btnlogin;
		
		}
		@FindBy(id = "logInPanelHeading") public WebElement loginheading;

		public WebElement getName() {
			return loginheading;

		
		}

}


