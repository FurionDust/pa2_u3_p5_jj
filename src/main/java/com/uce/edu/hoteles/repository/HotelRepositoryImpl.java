package com.uce.edu.hoteles.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.hoteles.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hot = this.seleccionar(id);
		this.entityManager.remove(hot);
	}

	@Override
	public List<Hotel> seleccionarPorNombreInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones WHERE h.nombre =:nombre",Hotel.class);
		myQuery.setParameter("nombre", nombre);
		List<Hotel> lista = myQuery.getResultList();
		for (Hotel hot : lista) {
			hot.getHabitaciones().size();
	}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarPorDireccionLeftJoin(String direccion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones WHERE h.direccion =:direccion",Hotel.class);
		myQuery.setParameter("direccion", direccion);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel h: lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarPorNumeroRightJoin(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones a WHERE a.numero =:numero",Hotel.class);
		myQuery.setParameter("numero", numero);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel h: lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarPorAvenidaFullJoin(String avDireccion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones WHERE h.direccion >:avDireccion",Hotel.class);
		myQuery.setParameter("avDireccion", avDireccion);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel h: lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}
}
