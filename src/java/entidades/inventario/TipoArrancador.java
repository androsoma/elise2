/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.inventario;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * <p>indica el tipo de arrancador de un balasto</p>
 * 
 * @author Cristian Gutierrez
 */
@Entity
@Table(name = "tipoarrancador")
@XmlRootElement
public class TipoArrancador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "TipoArrancadorSequence", sequenceName = "tipo_arrancador_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="TipoArrancadorSequence" )
    private int id;

    @Column(length = 100)
    private String descripcion;

    @Column
    private boolean activo;
    
    @OneToMany(mappedBy = "tipoArrancador", fetch = FetchType.LAZY)
    private List<Arrancador> listaArrancadores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public List<Arrancador> getListaArrancadores() {
        return listaArrancadores;
    }

    public void setListaArrancadores(List<Arrancador> listaArrancadores) {
        this.listaArrancadores = listaArrancadores;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoArrancador other = (TipoArrancador) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
