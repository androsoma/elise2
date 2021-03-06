/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.inventario;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Yeison Osorio
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Medicion.buscarPorLuminaria",
            query = "SELECT med"
            + " FROM Medicion med"
            + " JOIN med.luminaria l"
            + " WHERE l.id = :idLuminaria")})
public class Medicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "MedicionSequence", sequenceName = "medicion_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MedicionSequence")
    private Long id;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_luminaria")
    private Luminaria luminaria;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_transformador")
    private Transformador transformador;

    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaMedicion;

    @Column(length = 4)
    private String anio;

    @Column(length = 2)
    private String mes;

    @Column(length = 2)
    private String dia;

    @Column(length = 2)
    private String hora;

    @Column(length = 2)
    private String minuto;

    @Column
    private float voltaje;

    @Column
    private float corriente;

    @Column
    private float cosenophi;

    @Column
    private float potencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Luminaria getLuminaria() {
        return luminaria;
    }

    public void setLuminaria(Luminaria luminaria) {
        this.luminaria = luminaria;
    }

    public Transformador getTransformador() {
        return transformador;
    }

    public void setTransformador(Transformador transformador) {
        this.transformador = transformador;
    }

    public Date getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(Date fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public float getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(float voltaje) {
        this.voltaje = voltaje;
    }

    public float getCorriente() {
        return corriente;
    }

    public void setCorriente(float corriente) {
        this.corriente = corriente;
    }

    public float getCosenophi() {
        return cosenophi;
    }

    public void setCosenophi(float cosenophi) {
        this.cosenophi = cosenophi;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
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
        if (!(object instanceof Medicion)) {
            return false;
        }
        Medicion other = (Medicion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.Medicion[ id=" + id + " ]";
    }
    
    public String getDiaHora() {
        return getDia() + ": " + getHora() + ":" + getMinuto();
    }

}
