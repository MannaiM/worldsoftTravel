package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.domain.MvmentPrix;
import com.worldsoft.domain.Promotion;
import com.worldsoft.ejb.MvmentPrixServices;
import com.worldsoft.ejb.PromotionServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.PromotionModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class PromotionBean {
	@Inject
	ModelQuery modelQuery;

	@Inject
	PromotionServices promotionServices;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("prm", new PromotionModel());
	}

	@Get
	@NGReturn(model = "ajouterPrmM")
	public String ajouterPrm(PromotionModel prm) {
		try {
			promotionServices.addPromotionP(prm);
			return "Promotion ajoutée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Get
	@NGReturn(model = "editPromoM")
	public String editPromotion(PromotionModel prm) {
		System.out.println(prm.getIdjour());
		try {
			promotionServices.editPromotion(prm);
			return "Promotion Modifié";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Get
	@NGReturn(model = "promotions")
	public List<PromotionModel> deletePromotion(long idPromo) {
		promotionServices.deletePromotion(idPromo);
		return promotionServices.findPromotions();
	}

//findPromotions()

@Get
@NGReturn(model = "periodes")
public List<PromotionModel> findAllPromotion() {
	return promotionServices.findPromotions();
}
}
