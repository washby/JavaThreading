package unitTests;

import static org.junit.Assert.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import FileUtilities.DownloadSetup;

public class DownloadSetupJU {

	@Test
	public void test() {
		String testDir = "C:\\JavaHomeworks\\HW1";
		
		try {
			DownloadSetup ds = new DownloadSetup(testDir);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
