/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.inventario;

import entidades.inventario.Tercero;
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
public class TerceroFacade extends AbstractFacade<Tercero> {

    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerceroFacade() {
        super(Tercero.class);
    }

    public Tercero buscarTerceroPorNombreYCorreo(Tercero tercero) {
        try {
            Query query = em.createNamedQuery("Tercero.findByNombreAndCorreo");
            query.setParameter("nombres", tercero.getNombres());
            query.setParameter("apellidos", tercero.getApellidos());
            query.setParameter("correo", tercero.getEmail());

            query.setMaxResults(1);

            return (Tercero) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
