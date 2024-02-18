package com.uce.edu.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Supplier
		System.out.println("*********************Supplier");
		//Clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
			System.out.println(supplierClase.getId());
			
			System.out.println("Lambdas");	
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula= "1719608728";
			cedula = cedula + "canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());
		
		IPersonaSupplier<String> supplierLambda2 = () -> "1719608728"+"pais";

		System.out.println(supplierLambda2.getId());
		
		IPersonaSupplier<Integer> supplierLambda3 = () -> Integer.valueOf(100);

		System.out.println(supplierLambda3.getId());
		
		IPersonaSupplier<Integer> supplierLambda4 = () -> {
			Integer valor1= Integer.valueOf(100);
			valor1 = valor1*Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};

		System.out.println(supplierLambda4.getId());
	
		System.out.println("Metodos referenciados");
		//Métodos referenciados
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda5=met::obtenerId;
		System.out.println(supplierLambda5.getId());
		
		//2. Consumer
		System.out.println("*********************Consumer");
		//Clases
		System.out.println("Clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		
		System.out.println("Lambdas");
		IPersonaConsumer<String> consumerLambda = (cadena) -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");
		//metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaConsumer<String> consumer2 = met::procesar;
		consumer2.accept("Edison referenciado");
		
		
		System.out.println("*********************Predicate");
		//Lambdas 
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)== 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));
		
		IPersonaPredicate<String> predicateLambda2 = letra -> "Edison".contains(letra);
		System.out.println(predicateLambda2.evaluar("a"));
		
		//metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaPredicate<String> predicateLambda3 =met::evaluar;
		System.out.println(predicateLambda3.evaluar("w"));
		
		IPersonaPredicate<Integer> predicateLambda4 =met::procesar;
		System.out.println(predicateLambda4.evaluar(Integer.valueOf(10)));
		
		
		
		System.out.println("*********************Function");
		//Lambdas 
		System.out.println("Lambdas");
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(7));
		
		IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano -> {
			
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre()+" "+ciudadano.getApellido());
			if(ciudadano.getProvincia().compareTo("Pichincha")==0) {
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
		
		//metodos referenciados
		System.out.println("Metodos referenciados");
		
		Empleado empl2 = new Empleado();
		empl2.setNombreCompleto("Daniel Tobar");
		empl2.setPais("Ecuador");
		
		IPersonaFunction<Ciudadano, Empleado> function2 = met::cambiar;
		System.out.println(function2.aplicar(empl2));
		
		
		
		System.out.println("*********************Unary Operator");
		//Lambdas 
		System.out.println("Lambdas");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero*2);

		System.out.println(unaryOperatorLambda.aplicar(14));
		
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero ->numero + (numero*2);
		System.out.println(unaryOperatorLambda2.aplicar(14));
		
		//metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaUnaryOperatorFunction<Empleado> unary3 =met::procesar;
		System.out.println(unary3.aplicar(empl2));
		
		
		
		
		
	}
		
}
