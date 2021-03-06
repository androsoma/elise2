/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.inventario;

import entidades.inventario.Luminaria;
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
public class LuminariaFacade extends AbstractFacade<Luminaria> {
    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LuminariaFacade() {
        super(Luminaria.class);
    }
    
    public List<Luminaria> buscarLuminariasPorReferencia(String referenciaLuminaria) {
        Query query = em.createNamedQuery("Luminaria.buscarLuminariasPorReferencia");
        query.setParameter("referencia", "%" + referenciaLuminaria + "%");
        
        return query.getResultList();
    }
    
}
