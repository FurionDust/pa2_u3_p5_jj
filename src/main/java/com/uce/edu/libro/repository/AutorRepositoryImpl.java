package com.uce.edu.libro.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.empleado.repository.modelo.Ciudadano;
import com.uce.edu.libro.repository.model.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Autor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Autor autor = this.seleccionar(id);
		this.entityManager.remove(autor);
	}

	@Override
	public Autor seleccionarPorCriteria(String nombre, String nacionalidad) {
		// Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Autor> myCriteriaQuery = myCriteriaBuilder.createQuery(Autor.class);
		// 2.-Construir el SQL
		// 2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		// Nota: no necesariamnete el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Autor> myFrom = myCriteriaQuery.from(Autor.class);// FROM Ciudadano
		// 2.2 Construir las condiciones del (WHERE)

		Predicate condicionGenerica = null;

		if (nacionalidad.startsWith("Ec")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);

		} else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nacionalidad"), nacionalidad);
		}
		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);

		TypedQuery<Autor> myQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myQuery.getSingleResult();
	}

	@Override
	public List<Autor> seleccionarPorNombreInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a JOIN a.libros WHERE a.nombre =:nombre", Autor.class);
		myQuery.setParameter("nombre", nombre);
		List<Autor> lista = myQuery.getResultList();
		for (Autor hot : lista) {
			hot.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarPorNacionalidadLeftJoin(String nacionalidad) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager.createQuery(
				"SELECT a FROM Autor a RIGHT JOIN a.libros WHERE a.nacionalidad =:nacionalidad", Autor.class);
		myQuery.setParameter("nacionalidad", nacionalidad);
		List<Autor> lista = myQuery.getResultList();
		for (Autor hot : lista) {
			hot.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarPorCedulaLeftJoin(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a RIGHT JOIN a.libros WHERE a.cedula =:cedula", Autor.class);
		myQuery.setParameter("cedula", cedula);
		List<Autor> lista = myQuery.getResultList();
		for (Autor hot : lista) {
			hot.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarPorColorRightJoin(String colorFavorito) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> myQuery = this.entityManager.createQuery(
				"SELECT a FROM Autor a LEFT JOIN a.libros WHERE a.colorFavorito =:colorFavorito", Autor.class);
		myQuery.setParameter("colorFavorito", colorFavorito);
		List<Autor> lista = myQuery.getResultList();
		for (Autor hot : lista) {
			hot.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarAutoresFullJoin() {

		TypedQuery<Autor> myQuery = this.entityManager
				.createQuery("SELECT a FROM Autor a FULL JOIN a.libros l", Autor.class);
		List<Autor> lista = myQuery.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();
		}
		return lista;
	}

}
