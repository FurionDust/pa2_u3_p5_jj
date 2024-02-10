package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero =:numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact = myQuery.getSingleResult();
		fact.getDetallesFactura().size();// le digo que cargue el detalle bajo demanda
		return fact;
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM factura f inner join detalle_factura d on f.fact_id
		// =d.defa_id_factura

		// select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from
		// factura f1_0 join detalle_factura df1_0 on f1_0.fact_id=df1_0.defa_id_factura

		// JPQL: SELECT f FROM Factura f innner join f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detallesFactura d",
				Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura fac : lista) {
			fac.getDetallesFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM factura f inner join detalle_factura d on f.fact_id
		// =d.defa_id_factura
		// JPQL: SELECT f FROM Factura f innner join f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detallesFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura fac : lista) {
			fac.getDetallesFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detallesFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura fac : lista) {
			fac.getDetallesFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f FULL JOIN f.detallesFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura fac : lista) {
			fac.getDetallesFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		
		//SQL: SELECT * from vehiculo v, persona p
		
		//SQL: SELECT f.* FROM factura f, detalle_factura d WHERE f.fact_id = d.defa_id_factura
		
		//JPQL: SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura",Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura fac : lista) {
			fac.getDetallesFactura().size();
		}
		return lista;
	}
	//FETCH eficiente en terminos de numero de consultas
	//Native Query es mucho más rapido SQL Puro(Hibernate)
	
	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		//SELECT f FROM Factura f JOIN FETCH f.detalleFactura d // similar al inner pero tiene el fetch a la derecha 
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detallesFactura d",Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Factura fac = this.seleccionar(id);
		this.entityManager.remove(fac);
	}
	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		//SQL: DELETE FROM factura WHERE  fact_numero =:numero 
		//JPQL: DELETE FROM Factura f WHERE f.numero =:numero
		Query myQuery =this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero =:numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}
	
	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		// SELECT * FROM Factura f WHERE fecha >= fechaActual
		// Lista 
		//Recorrer la lista 
		//Por cada factura seteo la nueva fecha
		//Actualizar cada factura
		//SQL : UPDATE factura set fact_fecha =:fechaNueva WHERE fact_fecha >= fechaActual 
		//JPQL: UPDATE Factura f SET f.fecha =:fechaNueva WHERE f.fecha  >=:fechaActual
		Query myQuery=this.entityManager.createQuery("UPDATE Factura f SET f.fecha =:fechaNueva WHERE f.fecha  >=:fechaActual");
		myQuery.setParameter("fechaNueva", fechaNueva);
		myQuery.setParameter("fechaActual", fechaActual);
		//Cantidad de registros afectados/ actualizados
		return myQuery.executeUpdate();
	}



	@Override
	public Factura seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		// TODO Auto-generated method stub
		//JPQL: 
		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero,f.fecha) FROM Factura f ",FacturaDTO.class);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura buscar() {
		//SELECT 
		return null;
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Factura> seleccionarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f",Factura.class);
		return myQuery.getResultList();
	}

	
	
	
}
