package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.ArrangementServices;
import com.worldsoft.ejb.HotelServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.HotelModel;
import com.worldsoft.model.PeriodeModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class AjouterArrBean {
	@Inject
	ArrangementServices arrangementServices;
	@Inject
	HotelServices hotelServices;
	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("ajtArr", new ArrangementModel()).setProperty("hotels", hotelServices.findAllHotel());
	}

	@Get
	@NGReturn(model = "ajouterArranM")
	public String ajouterArran(ArrangementModel ajtArr) {
		System.out.println(ajtArr.getIdarr());
		try {
			arrangementServices.addArrangementH(ajtArr);
			return "arrangement ajouté";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Get
	@NGReturn(model = "editArranM")
	public String editArran(ArrangementModel ajtArr) {
		System.out.println(ajtArr.getIdarr());
		try {
			arrangementServices.editArrangementH(ajtArr);
			return "arrangement Modifié";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Get
	@NGReturn(model = "arrangements")
	public List<ArrangementModel> findArrangementByHotel(String hotel) {
		return arrangementServices.findArrangementByHotell(hotel);
	}

	@Get
	@NGReturn(model = "arrangements")
	public List<ArrangementModel> deleteArrangement(long idArrangement, long idHotel) {
		arrangementServices.deleteArrangement(idArrangement, idHotel);
		return arrangementServices.findArrangementByHotell(idHotel + "");
	}

}
