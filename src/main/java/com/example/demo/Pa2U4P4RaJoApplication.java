package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.IPropietarioService;
import com.example.demo.repository.modelo.Propietario;

@SpringBootApplication
public class Pa2U4P4RaJoApplication implements CommandLineRunner {

	@Autowired
	private IPropietarioService propietarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U4P4RaJoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//http://localhost:8080/concensionario/propietarios/buscar
		Propietario prop = new Propietario();
		prop.setNombre("Juan");
		prop.setApellido("Angulo");
		prop.setCedula("010");
		
		this.propietarioService.ingresar(prop);
		
		Propietario prop2 = new Propietario();
		prop2.setNombre("Angel");
		prop2.setApellido("Perez");
		prop2.setCedula("020");
		
		this.propietarioService.ingresar(prop2);
	}

}
