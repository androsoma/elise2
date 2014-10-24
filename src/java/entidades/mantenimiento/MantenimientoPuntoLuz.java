/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.mantenimiento;

import entidades.inventario.PuntoLuz;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Yeison Osorio
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "MantenimientoPuntoLuz.buscarPorPuntoLuz",
            query = "SELECT mpl"
            + " FROM MantenimientoPuntoLuz mpl"
            + " JOIN mpl.puntoLuz pl"
            + " WHERE pl.id = :idPuntoLuz"
            + " ORDER BY mpl.fechaProgramacion, mpl.fechaRealizacion"),
    @NamedQuery(name = "MantenimientoPuntoLuz.buscarProgramados",
            query = "SELECT mpl"
            + " FROM MantenimientoPuntoLuz mpl"
            + " WHERE mpl.realizado = FALSE"
            + " ORDER BY mpl.fechaProgramacion, mpl.fechaRealizacion"),
    @NamedQuery(name = "MantenimientoPuntoLuz.buscarRealizados",
            query = "SELECT mpl"
            + " FROM MantenimientoPuntoLuz mpl"
            + " WHERE mpl.realizado = TRUE"
            + " ORDER BY mpl.fechaProgramacion, mpl.fechaRealizacion"),
    @NamedQuery(name = "MantenimientoPuntoLuz.buscarProgramadosPorPuntoLuz",
            query = "SELECT mpl"
            + " FROM MantenimientoPuntoLuz mpl"
            + " JOIN mpl.puntoLuz pl"
            + " WHERE pl.id = :idPuntoLuz"
            + " AND mpl.realizado = FALSE"
            + " ORDER BY mpl.fechaProgramacion, mpl.fechaRealizacion"),
    @NamedQuery(name = "MantenimientoPuntoLuz.busarRealizadosPorPuntoLuz",
            query = "SELECT mpl"
            + " FROM MantenimientoPuntoLuz mpl"
            + " JOIN mpl.puntoLuz pl"
            + " WHERE pl.id = :idPuntoLuz"
            + " AND mpl.realizado = TRUE"
            + " ORDER BY mpl.fechaProgramacion, mpl.fechaRealizacion")})

public class MantenimientoPuntoLuz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "MantenimientoPuntoLuzSequence", sequenceName = "mantenimiento_puntoluz_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MantenimientoPuntoLuzSequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_puntoluz", nullable = false)
    private PuntoLuz puntoLuz;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaProgramacion;

    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRealizacion;

    @Column
    private String observaciones;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean realizado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PuntoLuz getPuntoLuz() {
        return puntoLuz;
    }

    public void setPuntoLuz(PuntoLuz puntoLuz) {
        this.puntoLuz = puntoLuz;
    }

    public Date getFechaProgramacion() {
        return fechaProgramacion;
    }

    public void setFechaProgramacion(Date fechaProgramacion) {
        this.fechaProgramacion = fechaProgramacion;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
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
        if (!(object instanceof MantenimientoPuntoLuz)) {
            return false;
        }
        MantenimientoPuntoLuz other = (MantenimientoPuntoLuz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.mantenimiento.MantenimientoPuntoLuz[ id=" + id + " ]";
    }

}
