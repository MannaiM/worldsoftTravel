package com.worldsoft.ngbeans;

import javax.inject.Inject;

import com.worldsoft.domain.RefUser;
import com.worldsoft.domain.RefUtilisateur;
import com.worldsoft.ejb.RefUserServices;
import com.worldsoft.ejb.RefUtilisateurServices;

import angularBeans.api.AngularBean;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;

@AngularBean
public class AuthentificationBean {

	// @Inject
	// RefUtilisateurServices refUtilisateurServices;
	@Inject
	RefUserServices refUserServices;

	@Get
	@NGReturn(model = "user")

	/*
	 * public RefUtilisateur sauthentifier(String login, String pwd) { try {
	 * RefUtilisateur utilisateur =
	 * refUtilisateurServices.authentification(login, pwd);
	 * System.out.println(utilisateur.getNomRefUtilisateur()); return
	 * utilisateur; } catch (Exception e) { return null; } }
	 */
	public RefUser sauthentifier(String login, String pwd) {
		try {
			RefUser usere = refUserServices.authentification(login, pwd);
			System.out.println(usere.getNomUser());
			return usere;
		} catch (Exception e) {
			return new RefUser(0);
		}
	}

}
