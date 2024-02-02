package com.uce.edu.empleado.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.empleado.repository.modelo.Ciudadano;
import com.uce.edu.empleado.repository.modelo.Empleado;

public interface ICiudadanoService {

	public Ciudadano buscar(Integer id);

	public void guardar(Ciudadano ciudadano);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);

	public Empleado buscarPorCedula(String cedula);

	public Ciudadano buscarPorCedulaCiu(String cedula);

	public Ciudadano buscarPorNombre(String nombre);

	public Ciudadano buscarPorApellido(String apellido);

	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula);

	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);
	
	public List<Ciudadano> buscarPorCedulaRightJoin(String cedula);
	
	public List<Ciudadano> buscarPorSalarioRightJoin(BigDecimal salario);
	
	public List<Ciudadano> buscarCiudadanosFullJoin();
	
	public List<Ciudadano> buscarCiudadanosFetchJoin();

}
