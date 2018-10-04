package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Hotel;
import com.worldsoft.domain.Jour;
import com.worldsoft.domain.Promotion;
import com.worldsoft.domain.Reduction;
import com.worldsoft.domain.ReductionPK;
import com.worldsoft.model.PromotionModel;
import com.worldsoft.model.ReductionModel;
@LocalBean
@Stateless
public class ReductionServices {
	@PersistenceContext
	EntityManager em;
	
	public void addReduction(Reduction reduction) {
		em.persist(reduction);
	}
	
	
	
	public void editReduction(Reduction reduction) {
		em.merge(reduction);
	}
	
	public Reduction findReduction(ReductionPK id) {
		return em.find(Reduction.class, id);
	}
	
	
	public void deletReduction(Reduction reduction){
		em.remove(em.merge(reduction));
	}
	
	public List<String> findAllReduction(){
		Query query = em.createQuery("select u.abrvReduction from Reduction u");
		return query.getResultList();
}
	
	public void deleteReduction(long idHotel ,long idPeriode, long idReduction ) {
		em.createQuery("delete from Reduction r where r.id.idHotel =:idHotel and p.id.idPeriode=:idPeriode and p.id.idReduction =:idReduction")
				.setParameter("idHotel", idHotel)
		        .setParameter("idPeriode", idPeriode)
		       .setParameter("idReduction", idReduction).executeUpdate();
		
		System.out.println("cc" );
	}
	public void editReduction(ReductionModel red) {
		System.out.println("Reduction "+ red);
		Reduction reduction = new Reduction();

		reduction.setActifReduction(red.getActifReduction());
		reduction.setAbrvReduction(red.getAbrvReduction());
		
        em.merge(reduction);
	}
	public List<ReductionModel> findReductions() {
		Query query = em.createQuery( //new ReductionModel(abrvReduction, actifReduction, lReduction, idHotel, idPeriode, idReduction)
				"select new com.worldsoft.model.ReductionModel(r.abrvReduction , r.actifReduction , r.lReduction , r.hotel.idHotel , r.periode.id.idPeriode , r.id.idReduction ) from Reduction r");
		return query.getResultList();
	}
	public void addReduction(ReductionModel red) {
		Reduction reduction = new Reduction();

		long maxIdreduc = 0;

		try {
			maxIdreduc = (long) em.createQuery("select max(r.id.idReduction) from Reduction r where r.id.idHotel =:idHotel and r.id.idPeriode =:idPeriode")
					.setParameter("idHotel", red.getIdHotel())
					.setParameter("idPeriode", red.getIdPeriode())
					.getSingleResult();
		} catch (Exception e) {
		}
		maxIdreduc++;
		reduction.setIdHotel( red.getIdHotel());
		reduction.setIdPeriode(red.getIdPeriode());
		reduction.setAbrvReduction(red.getAbrvReduction());
		reduction.setLReduction(red.getlReduction());
        reduction.setFlagServ(red.getFlag());
		reduction.setActifReduction(red.getActifReduction());
		em.persist(reduction);
	}
}
