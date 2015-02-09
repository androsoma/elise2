/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.inventario;

import entidades.inventario.ProgramacionConcentrador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yeison Osorio
 */
@Stateless
public class ProgramacionConcentradorFacade extends AbstractFacade<ProgramacionConcentrador> {

    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramacionConcentradorFacade() {
        super(ProgramacionConcentrador.class);
    }

    public ProgramacionConcentrador buscarProgramacionConcentradorPorIdentificador(String identificadorConcentrador) {
        try {
            Query query = em.createNamedQuery("ProgramacionConcentrador.buscarPorConcentrador");
            query.setParameter("identificadorConcentrador", identificadorConcentrador);
            query.setMaxResults(1);

            return (ProgramacionConcentrador) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
