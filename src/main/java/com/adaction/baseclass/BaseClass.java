package com.adaction.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	static JavascriptExecutor js;
	static Actions act;
	static 	 TakesScreenshot sc;
	static Alert alert;
	static Select s;
	static Scanner scan;
	private static String text;
	//open chrome
	public static  WebDriver browser_Launch(int sec) {
		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	    WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		return driver;
	}
	// load url
	public static WebDriver geturl(String url) {
		
		driver.get(url);
		return driver;

	}
	//to find element
	public static  WebElement elementfinding ( String webElement  , String value) {
		switch ( webElement ) {
		case "id":{
			return driver.findElement(By.id(value));
		}
		case "name":{
			return driver.findElement(By.name(value));

		}
		case "tagname":{
			return driver.findElement(By.tagName(value));
		}	
	case "classname":{
		return driver.findElement(By.className(value));
		
	}	
			
	case "xpath":{
		return driver.findElement(By.xpath(value));
	}
	
	case "link":{
		return driver.findElement(By.linkText(value));
	}	
	case "partiallink":{
		return driver.findElement(By.partialLinkText(value));
	}
	default:
		System.err.println("undefined locator please to check it");
			
		break;
		}
		return null;
	}
	

  public static List<WebElement>  elementsfinding(String locator ,String value) {
	switch (locator) {
	case "id":{
		return driver.findElements(By.id(value));
	}
	case "name":{
		return driver.findElements(By.name(value));

	}
	case "tagname":{
		return driver.findElements(By.tagName(value));
	}	
case "classname":{
	return driver.findElements(By.className(value));
	
}	
		
case "xpath":{
	return driver.findElements(By.xpath(value));
}

case "link":{
	return driver.findElements(By.linkText(value));
}	
case "partiallink":{
	return driver.findElements(By.partialLinkText(value));
}
default:
	System.err.println("undefined locator please to check it");
		
	break;
	}
	return null;
}
  //driver method
  
  public static void  close_or_quit(String closing) {
	  switch(closing) {
	  case "close":{
		  driver.close();
		  break;
	  }
   
      case"quit":{
		  
       driver.quit();
		   break;
	  }  
    
    default:
		  throw new IllegalArgumentException("unexepected value"+closing);
}

  }
  
  public static void waitwe(WebElement element,String str) {
	  waitforElementVisibility(element);
	  try {
		  element.sendKeys(str);
		  } catch (Exception e) {
			  System.out.println(e);
		  }
	   }
private static void waitforElementVisibility(WebElement element) {
	WebDriverWait w = new WebDriverWait(driver,Duration .ofSeconds(30));
	w.until(ExpectedConditions.visibilityOf(element));
	
}
// driver method return string
			
    public static String  gettitle() {
	return driver.getTitle();
	}
		  
  public static String getcurenturl() {
  return driver.getCurrentUrl();	

}
  public static String getpagesource() {
	  return driver.getPageSource();	
}
  public static String getwindowHandle() {
	  return driver.getWindowHandle();	
  }
  public static Set<String> getwindowHandles() {
	  return driver.getWindowHandles();	
  }

  
  // method manage
  public void manage(String manage_name) {
	  switch (manage_name) {
	  case "fullscreen":{
	  
	  driver.manage().window().fullscreen();
	  
	  }       break;
}
	  switch (manage_name) {
	  case "minimize":{
	  
	  driver.manage().window().minimize();
	  
       break;
}}
	  switch (manage_name) {
	  case "maximize":{
	  
	  driver.manage().window().maximize();
	  
       break;
}
	  
	  default:
		  throw new IllegalArgumentException("unexepected value"+manage_name);
	  
	  }
	      }// driver method
	 
	  public static void navigate( String navigate_value, String WebElement) {
	  
		switch (navigate_value) {
		case "to":{
			driver.navigate().to(navigate_value);
			break;
		}
		case "back":{
			driver.navigate().back();
			break;
		}
		case "forward":{
			driver.navigate().forward();
			break;
		}
		case "refresh":{
			driver.navigate().refresh();
		}
		default:
			throw new IllegalArgumentException("unexepected value"+navigate_value);
		}
	  }	//Switch_frame	
		public static void switch_framewith_WebElement(WebElement WebElement) {
		driver.switchTo().frame(WebElement);
		 }	
		public static void switch_framewith_index(int frameint) {
			driver.switchTo().frame(0);
		}

		public static void switch_framewith_nameorid(String nameorid) {
			driver.switchTo().frame(nameorid);
		}
		//switch_frameout
		private void switch_frameout(String direct_Or_onebyone) {
			if(direct_Or_onebyone.equalsIgnoreCase("direct")) {
			driver.switchTo().defaultContent();
			}
		else if(direct_Or_onebyone.equalsIgnoreCase("onebyone")) {
			driver.switchTo().parentFrame();
			}
		else {
			System.err.println("please to check yours syntax");
			}}
			// action mouseover
		public static void actions_mouseover(WebElement WebElement,String mouseover_actions) {
		Actions act = new Actions(driver);
		}
		//actions _dd by value
		private void actions_drog_drop_by(WebElement source,int addingvalue) {
			act= new Actions(driver);
			Point location=source.getLocation();
			int x=location.getX();
			int y=location.getY();
			}
		// actions_ javascriptExcecutor for scroll
		private void scroll_byelement( String script,WebElement element)  {
		 js=(JavascriptExecutor)driver;
		 try {
		if(script.equalsIgnoreCase("elementscroll")) {
		 js.executeScript("arguments[0].scrollIntoView();",element);
			} 
		 else if (script.equalsIgnoreCase("bottomscroll")) {
			 js.executeScript("window.scrollTo(0,document.body.scrollheight)");
		 }
		 else if (script.equalsIgnoreCase("topscroll")) {
			 js.executeScript("window.scrollTo(0,0)");
		 }
		 else if (script.equalsIgnoreCase("click")) {
		     js.executeScript("arguments[0].click",element);
		     
		 } }
		catch(JavascriptException e) {
			System.err.println("may be you made mistake in yours script please to check==>"+e.getMessage() );
		}
		 catch(Exception e) {
			 System.err.println("other exception ==> "+e.getMessage());
			 }}
		
		//robotclass
		 public static void robot(int nooftimes) throws AWTException  {
		 Robot robo =new Robot();
		 
		 for(int i=1;i<=nooftimes;i++) {
			 robo.keyPress(KeyEvent.VK_DOWN);
			  }
		 robo.keyPress(KeyEvent.VK_ENTER);
		 
		 }
		 //TAKESCREENSHOT
		 public static  void takescreenshot( String filename) throws IOException {
			  sc =(TakesScreenshot)driver;
			  File screenshotAs= sc.getScreenshotAs(OutputType.FILE);
			  
			File target = new File(System.getProperty("user.dir")+"\\Screenshot \\"+filename+".png");
			  
			  try
			  {
				 FileUtils.copyFile(screenshotAs, target);
				// FileHandler.copy(screenshotAs, target);
			  }
			  catch(IOException e) {
				  e.printStackTrace();
				  System.out.println(e);
				 }}
			// alert
			  public static void Alert_withouttext(String alerttype) {
				switch(alerttype) {
				case"simplealert":{
			    alert = driver.switchTo().alert();	
			    System.out.println(alert.getText());
			    alert.accept();
			    break;
		   }	
				case"confirmalertaccept":{
				    alert = driver.switchTo().alert();	
				    System.out.println(alert.getText());
				    alert.accept();
				    break;
			   }
				case"confirmalertacceptcancel":{
				    alert = driver.switchTo().alert();	
				    System.out.println(alert.getText());
				    alert.dismiss();
				    break;
			   }
				default:
					throw new IllegalArgumentException("unexepected value"+alerttype);
				}}
			  //prompt alert
			  public static void Alert_withtext_promptbox(String prompt_confirm_orcancel,String sentalerttext) {
				  
				switch(prompt_confirm_orcancel) { 
			  
				  case"confirm":{
				  
					alert=driver.switchTo().alert();
					System.out.println(alert.getText());
					alert.sendKeys(sentalerttext);
					alert.accept();
					break;
				  }
				  case"cancel":{
					  
						alert=driver.switchTo().alert();
						System.out.println(alert.getText());
						alert.sendKeys(sentalerttext);
						alert.dismiss();
						break;
					  }
					
				  default:
						throw new IllegalArgumentException("unexepected value"+prompt_confirm_orcancel);
				}}
				// drop down 
				//single dd
	     public static void dropdown_singleby_index(WebElement element,int indexvalue) {
		
      	 s =new Select(element);
		 s.selectByIndex(indexvalue);
	     }
	     public static void dropdown_singleby_valueoftext(String findby_valueortext,WebElement element) {
	    	 switch(findby_valueortext) {
	    	 case"value":{
	    		 s =new Select(element);
				s.selectByValue(findby_valueortext);
	    		 break;
	    	 }
	    	 case "text":{
	    		 s=new Select(element);
	    		 s.selectByVisibleText(findby_valueortext);
	    		 break;
	    		  }
	    	 default:
	    			throw new IllegalArgumentException("unexepected value"+findby_valueortext);
	    	 }}
		 //dd fuction
	    	 public static void dropdown_fuctions(WebElement element,String option) {
	    		 switch(option) {
	    		 case "printoption":{
	    			  s =new Select(element);
	    		 List<WebElement> dd_options = s.getOptions();
	    		 for(WebElement WebElement:dd_options) {
	    			 text=WebElement.getText();
	    			 System.out.println(text);
	    		 }
	    		 break;
	    		 
	    	 }
	    		 case "sizeoption":{
	    			  s =new Select(element);
	    		 List<WebElement> dd_options = s.getOptions();
	    			 int  size= dd_options.size();
	    		      System.out.println(size);
	    		 }
	    		 break;
	    		 
	    		 case"deselectall":{
	    			 s= new Select(element) ;
	    			 s.deselectAll();
	    		 }
	    		 break;
	    			 
	    		 case"getallSelectedoption":{
	    			 s = new Select(element);
	    			 List<WebElement> allselectedoption = s.getAllSelectedOptions();
	    			 for(WebElement selectedoption:allselectedoption) {
	    				 System.out.println( selectedoption .getText());
	    			 }
	    					 
	    		 }
	    			break; 
	    			
	    		 case"firstselectall":{
	    			 WebElement firstSelectedOption = s.getFirstSelectedOption();
	    			 System.out.println(firstSelectedOption.getText());
	    			 break;
	    			
    		 }
	    		 default:
		    			throw new IllegalArgumentException("unexepected value"+option);
	    		 }
	    	 }
		 //multiple  drop down by value
	    		 public static void dropdownbyindexvalue(String selectordeselect,WebElement element) {
	    			 switch(selectordeselect) {
	    			 case"selecting":{
	    				 Select dropdown = new Select(element);
	    				 boolean ismultipleornot = dropdown.isMultiple();
	    				 System.out.println("if the dropdown ismultipleornot"+ismultipleornot);
	    				 if(ismultipleornot==true) {
	    					 int size = dropdown.getOptions().size();
							String sizeofoption1 = null;
							System.out.println("the size options"+sizeofoption1);
							
							int sizeOfOptionn1 = 0;
							for(int i=0;i<sizeOfOptionn1;i++);
	    				scan =new Scanner(System.in);
	    				String please = null;
						System.out.println("enter the index value"+please);
	    				 int indexvalue =scan.nextInt();
	    				 int i = 0;
						if(i==indexvalue) {
							dropdown.selectByIndex(i);
	    					break; 
	    				 }}}
						case"deselecting":{
							Select dropdown = new Select(element);
		    				 boolean ismultipleornot = dropdown.isMultiple();
		    				 System.out.println("if the dropdown ismultipleornot"+ismultipleornot);
		    				 if(ismultipleornot==true) {
		    					 int size = dropdown.getOptions().size();
								String sizeofoption1 = null;
								System.out.println("the size options"+sizeofoption1);
								
								int sizeOfOptionn1 = 0;
								for(int i=0;i<sizeOfOptionn1;i++);
		    				scan =new Scanner(System.in);
		    				String please = null;
							System.out.println("enter the index value"+please);
		    				 int indexvalue =scan.nextInt();
		    				 int i = 0;
							if(i==indexvalue) {
								dropdown.deselectByIndex(i);
		    					break; 
		    				 }}}
				}
	    				  }
	    		 //windowhandling
	    		 
	    		  public static void Windonandlings(Set<String> windowid,int index) {
	    			  List<String> ref= new ArrayList<String>(windowid);
	    			  try {
	    				  driver.switchTo().window(ref.get(index));
	    				   String title = driver.getTitle();
	    			  }
	    			  catch(ArrayIndexOutOfBoundsException e) {
	    				  System.err.println("may be come"+e.getMessage());
	    			  }
	    			   
	    				catch(NoSuchElementException e) {
	    					System.err.println("may be window is closed or not opened please to check==>" +e.getMessage());
	    					}
	    			  catch(Exception e) {
	    				 System.err.println("other java related exception==>"+e.getMessage());
	    			  }
			
					
				}}
				
				

					

 
		
	    	 
			 
		 


		
				
		
		

		
		
	  		
			
			
			
			
	  
			
			
			
			
			
			
			
			
			
			
			



    
    
   
