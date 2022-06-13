package runner;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adaction.baseclass.BaseClass;

import adaction_helper.FileReaderManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/new.feature",glue="stepDefinition",
              monochrome = true,
                dryRun=false ,
                plugin= {"pretty","html:target/htmlreport/login_report.html","json:target/jsonreport/login_report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
                
              //  plugin= {"html:Report/Cucumber.html",
                		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class examplerunnerclass {
	public static WebDriver driver;
	@BeforeClass
		public static void setup() throws IOException {
			String browser_Launch = FileReaderManager.getInstance().getCrInstance().getbrowser_Launch();
			driver= BaseClass.browser_Launch(25);
			
			String geturl = FileReaderManager.getInstance().getCrInstance().geturl();
			driver=BaseClass.geturl(geturl);
	        }
		@AfterClass
		public static void tearDown() {
			//driver.close();
	
	}

}
