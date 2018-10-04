package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.HotelServices;
import com.worldsoft.ejb.PeriodeServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.PeriodeModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class PeriodeBean {
	@Inject
	HotelServices hotelServices;
	@Inject
	PeriodeServices periodeServices;
	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("ajtP", new PeriodeModel()).setProperty("hotels", hotelServices.findAllHotel());
	}

	@Get
	@NGReturn(model = "ajouterPerM")
	public String ajouterPer(PeriodeModel ajtP) {
		System.out.println(ajtP.getIdP());
		try {
			periodeServices.addPeriodeH(ajtP);
			return "Periode  ajoutée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Get
	@NGReturn(model = "periodes")
	public List<PeriodeModel> deletePeriode(long idPeriode, long idHotel) {
		periodeServices.deletePeriode(idPeriode, idHotel);
		return periodeServices.findPeriodeByHotels(idHotel + "");
	}

	@Get
	@NGReturn(model = "periodes")
	public List<PeriodeModel> findPeriodeByHotels(String hotel) {
		return periodeServices.findPeriodeByHotels(hotel);
	}
	@Get
	@NGReturn(model = "editPeriodeM")
	public String editPeriode(PeriodeModel prd) {
		System.out.println(prd.getIdP());
		try {
			periodeServices.editPeriode(prd);
			return "Periode Modifié";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
