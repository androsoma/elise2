/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.inventario;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * <p>representa un fabricante de un artefacto electrico o estructural</p>
 * @author Yeison Osorio
 */
@Entity
@Table(name = "fabricante")
@XmlRootElement
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "FabricanteSequence", sequenceName = "fabricante_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FabricanteSequence")
    private int id;
    
    @Column(length = 50)
    private String nombre;
    
    @Column(length = 50)
    private String nit;
    
    @OneToMany(mappedBy = "fabricante", fetch = FetchType.LAZY)
    private List<Luminaria> listaLuminarias;
    
    @OneToMany(mappedBy = "fabricante", fetch = FetchType.LAZY)
    private List<Arrancador> listaArrancadores;
    
    @OneToMany(mappedBy = "fabricante", fetch = FetchType.LAZY)
    private List<Balasto> listaBalastos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @XmlTransient
    public List<Luminaria> getListaLuminarias() {
        return listaLuminarias;
    }

    public void setListaLuminarias(List<Luminaria> listaLuminarias) {
        this.listaLuminarias = listaLuminarias;
    }
    
    @XmlTransient
    public List<Arrancador> getListaArrancadores() {
        return listaArrancadores;
    }

    public void setListaArrancadores(List<Arrancador> listaArrancadores) {
        this.listaArrancadores = listaArrancadores;
    }

    @XmlTransient
    public List<Balasto> getListaBalastos() {
        return listaBalastos;
    }

    public void setListaBalastos(List<Balasto> listaBalastos) {
        this.listaBalastos = listaBalastos;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
