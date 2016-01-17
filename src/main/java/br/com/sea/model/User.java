package br.com.sea.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Marcus
 */
@Entity
@Table(name = "TB_USER")

@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.byId", query = "SELECT u FROM User u WHERE u.id_User = :id_User"),
    @NamedQuery(name = "User.byName", query = "SELECT u FROM User u WHERE u.name = :name")
})
public class User implements Serializable {
    @Id
    @GenericGenerator(name = "idUser", strategy = "increment")
    @GeneratedValue(generator = "idUser")
    @Column(name = "ID_USER")
    private Long id_User;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTHDAY_DATE")
    private String birthday_Date;

    @Column(name = "EMAIL")
    private String email;
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Phone phone;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Address address;

    public Long getId_User() {
        return id_User;
    }

    public void setId_User(Long id_User) {
        this.id_User = id_User;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday_Date() {
        return birthday_Date;
    }

    public void setData_Brith(String birthday_Date) {
        this.birthday_Date = birthday_Date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
