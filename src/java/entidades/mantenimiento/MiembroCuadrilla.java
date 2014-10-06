/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.mantenimiento;

import entidades.inventario.Tercero;
import java.io.Serializable;
import java.util.Objects;
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
 * @author lbertel
 */
@Entity
public class MiembroCuadrilla implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "MiembroCuadrillaSequence", sequenceName = "miembro_cuadrilla_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MiembroCuadrillaSequence")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "fk_tercero", nullable = false)
    private Tercero tercero;

    @ManyToOne
    @JoinColumn(name = "fk_cuadrilla", nullable = true)
    private Cuadrilla cuadrilla;

    @ManyToOne
    @JoinColumn(name = "fk_rolcuadrilla", nullable = true)
    private RolCuadrilla rolCuadrilla;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    public Cuadrilla getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public RolCuadrilla getRolCuadrilla() {
        return rolCuadrilla;
    }

    public void setRolCuadrilla(RolCuadrilla rolCuadrilla) {
        this.rolCuadrilla = rolCuadrilla;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MiembroCuadrilla other = (MiembroCuadrilla) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return tercero.getNombres() + " " + tercero.getApellidos();
    }

}
