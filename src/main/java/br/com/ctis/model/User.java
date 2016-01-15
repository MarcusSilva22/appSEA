package br.com.ctis.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Marcus
 */
@Entity
@Table(name = "TB_USER")
public class User implements Serializable {

    @OneToMany(mappedBy = "id_User")
    private List<Andress> andresss;

    @Id
    @Column(name = "ID_USER")
    private Long id_User;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATA_BRITH")
    private String data_Brith;

    @Column(name = "EMAIL")
    private String email;
    
    @OneToMany(mappedBy = "phones_user")
    private List<Phone> phone;

    public List<Andress> getAndresss() {
        return andresss;
    }

    public void setAndresss(List<Andress> andresss) {
        this.andresss = andresss;
    }

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

    public String getData_Brith() {
        return data_Brith;
    }

    public void setData_Brith(String data_Brith) {
        this.data_Brith = data_Brith;
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
}
