package dao;

import javax.persistence.EntityManager;

public class GenericDAO<T> {
	
	@SuppressWarnings("unused")
	private Class<T> klass;
	
	public GenericDAO(Class<T> klass) {
		this.klass = klass;
	}
	
	public void persist(T t) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		em.persist(t);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void merge(T t) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		em.merge(t);
		DatabaseHelper.commitTxAndClose(em);
	}
	
}
