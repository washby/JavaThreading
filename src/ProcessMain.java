import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import fileUtilities.DownloadSetup;
import fileUtilities.FileFormatter;
import threadingUtils.RunJavaProgram;


public class ProcessMain {
	
	public static void main(String[] args){
		String properOutput = "Hello World.\n";
		
		String testDir = "C:\\JavaHomeworks\\HW1";
		
		try {
			DownloadSetup ds = new DownloadSetup(testDir);
			File dir = new File(testDir);
			File[] files = dir.listFiles();
			for(File file : files){
				String filename = file.getAbsolutePath(); 
				System.out.println("----"+file.getName());
				RunJavaProgram mp = new RunJavaProgram(filename);
				String str = mp.getOutput();
				if(str.trim().equalsIgnoreCase(properOutput.trim())){
					System.out.println(filename + " is correct.");
				}else{
					System.out.println("-----");
					System.out.println("--"+filename);
					System.out.println("--|"+mp.getOutput() + "| != |"+str+"|");
					System.out.println("-----");
				}				
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
