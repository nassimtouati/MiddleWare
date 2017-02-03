package session;
import entity.*;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class AcountFacade
 */
@Stateless
@LocalBean
public class SeatFacade extends AbstractFacade<Seat> implements SeatFacadeLocal {

	@PersistenceContext(unitName ="LoginEJBApplication_EJB")
	private EntityManager em;
	
	
	
	
    public SeatFacade() {
        super(Seat.class);
   
    }
    @Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	
   

    
}
