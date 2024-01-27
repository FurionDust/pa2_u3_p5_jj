package com.uce.edu.hoteles.service;

import java.util.List;

import com.uce.edu.hoteles.repository.modelo.Hotel;

public interface IHotelService {

	public Hotel buscar(Integer id);

	public void guardar(Hotel hotel);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);
	
	//JOINS
	public List<Hotel> buscarPorNombreInnerJoin(String nombre);
	
	public List<Hotel> buscarPorDireccionLeftJoin(String direccion);

	public List<Hotel> buscarPorNumeroRightJoin(String numero);
	
	public List<Hotel> buscarPorAvenidaFullJoin(String avDireccion);
}
