package fileredirector;

import java.io.File;
import java.io.IOException;

public class ParseAndConvert extends Convertor{
	
	public ParseAndConvert(){
		super();
	}
	
	public static void parseDirectoryAndConvert(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				parseDirectoryAndConvert(fileEntry);
			} else {
				String fileName = fileEntry.getName();

				int i = 0;
				while (i < extenstions.length) {
					if (fileName.endsWith(extenstions[i])
							&& !fileName.endsWith("pox")) {
						Runtime rt = Runtime.getRuntime();
						System.out.println(pathToConvertor + "\\"
								+ extenstions[i] + "\\Convertor"
								+ extenstions[i] + ".bat "
								+ fileEntry.getName());

						try {
							Process pr = rt.exec(pathToConvertor + "\\"
									+ extenstions[i] + "\\Convertor"
									+ extenstions[i] + ".bat "
									+ fileEntry.getAbsolutePath());
						} catch (IOException e) { // TODO Auto-generated catch
													// block
							e.printStackTrace();
						}

					}
					++i;
				}

			}
		}
	}
}
