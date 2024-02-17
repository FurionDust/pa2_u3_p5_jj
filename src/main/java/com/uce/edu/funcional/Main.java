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
	
		//Métodos referenciados
		
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
		
		
		System.out.println("*********************Predicate");
		//Lambdas 
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)== 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));
		
		IPersonaPredicate<String> precidateLambda2 = letra -> "Edison".contains(letra);
		System.out.println(precidateLambda2.evaluar("a"));
		
		
	}

}
