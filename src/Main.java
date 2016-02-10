import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import FileUtilities.FileFormatter;

/**
 * 
 */

/**
 * @author washby
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileFormatter ff = new FileFormatter("Test.java");
			ArrayList<String> lineArray = ff.getLines();
			System.out.println("Start");
			for(int i = 0; i < lineArray.size(); i++){
				System.out.println("--"+lineArray.get(i));
			}
			System.out.println("End");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
