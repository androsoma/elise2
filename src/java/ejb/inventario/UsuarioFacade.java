/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.inventario;

import entidades.inventario.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "elisePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario autenticarUsuario(Usuario usuario) {
        try {
            Query query = em.createNamedQuery("Usuario.findByUsuarioContrasena");

            query.setParameter("nombreUsuario", usuario.getNombreUsuario());
            query.setParameter("contrasena", usuario.getContrasena());

            query.setMaxResults(1);

            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
