package session;

import entity.Account;
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
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {
       
   
	@PersistenceContext(unitName ="LoginEJBApplication_EJB")
	private EntityManager em;
	
	
	
	
    public AccountFacade() {
        super(Account.class);
   
    }


	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	

	public boolean checkLogin (String u, String p){
		
		Query q= em.createNamedQuery("Account.checkLogin");
		q.setParameter("usename", u);
		q.setParameter("password", p);
		
		return q.getResultList().size()>0 ;
	}

}
