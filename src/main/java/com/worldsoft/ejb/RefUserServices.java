package com.worldsoft.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Jour;
import com.worldsoft.domain.Periode;
import com.worldsoft.domain.PeriodePK;
import com.worldsoft.domain.RefUser;
import com.worldsoft.domain.RefUtilisateur;
import com.worldsoft.domain.Role;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.UserModel;

@LocalBean
@Stateless
public class RefUserServices {

	@PersistenceContext
	EntityManager em;
	

	
	public void addRefUser() {
		long idU = new Long(2);
		String nom = new String("Maha");
		String login = new String("MS");
		String pwd = new String("MS");
		RefUser refUser = new RefUser();
		refUser.setIdUsers(idU);
		refUser.setNomUser(nom);
		Role role = new Role();
		role.setIdRole(1);
		refUser.setRole(role);
		refUser.setUserLogin(login);
		refUser.setUserPwd(pwd);

		em.persist(refUser);
	}

	public void ediRefUser(RefUser refUser) {
		em.merge(refUser);
	}

	public RefUser findRefUser(long idUsers) {
		return em.find(RefUser.class, idUsers);
	}

	public void deletRefUser(RefUser refUser) {
		//RefUser refUser = new RefUser();
		refUser.getIdUsers();
		//IdUsers = (long) em.createQuery("select idUsers from RefUser").getSingleResult();
		em.remove(em.merge(refUser));
	}

	public List<PeriodeModel> findAllRefUser() {
		Query query = em.createQuery("select u.idUsers from refUser u");
		return query.getResultList();
	}
	
	
	public RefUser authentification(String login, String pwd) {
		System.out.println(login +" "+pwd);
		Query query = em
				.createQuery(
						"select u from RefUser u where u.userLogin = :login and u.userPwd = :pwd")
				.setParameter("login", login).setParameter("pwd", pwd);
		return (RefUser) query.getSingleResult();
		}

	public void afficheU(){
		
		Query query = em
				.createQuery( "select u.nomUser, u.userLogin  from RefUser u where u.userLogin = :login and u.userPwd = :pwd")
		;
	
		System.out.println(query.getSingleResult());
		
	}
	
	public void addRefUser(RefUser user) {
		long maxIdUsers = 0;

		try {
			maxIdUsers = (long) em.createQuery("select max(idUsers) from RefUser").getSingleResult();
		} catch (Exception e) {
		}
		maxIdUsers++;
		user.setIdUsers(maxIdUsers);
		
		em.persist(user);
		// TODO Auto-generated method stub

	}
	
	public List<UserModel> findAllUser() {
	Query query = em.createQuery(//new UserModel(idUser, nomUser, userLogin, userPwd, idRole)
			"select new com.worldsoft.model.UserModel( u.idUsers ,u.nomUser ,u.userLogin ,u.userPwd,u.role.lRole) from RefUser u");
			return query.getResultList();
		}

	public void deleteUser(long idUser) {
		
			em.createQuery("delete from RefUser a where a.idUsers =:idUser ")
			.setParameter("idUser", idUser).executeUpdate();
        System.out.println(idUser);
}
		
	}
	

