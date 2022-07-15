/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entidad.Apoderado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristhian
 */
@Stateless
public class ApoderadoFacade extends AbstractFacade<Apoderado> implements ApoderadoFacadeLocal {

    @PersistenceContext(unitName = "MatriculaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApoderadoFacade() {
        super(Apoderado.class);
    }
    
}
