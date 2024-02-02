package com.uce.edu.empleado.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.empleado.repository.ICiudadanoRepository;
import com.uce.edu.empleado.repository.modelo.Ciudadano;
import com.uce.edu.empleado.repository.modelo.Empleado;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;

	@Override
	public void guardar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.eliminar(id);
	}

	@Override
	public Empleado buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public Ciudadano buscarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCedulaCiu(cedula);
	}

	@Override
	public Ciudadano buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.buscarPorNombre(nombre);
	}

	@Override
	public Ciudadano buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.selecionarPorApellido(apellido);
	}

	@Override
	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCriteria(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCriteriaAndOr(nombre, apellido, cedula);
	}

	@Override
	public List<Ciudadano> buscarPorCedulaRightJoin(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCedulaRightJoin(cedula);
	}

	@Override
	public List<Ciudadano> buscarPorSalarioRightJoin(BigDecimal salario) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorSalarioRightJoin(salario);
	}

	@Override
	public List<Ciudadano> buscarCiudadanosFullJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanosFullJoin();
	}

	@Override
	public List<Ciudadano> buscarCiudadanosFetchJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarCiudadanosFetchJoin();
	}

}
