package com.uce.edu.empleado.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.empleado.repository.IEmpleadoRepository;
import com.uce.edu.empleado.repository.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.insertar(empleado);
	}

	@Override
	public Empleado seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.actualizar(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.empleadoRepository.eliminar(id);
	}

	@Override
	public Empleado buscarPorSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionarPorSalario(salario);
	}

	@Override
	public Empleado buscarPorFecha(LocalDateTime fechaIngreso) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionarPorFecha(fechaIngreso);
	}

	@Override
	public Empleado buscarPorCriteria(BigDecimal salario) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionarPorCriteria(salario);
	}

}
