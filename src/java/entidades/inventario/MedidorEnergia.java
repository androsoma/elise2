/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.inventario;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Yeison Osorio
 */
@Entity
public class MedidorEnergia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "MedidorEnergiaSequence", sequenceName = "medidor_energia_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MedidorEnergiaSequence")
    private Long id;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_fabricante", nullable = true)
    private Fabricante fabricante;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_tipomedidor", nullable = true)
    private TipoMedidor tipoMedidor;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_claseprecision", nullable = true)
    private ClasePrecision clasePrecision;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_tipoconexionmedidor", nullable = true)
    private TipoConexionMedidor tipoConexionMedidor;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_tipoproteccion", nullable = true)
    private TipoProteccion tipoProteccion;
    
    @Column(length = 255, nullable = true)
    private String serial;
    
    @Column(length = 255, nullable = true)
    private String referencia;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_voltajealta", nullable = true)
    private Voltaje voltajeAlta;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_voltajebaja", nullable = true)
    private Voltaje voltajeBaja;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_potencia", nullable = true)
    private Potencia potenciaMaxima;
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "fk_frecuencia", nullable = true)
    private Frecuencia frecuencia;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public TipoMedidor getTipoMedidor() {
        return tipoMedidor;
    }

    public void setTipoMedidor(TipoMedidor tipoMedidor) {
        this.tipoMedidor = tipoMedidor;
    }

    public ClasePrecision getClasePrecision() {
        return clasePrecision;
    }

    public void setClasePrecision(ClasePrecision clasePrecision) {
        this.clasePrecision = clasePrecision;
    }

    public TipoConexionMedidor getTipoConexionMedidor() {
        return tipoConexionMedidor;
    }

    public void setTipoConexionMedidor(TipoConexionMedidor tipoConexionMedidor) {
        this.tipoConexionMedidor = tipoConexionMedidor;
    }

    public TipoProteccion getTipoProteccion() {
        return tipoProteccion;
    }

    public void setTipoProteccion(TipoProteccion tipoProteccion) {
        this.tipoProteccion = tipoProteccion;
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
    
    public Potencia getPotenciaMaxima() {
        return potenciaMaxima;
    }

    public void setPotenciaMaxima(Potencia potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    public Frecuencia getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Frecuencia frecuencia) {
        this.frecuencia = frecuencia;
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
        if (!(object instanceof MedidorEnergia)) {
            return false;
        }
        MedidorEnergia other = (MedidorEnergia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.inventario.MedidorEnergia[ id=" + id + " ]";
    }
    
}
