package srcPackage;

public class EsteAlimentoNoEstaCompradoException extends Exception {

	protected String mensaje; 
	
	public EsteAlimentoNoEstaCompradoException(String mensaje) {
		super(mensaje); 
	}
	
}
