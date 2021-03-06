package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 * Session Bean implementation class AbstractFacade
 */
@Stateless
public abstract class AbstractFacade <T> {

			
		private Class<T> entityClass;
		
		 
		
		public AbstractFacade(Class<T> entityClass) {
	
		this.entityClass = entityClass;
		
		}
	
		protected abstract EntityManager getEntityManager();
	
		public void create(T entity) {
	
		getEntityManager().persist(entity);
		
		}
	
		public void edit(T entity) {
		
		getEntityManager().merge(entity);
	
		}
	
		public void remove(T entity) {
		
		getEntityManager().remove(getEntityManager().merge(entity));
		
		}
		
		 
		
		public T find(Object a_name) {
		
		return getEntityManager().find(entityClass, a_name);
		
		}
		
		 
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<T> findAll() {
		
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		
		cq.select(cq.from(entityClass));
		 
		return getEntityManager().createQuery(cq).getResultList();
		 
		}
	 
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<T> findRange(int[] range) {
		 
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		 
		cq.select(cq.from(entityClass));
		 
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		 
		q.setMaxResults(range[1] - range[0]);
		 
		q.setFirstResult(range[0]);
		 
		return q.getResultList();
		 
		}
		 
		 
		 
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public int count() {
		
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		 
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		 
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		 
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		 
		return ((Long) q.getSingleResult()).intValue();
		 
		}

		public Long checkNbrBooking(String idSeat, String idArtiste, String username) {
			// TODO Auto-generated method stub
			return null;
		}
		
//		@SuppressWarnings({ "rawtypes", "unchecked" })
//		public double gain() {
//		
//		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//		
//		cq.select(cq.from(entityClass));
//		 
//		return (int) getEntityManager().createQuery(cq).getSingleResult();
//		 
//		}
		}
	


