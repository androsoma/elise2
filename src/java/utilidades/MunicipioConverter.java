/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import control.InventarioControl;
import entidades.inventario.Municipio;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Yeison Osorio
 */
@FacesConverter(value = "municipioConverter")
public class MunicipioConverter implements Converter {

    @ManagedProperty(name = "inventarioControl", value = "#{inventarioControl}")
    private InventarioControl inventarioControl;

    public InventarioControl getInventarioControl() {
        return inventarioControl;
    }

    public void setInventarioControl(InventarioControl inventarioControl) {
        this.inventarioControl = inventarioControl;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                Long identificador = Long.valueOf(value);
                
                for (Municipio municipio : inventarioControl.getMunicipios()) {
                    if (municipio.getId().compareTo(identificador) == 0) {
                        return municipio;
                    }
                }
            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un municipio válido"));
            }
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Municipio) value).getId());
        }
    }

}
