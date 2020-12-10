package co.com.michaelpage.api.Client.exception;

/**
 * Exception de NotFound en el Rest
 * @autor Julio Martínez
 */
public class NotFoundException extends RestException{
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(ErrorDto errorDto) {
        super(errorDto);
    }
}
