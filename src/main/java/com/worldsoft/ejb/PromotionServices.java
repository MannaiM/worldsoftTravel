package com.worldsoft.ejb;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.domain.ArrangementPK;
import com.worldsoft.domain.Jour;
import com.worldsoft.domain.Promotion;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.PromotionModel;

@LocalBean
@Stateless
public class PromotionServices {
	@PersistenceContext
	EntityManager em;
	
	public void addPromotion(Promotion promotion) {
		em.persist(promotion);
	}
	
	
	
	public void editPromotion(Promotion promotion) {
		em.merge(promotion);
	}
	
	public Promotion findPromotion(long idPromo) {
		return em.find(Promotion.class, idPromo);
	}
	
	
	public void deletPromotion(Promotion promotion){
		em.remove(em.merge(promotion));
	}
	
	public List<String> findAllPromotion(){
		Query query = em.createQuery("select u.abrvPromotion from Promotion u");
		return query.getResultList();
}
	
	public void addPromotionP(PromotionModel prm) {
		Promotion promotion = new Promotion();

		long maxIdPromotion = 0;

		try {
			maxIdPromotion = (long) em.createQuery("select max(idPromo) from Promotion").getSingleResult();
		} catch (Exception e) {
		}
		maxIdPromotion++;
		promotion.setIdPromo(maxIdPromotion);
		promotion.setAbrvPromotion(prm.getAbrvP());
		promotion.setFlagServ(prm.getFlag());
		promotion.setLProm(prm.getLablP());
//		promotion.setIdChm(Long.parseLong(prm.getIdchm()));
//		promotion.setIdHotel(prm.getIdhotel());
		Jour jour = new Jour();
		jour.setIdJour(1);
		promotion.setJour(jour);
		
		
		
		em.persist(promotion);
	}
	public void deletePromotion(long idPromo) {
		em.createQuery("delete from Promotion p where  p.idPromo=:idPromo")
				.setParameter("idPromo", idPromo).executeUpdate();
		System.out.println(idPromo );
	}
	public void editPromotion(PromotionModel prm) {
		System.out.println("Promotion "+ prm);
		Promotion promotion = new Promotion();

		promotion.setIdChm(Integer.parseInt(prm.getIdchm()));
		
        em.merge(promotion);
	}
	public List<PromotionModel> findPromotions() {
		Query query = em.createQuery( //new PromotionModel(idhotel, idchm, idjour, idPromo, abrvP)
				"select new com.worldsoft.model.PromotionModel(u.hotel.idHotel ,u.typeChambre.idChm ,u.jour.idJour ,u.idPromo , u.abrvPromotion ) from Promotion u");
		return query.getResultList();
	}
}
