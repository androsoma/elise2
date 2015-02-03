/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.inventario;

import entidades.inventario.Concentrador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LENOVO
 */
@Stateless
public class ConcentradorFacade extends AbstractFacade<Concentrador> {

    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcentradorFacade() {
        super(Concentrador.class);
    }

    public Concentrador buscarConcentradorPorIdentificador(String identificador) {
        try {
            Query query = em.createNamedQuery("Concentrador.buscarPorIdentificador");
            query.setParameter("identificador", identificador);
            query.setMaxResults(1);

            return (Concentrador) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
