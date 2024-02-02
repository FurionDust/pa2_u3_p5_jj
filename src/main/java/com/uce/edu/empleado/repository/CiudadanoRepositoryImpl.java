package com.uce.edu.empleado.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.empleado.repository.modelo.Ciudadano;
import com.uce.edu.empleado.repository.modelo.Empleado;
import com.uce.edu.hoteles.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.Factura;

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
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciud = this.seleccionar(id);
		this.entityManager.remove(ciud);
	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula =:cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula =:cedula",
				Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c WHERE c.nombre =:nombre", Ciudadano.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano selecionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		// SELECT c FROM Ciudadano c WHERE c.apellido = :variable --->SQL normal
		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity
		// Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);

		// 2.-Construir el SQL
		// 2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		// Nota: no necesariamnete el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);// FROM Ciudadano

		// 2.2 Construir las condiciones (WHERE) del SQL
		// En criteria API Query las condiciones se las conoce como "Predicate" en
		// español como Predicado
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionApellido);

		// 4. Ejecutamos la consulta con un typedQuery
		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity
		// Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		// 2.-Construir el SQL
		// 2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		// Nota: no necesariamnete el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);// FROM Ciudadano
		// 2.2 Construir las condiciones del (WHERE)

		Predicate condicionGenerica = null;

		if (cedula.startsWith("17")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);

		} else if (cedula.startsWith("05")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		} else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);
		}
		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);

		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity
		// Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		// 2.-Construir el SQL
		// 2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		// Nota: no necesariamnete el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);// FROM Ciudadano
		// 2.2 Construir las condiciones del (WHERE)

		Predicate condicionTotal = null;

		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);

		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		if (cedula.startsWith("17")) {
			condicionTotal = myCriteriaBuilder.or(condicionNombre, condicionApellido);

		} else if (cedula.startsWith("05")) {
			condicionTotal = myCriteriaBuilder.and(condicionNombre, condicionApellido);
		}
		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionTotal);

		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myQuery.getSingleResult();
	}

	@Override
	public List<Ciudadano> seleccionarPorCedulaRightJoin(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery(
				"SELECT c FROM Ciudadano c RIGHT JOIN c.empleado WHERE c.cedula =:cedula", Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		List<Ciudadano> lista = myQuery.getResultList();
		for (Ciudadano c : lista) {
			c.getNombre().length();
		}
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarPorSalarioRightJoin(BigDecimal salario) {
		TypedQuery<Ciudadano> myQuery = this.entityManager.createQuery(
				"SELECT c FROM Ciudadano c RIGHT JOIN c.empleado e WHERE e.salario =:salario", Ciudadano.class);
		myQuery.setParameter("salario", salario);
		List<Ciudadano> lista = myQuery.getResultList();
		for (Ciudadano c : lista) {
			c.getNombre().length();
		}
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadanosFullJoin() {

		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c FULL JOIN c.empleado e", Ciudadano.class);
		List<Ciudadano> lista = myQuery.getResultList();
		for (Ciudadano c : lista) {
			c.getNombre().length();
		}
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarCiudadanosFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT c FROM Ciudadano c JOIN FETCH c.empleado e", Ciudadano.class);

		return myQuery.getResultList();
	}
}
