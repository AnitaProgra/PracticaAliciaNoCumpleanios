package srcPackage;

import java.util.ArrayList;
import java.util.HashSet;

public class Persona {

	protected String nombre; 
	protected Double dinero; 
	protected Integer altura; 
	protected Integer edad; 
	protected double peso;
	
	
	
	public Persona(String nombre, Double dinero, Integer altura, Integer edad, double peso) {
		super();
		this.nombre = nombre;
		this.dinero = dinero;
		this.altura = altura;
		this.edad = edad;
		this.peso = peso;
	
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getDinero() {
		return dinero;
	}


	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}


	public Integer getAltura() {
		 
		return altura;
	}
	


	public void setAltura(Integer altura) {
		this.altura = altura;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public double getPeso() {
		return peso;
	}



	
	public void comprar(Productos producto) throws  DineroInsuficienteException{
	 try {
		 if(producto==Productos.MASITA || producto==Productos.ALFAJOR || producto==Productos.BAGEL
	  ||producto==Productos.BOCADITO_DE_CHOCOLATE || producto==Productos.CARAMELO || producto==Productos.GOMITAS) {
			 dinero -= 50.0; 
			 setDinero(dinero);
		 }
		 
		 if(getDinero()<0.0) {
			 throw new  DineroInsuficienteException (" Dinero Insuficiente Exception"); 
		 }
	 }
	 
	 catch( DineroInsuficienteException e) {
		 System.out.println(e.getMessage()); 
	 }
	 
	 
	}
	
	
	
	public void comeer(Supermercado supermercado, Productos producto) throws EsteAlimentoNoEstaCompradoException{
		
		 try {
			 if( producto==Productos.MASITA || producto==Productos.ALFAJOR || producto==Productos.BAGEL) {
				 altura -= 50; 
				 setAltura(altura);
				
			 }
			 
			
			 else if(producto==Productos.BOCADITO_DE_CHOCOLATE || producto==Productos.CARAMELO || producto==Productos.GOMITAS) {
				 altura += 40; 
				 setAltura(altura);
			
				 }
			 
			 else if (!supermercado.productos.contains(producto) ){
				 throw new EsteAlimentoNoEstaCompradoException("Este Alimento No Esta Comprado"); 
				
			 }
			 
			supermercado.getProductos().remove(producto); 
		 }
		 
		 catch(EsteAlimentoNoEstaCompradoException e) {
			 System.out.println(e.getMessage());
		 }
		}
	
	
	
	
	public boolean verificarQueMiAlturaEsteCorrecta(Persona persona) throws NoPuedoEncogerException, NoPuedoCrecerException{
		
      	if(persona.getAltura()>280) {

				throw new NoPuedoCrecerException("NoPuedoCrecerException"); 
			 
		}
		
		else if(persona.getAltura()<50) {
			
			throw new NoPuedoEncogerException("NoPuedoEncogerException"); 
		 
	}
		else return true; 
 }
	


	
	
	
	}
	
	
	

