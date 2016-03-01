import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import fileUtilities.DownloadSetup;
import fileUtilities.FileFormatter;


/**
 * 
 */

/**
 * @author washby
 *
 */
public class FileManipMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String testDir = "C:\\JavaHomeworks\\HW1";
		
		try {
			DownloadSetup ds = new DownloadSetup(testDir);
			File dir = new File(testDir);
			File[] files = dir.listFiles();
			for(File file : files){
				System.out.println("----"+file.getName());
				FileFormatter ff = new FileFormatter(file);
				//file = ff.getFile();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
