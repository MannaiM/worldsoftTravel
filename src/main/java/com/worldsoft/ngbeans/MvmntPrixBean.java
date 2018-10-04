package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.ArrangementServices;
import com.worldsoft.ejb.AvionServices;
import com.worldsoft.ejb.HotelServices;
import com.worldsoft.ejb.JourServices;
import com.worldsoft.ejb.MvmentPrixServices;
import com.worldsoft.ejb.PeriodeServices;
import com.worldsoft.ejb.TypeChambreServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.HotelModel;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.TypeChambreModel;
import com.worldsoft.model.mvtPrixHotelModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class MvmntPrixBean {

	@Inject
	MvmentPrixServices mvmntPrixServices;

	@Inject
	HotelServices hotelServices;

	@Inject
	TypeChambreServices typeChambreServices;

	@Inject
	ArrangementServices arrangementservices;

	@Inject
	JourServices jourservices;

	@Inject
	PeriodeServices periodeServices;
	@Inject
	AvionServices avionServices;
	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("mvtH", new mvtPrixHotelModel())
				.setProperty("category", hotelServices.findCategoriHotel())
				.setProperty("jours", jourservices.findAllJour())
				.setProperty("hotels", hotelServices.findAllHotel())
//				.setProperty("periodess", periodeServices.findAllPeriode())
//				.setProperty("arragss", arrangementservices.findAllArrangement())

               // .setProperty("airline", avionServices.findAir())
				.setProperty("avions", avionServices.findAllAvion());
	}

	@Get
	@NGReturn(model = "ajoutermvmntM")
	public String ajoutermvmnt(mvtPrixHotelModel mvtH) {
		System.out.println(mvtH.getIdPrix());
		try {
			mvmntPrixServices.addMvmentPrix(mvtH);
			return "chambres ajoutée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Get
	@NGReturn(model = "message")
	public String testMvt(mvtPrixHotelModel mvtH) {
		System.out.println(mvtH.getIdPrix());
		try {
			mvmntPrixServices.addMvmentPrixTest(mvtH);
			return "ligne ajoutée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Get
	@NGReturn(model = "hotels")
	public List<HotelModel> findHotelByCategoryermvmnt(String category) {
		return hotelServices.findHotelByCategoriHotel(category);
	}

	@Get
	@NGReturn(model = "periodes")
	public List<PeriodeModel> findPeriodeByHotel(String hotel) {
		return periodeServices.findPeriodeByHotel(hotel);
	}

	@Get
	@NGReturn(model = "arrangements")
	public List<ArrangementModel> findArrangementByHotel(String hotel) {
		return arrangementservices.findArrangementByHotel(hotel);
	}

	@Get
	@NGReturn(model = "typeChambres")
	public List<TypeChambreModel> findTypeChambreByHotel(String hotel) {
		return typeChambreServices.findTypeChambreByHotel(hotel);
	}
	
	@Get
	@NGReturn(model = "mvtPrixHs")
	public List<mvtPrixHotelModel>findAllMvmentPrixHotel(String hotel) {
		return mvmntPrixServices.findAllMvmentPrixHotel(hotel);
				
	}
	
	@Get
	@NGReturn(model = "editmvtHM")
	public String editMvtPrixH(mvtPrixHotelModel mvtH) {
		System.out.println(mvtH.getIdPrix());
		try {
			mvmntPrixServices.editMvtPrixH(mvtH);
			return "Modification terminée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Get
	@NGReturn(model = "mvtPrixHs")
	public List<mvtPrixHotelModel> deletemvtH(String idprix, String idHotel) {
		mvmntPrixServices.deletemvtH(idprix );
		return mvmntPrixServices.findAllMvmentPrixHotel(idHotel);
	}
}
