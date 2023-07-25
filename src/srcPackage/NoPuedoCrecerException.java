package srcPackage;

public class NoPuedoCrecerException  extends Exception{

	protected String mensaje; 
	
	public NoPuedoCrecerException(String mensaje) {
		super(mensaje); 
	}
	
}
