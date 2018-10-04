package com.worldsoft.ejb;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.domain.ArrangementPK;
import com.worldsoft.domain.Periode;
import com.worldsoft.domain.PeriodePK;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.PeriodeModel;

import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;

@LocalBean
@Stateless
public class PeriodeServices {
	@PersistenceContext
	EntityManager em;

	public void addPeriode(Periode periode) {

		em.persist(periode);
	}

	public void editPeriode(Periode periode) {
		em.merge(periode);
	}

	public Periode findPeriode(PeriodePK id) {
		return em.find(Periode.class, id);
	}

	public void deletPeriode(Periode periode) {
		em.remove(em.merge(periode));
	}

	public List<PeriodeModel> findPeriodeByHotel(String hotel) {
		Query query = em
				.createQuery(
						"select new com.worldsoft.model.PeriodeModel( u.id.idPeriode ,u.abrvPeriode)from Periode u where u.id.idHotel =:hotel")
				.setParameter("hotel", Long.parseLong(hotel));
		return query.getResultList();
	}

	public List<PeriodeModel> findPeriodeByHotels(String hotel) {
		//PeriodeModel pm = new PeriodeModel(idP, nomP, lblP, dtDeb, dtFin, idHotel)

		Query query = em
				.createQuery(
						"select new com.worldsoft.model.PeriodeModel( u.id.idPeriode, u.abrvPeriode, u.lPeriode, u.dtDebut, u.dtFin , u.id.idHotel ,u.closed)from Periode u where u.id.idHotel =:hotel")
				.setParameter("hotel", Long.parseLong(hotel));
		return query.getResultList();
	}

	public List<PeriodeModel> findAllPeriode() {
		Query query = em.createQuery(
				"select new com.worldsoft.model.PeriodeModel( u.id.idPeriode ,u.abrvPeriode)from Periode u");
		return query.getResultList();
	}

	/*
	 * public List<String> findjour(String jr) { Calendar date1 =
	 * Calendar.getInstance(); date1.set(2016, 04, 02); while
	 * (date1.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
	 * date1.add(Calendar.DATE, 1); } Periode periode = new Periode();
	 * periode.getDtDebut(); periode.getDtFin();
	 * 
	 * 
	 * System.out.println(periode); }
	 */

	public void addPeriodeH(PeriodeModel ajtP) {
		Periode periode = new Periode();
		long maxIdP = 0;

		try {
			maxIdP = (long) em.createQuery("select max(p.id.idPeriode) from Periode p where p.id.idHotel=:idHotel")
					.setParameter("idHotel", Long.parseLong(ajtP.getIdHotel())).getSingleResult();
		} catch (Exception e) {
		}
		maxIdP++;
		PeriodePK periodePK = new PeriodePK(Integer.parseInt(ajtP.getIdHotel()), maxIdP);
		periode.setId(periodePK);
		periode.setAbrvPeriode(ajtP.getNomP());
		periode.setLPeriode(ajtP.getLblP());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			periode.setDtDebut(dateFormat.parse(ajtP.getDtDeb()));
			periode.setDtFin(dateFormat.parse(ajtP.getDtFin()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		periode.setClosed(ajtP.getClose());

		em.persist(periode);
	}

	public void deletePeriode(long idPeriode, long idHotel) {
		em.createQuery("delete from Periode p where p.id.idPeriode =:idPeriode and p.id.idHotel=:idHotel")
				.setParameter("idHotel", idHotel).setParameter("idPeriode", idPeriode).executeUpdate();

	}
	public void editPeriode(PeriodeModel ajtP) {
		System.out.println("Periode "+ ajtP);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Periode periode = new Periode();

		//periode.setClosed(ajtP.getClose());
		
		try {
		periode.setDtDebut(dateFormat.parse(ajtP.getDtDeb()));
		periode.setDtFin(dateFormat.parse(ajtP.getDtFin()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		periode.setClosed(ajtP.getClose());
		periode.setLPeriode(ajtP.getLblP());
		periode.setAbrvPeriode(ajtP.getNomP());
		PeriodePK periodePK = new PeriodePK(Integer.parseInt(ajtP.getIdHotel()), ajtP.getIdP());
		periode.setId(periodePK);
		em.merge(periode);
		System.out.println("Periode 2avrv "+ ajtP);
	}

}
