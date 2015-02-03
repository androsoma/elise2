/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.inventario;

import entidades.inventario.ConsumoLuminaria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LENOVO
 */
@Stateless
public class ConsumoLuminariaFacade extends AbstractFacade<ConsumoLuminaria> {

    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsumoLuminariaFacade() {
        super(ConsumoLuminaria.class);
    }

    public List<ConsumoLuminaria> buscarConsumosPorLuminaria(Long idLuminaria) {
        Query query = em.createNamedQuery("ConsumoLuminaria.buscarPorLuminaria");
        query.setParameter("idLuminaria", idLuminaria);

        return query.getResultList();
    }

}
