package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5JjApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Factura fac = new Factura();
		fac.setCedula("1719608729");
		fac.setFecha(LocalDateTime.now());
		fac.setNumero("0001-02569");
		
		
		DetalleFactura det1 = new DetalleFactura();
		det1.setCantidad(4);
		det1.setCodigoBarras("55443322");
		det1.setFactura(fac);
		det1.setNombreProducto("Coca Cola");
		
		DetalleFactura det2 = new DetalleFactura();
		det2.setCantidad(4);
		det2.setCodigoBarras("66554433");
		det2.setFactura(fac);
		det2.setNombreProducto("Pepsi");
		
		List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
		detalle.add(det1);
		detalle.add(det2);
		
		fac.setDetallesFactura(detalle);
		
		this.facturaService.guardar(fac);
		
		Factura facVer = this.facturaService.buscarPorNumero("0001-02569");
		for(DetalleFactura det:facVer.getDetallesFactura()) {
			System.out.println(det.getCodigoBarras());
		}
		
		System.out.println(facVer);
	}

}
