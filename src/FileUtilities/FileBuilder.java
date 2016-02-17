/**
 * 
 */
package FileUtilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author washby
 *
 */
public class FileBuilder {
	
	private File file;
	
	public FileBuilder(String absolutePathName, ArrayList<String> lines) throws IOException{
		this.file = new File(absolutePathName);

		//create file if it does not exist
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for(String line : lines){
			bw.write(line+"\n");
		}
		bw.close();
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

}
