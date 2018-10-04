package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Jour;
import com.worldsoft.model.JourModel;

@LocalBean
@Stateless
public class JourServices {
	@PersistenceContext
	EntityManager em;
	public void addJour(Jour jour) {
		em.persist(jour);
	}
	
	
	
	public void editjour(Jour jour) {
		em.merge(jour);
	}
	
	public Jour findjour(long idJour) {
		return em.find(Jour.class, idJour);
	}
	
	
	public void deletAvion(Jour jour){
		em.remove(em.merge(jour));
	}
	
	public List<JourModel> findAllJour(){
		Query query = em.createQuery("select new com.worldsoft.model.JourModel( u.idJour ,u.nomJour) from Jour u");
		return query.getResultList();
	}
	
}
