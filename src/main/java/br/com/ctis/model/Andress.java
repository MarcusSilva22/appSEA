package br.com.ctis.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marcus
 */

@Entity
@Table(name = "TB_ANDRESS")
public class Andress implements Serializable {
    
    @Id
    @Column(name="ID_ANDRESS")
    private Long id_Andress;
    
    @Column(name="ANDRESS")
    private String andress;
    
    @Column(name="SUPPLEMENT")
    private String supplement;
    
    @ManyToOne
    @JoinColumn(name="ID_USER", referencedColumnName = "ID_USER")
    private User andress_user;
       
    @OneToMany(mappedBy = "district_Andress")
    private District district;
    
    @OneToMany(mappedBy = "uf_Andress")
    private UF uf_Andress;

    public Long getId_Andress() {
        return id_Andress;
    }

    public void setId_Andress(Long id_Andress) {
        this.id_Andress = id_Andress;
    }

    public String getAndress() {
        return andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public User getAndress_user() {
        return andress_user;
    }

    public void setAndress_user(User andress_user) {
        this.andress_user = andress_user;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public UF getUf_Andress() {
        return uf_Andress;
    }

    public void setUf_Andress(UF uf_Andress) {
        this.uf_Andress = uf_Andress;
    }
    
    
}
