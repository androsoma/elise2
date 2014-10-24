/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.mantenimiento;

import entidades.mantenimiento.MantenimientoPuntoLuz;
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
public class MantenimientoPuntoLuzFacade extends AbstractFacade<MantenimientoPuntoLuz> {

    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MantenimientoPuntoLuzFacade() {
        super(MantenimientoPuntoLuz.class);
    }

    public List<MantenimientoPuntoLuz> buscarMantenimientosPorPuntoLuz(Long idPuntoLuz) {
        Query query = em.createNamedQuery("MantenimientoPuntoLuz.buscarPorPuntoLuz");
        query.setParameter("idPuntoLuz", idPuntoLuz);

        return query.getResultList();
    }

    public List<MantenimientoPuntoLuz> buscarProgramados() {
        Query query = em.createNamedQuery("MantenimientoPuntoLuz.buscarProgramados");

        return query.getResultList();
    }

    public List<MantenimientoPuntoLuz> buscarRealizados() {
        Query query = em.createNamedQuery("MantenimientoPuntoLuz.buscarRealizados");

        return query.getResultList();
    }

    public List<MantenimientoPuntoLuz> buscarProgramadosPorPuntoLuz(Long idPuntoLuz) {
        Query query = em.createNamedQuery("MantenimientoPuntoLuz.buscarProgramadosPorPuntoLuz");
        query.setParameter("idPuntoLuz", idPuntoLuz);

        return query.getResultList();
    }

    public List<MantenimientoPuntoLuz> buscarRealizadosPorPuntoLuz(Long idPuntoLuz) {
        Query query = em.createNamedQuery("MantenimientoPuntoLuz.busarRealizadosPorPuntoLuz");
        query.setParameter("idPuntoLuz", idPuntoLuz);

        return query.getResultList();
    }
}
