package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

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
	//FETCH eficiente en terminosde numero de consultas
	//Native Query es mucho más rapido SQL Puro(Hibernate)
	
	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		//SELECT f FROM Factura f JOIN FETCH f.detalleFactura d // similar al inner pero tiene el fetch a la derecha 
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detallesFactura d",Factura.class);

		return myQuery.getResultList();
	}

}
