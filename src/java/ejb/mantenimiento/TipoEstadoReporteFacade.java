/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.mantenimiento;

import entidades.mantenimiento.TipoEstadoReporte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LENOVO
 */
@Stateless
public class TipoEstadoReporteFacade extends AbstractFacade<TipoEstadoReporte> {
    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEstadoReporteFacade() {
        super(TipoEstadoReporte.class);
    }
    
}
