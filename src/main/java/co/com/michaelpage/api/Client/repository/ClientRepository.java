package co.com.michaelpage.api.Client.repository;

import co.com.michaelpage.api.Client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  Inteface Repository tabla Client
 * @author Julio Martínez
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
