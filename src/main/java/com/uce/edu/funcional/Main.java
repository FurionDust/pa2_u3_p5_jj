package com.uce.edu.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Supplier
		System.out.println("*********************Supplier");
		// Clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());

		System.out.println("Lambdas");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "1719608728";
			cedula = cedula + "canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());

		IPersonaSupplier<String> supplierLambda2 = () -> "1719608728" + "pais";

		System.out.println(supplierLambda2.getId());

		IPersonaSupplier<Integer> supplierLambda3 = () -> Integer.valueOf(100);

		System.out.println(supplierLambda3.getId());

		IPersonaSupplier<Integer> supplierLambda4 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};

		System.out.println(supplierLambda4.getId());

		System.out.println("Metodos referenciados");
		// Métodos referenciados
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda5 = met::obtenerId;
		System.out.println(supplierLambda5.getId());

		// 2. Consumer
		System.out.println("*********************Consumer");
		// Clases
		System.out.println("Clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");

		System.out.println("Lambdas");
		IPersonaConsumer<String> consumerLambda = (cadena) -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");
		// metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaConsumer<String> consumer2 = met::procesar;
		consumer2.accept("Edison referenciado");

		System.out.println("*********************Predicate");
		// Lambdas
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));

		IPersonaPredicate<String> predicateLambda2 = letra -> "Edison".contains(letra);
		System.out.println(predicateLambda2.evaluar("a"));

		// metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaPredicate<String> predicateLambda3 = met::evaluar;
		System.out.println(predicateLambda3.evaluar("w"));

		IPersonaPredicate<Integer> predicateLambda4 = met::procesar;
		System.out.println(predicateLambda4.evaluar(Integer.valueOf(10)));

		System.out.println("*********************Function");
		// Lambdas
		System.out.println("Lambdas");
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(7));

		IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano -> {

			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				empl.setPais("Ecuador");
			}
			return empl;
		};

		Ciudadano ciud = new Ciudadano();
		ciud.setApellido("Cayambe");
		ciud.setNombre("Edison");
		ciud.setProvincia("Pichincha");

		Empleado empl = functionLambda1.aplicar(ciud);
		System.out.println(empl);

		// metodos referenciados
		System.out.println("Metodos referenciados");

		Empleado empl2 = new Empleado();
		empl2.setNombreCompleto("Daniel Tobar");
		empl2.setPais("Ecuador");

		IPersonaFunction<Ciudadano, Empleado> function2 = met::cambiar;
		System.out.println(function2.aplicar(empl2));

		System.out.println("*********************Unary Operator");
		// Lambdas
		System.out.println("Lambdas");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);

		System.out.println(unaryOperatorLambda.aplicar(14));

		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda2.aplicar(14));

		// metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaUnaryOperatorFunction<Empleado> unary3 = met::procesar;
		System.out.println(unary3.aplicar(empl2));

		System.out.println("*Implementación de interfaces funcionales mediantte librerias JAVA");

		// 1.Supplier
		System.out.println("\nSupplier JAVA");
		Stream<String> lista = Stream.generate(() -> "465465465" + "pais").limit(20);
		lista.forEach(cadena -> System.out.println(cadena));

		// 2. Consumer
		System.out.println("\nConsumer JAVA");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 67, 8, 5, 4, 85, 74);
		listaNumeros.forEach(cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		});

//		for(Integer numero:lista2) {
//			System.out.println("Se inserta");
//			System.out.println(numero);
//		}

		// 3. Predicate
		System.out.println("\nPredicate JAVA");
		Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> numero >= 10);
		listaFiltrada.forEach(numero -> System.out.println(numero));

		// 4. Function
		System.out.println("\nFunction JAVA");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50;
			return "Num:" + numero.toString();
		});
		listaCambiada.forEach(cadena -> System.out.println(cadena));

		Ciudadano ciud01 = new Ciudadano();
		ciud01.setApellido("Cayambe");
		ciud01.setNombre("Edison");
		ciud01.setProvincia("Pichincha");

		Ciudadano ciud02 = new Ciudadano();
		ciud02.setApellido("Teran");
		ciud02.setNombre("Daniel");
		ciud02.setProvincia("Pichincha");

		Ciudadano ciud03 = new Ciudadano();
		ciud03.setApellido("Jacome");
		ciud03.setNombre("Viviana");
		ciud03.setProvincia("Pichincha");

		List<Ciudadano> listaCiudadano = Arrays.asList(ciud01, ciud02, ciud03);
		Stream<Empleado> listaEmpleados = listaCiudadano.stream().map(ciudadano -> {
			Empleado emp2 = new Empleado();
			emp2.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				emp2.setPais("Ecuador");
			}
			return emp2;
		});
		listaEmpleados.forEach(empleado -> System.out.println(empleado));

		// 4. Function
		System.out.println("\nUnary Operator JAVA");
		Stream<Integer> listaNumeros2 = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50;
			return numero;
		});
		listaNumeros2.forEach(numero -> System.out.println(numero));

		
	}

}
