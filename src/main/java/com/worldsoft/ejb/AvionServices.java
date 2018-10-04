package com.worldsoft.ejb;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.domain.ArrangementPK;
import com.worldsoft.domain.Avion;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.HotelModel;

@LocalBean
@Stateless
public class AvionServices {
	@PersistenceContext
	EntityManager em;
	public void addAvion() {
		Avion avion=new Avion();
		em.persist(avion);
	}
	
	
	
	public void editAvion(Avion avion) {
		em.merge(avion);
	}
	
	public Avion findAvion(long idAvion) {
		return em.find(Avion.class, idAvion);
	}
	
	
	public void deletAvion(Avion avion){
		em.remove(em.merge(avion));
	}
	
	public List<AvionModel> findAllAvion(){
		Query query = em.createQuery("select new com.worldsoft.model.AvionModel( u.idAvion ,u.abrvAvion) from Avion u");
		return query.getResultList();
	}
	
	
	
	public void addAvion1(AvionModel ajtA) {
		Avion avion = new Avion();
		long maxIdAvion = 0;

		try {
			maxIdAvion = (long) em.createQuery("select max(idAvion) from Avion").getSingleResult();
		} catch (Exception e) {
		}
		maxIdAvion++;
		avion.setIdAvion(maxIdAvion);
		
		
		
		
		avion.setTypeAvion(ajtA.getTypeAv());
		avion.setNomAvion(ajtA.getNomavion());
		avion.setAirline(ajtA.getAirline());
		avion.setAbrvAvion(ajtA.getAbrvAv());
		
		em.persist(avion);
	}
	public List<AvionModel> findAllavionsByAir(String airline) {
		System.out.println(airline);
		// AvionModel l =new  AvionModel(idavion, airline, nomavion, typeAv, abrvAv)
		Query query = em
				.createQuery(
						"select new com.worldsoft.model.AvionModel(u.idAvion ,u.airline ,u.nomAvion ,u.typeAvion ,u.abrvAvion)from Avion u where u.airline =:airline")
				.setParameter("airline", airline);
		return query.getResultList();

	}
	
	public List<AvionModel> findAir() {
		Query query = em.createQuery("select distinct new com.worldsoft.model.AvionModel(u.airline) from Avion u");
		return query.getResultList();
	}



//	public List<AvionModel> findAvionByAirLine(String airline) {
//		Query query = em
//				.createQuery(
//						"select new com.worldsoft.model.AvionModel(u.idAvion ,u.airline ,u.nomAvion) from Avion u where u.airline =:airline")
//				.setParameter("airline", airline);
//		return query.getResultList();
//	}
	public void deleteAvion(long idAvion) {
		em.createQuery("delete from Avion a where a.idAvion =:idAvion ")
				.setParameter("idAvion", idAvion).executeUpdate();
            System.out.println(idAvion);
	}
	public List<AvionModel> findAllavions() {
		// AvionModel l =new  AvionModel(idavion, airline, nomavion, typeAv, abrvAv)
		Query query = em
				.createQuery(
					"select new com.worldsoft.model.AvionModel(u.idAvion ,u.airline ,u.nomAvion ,u.typeAvion ,u.abrvAvion)from Avion u ");
		return query.getResultList();

	}
	public void editAvion(AvionModel ajtA) {
		System.out.println("Avion "+ ajtA);
		Avion avion = new Avion();
        avion.setAbrvAvion(ajtA.getAbrvAv());
        avion.setIdAvion(ajtA.getIdavion());
        avion.setNomAvion(ajtA.getNomavion());
		avion.setAirline(ajtA.getAirline());
		avion.setTypeAvion(ajtA.getTypeAv());
		
		em.merge(avion);

	}

	
}
