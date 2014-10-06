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
public class Bombillo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "BombilloSequence", sequenceName = "bombillo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BombilloSequence")
    private Long id;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_tipobombillo", nullable = true)
    private TipoBombillo tipoBombillo;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_fabricante", nullable = true)
    private Fabricante fabricante;
    
    @Column(length = 255, nullable = true)
    private String flujoLuminoso;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_potencia", nullable = true)
    private Potencia potencia;
    
    @Column(length = 255, nullable = true)
    private String vidaUtil;
    
    @Column(length = 255, nullable = true)
    private String referencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoBombillo getTipoBombillo() {
        return tipoBombillo;
    }

    public void setTipoBombillo(TipoBombillo tipoBombillo) {
        this.tipoBombillo = tipoBombillo;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getFlujoLuminoso() {
        return flujoLuminoso;
    }

    public void setFlujoLuminoso(String flujoLuminoso) {
        this.flujoLuminoso = flujoLuminoso;
    }

    public Potencia getPotencia() {
        return potencia;
    }

    public void setPotencia(Potencia potencia) {
        this.potencia = potencia;
    }

    public String getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(String vidaUtil) {
        this.vidaUtil = vidaUtil;
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
        if (!(object instanceof Bombillo)) {
            return false;
        }
        Bombillo other = (Bombillo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.Bombillo[ id=" + id + " ]";
    }
    
}
