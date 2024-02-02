package com.uce.edu.empleado.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.uce.edu.empleado.repository.modelo.Empleado;

public interface IEmpleadoRepository {

	// CRUD
	public Empleado seleccionar(Integer id);

	public void insertar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);

	public Empleado seleccionarPorSalario(BigDecimal salario);

	public Empleado seleccionarPorFecha(LocalDateTime fechaIngreso);

	public Empleado seleccionarPorCriteria(BigDecimal salario);

}
