package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.AvionServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.mvtPrixHotelModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class AjouterABean {
	@Inject
	AvionServices avionServices;

	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("ajtA", new AvionModel())
		.setProperty("avions", avionServices.findAllavions())
		.setProperty("airlines", avionServices.findAir());
}
	
	@Get
	@NGReturn(model = "ajouterAvionM")
	public String ajouterAvion(AvionModel ajtA) {
		System.out.println(ajtA.getNomavion());
		try {
			avionServices.addAvion1(ajtA);
			return "avion ajoutée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Get
	@NGReturn(model = "avions")
	public List<AvionModel> findAllavionsByAir(String airline) {
		return avionServices.findAllavionsByAir(airline);
	}
	
	
	@Get
	@NGReturn(model = "avions")
	public List<AvionModel> deleteAvion(long idAvion) {
		avionServices.deleteAvion(idAvion);
		return avionServices.findAllavions();
	}
	
	@Get
	@NGReturn(model = "editAvionM")
	public String editAvion(AvionModel ajtA) {
		System.out.println(ajtA.getIdavion());
		try {
			 avionServices.editAvion(ajtA);
			return "avion Modifié";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	
}