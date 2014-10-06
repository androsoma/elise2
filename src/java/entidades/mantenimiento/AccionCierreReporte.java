/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.mantenimiento;

import entidades.inventario.Usuario;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Yeison Osorio
 */
@Entity
public class AccionCierreReporte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "AccionCierreReporteSequence", sequenceName = "accioncierre_reporte_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccionCierreReporteSequence")
    private Long id;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_reportepuntoluz", nullable = false)
    private ReportePuntoLuz reportePuntoLuz;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_accioncierre", nullable = false)
    private AccionCierre accionCierre;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario usuario;
    
    @Column(columnDefinition = "TEXT")
    private String observaciones;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaRegistro;   
    
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

    public AccionCierre getAccionCierre() {
        return accionCierre;
    }

    public void setAccionCierre(AccionCierre accionCierre) {
        this.accionCierre = accionCierre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
        if (!(object instanceof AccionCierreReporte)) {
            return false;
        }
        AccionCierreReporte other = (AccionCierreReporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.mantenimiento.AccionCierreReporte[ id=" + id + " ]";
    }
    
}
