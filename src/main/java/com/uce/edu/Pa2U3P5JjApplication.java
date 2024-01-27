package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.hoteles.repository.modelo.Habitacion;
import com.uce.edu.hoteles.repository.modelo.Hotel;
import com.uce.edu.hoteles.service.IHabitacionService;
import com.uce.edu.hoteles.service.IHotelService;
import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5JjApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	//Join Types en jakarta persistance
	//1) JOIN
	//1.1) INNER JOIN
	//1.2) OUTER JOIN
	//1.2.1) RIGHT
	//1.2.2) LEFT
	//1.2.3) FULL
	//2) JOIN WHERE
	//3) FETCH JOIN
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("INNER JOIN");
		List<Hotel> lista = this.hotelService.buscarPorNombreInnerJoin("El templo");
		for(Hotel h: lista) {
			System.out.println(h);
		}
		System.out.println("LEFT JOIN");
		List<Hotel> lista2 = this.hotelService.buscarPorDireccionLeftJoin("Av. Simón Bolivar");
		for(Hotel h: lista2) {
			System.out.println(h);
		}
		System.out.println("RIGHT JOIN");
		List<Hotel> lista3 = this.hotelService.buscarPorNumeroRightJoin("A-12");
		for(Hotel h: lista3) {
			System.out.println(h);
		}
		System.out.println("FULL JOIN");
		List<Hotel> lista4 = this.hotelService.buscarPorAvenidaFullJoin("C");
		for(Hotel h: lista4) {
			System.out.println(h);
		}
	}

}
