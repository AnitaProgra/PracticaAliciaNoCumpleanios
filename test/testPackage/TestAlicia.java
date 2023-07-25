package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import srcPackage.DineroInsuficienteException;
import srcPackage.EsteAlimentoNoEstaCompradoException;
import srcPackage.NoPuedoCrecerException;
import srcPackage.NoPuedoEncogerException;
import srcPackage.Persona;
import srcPackage.Productos;
import srcPackage.Supermercado;

public class TestAlicia {

	@Test
	public void testDinero() throws DineroInsuficienteException {
		Persona alicia= new Persona("alicia", 155.0, 180, 15, 60.0); 
		
		alicia.comprar(Productos.CARAMELO);
		alicia.comprar(Productos.BAGEL);
		alicia.comprar(Productos.ALFAJOR);
		alicia.comprar(Productos.BOCADITO_DE_CHOCOLATE);
		
		Double esperado = -45.0; 
		
		assertEquals(esperado, alicia.getDinero()); 
	}
	
	
	@Test
	public void testAlturaEncogimiento() throws NoPuedoCrecerException, NoPuedoEncogerException, EsteAlimentoNoEstaCompradoException {
		Persona alicia= new Persona("alicia", 155.0, 180, 15, 60.0); 
		Supermercado dia = new Supermercado("Dia"); 
		
		dia.agregarProductos(Productos.BAGEL);
		dia.agregarProductos(Productos.MASITA);
		dia.agregarProductos(Productos.MASITA);
		
		
		alicia.comeer(dia, Productos.BAGEL);
		alicia.comeer(dia, Productos.MASITA);
		
		assertTrue(alicia.verificarQueMiAlturaEsteCorrecta(alicia)); 
	}
	
	
	@Test(expected=NoPuedoCrecerException.class)
	public void testAlturaCrecimento() throws NoPuedoCrecerException, NoPuedoEncogerException, EsteAlimentoNoEstaCompradoException {
		Persona alicia= new Persona("alicia", 155.0, 180, 15, 60.0); 
		Supermercado dia = new Supermercado("Dia"); 
		
		dia.agregarProductos(Productos.BAGEL);
		dia.agregarProductos(Productos.MASITA);
		dia.agregarProductos(Productos.MASITA);
		dia.agregarProductos(Productos.BOCADITO_DE_CHOCOLATE);
		dia.agregarProductos(Productos.GOMITAS);
		dia.agregarProductos(Productos.GOMITAS);
		
		
		
		alicia.comeer(dia, Productos.BOCADITO_DE_CHOCOLATE);
		alicia.comeer(dia, Productos.GOMITAS);
		alicia.comeer(dia, Productos.GOMITAS);
		alicia.comeer(dia, Productos.ALFAJOR);
		
	    alicia.verificarQueMiAlturaEsteCorrecta(alicia); 
	}
	
	
	
	@Test
	public void testVerificarMiAlturaFinalLuegoDeConsumirAlimentosQueEncogenyAgrandanMezclados() throws NoPuedoCrecerException, NoPuedoEncogerException, EsteAlimentoNoEstaCompradoException {
		Persona alicia= new Persona("alicia", 155.0, 180, 15, 60.0); 
		Supermercado dia = new Supermercado("Dia"); 
		
		dia.agregarProductos(Productos.BAGEL);
		dia.agregarProductos(Productos.MASITA);
		dia.agregarProductos(Productos.MASITA);
		
		
		alicia.comeer(dia, Productos.BAGEL);
		alicia.comeer(dia, Productos.MASITA);
		alicia.comeer(dia, Productos.BAGEL);
		alicia.comeer(dia, Productos.CARAMELO);
		alicia.comeer(dia, Productos.CARAMELO);
		
		Integer esperado = 110;
		
		assertEquals(esperado, alicia.getAltura()); 
	}
	
	
	@Test
	public void verificarQueLosAlimentosSeVayanEliminandoDeLaListaAMedidaQueSeConsumen() throws EsteAlimentoNoEstaCompradoException  {
		Persona alicia= new Persona("alicia", 155.0, 180, 15, 60.0); 
		Supermercado dia = new Supermercado("Dia"); 
		
		dia.agregarProductos(Productos.BAGEL);
		dia.agregarProductos(Productos.MASITA);
		dia.agregarProductos(Productos.MASITA);
		dia.agregarProductos(Productos.ALFAJOR);
		dia.agregarProductos(Productos.CARAMELO);
		dia.agregarProductos(Productos.CARAMELO);
		dia.agregarProductos(Productos.GOMITAS);
		dia.agregarProductos(Productos.BOCADITO_DE_CHOCOLATE);
		
		
		alicia.comeer(dia, Productos.ALFAJOR);
		alicia.comeer(dia, Productos.BOCADITO_DE_CHOCOLATE);
		alicia.comeer(dia, Productos.CARAMELO);
		alicia.comeer(dia, Productos.MASITA);
		alicia.comeer(dia, Productos.MASITA);
		
		Integer esperado = 3;
		
		assertEquals(esperado, dia.tamanioListaProductos()); 
	}
	

	@Test
	public void ordenarProductosAlfabeticamente()  {
		Supermercado dia = new Supermercado("Dia"); 
		
		dia.agregarProductos(Productos.BAGEL);
		dia.agregarProductos(Productos.MASITA);
		dia.agregarProductos(Productos.ALFAJOR);
		dia.agregarProductos(Productos.CARAMELO);
		
		
        
		assertTrue(dia.imprimirProductosOrdenados()); 
		
	
	}
	
	
	
}
