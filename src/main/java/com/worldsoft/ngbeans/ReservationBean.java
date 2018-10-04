package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.ArrangementServices;
import com.worldsoft.ejb.HotelServices;
import com.worldsoft.ejb.RefTiersServices;
import com.worldsoft.ejb.ReservationServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.HotelModel;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.ReservationModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class ReservationBean {
	@Inject
	ReservationServices reservationServices;
	@Inject
	RefTiersServices 	refTiersServices;
	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("res", new ReservationModel())
		.setProperty("reservations", reservationServices.findReservations())
		.setProperty("tiers", refTiersServices.findIdRefTier());
	}

	@Get
	@NGReturn(model = "reservations")
	public List<ReservationModel> findReservationbyRefTier(long idRefTier) {
		return reservationServices.findReservationbyRefTier( idRefTier);
	}

	@Get
	@NGReturn(model = "reservations")
	public List<ReservationModel> deleteRes(long idRefTier, long idRes) {
		reservationServices.deleteRes(idRefTier, idRes);
		return reservationServices.findReservationbyRefTier(idRefTier );
	}

}
