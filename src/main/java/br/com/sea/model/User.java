package br.com.sea.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    @Column(name = "ID_USER")
    private Long id_User;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTHDAY_DATE")
    private String birthday_Date;

    @Column(name = "EMAIL")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "phones_user")
    private List<Phone> phone;

    @JsonIgnore
    @OneToMany(mappedBy = "address_user")
    private List<Address> address;

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

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    
}
