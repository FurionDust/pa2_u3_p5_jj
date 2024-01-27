package com.uce.edu.hoteles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.hoteles.repository.IHotelRepository;
import com.uce.edu.hoteles.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionar(id);
	}

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.actualizar(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.hotelRepository.eliminar(id);
	}

	@Override
	public List<Hotel> buscarPorNombreInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorNombreInnerJoin(nombre);
	}

	@Override
	public List<Hotel> buscarPorDireccionLeftJoin(String direccion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorDireccionLeftJoin(direccion);
	}

	@Override
	public List<Hotel> buscarPorNumeroRightJoin(String numero) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorNumeroRightJoin(numero);
	}

	@Override
	public List<Hotel> buscarPorAvenidaFullJoin(String avDireccion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorAvenidaFullJoin(avDireccion);
	}

}
