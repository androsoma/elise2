/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.inventario;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Yeison Osorio
 */
@Entity
public class Poste implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "PosteSequence", sequenceName = "poste_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PosteSequence")
    private Long id;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_materialposte", nullable = true)
    private MaterialPoste material;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_alturaposte", nullable = true)
    private AlturaPoste alturaPoste;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_fabricante", nullable = true)
    private Fabricante fabricante;
    
    @Column(length = 255, nullable = true)
    private String referencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MaterialPoste getMaterial() {
        return material;
    }

    public void setMaterial(MaterialPoste material) {
        this.material = material;
    }

    public AlturaPoste getAlturaPoste() {
        return alturaPoste;
    }

    public void setAlturaPoste(AlturaPoste alturaPoste) {
        this.alturaPoste = alturaPoste;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poste)) {
            return false;
        }
        Poste other = (Poste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.Poste[ id=" + id + " ]";
    }
    
}
