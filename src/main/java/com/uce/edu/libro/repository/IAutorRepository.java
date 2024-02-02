package com.uce.edu.libro.repository;

import java.util.List;

import com.uce.edu.libro.repository.model.Autor;

public interface IAutorRepository {

	// CRUD
	public Autor seleccionar(Integer id);

	public void insertar(Autor autor);

	public void actualizar(Autor autor);

	public void eliminar(Integer id);

	public Autor seleccionarPorCriteria(String nombre, String nacionalidad);
	
	public List<Autor> seleccionarPorNombreInnerJoin(String nombre);
	
	public List<Autor> seleccionarPorNacionalidadLeftJoin(String nacionalidad);
	
	public List<Autor> seleccionarPorCedulaLeftJoin(String cedula);
	
	public List<Autor> seleccionarPorColorRightJoin(String colorFavorito);
	
	public List<Autor> seleccionarAutoresFullJoin();
	

}
