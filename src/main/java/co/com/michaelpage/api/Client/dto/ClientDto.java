package co.com.michaelpage.api.Client.dto;

import javax.validation.constraints.NotEmpty;

/**
 * DTO para Client
 * @autor Julio Martínez
 */
public class ClientDto {
    private Long id;

    @NotEmpty(message = "Primer nombre es requerido")
    private String firstName;

    @NotEmpty(message = "Apellido nombre es requerido")
    private String lastName;

    private String email;

    public ClientDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
