package session;

import java.sql.ResultSet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Artiste;


@Stateless
@LocalBean
public class ArtisteFacade extends AbstractFacade<Artiste>implements ArtisteFacadeLocal {

	@PersistenceContext(unitName ="LoginEJBApplication_EJB")
	private EntityManager em;
	
    public ArtisteFacade() {
        super(Artiste.class);
    }

	

	@Override
	public Artiste find(Object id) {
		
		return null;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	@Override
	public int findSeatId(int idArtiste) {
		TypedQuery<Integer> q= em.createQuery("select id_seat from Artiste where idArtiste"+idArtiste,Integer.class);
		
		
		return q.getSingleResult();
	}

	
	



}
