package session;
import javax.ejb.Local;
import java.util.List;


import entity.Artiste;
@Local
public interface ArtisteFacadeLocal {

	void create (Artiste artiste);
	void edit (Artiste artiste);
	void remove (Artiste artiste);
	Artiste find(Object a_name);
	
	List <Artiste>findAll();
	List <Artiste>findRange(int[]range);
	int count();
	int findSeatId(int idArtiste);

}
