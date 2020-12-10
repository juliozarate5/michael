package co.com.michaelpage.api.Client.service.impl;

import co.com.michaelpage.api.Client.dto.ClientDto;
import co.com.michaelpage.api.Client.exception.BadRequestException;
import co.com.michaelpage.api.Client.exception.ErrorDto;
import co.com.michaelpage.api.Client.exception.NotFoundException;
import co.com.michaelpage.api.Client.exception.RestException;
import co.com.michaelpage.api.Client.model.Client;
import co.com.michaelpage.api.Client.repository.IClientRepository;
import co.com.michaelpage.api.Client.service.iface.IClientService;
import co.com.michaelpage.api.Client.util.ConstUtil;
import co.com.michaelpage.api.Client.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interface IClientService Service Stereotype
 * @author Julio Martínez
 */
@Service
public class ClientServiceImpl implements IClientService{

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public List<ClientDto> getAll() throws RestException {
        List<Client> clients = this.clientRepository.findAll();
        if(clients==null || clients.isEmpty()){
            throw new NotFoundException(ErrorDto.getErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
        }
        List<ClientDto> clientsDto = new ArrayList<>();
        Helper.setMapValuesClient(clients, clientsDto);
        return clientsDto;
    }

    @Override
    public void create(ClientDto clientDto) throws RestException {
        if(clientDto == null){
            throw new BadRequestException(ErrorDto.getErrorDto(
                    HttpStatus.BAD_REQUEST.getReasonPhrase(),
                    ConstUtil.MESSAGE_ERROR_DATA,
                    HttpStatus.BAD_REQUEST.value()));
        }
        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        this.clientRepository.save(client);
    }
}
