package com.uce.edu.libro.service;

import java.util.List;

import com.uce.edu.libro.repository.model.Autor;

public interface IAutorService {

	// CRUD
	public Autor buscar(Integer id);

	public void guardar(Autor autor);

	public void actualizar(Autor autor);

	public void eliminar(Integer id);

	public Autor buscarPorCriteria(String nombre, String nacionalidad);

	public List<Autor> buscarPorNombreInnerJoin(String nombre);
	
	public List<Autor> buscarPorNacionalidadLeftJoin(String nacionalidad);
	
	public List<Autor> buscarPorCedulaLeftJoin(String cedula);
	
	public List<Autor> buscarPorColorRightJoin(String colorFavorito);
	
	public List<Autor> buscarAutoresFullJoin();
	
}
