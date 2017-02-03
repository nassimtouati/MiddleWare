package session;

import java.util.List;

import javax.ejb.Local;

import entity.*;
@Local
public interface SeatFacadeLocal {

	void create (Seat seat);
	void edit (Seat seat);
	void remove (Seat seat);
	Seat find(Object id);
	
	List <Seat>findAll();
	List <Seat>findRange(int[]range);
	int count();
	
}
