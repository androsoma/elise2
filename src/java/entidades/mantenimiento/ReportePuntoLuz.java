/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.mantenimiento;

import entidades.inventario.PuntoLuz;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Yeison Osorio
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ReportePuntoLuz.findByEstadoReportado",
            query = "SELECT rpl"
            + " FROM EstadoReporte er"
            + " JOIN er.reportePuntoLuz rpl"
            + " JOIN er.tipoEstadoReporte ter"
            + " WHERE ter.id = 1"),
    @NamedQuery(name = "ReportePuntoLuz.findByTipoEstadoReporte",
            query = "SELECT rpl"
            + " FROM EstadoReporte er"
            + " JOIN er.reportePuntoLuz rpl"
            + " JOIN er.tipoEstadoReporte ter"
            + " WHERE ter.id = :idTipoEstadoReporte")})

public class ReportePuntoLuz implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ReportePuntoLuzSequence", sequenceName = "reporte_puntoluz_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReportePuntoLuzSequence")
    private Long id;

    @Column
    private String codigo;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_ciudadano", nullable = false)
    private Ciudadano ciudadano;

    @ManyToOne
    @JoinColumn(name = "fk_puntoluz", nullable = false)
    private PuntoLuz puntoLuz;

    @ManyToOne
    @JoinColumn(name = "fk_tipoincidente", nullable = false)
    private TipoIncidente tipoIncidente;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIncidencia;

    @Column
    private String observaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public PuntoLuz getPuntoLuz() {
        return puntoLuz;
    }

    public void setPuntoLuz(PuntoLuz puntoLuz) {
        this.puntoLuz = puntoLuz;
    }

    public TipoIncidente getTipoIncidente() {
        return tipoIncidente;
    }

    public void setTipoIncidente(TipoIncidente tipoIncidente) {
        this.tipoIncidente = tipoIncidente;
    }

    public Date getFechaIncidencia() {
        return fechaIncidencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setFechaIncidencia(Date fechaIncidencia) {
        this.fechaIncidencia = fechaIncidencia;
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
        if (!(object instanceof ReportePuntoLuz)) {
            return false;
        }
        ReportePuntoLuz other = (ReportePuntoLuz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.mantenimiento.ReporteLuminaria[ id=" + id + " ]";
    }

}
