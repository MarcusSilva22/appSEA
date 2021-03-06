package br.com.sea.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Marcus
 */

@Entity
@Table(name = "TB_ADDRESS")
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable {
    
    @Id
    @GenericGenerator(name = "idAddress", strategy = "increment")
    @GeneratedValue(generator = "idAddress")
    @Column(name="ID_ADDRESS")
    private Long id_Address;
    
    @Column(name="ADDRESS")
    private String address;
    
    @Column(name="SUPPLEMENT")
    private String supplement;
       
    @Column(name="DISTRICT")
    private String district_Address;
    
    @Column(name="UF")
    private String uf_Address;

    public Long getId_Address() {
        return id_Address;
    }

    public void setId_Address(Long id_Address) {
        this.id_Address = id_Address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public String getDistrict_Address() {
        return district_Address;
    }

    public void setDistrict_Address(String district_Address) {
        this.district_Address = district_Address;
    }

    public String getUf_Address() {
        return uf_Address;
    }

    public void setUf_Address(String uf_Address) {
        this.uf_Address = uf_Address;
    }
    
    
}
