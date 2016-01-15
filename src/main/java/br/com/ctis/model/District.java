package br.com.ctis.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marcus
 */

@Entity
@Table(name = "TB_UF")
public class District implements Serializable {

    @Id
    @Column(name="ID_UF")
    private Long id_UF;
    
    @Column(name="DISTRICT")
    private String District;
    
    @ManyToOne
    @JoinColumn(name="ID_ANDRESS", referencedColumnName = "ID_ANDRESS")
    private Andress district_Andress;

    public Long getId_UF() {
        return id_UF;
    }

    public void setId_UF(Long id_UF) {
        this.id_UF = id_UF;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public Andress getDistrict_Andress() {
        return district_Andress;
    }

    public void setDistrict_Andress(Andress district_Andress) {
        this.district_Andress = district_Andress;
    }
    
    
    
    
}
