package fileredirector;

import java.io.File;
import java.io.IOException;

public class ParseAndDeconvert extends Convertor{
	public ParseAndDeconvert(){
		super();
	}
	
	public static void parseDirectoryAndDeconvert(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				parseDirectoryAndDeconvert(fileEntry);
			} else {
				String fileName = fileEntry.getName();

				int i = 0;
				while (i < extenstions.length) {
					if (fileName.endsWith(extenstions[i])
							&& !fileName.endsWith("pox")) {

						File folderOfFile = fileEntry.getParentFile();
						for (final File fileToDeconvert : folderOfFile
								.listFiles()) {
							String file = fileToDeconvert.getName();
							String nameOnly[] = fileName.split("."
									+ extenstions[i]);
							if (file.endsWith("pox")
									&& file.startsWith(nameOnly[0])) {

								Runtime rt = Runtime.getRuntime();
								System.out.println(pathToConvertor + "\\"
										+ extenstions[i] + "\\Deconvertor"
										+ extenstions[i] + ".bat "
										+ fileToDeconvert.getName());

								try {
									Process pr = rt
											.exec(pathToConvertor
													+ "\\"
													+ extenstions[i]
													+ "\\Deconvertor"
													+ extenstions[i]
													+ ".bat "
													+ fileToDeconvert
															.getAbsolutePath());
								} catch (IOException e) { // TODO Auto-generated
															// catch
															// block
									e.printStackTrace();
								}

							}
						}

					}
					++i;
				}

			}
		}
	}
}
