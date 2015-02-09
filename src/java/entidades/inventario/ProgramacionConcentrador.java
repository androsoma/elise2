/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Yeison Osorio
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ProgramacionConcentrador.buscarPorConcentrador", query = "SELECT pc FROM ProgramacionConcentrador pc JOIN pc.concentrador c WHERE c.identificador = :identificadorConcentrador")})
public class ProgramacionConcentrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column
    @SequenceGenerator(name = "ProgramacionConcentradorSequence", sequenceName = "programacionconcentrador_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProgramacionConcentradorSequence")
    private Long id;
    
    @Column
    private String cantidadHoras;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_concentrador", referencedColumnName = "id")
    private Concentrador concentrador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(String cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public Concentrador getConcentrador() {
        return concentrador;
    }

    public void setConcentrador(Concentrador concentrador) {
        this.concentrador = concentrador;
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
        if (!(object instanceof ProgramacionConcentrador)) {
            return false;
        }
        ProgramacionConcentrador other = (ProgramacionConcentrador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.inventario.ProgramacionConcentrador[ id=" + id + " ]";
    }
}
