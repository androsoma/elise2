/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.mantenimiento;

import entidades.inventario.Tercero;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Yeison Osorio
 */
@Entity
public class EstadoReporte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "EstadoReporteSequence", sequenceName = "estado_reporte_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EstadoReporteSequence")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "fk_reportepuntoluz", nullable = false)
    private ReportePuntoLuz reportePuntoLuz;
    
    @ManyToOne
    @JoinColumn(name = "fk_tipoestadoreporte", nullable = false)
    private TipoEstadoReporte tipoEstadoReporte;
    
    @ManyToOne
    @JoinColumn(name = "fk_tercero", nullable = false)
    private Tercero tercero;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaCambioEstado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReportePuntoLuz getReportePuntoLuz() {
        return reportePuntoLuz;
    }

    public void setReportePuntoLuz(ReportePuntoLuz reportePuntoLuz) {
        this.reportePuntoLuz = reportePuntoLuz;
    }

    public TipoEstadoReporte getTipoEstadoReporte() {
        return tipoEstadoReporte;
    }

    public void setTipoEstadoReporte(TipoEstadoReporte tipoEstadoReporte) {
        this.tipoEstadoReporte = tipoEstadoReporte;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    public Date getFechaCambioEstado() {
        return fechaCambioEstado;
    }

    public void setFechaCambioEstado(Date fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
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
        if (!(object instanceof EstadoReporte)) {
            return false;
        }
        EstadoReporte other = (EstadoReporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipoEstadoReporte.getDescripcion();
    }
    
}
