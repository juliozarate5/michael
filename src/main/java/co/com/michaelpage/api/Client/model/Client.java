package co.com.michaelpage.api.Client.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity para mapeo de tabla "client"
 * @author Julio Martínez
 */
@Entity // la convierte en una entity de hibernate
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)// for H2
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    /**
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    private static final long serialVersionUID = 1L;
}
