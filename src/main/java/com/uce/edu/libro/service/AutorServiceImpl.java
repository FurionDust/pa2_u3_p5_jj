package com.uce.edu.libro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.libro.repository.IAutorRepository;
import com.uce.edu.libro.repository.model.Autor;

@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorRepository autorRepository;

	@Override
	public Autor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionar(id);
	}

	@Override
	public void guardar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.insertar(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.actualizar(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.autorRepository.eliminar(id);
	}

	@Override
	public Autor buscarPorCriteria(String nombre, String nacionalidad) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorCriteria(nombre, nacionalidad);
	}

	@Override
	public List<Autor> buscarPorNombreInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorNombreInnerJoin(nombre);
	}

	@Override
	public List<Autor> buscarPorNacionalidadLeftJoin(String nacionalidad) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorNacionalidadLeftJoin(nacionalidad);
	}

	@Override
	public List<Autor> buscarPorCedulaLeftJoin(String cedula) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorCedulaLeftJoin(cedula);
	}

	@Override
	public List<Autor> buscarPorColorRightJoin(String colorFavorito) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarPorColorRightJoin(colorFavorito);
	}

	@Override
	public List<Autor> buscarAutoresFullJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarAutoresFullJoin();
	}

}
