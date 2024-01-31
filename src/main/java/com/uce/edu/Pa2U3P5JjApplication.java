package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.hoteles.service.IHotelService;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5JjApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IFacturaService facturaService;

	// Join Types en jakarta persistance
	// 1) JOIN
	// 1.1) INNER JOIN
	// 1.2) OUTER JOIN
	// 1.2.1) RIGHT
	// 1.2.2) LEFT
	// 1.2.3) FULL
	// 2) JOIN WHERE
	// 3) FETCH JOIN

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("UPDATE");
		int cantidad = this.facturaService.actualizarFechas(LocalDateTime.of(2020, 01,9,12,50), LocalDateTime.of(2020, 01,15,10,00));
		System.out.println("Cantidad de registros actualizados");
		System.out.println(cantidad);
		
		System.out.println("DELETE");
		int cantidad2 =this.facturaService.borrarPorNumero("0001-02570");
		System.out.println("Cantidad de registros/filas eliminados");
		System.out.println(cantidad2);		
		
		//this.facturaService.borrar(1);
		
		
		//DTO = Data Transfer Object
		//Patron de diseño para transferir datos mediante un objeto
		//transfiere datos desde la capa repository hasta la service
		System.out.println("Factura DTO");
		List<FacturaDTO> listaDTO= this.facturaService.buscarFacturasDTO();
		for(FacturaDTO f:listaDTO) {
			System.out.println(f);
		}
	}

}
