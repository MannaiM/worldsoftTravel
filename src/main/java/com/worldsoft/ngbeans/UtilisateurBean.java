package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.domain.MvmentPrix;
import com.worldsoft.domain.RefUser;
import com.worldsoft.domain.RefUtilisateur;
import com.worldsoft.ejb.MvmentPrixServices;
import com.worldsoft.ejb.RefTiersServices;
import com.worldsoft.ejb.RefUserServices;
import com.worldsoft.ejb.RefUtilisateurServices;
import com.worldsoft.ejb.RoleServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.UserModel;
import com.worldsoft.model.UtilisateurModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class UtilisateurBean {
	@Inject
	RefTiersServices refTiersService;

	@Inject
	RefUtilisateurServices refUtilisateurServices;

	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("utilis", new UtilisateurModel())
		.setProperty("utilisateurs", refUtilisateurServices.findAllUtilisateur())
		.setProperty("tiers", refTiersService.findIdRefTier());
	}

	@Get
	@NGReturn(model = "ajouterutilisateurM")
	public String ajouterutilisateur(UtilisateurModel utilis) {
		
		System.out.println(utilis);
		try {
			refUtilisateurServices.addRefUtilisateur(utilis);
			return "utilisateur ajouté";
		} catch (Exception e) {
			return null;
		}
	}
	@Get
	@NGReturn(model = "utilisateurs")
	public List<UtilisateurModel> deleteUtilis(long idUtilis) {
		refUtilisateurServices.deleteUtilis(idUtilis);
		return refUtilisateurServices.findAllUtilisateur();
	}
	
	
	@Get
	@NGReturn(model = "utilisateurs")
	public List<UtilisateurModel> findUtilisbyTier(String refTier) {
		return refUtilisateurServices.findUtilisbyTier(refTier);
	}
}
