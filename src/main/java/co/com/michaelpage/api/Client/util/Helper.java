package co.com.michaelpage.api.Client.util;

import co.com.michaelpage.api.Client.dto.ClientDto;
import co.com.michaelpage.api.Client.model.Client;

import java.util.List;

/**
 * Utilidad o Helper para métodos transversales en la aplicación
 * @author Julio Martínez
 */
public interface Helper {

    /**
     * Recibe por referencia una instancia de List para mapear su resultado al CLientDto
     * @param clients List
     * @param clientsDto List
     */
    public static void setMapValuesClient(List<Client> clients, List<ClientDto> clientsDto){
        clients.stream().map(client ->{
          ClientDto cDto = getMapValuesClient(client);
          return cDto;
        }).forEach(cDto -> {
            clientsDto.add(cDto);
        });
    }

    public static ClientDto getMapValuesClient(Client client){
        ClientDto cDto = new ClientDto();
        cDto.setFirstName(client.getFirstName());
        cDto.setLastName(client.getLastName());
        cDto.setEmail(client.getEmail());
        return cDto;
    }
}
