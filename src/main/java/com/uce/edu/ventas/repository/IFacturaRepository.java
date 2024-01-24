package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaRepository {
	
	//CRUD 
	public Factura seleccionarPorNumero(String numero);
	
	public void insertar(Factura factura);
	

}
