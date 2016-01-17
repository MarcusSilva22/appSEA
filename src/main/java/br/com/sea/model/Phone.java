package br.com.sea.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Marcus
 */
@Entity
@Table(name = "TB_PHONE")
@NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
public class Phone implements Serializable {

    @Id
    @GenericGenerator(name = "idPhone", strategy = "increment")
    @GeneratedValue(generator = "idPhone")
    @Column(name = "ID_PHONE")
    private Long id_Phone;

    @Column(name = "PHONE")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private User phones_user;

    public Long getId_Phone() {
        return id_Phone;
    }

    public void setId_Phone(Long id_Phone) {
        this.id_Phone = id_Phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getId_User() {
        return phones_user;
    }

    public void setId_User(User phones_user) {
        this.phones_user = phones_user;
    }

}
