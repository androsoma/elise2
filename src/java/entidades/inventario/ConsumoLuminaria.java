/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
    @NamedQuery(name = "ConsumoLuminaria.buscarPorLuminaria",
            query = "SELECT cl "
            + " FROM ConsumoLuminaria cl "
            + "  JOIN cl.luminaria l"
            + " WHERE l.id = :idLuminaria")})
public class ConsumoLuminaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "ConsumoLuminariaSequence", sequenceName = "consumoluminaria_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ConsumoLuminariaSequence")
    private Long id;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_luminaria", referencedColumnName = "id")
    private Luminaria luminaria;
    
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
    private float consumo;

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

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
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
        if (!(object instanceof ConsumoLuminaria)) {
            return false;
        }
        ConsumoLuminaria other = (ConsumoLuminaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.ConsumoLuminaria[ id=" + id + " ]";
    }

}
