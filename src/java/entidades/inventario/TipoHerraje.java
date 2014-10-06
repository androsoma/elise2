/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.inventario;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * <p>define los artefactos de sujecion de las luminarias</p>
 * 
 * @author Cristian Gutierrez
 */
@Entity
@Table(name = "tipoherraje")
@XmlRootElement
public class TipoHerraje implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id
    @SequenceGenerator(name = "TipoHerrajeSequence", sequenceName = "tipo_herraje_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoHerrajeSequence")
    private Long id;

    @Column(length = 100)
    private String descripcion;

    @Column
    private boolean activo;
    
    @OneToMany(mappedBy = "tipoHerraje")
    private List<Luminaria> listaLuminarias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @XmlTransient
    public List<Luminaria> getListaLuminarias() {
        return listaLuminarias;
    }

    public void setListaLuminarias(List<Luminaria> listaLuminarias) {
        this.listaLuminarias = listaLuminarias;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHerraje)) {
            return false;
        }
        TipoHerraje other = (TipoHerraje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
