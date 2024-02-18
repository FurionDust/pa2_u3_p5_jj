package com.uce.edu.funcional;

public class MetodosReferenciados {

	public String obtenerId() {
		String cedula = "1719608728";
		cedula = cedula + "provincia";
		return cedula;
	}

	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("Se procesa la cadena");
	}

	public boolean evaluar(String cadena) {
		return "Edison".contains(cadena);
	}

	public boolean procesar(Integer numero) {
		return 8 == numero;
	}

	public Ciudadano cambiar(Empleado empl) {
		Ciudadano ciud = new Ciudadano();
		String nombre = empl.getNombreCompleto().split(" ")[0];
		String apellido = empl.getNombreCompleto().split(" ")[1];
		ciud.setNombre(nombre);
		ciud.setApellido(apellido);
		ciud.setProvincia("Pichincha");
		return ciud;
	}

	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto() + " " + empl.getPais());
		empl.setPais(empl.getPais() + " de nacimiento");
		return empl;
	}
}
