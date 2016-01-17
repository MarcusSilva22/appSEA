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

}
