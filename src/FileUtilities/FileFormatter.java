package fileUtilities;
/**
 * @author washby
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class FileFormatter {
	
	private BufferedReader reader;
	private ArrayList<String> lines = new ArrayList<String>();
	private File file;
	

	public FileFormatter(String filePath) throws IOException{
		File file = new File(filePath);
		new FileFormatter(file);
	}
	
	public FileFormatter(File file) throws IOException{
		InputStream inFile = new FileInputStream(file.getAbsolutePath());
		InputStreamReader inReader = new InputStreamReader(inFile);
		this.reader = new BufferedReader(inReader);	
		setupLinesInFile();
		formatIndentation();
		FileBuilder fb = new FileBuilder(file.getAbsolutePath(), lines);
		file = fb.getFile();
	}

	private void setupLinesInFile() throws IOException{
		String line;
		while((line = reader.readLine()) != null){
			line = line.trim();
			boolean addLine = true;
			//line = stripSingleLineComments(line).trim();
			if(line.equals("")){addLine = false;}
			
			if(addLine){lines.add(line);}

		}
	}

	private String stripSingleLineComments(String line) {
		// TODO Auto-generated method stub
		String temp = "";
		for(int i = 0; i<line.length(); i++){
			if(line.charAt(i)=='/'){
				System.out.println("found first / at "+i+" with string length of "+line.length());
				if(line.length() > i+1){
					if(line.charAt(i+1) == '/'){
						break;
					}
				}
			}
			temp += line.charAt(i);
		}
		return temp;
	}
	
	private void formatIndentation(){
		int tabs = 0;
		for(int lineNumber = 0; lineNumber < lines.size(); lineNumber++){
			String line = lines.get(lineNumber);
			for(int i = 0; i<tabs; i++){
				line = '\t'+line;
			}
			for(int i = 0; i<line.length(); i++){
				if (line.charAt(i) == '{')
					tabs++;
				if (line.charAt(i) == '}'){
					tabs--;
					line = line.substring(1, line.length());
				}
			}
			lines.set(lineNumber, line);
		}
	}

	/**
	 * @return the lines
	 */
	public ArrayList<String> getLines() {
		return lines;
	}
	
	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}
}
