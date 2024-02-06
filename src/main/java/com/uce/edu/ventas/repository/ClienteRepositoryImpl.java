package com.uce.edu.ventas.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	//begin
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Antes");
		try {
			this.entityManager.persist(cliente);
		}catch (RuntimeException e) {
			System.out.println("ERROR");
		}

		System.out.println("Despues");
	}//commit

}
