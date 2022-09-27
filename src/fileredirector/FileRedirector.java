package fileredirector;

import java.io.File;
import java.io.IOException;

public class FileRedirector {

	public static void main(String arg[]) {

		try {
			String sourceFolder = System.getenv("SOURCE");
			ParseAndConvert pac = new ParseAndConvert();
			ParseAndDeconvert pad = new ParseAndDeconvert();
			
			File f = new File(sourceFolder);
			ParseAndConvert.parseDirectoryAndConvert(f);
			ParseAndDeconvert.parseDirectoryAndDeconvert(f);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	

	
}
