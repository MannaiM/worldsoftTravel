package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.domain.MvmentPrix;
import com.worldsoft.domain.Promotion;
import com.worldsoft.ejb.MvmentPrixServices;
import com.worldsoft.ejb.PromotionServices;
import com.worldsoft.ejb.ReductionServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.PromotionModel;
import com.worldsoft.model.ReductionModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class ReductionBean {
	@Inject
	ModelQuery modelQuery;

	@Inject
	ReductionServices reductionServices;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("red", new ReductionModel());
	}

	@Get
	@NGReturn(model = "ajouterRedM")
	public String addReduction(ReductionModel red) {
		try {
			reductionServices.addReduction(red);
			return "Reduction ajoutée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Get
	@NGReturn(model = "editRedM")
	public String editReduction(ReductionModel red) {
		System.out.println(red.getIdReduction());
		try {
			reductionServices.editReduction(red);
			return "Reduction Modifié";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Get
	@NGReturn(model = "reductions")
	public List<ReductionModel> deleteReduction(long idHotel ,long idPeriode , long idReduction) {
		reductionServices.deleteReduction(idHotel, idPeriode, idReduction);
		return reductionServices.findReductions();
	}

//findPromotions()

@Get
@NGReturn(model = "reductions")
public List<ReductionModel> findReductions() {
	return reductionServices.findReductions();
}
}
