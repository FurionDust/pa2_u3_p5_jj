package com.uce.edu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.empleado.repository.modelo.Ciudadano;
import com.uce.edu.empleado.service.ICiudadanoService;
import com.uce.edu.hoteles.repository.modelo.Hotel;
import com.uce.edu.hoteles.service.IHotelService;
import com.uce.edu.libro.repository.model.Autor;
import com.uce.edu.libro.service.IAutorService;
import com.uce.edu.libro.service.ILibroService;
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

		
		System.out.println("INNER JOIN");
		//1)
		List<Autor> lista = this.autorService.buscarPorNombreInnerJoin("Alejandro Loor");
		for(Autor a: lista) {
			System.out.println(a);
		}
		//2)
		List<Hotel> lista2 = this.hotelService.buscarPorNombreInnerJoin("El templo");
		for(Hotel h: lista2) {
			System.out.println(h);
		}
		System.out.println("RIGHT JOIN");
		//1)
		List<Ciudadano> lista5 = this.ciudadanoService.buscarPorCedulaRightJoin("1719608729");
		for(Ciudadano c: lista5) {
			System.out.println(c);
		}
		//2)
		List<Ciudadano> lista6 = this.ciudadanoService.buscarPorSalarioRightJoin(new BigDecimal(450));
		for(Ciudadano ci: lista6) {
			System.out.println(ci);
		}
		System.out.println("LEFT JOIN");
		//1) 
		List<Autor> lista3 = this.autorService.buscarPorNacionalidadLeftJoin("Chileno");
		for(Autor au: lista3) {
			System.out.println(au);
		}
		//2)
		List<Autor> lista4 = this.autorService.buscarPorCedulaLeftJoin("171960829");
		for(Autor aut: lista4) {
			System.out.println(aut);
		}
		System.out.println("FULL JOIN");
		//1)
		List<Ciudadano> lista7 = this.ciudadanoService.buscarCiudadanosFullJoin();
		for(Ciudadano c:lista7) {
			System.out.println(c);
		}
		//2)
		List<Autor> lista8 = this.autorService.buscarAutoresFullJoin();
		for(Autor a:lista8) {
			System.out.println(a);
		}
		System.out.println("FETCH JOIN");
		//1)
		List<Hotel> lista9 = this.hotelService.seleccionarHotelesFetchJoin();
		for(Hotel h:lista9) {
			System.out.println(h);
		}
		//2)
		List<Ciudadano> lista10 =this.ciudadanoService.buscarCiudadanosFetchJoin();
		for(Ciudadano ciu:lista10) {
			System.out.println(ciu);
		}
	}

}
