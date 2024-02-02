package com.uce.edu.libro.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.libro.repository.model.Libro;

public interface ILibroRepository {

	// CRUD
	public Libro seleccionar(Integer id);

	public void insertar(Libro libro);

	public void actualizar(Libro libro);

	public void eliminar(Integer id);

	public Libro seleccionarPorNombre(String nombre);

	public Libro seleccionarPorTitulo(String titulo);

	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion);

	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion);

	public Libro seleccionarPorTituloNamed(String titulo);

	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion);

	public Libro seleccionarPorCriteria(String titulo);

}
