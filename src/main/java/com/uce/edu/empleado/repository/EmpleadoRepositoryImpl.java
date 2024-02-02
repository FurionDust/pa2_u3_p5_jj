package com.uce.edu.empleado.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.uce.edu.empleado.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public Empleado seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Empleado empl = this.seleccionar(id);
		this.entityManager.remove(empl);
	}

	@Override
	public Empleado seleccionarPorSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.salario =:salario", Empleado.class);
		myQuery.setParameter("salario", salario);
		return myQuery.getSingleResult();
	}

	@Override
	public Empleado seleccionarPorFecha(LocalDateTime fechaIngreso) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createNativeQuery("SELECT * FROM empleado e WHERE e.empl_fecha_ingreso <=:fecha", Empleado.class);
		myQuery.setParameter("fecha", fechaIngreso);
		return (Empleado) myQuery.getSingleResult();
	}

	@Override
	public Empleado seleccionarPorCriteria(BigDecimal salario) {
		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity
		// Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Empleado> myCriteriaQuery = myCriteriaBuilder.createQuery(Empleado.class);

		// 2.-Construir el SQL
		// 2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		// Nota: no necesariamnete el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Empleado> myFrom = myCriteriaQuery.from(Empleado.class);// FROM Ciudadano

		// 2.2 Construir las condiciones (WHERE) del SQL
		// En criteria API Query las condiciones se las conoce como "Predicate" en
		// español como Predicado
		Predicate condicionSalario = myCriteriaBuilder.equal(myFrom.get("salario"), salario);

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionSalario);

		// 4. Ejecutamos la consulta con un typedQuery
		TypedQuery<Empleado> myQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myQuery.getSingleResult();
	}

}
