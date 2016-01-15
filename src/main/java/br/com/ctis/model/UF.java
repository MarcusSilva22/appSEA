package br.com.ctis.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marcus
 */
@Entity
@Table(name = "TB_UF")
public class UF implements Serializable {
    
    @Id
    @Column(name="ID_UF")
    private Long id_UF;
    
    @Column(name="UF")
    private Character uf;
    
    @ManyToOne
    @JoinColumn(name="ID_ANDRESS", referencedColumnName = "ID_ANDRESS")
    private Andress uf_Andress;

    public Long getId_UF() {
        return id_UF;
    }

    public void setId_UF(Long id_UF) {
        this.id_UF = id_UF;
    }

    public Character getUf() {
        return uf;
    }

    public void setUf(Character uf) {
        this.uf = uf;
    }

    public Andress getUf_Andress() {
        return uf_Andress;
    }

    public void setUf_Andress(Andress uf_Andress) {
        this.uf_Andress = uf_Andress;
    }
    
    
    
}
