/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.inventario;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Gutiérrez
 */
@Entity
@Table(name = "balasto")
@XmlRootElement
public class Balasto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "BalastoSequence", sequenceName = "balasto_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BalastoSequence")
    private Long id;

    @Column(length = 255)
    private String referencia;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_fabricante")
    private Fabricante fabricante;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_tipobalasto")
    private TipoBalasto tipoBalasto;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_tipoproteccion")
    private TipoProteccion tipoProteccion;
    
    @OneToOne(mappedBy = "balasto", fetch = FetchType.EAGER)
    private Luminaria luminaria;

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

    public TipoBalasto getTipoBalasto() {
        return tipoBalasto;
    }

    public void setTipoBalasto(TipoBalasto tipoBalasto) {
        this.tipoBalasto = tipoBalasto;
    }

    public TipoProteccion getTipoProteccion() {
        return tipoProteccion;
    }

    public void setTipoProteccion(TipoProteccion tipoProteccion) {
        this.tipoProteccion = tipoProteccion;
    }

    public Luminaria getLuminaria() {
        return luminaria;
    }

    public void setLuminaria(Luminaria luminaria) {
        this.luminaria = luminaria;
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
        if (!(object instanceof Balasto)) {
            return false;
        }
        Balasto other = (Balasto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.Balasto[ id=" + id + " ]";
    }

}
