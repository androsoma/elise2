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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Gutiérrez
 */
@Entity
@Table(name = "transformador")
@XmlRootElement
public class Transformador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TransformadorSequence")
    @SequenceGenerator(name = "TransformadorSequence", sequenceName = "transformador_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_tipotransformador", nullable = true)
    private TipoTransformador tipoTransformador;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_tipoconexiontransformador", nullable = true)
    private TipoConexionTransformador tipoConexionTransformador;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_fabricante", nullable = true)
    private Fabricante fabricante;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_frecuencia", nullable = true)
    private Frecuencia frecuencia;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_voltajealta", nullable = true)
    private Voltaje voltajeAlta;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_voltajebaja", nullable = true)
    private Voltaje voltajeBaja;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_potencia", nullable = true)
    private Potencia potencia;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_fase", nullable = true)
    private Fase fase;

    @ManyToOne(optional = true, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_concentrador", nullable = true)
    private Concentrador concentrador;

    @Column(nullable = true)
    private boolean exclusivo;

    @Column(length = 255, nullable = true)
    private String serial;

    @Column(length = 255, nullable = true)
    private String referencia;

    @Column(nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;

//    @OneToMany(mappedBy = "transformador")
//    private List<Luminaria> listaLuminarias;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isExclusivo() {
        return exclusivo;
    }

    public void setExclusivo(boolean exclusivo) {
        this.exclusivo = exclusivo;
    }

    public TipoTransformador getTipoTransformador() {
        return tipoTransformador;
    }

    public void setTipoTransformador(TipoTransformador tipoTransformador) {
        this.tipoTransformador = tipoTransformador;
    }

    public TipoConexionTransformador getTipoConexionTransformador() {
        return tipoConexionTransformador;
    }

    public void setTipoConexionTransformador(TipoConexionTransformador tipoConexionTransformador) {
        this.tipoConexionTransformador = tipoConexionTransformador;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Frecuencia getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Frecuencia frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Voltaje getVoltajeAlta() {
        return voltajeAlta;
    }

    public void setVoltajeAlta(Voltaje voltajeAlta) {
        this.voltajeAlta = voltajeAlta;
    }

    public Voltaje getVoltajeBaja() {
        return voltajeBaja;
    }

    public void setVoltajeBaja(Voltaje voltajeBaja) {
        this.voltajeBaja = voltajeBaja;
    }

    public Potencia getPotencia() {
        return potencia;
    }

    public void setPotencia(Potencia potencia) {
        this.potencia = potencia;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Concentrador getConcentrador() {
        return concentrador;
    }

    public void setConcentrador(Concentrador concentrador) {
        this.concentrador = concentrador;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

//    @XmlTransient
//    public List<Luminaria> getListaLuminarias() {
//        return listaLuminarias;
//    }
//
//    public void setListaLuminarias(List<Luminaria> listaLuminarias) {
//        this.listaLuminarias = listaLuminarias;
//    }    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transformador)) {
            return false;
        }
        Transformador other = (Transformador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.inventario.Transformador[ id=" + id + " ]";
    }

}
