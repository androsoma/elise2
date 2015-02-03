/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.inventario;

import entidades.inventario.PuntoLuz;
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
public class PuntoLuzFacade extends AbstractFacade<PuntoLuz> {

    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuntoLuzFacade() {
        super(PuntoLuz.class);
    }

    public List<PuntoLuz> buscarPuntosConLuminaria() {
        Query query = em.createNamedQuery("PuntoLuz.buscarPuntosConLuminaria");

        return query.getResultList();
    }

    public List<PuntoLuz> buscarLuminariasPorConcentrador(Long idConcentrador) {
        String sql = "SELECT pl.* FROM puntoluz pl JOIN luminariaconcentrador lc ON lc.fk_luminaria = pl.fk_luminaria WHERE lc.fk_concentrador = " + idConcentrador;
        Query query = em.createNativeQuery(sql);

        return query.getResultList();
    }
    
     public List<PuntoLuz> buscarPuntosLuzLuminariasPorConcentrador(Long idConcentrador) {
         Query query = em.createNamedQuery("PuntoLuz.buscarPuntosLuzLuminariaConcentrador");
         query.setParameter("idConcentrador", idConcentrador);
         
         return query.getResultList();
     }

}
