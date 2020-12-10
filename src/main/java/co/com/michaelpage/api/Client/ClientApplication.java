package co.com.michaelpage.api.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de partida. Inicia Spring ApplicationContext y carga los beans en el contexto de aplicaciónd de spring
 * @author Julio Martínez
 */
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
