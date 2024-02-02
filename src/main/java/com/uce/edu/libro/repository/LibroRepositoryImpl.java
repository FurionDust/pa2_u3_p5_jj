package com.uce.edu.libro.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.libro.repository.model.Libro;

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
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Libro libro = this.seleccionar(id);
		this.entityManager.remove(libro);
	}

	@Override
	public Libro seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		// SQL : SELECT * FROM libro l WHERE l.libr_titulo = ?
		// JPQL: SELECT l FROM Libro l WHERE l.titulo = :variable
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :variable");
		myQuery.setParameter("variable", nombre);
		return (Libro) myQuery.getSingleResult();
		// return (Libro) myQuery.getResultList().get(0);
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l Where l.fechaPublicacion >= :fecha");
		myQuery.setParameter("fecha", fechaPublicacion);
		return (List<Libro>) myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		// SQL : SELECT * FROM libro l WHERE l.libr_titulo = ?
		// JPQL: SELECT l FROM Libro l WHERE l.titulo = :variable
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo",
				Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
		// return (Libro) myQuery.getResultList().get(0);
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager
				.createQuery("SELECT l FROM Libro l Where l.fechaPublicacion >= :fecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorCriteria(String titulo) {
		// SELECT c FROM Ciudadano c WHERE c.apellido = :variable --->SQL normal
		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity
		// Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1.-Determianmos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Libro> myCriteriaQuery = myCriteriaBuilder.createQuery(Libro.class);

		// 2.-Construir el SQL
		// 2.1 Determinamos elfrom utilizando una interfaz conocida como (Root)
		// Nota: no necesariamnete el from es igual al tipo de retorno
		// SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Libro> myFrom = myCriteriaQuery.from(Libro.class);// FROM Ciudadano

		// 2.2 Construir las condiciones (WHERE) del SQL
		// En criteria API Query las condiciones se las conoce como "Predicate" en
		// español como Predicado
		Predicate condicionTitulo = myCriteriaBuilder.equal(myFrom.get("titulo"), titulo);

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionTitulo);

		// 4. Ejecutamos la consulta con un typedQuery
		TypedQuery<Libro> myQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myQuery.getSingleResult();
	}

}
