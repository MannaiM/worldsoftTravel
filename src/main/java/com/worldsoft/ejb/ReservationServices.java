package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Reservation;
import com.worldsoft.model.ReservationModel;


@LocalBean
@Stateless

public class ReservationServices {
	@PersistenceContext
	EntityManager em;

	public void addReservation(Reservation reservation) {
		em.persist(reservation);
	}

	public void editReservation(Reservation reservation) {
		em.merge(reservation);
	}

	public Reservation findReservation(long idReserv) {
		return (Reservation) em.createQuery("select u from Reservation u where u.id.idReserv =:p1")
				.setParameter("p1", idReserv).getResultList();
	}

	public void deletReservation(Reservation reservation) {
		em.remove(em.merge(reservation));
	}

	public List<Reservation> findAllReservation() {
		Query query = em.createQuery("select u from Reservation u");
		return query.getResultList();
	}
	public List<ReservationModel> findReservationbyRefTier(long idRefTier){
		Query query = em
				.createQuery(//new ReservationModel(idRefTiers, idReserv, dateReserv, lResr, prix)
						"select new com.worldsoft.model.ReservationModel(u.refTier.idRefTiers ,u.id.idReserv ,u.dateReserv ,u.lResr ,u.prix) from Reservation u where  u.refTier.idRefTiers =:idRefTier")
 		.setParameter("idRefTier", idRefTier);
		return query.getResultList();
	}
	public List<ReservationModel> findReservations(){
		Query query = em
				.createQuery(//new ReservationModel(idRefTiers, idReserv, dateReserv, lResr, prix)
						"select new com.worldsoft.model.ReservationModel(u.refTier.idRefTiers ,u.id.idReserv ,u.dateReserv ,u.lResr ,u.prix) from Reservation u ");
 		
		return query.getResultList();
	}
	
	public void deleteRes(long idRefTier, long idRes) {
		
		em.createQuery("delete from Reservation r where r.id.idRefTiers =:idRefTier and r.id.idReserv=:idRes")
				.setParameter("idRefTier", idRefTier).setParameter("idRes", idRes).executeUpdate();
		System.out.println(idRes + "   " + idRefTier);
	}


}
