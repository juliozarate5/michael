package co.com.michaelpage.api.Client.repository;

import co.com.michaelpage.api.Client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  Inteface Repository tabla Client Repository Stereotype
 * @author Julio Martínez
 */
@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

}
