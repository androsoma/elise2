/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.inventario;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Gutiérrez
 */
@Entity
@Table(name = "luminaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Luminaria.findAll", query = "SELECT l FROM Luminaria l"),
    @NamedQuery(name = "Luminaria.findById", query = "SELECT l FROM Luminaria l WHERE l.id = :id"),
    @NamedQuery(name = "Luminaria.findByAltura", query = "SELECT l FROM Luminaria l WHERE l.altura = :altura"),
    @NamedQuery(name = "Luminaria.findByReferencia", query = "SELECT l FROM Luminaria l WHERE l.referencia = :referencia")})
public class Luminaria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @SequenceGenerator(name = "LuminariaSequence", sequenceName = "luminaria_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LuminariaSequence")
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_brazoluminaria", referencedColumnName = "id")
    private BrazoLuminaria brazoLuminaria;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_balasto", referencedColumnName = "id")
    private Balasto balasto;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_arrancador", referencedColumnName = "id")
    private Arrancador arrancador;

//    @ManyToOne(cascade = {CascadeType.REFRESH})
//    @JoinColumn(name = "fk_transformador", referencedColumnName = "id")
//    private Transformador transformador;
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_tipoherraje", referencedColumnName = "id")
    private TipoHerraje tipoHerraje;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_fabricante", referencedColumnName = "id")
    private Fabricante fabricante;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_potencia")
    private Potencia potencia;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_concentrador")
    private Concentrador concentrador;

    @Column(name = "altura")
    private float altura;

    @Size(max = 255)
    @Column(name = "referencia")
    private String referencia;

    @Column(name = "niveliluminacion")
    private float nivelIluminacion;

    @Column(name = "encendida", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean encendida;

    @Column(name = "fecharegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Transformador getTransformador() {
//        return transformador;
//    }
//
//    public void setTransformador(Transformador transformador) {
//        this.transformador = transformador;
//    }
    public BrazoLuminaria getBrazoLuminaria() {
        return brazoLuminaria;
    }

    public void setBrazoLuminaria(BrazoLuminaria brazoLuminaria) {
        this.brazoLuminaria = brazoLuminaria;
    }

    public Balasto getBalasto() {
        return balasto;
    }

    public void setBalasto(Balasto balasto) {
        this.balasto = balasto;
    }

    public Arrancador getArrancador() {
        return arrancador;
    }

    public void setArrancador(Arrancador arrancador) {
        this.arrancador = arrancador;
    }

    public TipoHerraje getTipoHerraje() {
        return tipoHerraje;
    }

    public void setTipoHerraje(TipoHerraje tipoHerraje) {
        this.tipoHerraje = tipoHerraje;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Potencia getPotencia() {
        return potencia;
    }

    public void setPotencia(Potencia potencia) {
        this.potencia = potencia;
    }

    public Concentrador getConcentrador() {
        return concentrador;
    }

    public void setConcentrador(Concentrador concentrador) {
        this.concentrador = concentrador;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public float getNivelIluminacion() {
        return nivelIluminacion;
    }

    public void setNivelIluminacion(float nivelIluminacion) {
        this.nivelIluminacion = nivelIluminacion;
    }

    public boolean isEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
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
        if (!(object instanceof Luminaria)) {
            return false;
        }
        Luminaria other = (Luminaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.Luminaria[ id=" + id + " ]";
    }

}
