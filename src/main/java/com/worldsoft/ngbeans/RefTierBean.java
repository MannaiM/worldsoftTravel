package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.AvionServices;
import com.worldsoft.ejb.RefTiersServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.TierModel;
import com.worldsoft.model.mvtPrixHotelModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class RefTierBean {
	@Inject
	RefTiersServices refTiersServices;

	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("refT", new TierModel())
		.setProperty("tiers", refTiersServices.findAllRefTiers());
}
	
	@Get
	@NGReturn(model = "ajouterRefM")
	public String ajouterTier(TierModel refT) {
		System.out.println(refT.getResSocial());
		try {
			refTiersServices.addTier(refT);
			return "tiers ajoutée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Get
	@NGReturn(model = "tiers")
	public List<TierModel> findRefTiersActif(String tiersActif) {
		return refTiersServices.findRefTiersActif(tiersActif);
	}
	
	
	@Get
	@NGReturn(model = "tiers")
	public List<TierModel> deleteTier(long idRefTier) {
		refTiersServices.deleteRefTier(idRefTier);
		return refTiersServices.findAllRefTiers();
	}
	
	@Get
	@NGReturn(model = "editTierM")
	public String editTier(TierModel refT) {
		System.out.println(refT.getIdRefTiers());
		try {
			refTiersServices.editTier(refT);
			return "avion Modifié";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	
}