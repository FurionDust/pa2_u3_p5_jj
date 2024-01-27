package com.uce.edu.hoteles.repository;

import java.util.List;

import com.uce.edu.hoteles.repository.modelo.Hotel;

public interface IHotelRepository {

	public Hotel seleccionar(Integer id);

	public void insertar(Hotel hotel);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);
	
	//JOINS
		//INNER
	public List<Hotel> seleccionarPorNombreInnerJoin(String nombre);
		//LEFT
	public List<Hotel> seleccionarPorDireccionLeftJoin(String direccion);
		//RIGHT
	public List<Hotel> seleccionarPorNumeroRightJoin(String numero);
		//FULL
	public List<Hotel> seleccionarPorAvenidaFullJoin(String avDireccion);
	
}
