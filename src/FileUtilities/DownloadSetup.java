/**
 * 
 */
package fileUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author washby
 *
 */
public class DownloadSetup {

	private File[] files;
	private String dirString;
	
	public DownloadSetup(String dir) throws IOException{
		this.dirString = dir;
		File directory = new File(dir);
		this.files = directory.listFiles();

		removeAllNoneJavaFiles();
		this.files = directory.listFiles();
		renameFilesAndClasses();
		
		//clean up old files
		for(File file : this.files){
			System.out.println("--deleting "+file.getAbsolutePath());
			file.delete();
		}
		files = null;
	}
	
	private void removeAllNoneJavaFiles(){
		for(File file : files){
			if(!(file.getName().matches(".+java$")))
				file.delete();
		}
	}
	
	private void renameFilesAndClasses(){
		try{
			for(File file : files){
				String str = file.getName();
				int firstPos = str.indexOf("_");
				int secPos = str.indexOf("_", firstPos+1);
				String newClassName = str.substring(firstPos+1, secPos);
				String newFileName = dirString+"\\"+newClassName+".java";
				
				renameClass(file, newFileName, newClassName);
			}
		}catch(Exception e){
			;//do nothing
		}
	}
	
	private void renameClass(File f, String newFileName, String newClassName) throws IOException{
		boolean renamed = false;
		InputStream inFile = new FileInputStream(f.getAbsolutePath());
		InputStreamReader inReader = new InputStreamReader(inFile);
		BufferedReader reader = new BufferedReader(inReader);
		
		
	
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		
		while((line = reader.readLine()) != null){
			//System.out.println(line);
			if(line.matches("^public class(.*)")){
				//line.replaceAll("^public class (.*)\\{","public class "+newClassName+"{");
				line = "public class "+newClassName+"{";
			}
			lines.add(line);
		}
		
		new FileBuilder(newFileName, lines).getFile();
		inFile.close();
		inReader.close();
	}
}
