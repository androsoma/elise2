/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.inventario;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Yeison Osorio
 */
@Entity
public class PuntoLuz implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PuntoLuzSequence", sequenceName = "punto_luz_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PuntoLuzSequence")
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_ubicacionpunto", nullable = false)
    private UbicacionPunto ubicacionPunto;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_transformador", nullable = true)
    private Transformador transformador;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_luminaria", nullable = true)
    private Luminaria luminaria;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_bombillo", nullable = true)
    private Bombillo bombillo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_poste", nullable = true)
    private Poste poste;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_medidorenergia", nullable = true)
    private MedidorEnergia medidorEnergia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UbicacionPunto getUbicacionPunto() {
        return ubicacionPunto;
    }

    public void setUbicacionPunto(UbicacionPunto ubicacionPunto) {
        this.ubicacionPunto = ubicacionPunto;
    }

    public Transformador getTransformador() {
        return transformador;
    }

    public void setTransformador(Transformador transformador) {
        this.transformador = transformador;
    }

    public Luminaria getLuminaria() {
        return luminaria;
    }

    public void setLuminaria(Luminaria luminaria) {
        this.luminaria = luminaria;
    }

    public Bombillo getBombillo() {
        return bombillo;
    }

    public void setBombillo(Bombillo bombillo) {
        this.bombillo = bombillo;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public MedidorEnergia getMedidorEnergia() {
        return medidorEnergia;
    }

    public void setMedidorEnergia(MedidorEnergia medidorEnergia) {
        this.medidorEnergia = medidorEnergia;
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
        if (!(object instanceof PuntoLuz)) {
            return false;
        }
        PuntoLuz other = (PuntoLuz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.inventario.PuntoLuz[ id=" + id + " ]";
    }

    public String getDireccionCompleta() {
        String direccion = "";
        direccion = direccion.concat(ubicacionPunto.getMunicipio().getNombre() + " - ");
        direccion = direccion.concat(ubicacionPunto.getBarrio().getNombre() + ": ");
        direccion = direccion.concat(ubicacionPunto.getDireccion());

        return direccion;
    }

}
