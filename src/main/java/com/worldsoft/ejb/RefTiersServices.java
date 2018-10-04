package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.EJBAccessException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.RefTier;
import com.worldsoft.domain.RefUser;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.RoleModel;
import com.worldsoft.model.TierModel;

@LocalBean
@Stateless
public class RefTiersServices {
	
	@PersistenceContext
	EntityManager em;
	
	public void addRefTier(RefTier refTier) {
		em.persist(refTier);
	}
	
	
	
	public void editRefTier(RefTier refTier) {
		em.merge(refTier);
	}
	
	public RefTier findRefTier(long id) {
		return em.find(RefTier.class, id);
	}
	
	
	public void deletRefTier(RefTier refTier){
		em.remove(em.merge(refTier));
	}
	
	public List<String> findAllRefTier(){
		Query query = em.createQuery("select u.adrTiers from RefTier u");
		return query.getResultList();
	}
	
	
	public RefUser authentification(String login , String pwd){
		Query query =	em.createQuery("select u from RefUtilisateur u where u.userLogin = :login and u.userPwd = crypte(:pwd)").setParameter("login", login ).setParameter("pwd", pwd);
		return (RefUser) query.getSingleResult();
		
		}
public List<TierModel> findIdRefTier() {
		
			Query query = em.createQuery(// new TierModel(idRefTiers, resSocial)
					"select new com.worldsoft.model.TierModel(u.idRefTiers, u.resSocial) from RefTier u");
			

			return query.getResultList();
		}


 public void addTier(TierModel refT) {
	 RefTier refTier = new RefTier();
	 long maxIdTier = 0;

		try {
			maxIdTier = (long) em.createQuery("select max(idRefTiers) from RefTier").getSingleResult();
		} catch (Exception e) {
		}
		maxIdTier++;
		refTier.setIdRefTiers(maxIdTier);
		refTier.setEmailClient(refT.getEmailClient());
		refTier.setMobTiers(refT.getMobTiers());
		refTier.setResSocial(refT.getResSocial());
		refTier.setAdrTiers(refT.getAdrTiers());
		refTier.setTelTiers(refT.getTelTiers());
		refTier.setTiersActif(refT.getTiersActif());
		refTier.setSiteTiers(refT.getSiteTiers());
	 em.persist(refTier);
 }
 public void editTier(TierModel refT){
	 RefTier refTier = new RefTier();
	 refTier.setIdRefTiers(refT.getIdRefTiers());
	 refTier.setEmailClient(refT.getEmailClient());
		refTier.setMobTiers(refT.getMobTiers());
		refTier.setResSocial(refT.getResSocial());
		refTier.setAdrTiers(refT.getAdrTiers());
		refTier.setTelTiers(refT.getTelTiers());
		refTier.setTiersActif(refT.getTiersActif());
		refTier.setSiteTiers(refT.getSiteTiers());
		em.merge(refTier);
 }
 public void deleteRefTier(long idRefTier) {
	 try{
		em.createQuery("delete from RefTier r where r.idRefTiers =:idRefTier ")
				.setParameter("idRefTier", idRefTier).executeUpdate();}
	 catch(Exception e){
		em.createQuery("delete from RefUtilisateur p where  p.idRefTiers =:idRefTier")
		.setParameter("idRefTier", idRefTier)
		.executeUpdate();
		
	 }
		
         System.out.println(idRefTier);
	}
 public List<TierModel> findAllRefTiers() {
		
		Query query = em
				.createQuery(//new TierModel(idRefTiers, resSocial, adrTiers, emailClient, mobTiers, siteTiers, tiersActif, telTiers)
					"select new com.worldsoft.model.TierModel(u.idRefTiers ,u.resSocial ,u.adrTiers ,u.emailClient ,u.mobTiers ,u.siteTiers ,u.tiersActif ,u.telTiers)from RefTier u ");
		return query.getResultList();

	}
 public List<TierModel> findRefTiersActif(String tiersActif) {
		
		Query query = em
				.createQuery(//new TierModel(idRefTiers, resSocial, adrTiers, emailClient, mobTiers, siteTiers, tiersActif, telTiers)
					"select new com.worldsoft.model.TierModel(u.idRefTiers ,u.resSocial ,u.adrTiers ,u.emailClient ,u.mobTiers ,u.siteTiers ,u.tiersActif ,u.telTiers)from RefTier u  where tiersActif =:tiersActif")
				.setParameter("tiersActif", tiersActif);
		return query.getResultList();

	}
	}

	
	
	
	
	
	


