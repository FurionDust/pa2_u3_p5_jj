package com.uce.edu.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {

	// CRUD
	public Factura buscarPorNumero(String numero);

	public void guardar(Factura factura, Cliente cliente);

	public void borrar(Integer id);

	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);

	public List<Factura> buscarFacturasInnerJoin();

	public List<Factura> buscarFacturasRightJoin();

	public List<Factura> buscarFacturasLeftJoin();

	public List<Factura> buscarFacturasFullJoin();

	public List<Factura> buscarFacturasWhereJoin();

	public List<Factura> buscarFacturasFetchJoin();

	public int borrarPorNumero(String numero);

	public List<FacturaDTO> buscarFacturasDTO();

	public void prueba();
	
	public void pruebaSupports();
	
	public void pruebaNever();
	
	
}
