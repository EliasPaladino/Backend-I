package com.dh.clase23.integral;

import com.dh.clase23.integral.dominio.Domicilio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegralApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegralApplication.class, args);

		Domicilio domicilio1 = new Domicilio(1L, "Calle falsa", "2233", "Trujillo", "Jujuy");
		Domicilio domicilio2 = new Domicilio(2L, "Avenida siempre viva", "1234", "Virrey del pino", "Buenos Aires");


	}

}
