package com.uce.edu.empleado.repository;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.empleado.repository.modelo.Ciudadano;
import com.uce.edu.empleado.repository.modelo.Empleado;

public interface ICiudadanoRepository {

	public Ciudadano seleccionar(Integer id);

	public void insertar(Ciudadano ciudadano);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);

	public Empleado seleccionarPorCedula(String cedula);

	public Ciudadano seleccionarPorCedulaCiu(String cedula);

	public Ciudadano buscarPorNombre(String nombre);

	public Ciudadano selecionarPorApellido(String apellido);

	// Funcionalidad que cuando sea el ciudadano de pichincha busque por nombre
	// Cuando sea de cotopaxi, lo busque por apellido
	// cuando no sea ni de cotopaxi ni pichincha lo busque por cedula
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);

	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);
	
	public List<Ciudadano> seleccionarPorCedulaRightJoin(String cedula);
	
	public List<Ciudadano> seleccionarPorSalarioRightJoin(BigDecimal salario);
	
	public List<Ciudadano> seleccionarCiudadanosFullJoin();
	
	public List<Ciudadano> seleccionarCiudadanosFetchJoin();

}
