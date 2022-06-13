package pom;

 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adaction_loginpage {
	
	WebDriver driver1;
	
	public adaction_loginpage(WebDriver driver) {
		this.driver1=driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(id="user") public static  WebElement username;
	//username
	public static WebElement getusername() {
		return username;
		}
	@FindBy(id="password") public static WebElement password;
	
	public static WebElement getpassword() {
		return password;
	
   }

	@FindBy(id="login") public static WebElement login;
	//login
	public static WebElement getlogin() {
		return login;
	
	}
	@FindBy(xpath = "//td[@class='login_title']") public WebElement name;

		public WebElement gettext() {
			return name;

		
	}

	
	}

