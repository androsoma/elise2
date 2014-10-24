/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.mantenimiento;

import entidades.mantenimiento.ReportePuntoLuz;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yeison Osorio
 */
@Stateless
public class ReportePuntoLuzFacade extends AbstractFacade<ReportePuntoLuz> {
    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportePuntoLuzFacade() {
        super(ReportePuntoLuz.class);
    }
    
    public List<ReportePuntoLuz> consultarPorEstadoReportado() {
        Query query = em.createNamedQuery("ReportePuntoLuz.findByEstadoReportado");
        
        return (List<ReportePuntoLuz>) query.getResultList();
    }
    
    public List<ReportePuntoLuz> consultarPorTipoEstadoReporte(Long idTipoEstadoReporte) {
         Query query = em.createNamedQuery("ReportePuntoLuz.findByTipoEstadoReporte");
         query.setParameter("idTipoEstadoReporte", idTipoEstadoReporte);
         
         return (List<ReportePuntoLuz>) query.getResultList();
    }
    
    public List<ReportePuntoLuz> consultarPorTipoEstadoReporteYPuntoLuz(Long idTipoEstadoReporte, Long idPuntoLuz) {
        Query query = em.createNamedQuery("ReportePuntoLuz.findByTipoEstadoReporteAndPuntoLuz");
        query.setParameter("idTipoEstadoReporte", idTipoEstadoReporte);
        query.setParameter("idPuntoLuz", idPuntoLuz);
        
        return query.getResultList();
    }
}
