/**
 * 
 */
package FileUtilities;



import java.nio.file.DirectoryStream;
import java.nio.file.Path;

/**
 * @author washby
 *
 */
public class DownloadCleanup {
	
	public DownloadCleanup(String directory){
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(directory)){
			for(Path file: stream){
				System.out.println(file.getFileName());
			}
		}
	}

}
