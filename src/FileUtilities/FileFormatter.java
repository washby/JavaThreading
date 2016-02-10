package FileUtilities;
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
	
	BufferedReader reader;
	ArrayList<String> lines = new ArrayList<String>();
	
	

	public FileFormatter(String filePath) throws IOException{
		InputStream inFile = new FileInputStream(filePath);
		InputStreamReader inReader = new InputStreamReader(inFile);
		this.reader = new BufferedReader(inReader);	
		formatFile();
	}

	private void formatFile() throws IOException{
		String line;
		while((line = reader.readLine()) != null){
			boolean addLine = true;
			line = stripSingleLineComments(line).trim();
			if(line.equals("")){addLine = false;}
			
			if(addLine){lines.add(line);}

		}
	}

	private String stripSingleLineComments(String line) {
		// TODO Auto-generated method stub
		String temp = "";
		for(int i = 0; i<line.length(); i++){
			if(line.charAt(i)=='/'){
				if(line.length() >= i+1){
					if(line.charAt(i+1) == '/'){
						break;
					}
				}
			}
			temp += line.charAt(i);
		}
		return temp;
	}

	/**
	 * @return the lines
	 */
	public ArrayList<String> getLines() {
		return lines;
	}
}
