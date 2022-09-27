package fileredirector;

public abstract class Convertor {
	protected static String extenstions[];	
	protected static String extensionList = System.getenv("EXTENSIONLIST");
	protected static String pathToConvertor = System.getenv("PATHTOCONVERTOR");
	
	public Convertor(){
		extenstions = extensionList.split(";");
	}
}
