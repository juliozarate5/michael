package co.com.michaelpage.api.Client.service.iface;

import co.com.michaelpage.api.Client.dto.ClientDto;
import co.com.michaelpage.api.Client.exception.RestException;
import co.com.michaelpage.api.Client.model.Client;

import java.util.List;

/**
 * Interface definición de los métodos del servicio CLient (GET, POST)
 * @autor Julio Martínez
 */
public interface IClientService {

    /**
     * Obtiene todos los clientes de la tabla client (GET)
     * @return
     * @throws RestException RestException lanzada por algun error en el proceso
     */
    List<ClientDto> getAll() throws RestException;

    /**
     * Crea un nuevo cliente
     * @param clientDto Objeto ClientDto
     * @throws RestException lanzada por un error en el proceso
     */
    void create(ClientDto clientDto) throws RestException;
}
