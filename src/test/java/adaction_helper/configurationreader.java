package adaction_helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 

public class configurationreader {
	public static Properties ps;
	 
	 public configurationreader() throws IOException {
	File f = new File("src\\test\\java\\adaction_helper\\Adaction_property");
	FileInputStream fis = new FileInputStream(f);
	 ps = new Properties();
	ps.load(fis);
	}
	 
	public String getbrowser_Launch () {
	 String browesername = ps.getProperty("browser_Launch");
		 return browesername;
}
	public String geturl() {
	 String url = ps.getProperty("geturl");
		return url;

	}
	 public static void main(String[] args) throws IOException {
		configurationreader cr = new configurationreader();
	 cr.getbrowser_Launch();
		 cr.geturl();
		
	}

		
	

	
}