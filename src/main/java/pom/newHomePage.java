package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newHomePage {
WebDriver driver;
	
	public newHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//Select[@name='location']") public static  WebElement locationname;

	
	public static WebElement gethotellocation() {
		return locationname;
		}
@FindBy(id="hotels") public static  WebElement hotels;
	
	public static WebElement gethotels() {
		return hotels;
		}
@FindBy(name="//select[@name='room_type']") public static  WebElement hoteltypes;
	
	public static WebElement selectroomtype() {
		return hoteltypes;
		}
	
@FindBy(id="room_nos") public static  WebElement roomselect;
	
	public static WebElement getroomselect() {
		return roomselect;
		}
@FindBy(xpath="datepick_in") public static  WebElement indates;
	
	public static WebElement getindate() {
		return indates;
		}
@FindBy(xpath="//input[@value='27/05/2022']") public static  WebElement outdates;
	
	public static WebElement getoutdate() {
		return outdates;
		}
@FindBy(id="adult_room") public static  WebElement adult;
	
	public static WebElement getadultdetails() {
		return adult;
		}

@FindBy(id="child_room") public static  WebElement child;
	
	public static WebElement getchildinfo() {
		return child;
		}




}
