package co.com.michaelpage.api.Client.service.impl;

import co.com.michaelpage.api.Client.dto.ClientDto;
import co.com.michaelpage.api.Client.exception.RestException;
import co.com.michaelpage.api.Client.model.Client;
import co.com.michaelpage.api.Client.repository.IClientRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImplTest clientServiceImplTest;

    @Mock
    private ClientServiceImpl clientService = mock(ClientServiceImpl.class);

    @Mock
    private IClientRepository clientRepository = mock(IClientRepository.class);

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll()  {
        //Arange
        List<Client> clients = new ArrayList<>();
        Client client = new Client();
        client.setFirstName("Julio");
        client.setLastName("Martinez");
        client.setEmail("email@email.com");
        clients.add(client);

       when(clientRepository.findAll()).thenReturn(clients);
        // Actual
        List<Client> clientsTest = clientRepository.findAll();

        //Assert
        assertEquals(1, clientsTest.size());
    }

    @Test
    void create() {
        ClientDto client = new ClientDto();
        client.setFirstName("Julio");
        client.setLastName("Martinez");
        client.setEmail("email@email.com");
        try {
            clientService.create(client);
            assertTrue(true);
        } catch (RestException e) {
            assertTrue(false);
        }
    }
}