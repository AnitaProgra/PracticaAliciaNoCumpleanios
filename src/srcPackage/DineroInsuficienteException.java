package srcPackage;

public class DineroInsuficienteException extends Exception {

	protected String mensaje; 
	
	public DineroInsuficienteException(String mensaje) {
		super(mensaje); 
	}
}
