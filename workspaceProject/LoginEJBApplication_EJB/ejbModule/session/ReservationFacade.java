package session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.*;
/**
 * Session Bean implementation class ReservationFacade
 */
@Stateless
@LocalBean
public class ReservationFacade extends AbstractFacade<Reservation> implements ReservationFacadeLocal{

	@PersistenceContext(unitName ="LoginEJBApplication_EJB")
	private EntityManager em;
	
	
    public ReservationFacade() {
    	super(Reservation.class);
    }

@Override
protected EntityManager getEntityManager() {
	// TODO Auto-generated method stub
	return em;
	
}

@Override
public Long checkNbrBooking(String idSeat, String idArtiste, String username) {
	Query q =em.createNamedQuery("Reservation.checknbrSeat");
	q.setParameter("idArtiste", idArtiste);
	q.setParameter("idSeat", idSeat);
	q.setParameter("userName", username);
	
	return (Long) q.getSingleResult() ;
}



}
