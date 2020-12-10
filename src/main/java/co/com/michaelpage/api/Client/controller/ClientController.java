package co.com.michaelpage.api.Client.controller;

import co.com.michaelpage.api.Client.dto.ClientDto;
import co.com.michaelpage.api.Client.exception.*;
import co.com.michaelpage.api.Client.service.iface.IClientService;
import co.com.michaelpage.api.Client.util.ConstUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que presta una API Rest para las operaciones relacionadas con el Entity Client
 * @author Julio Martínez
 */
@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@Api(value = "/client", tags = {"Clientes"})
@SwaggerDefinition(tags = {
        @Tag(name = "Clientes", description = "Gestión API Clientes")
})
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private IClientService clientService;

    /**
     * Recurso para obtener todos los clientes
     * @return List ClientDto
     * @throws RestException
     */
    @ApiOperation(value = "Obtiene los clientes registrados en el sistema",
            response = ClientDto.class,
            responseContainer = "List",
            produces = "application/json",
            httpMethod = "GET")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getAll() throws RestException{
        try {
            return this.clientService.getAll();
        }catch (NotFoundException ex){
            throw ex;
        }
    }

    /**
     *  Recurso para crear un nuevo registro de cliente
     * @param clientDto Objeto ClienteDto
     * @throws RestException
     */
    @ApiOperation(value = "Realiza la creación de un nuevo cliente en el sistema",
            responseContainer = "List",
            produces = "application/json",
            httpMethod = "POST")
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Validated ClientDto clientDto) throws RestException{
        try {
            this.clientService.create(clientDto);
        }catch (BadRequestException ex){
            throw ex;
        }catch (Exception ex){
            log.error("Error Creando", ex);
            throw new InternalServerErrorException(ErrorDto.getErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND,
                    HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }
}
