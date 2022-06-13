package adaction_helper;

import java.io.IOException;

public class FileReaderManager {
	
	private FileReaderManager(){
		
	}
	public static  FileReaderManager getInstance() {
		FileReaderManager frm =new  FileReaderManager();
		return frm;
		}
	public  configurationreader getCrInstance() throws IOException {
		 configurationreader cr = new  configurationreader();
		return cr;
		
		
	}
}
