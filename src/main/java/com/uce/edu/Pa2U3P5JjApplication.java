package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.empleado.service.ICiudadanoService;
import com.uce.edu.hoteles.service.IHotelService;
import com.uce.edu.libro.service.IAutorService;
import com.uce.edu.libro.service.ILibroService;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5JjApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private ILibroService iLibroService;
	@Autowired
	private IAutorService autorService;
	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		Factura fact = new Factura();
		fact.setCedula("123123");
		fact.setFecha(LocalDateTime.now());
		fact.setNumero("001-002");

		Cliente cli = new Cliente();
		cli.setApellido("Perez");
		cli.setNombre("Alejandro");

		//this.facturaService.guardar(fact, cli);
		System.out.println("MAIN: " +TransactionSynchronizationManager.isActualTransactionActive());
		this.facturaService.prueba();
	}

}
