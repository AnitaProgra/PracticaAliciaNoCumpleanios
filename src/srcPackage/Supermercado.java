package srcPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Supermercado {

	protected String nombreSuper; 
	protected ArrayList<Productos> productos;

	public Supermercado(String nombreSuper) {
	this.nombreSuper= nombreSuper; 
	this.productos= new ArrayList<>(); 
	} 
	
	public void agregarProductos(Productos producto) {
		productos.add(producto); 
	}
	

	public Integer tamanioListaProductos() {
	    return productos.size(); 
	}
	
	
	
	
	public TreeSet<Productos> devolverProductosOrdenados() {
	   
     TreeSet<Productos> productosTreeSet = new TreeSet<>(new Comparator<Productos>()
		 
	    {
    	 @Override 
    	 public int compare(Productos prod1, Productos prod2) { 
         return prod1.name().compareTo(prod2.name()); } 
    	 }
		 
	   );

	    
	    productosTreeSet.addAll(productos);

	    return productosTreeSet;
	    
	}

	
	public boolean imprimirProductosOrdenados() {
		
	    TreeSet<Productos> productosTreeSet = devolverProductosOrdenados();
	    
	    if (productosTreeSet.isEmpty()) {
	    	return false; 
	    }
	    if(!productosTreeSet.isEmpty()) {
	    for (Productos producto : productosTreeSet) {
	        System.out.println(producto);
	    }
	    }
		return true;
	    
	}
	
	
	public ArrayList<Productos> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
	}

	
	
	
	
}
