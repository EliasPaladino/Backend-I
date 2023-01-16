package com.dh.clase23.integral;

import com.dh.clase23.integral.Service.DomicilioService;
import com.dh.clase23.integral.dominio.Domicilio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class IntegralApplication {

	private static void cargarBD() {
		Connection connection = null;

		try {

			Class.forName("org.h2.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:h2:~/clase23s;INIT=RUNSCRIPT FROM 'create.sql'","sa","");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		cargarBD();

		Domicilio domicilio1 = new Domicilio( "Calle falsa", "2233", "Trujillo", "Jujuy");
		Domicilio domicilio2 = new Domicilio( "Avenida siempre viva", "1234", "Virrey del pino", "Buenos Aires");

		DomicilioService domicilioService = new DomicilioService();

		domicilioService.guardar(domicilio1);
		domicilioService.guardar(domicilio2);

		domicilioService.listar();

		SpringApplication.run(IntegralApplication.class, args);
	}

}
