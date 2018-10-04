package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.RefFonction;
@LocalBean
@Stateless
public class RefFonctionServices {
	@PersistenceContext
	EntityManager em;
	
	public void addRefFonction(RefFonction refFonction) {
		em.persist(refFonction);
	}
	
	
	
	public void editRefFonction(RefFonction refFonction) {
		em.merge(refFonction);
	}
	
	public RefFonction findRefFonction(long idFonction) {
		return em.find(RefFonction.class, idFonction);
	}
	
	
	public void deletRefFonction(RefFonction refFonction){
		em.remove(em.merge(refFonction));
	}
	
	public List<String> findAllRefFonction(){
		Query query = em.createQuery("select u from RefFonction u");
		return query.getResultList();
}
}
