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
@Table(name = "arrancador")
@XmlRootElement
public class Arrancador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "ArrancadorSequence", sequenceName = "arrancador_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ArrancadorSequence")
    private Long id;
    
    @Column(length = 255)
    private String referencia;
    
    @JoinColumn(name = "fk_fabricante", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Fabricante fabricante;
    

    @JoinColumn(name = "fk_tipoarrancador", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private TipoArrancador tipoArrancador;
    
    @OneToOne(mappedBy = "arrancador", fetch = FetchType.EAGER)
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

    public TipoArrancador getTipoArrancador() {
        return tipoArrancador;
    }

    public void setTipoArrancador(TipoArrancador tipoArrancador) {
        this.tipoArrancador = tipoArrancador;
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
        if (!(object instanceof Arrancador)) {
            return false;
        }
        Arrancador other = (Arrancador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.Arrancador[ id=" + id + " ]";
    }
    
}
