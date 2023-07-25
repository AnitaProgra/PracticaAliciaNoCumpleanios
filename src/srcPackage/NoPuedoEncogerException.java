package srcPackage;

public class NoPuedoEncogerException extends Exception {
	
	protected String mensaje; 
	
	public NoPuedoEncogerException(String mensaje) {
		super(mensaje); 
	}

}
