package com.uce.edu.libro.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.libro.repository.model.Libro;

public interface ILibroService {

	// CRUD
	public Libro buscar(Integer id);

	public void guardar(Libro libro);

	public void actualizar(Libro libro);

	public void eliminar(Integer id);

	public Libro buscarPorNombre(String nombre);

	public Libro buscarPorTitulo(String titulo);

	public Libro buscarPorTituloNamed(String titulo);

	public List<Libro> buscarPorFechaPublicacion(LocalDateTime fechaPublicacion);

	public List<Libro> buscarPorFecha(LocalDateTime fechaPublicacion);

	public List<Libro> buscarPorFechaNamed(LocalDateTime fechaPublicacion);

	public Libro buscarPorCriteria(String titulo);
}
