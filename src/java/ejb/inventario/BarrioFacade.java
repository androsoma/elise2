/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.inventario;

import entidades.inventario.Barrio;
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
public class BarrioFacade extends AbstractFacade<Barrio> {
    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BarrioFacade() {
        super(Barrio.class);
    }
    
    public List<Barrio> getBarriosByZona(Long idZona) {
        Query query = em.createNamedQuery("Barrio.findByZona");
        query.setParameter("idZona", idZona);
        
        return query.getResultList();
    }
    
     public List<Barrio> buscarTodos() {
        Query query = em.createNamedQuery("Barrio.buscarTodos");
        
        return query.getResultList();
    }
    
}
