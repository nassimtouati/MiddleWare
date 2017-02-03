package session;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import entity.*;

@Local
public interface ReservationFacadeLocal {
	
	void create (Reservation reservation);
	void edit (Reservation reservation);
	void remove (Reservation reservation);
	Reservation find(Object id);
	
	List <Reservation>findAll();
	List <Reservation>findRange(int[]range);
	int count();
	Long checkNbrBooking(String idSeat, String idArtiste, String username);
	
}
