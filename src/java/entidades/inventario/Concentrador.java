/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.inventario;

import java.io.Serializable;
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
public class Concentrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "ConcentradorSequence", sequenceName = "concentrador_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ConcentradorSequence")
    private Long id;

    @Column(nullable = false)
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "fk_fabricante")
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "fk_tipoconcentrador")
    private TipoConcentrador tipoConcentrador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public TipoConcentrador getTipoConcentrador() {
        return tipoConcentrador;
    }

    public void setTipoConcentrador(TipoConcentrador tipoConcentrador) {
        this.tipoConcentrador = tipoConcentrador;
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
        if (!(object instanceof Concentrador)) {
            return false;
        }
        Concentrador other = (Concentrador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.Concentrador[ id=" + id + " ]";
    }

}
