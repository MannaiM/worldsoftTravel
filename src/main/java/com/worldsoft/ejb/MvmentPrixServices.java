package com.worldsoft.ejb;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.domain.ArrangementPK;
import com.worldsoft.domain.Avion;
import com.worldsoft.domain.ClassVol;
import com.worldsoft.domain.ClassVolPK;
import com.worldsoft.domain.Hotel;
import com.worldsoft.domain.Jour;
import com.worldsoft.domain.MvmentPrix;
import com.worldsoft.domain.TypeChambre;
import com.worldsoft.domain.TypeChambrePK;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.DtDebutFinPeriode;
import com.worldsoft.model.HotelModel;
import com.worldsoft.model.mvtPrixHotelModel;
import com.worldsoft.model.mvtPrixSejourModel;
import com.worldsoft.model.mvtPrixVolModel;

@LocalBean
@Stateless
public class MvmentPrixServices {

	@PersistenceContext
	EntityManager em;

	public void addMvmentPrix2() {

		MvmentPrix mvmentPrix = new MvmentPrix();
		try {
			mvmentPrix.setIdPrix(((BigDecimal) em.createQuery("select max(idPrix) from MvmentPrix").getSingleResult())
					.add(new BigDecimal(1)));
		} catch (Exception e) {
			// TODO: handle exception
		}

		BigDecimal prixAchat = new BigDecimal(70);
		BigDecimal prixVente = new BigDecimal(100);

		Jour jour = new Jour();
		jour.setIdJour(1);
		mvmentPrix.setJour(jour);

		Hotel hotel = new Hotel();
		hotel.setIdHotel(1);
		mvmentPrix.setHotel(hotel);

		mvmentPrix.setIdPeriode(1);

		mvmentPrix.setIdChm(1);
		mvmentPrix.setIdArrangement(1);

		Arrangement arg = new Arrangement();
		ArrangementPK arrangementPK = new ArrangementPK(1, 1);
		arg.setId(arrangementPK);
		mvmentPrix.setArrangement(arg);

		TypeChambre chambre = new TypeChambre();
		TypeChambrePK chambrePK = new TypeChambrePK(1, 1);
		chambre.setId(chambrePK);
		mvmentPrix.setTypeChambre(chambre);

		mvmentPrix.setPrixAchat(prixAchat);
		mvmentPrix.setPrixVente(prixVente);

		em.persist(mvmentPrix);
	}

	public void ajouterVol() {
		MvmentPrix mvmentPrix = new MvmentPrix();

		em.persist(mvmentPrix);

	}

	public void calculeMarge() {
    
	}

	public void editMvmentPrix(mvtPrixHotelModel mvtH) {
		em.merge(mvtH);
	}

	public MvmentPrix findMvmentPrix(long idPrix) {
		return em.find(MvmentPrix.class, idPrix);
	}

	public void deletMvmentPrix(MvmentPrix mvmentPrix) {
		em.remove(em.merge(mvmentPrix));
	}

	public List<String> findAllMvmentPrix() {
		Query query = em.createQuery("select u from MvmentPrix u");
		return query.getResultList();
	}

	public List<mvtPrixHotelModel> findAllMvmentPrixHotel(String hotel) {
		// mvtPrixHotelModel mv =new mvtPrixHotelModel(idPeriode, prixVente,
		// marge, prixAchat, nbreChm, idPrix, idArrangement, idChm)

		Query query = em
				.createQuery(// new mvtPrixHotelModel(idPeriode, prixVente,
								// marge, prixAchat, nbreChm, idPrix,
								// idArrangement, idChm)
						"select new com.worldsoft.model.mvtPrixHotelModel(u.periode.id.idPeriode , u.prixVente ,u.marge , u.prixAchat ,u.nbreChm ,u.idPrix ,u.arrangement.id.idArrangement , u.typeChambre.id.idChm) from MvmentPrix u where u.hotel.idHotel=:idhotel")
				.setParameter("idhotel", Long.parseLong(hotel));
		System.out.println("all the mvtPrix sont affichés");
		return query.getResultList();
	}
	// public BigDecimal maxIdPrix(maxi){
	// Query query = em.createQuery("select max(u.idPrix) as maxi from
	// MvmentPrix u");
	// return maxi;

	// }
	public void addMvmentPrix(mvtPrixHotelModel mvtH) {
		System.out.println(mvtH);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		BigDecimal maxIdPrix = new BigDecimal(0);
		try {
			maxIdPrix = (BigDecimal) em.createQuery("select max(idPrix) from MvmentPrix").getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (maxIdPrix == null) {
			maxIdPrix = new BigDecimal(0);
		}
		System.out.println("maxId " + maxIdPrix);
		maxIdPrix = maxIdPrix.add(new BigDecimal(1));

		for (String idArrangement : mvtH.getArrangements()) {
			for (String idJour : mvtH.getJours()) {
				BigDecimal numJour = (BigDecimal) em.createQuery("select j.numJour from Jour j WHERE j.idJour =:idJour")
						.setParameter("idJour", Long.parseLong(idJour)).getSingleResult();

				DtDebutFinPeriode dtDebutFinPeriode = (DtDebutFinPeriode) em
						.createQuery(
								"Select new com.worldsoft.model.DtDebutFinPeriode(u.dtDebut , u.dtFin) from Periode u where u.id.idPeriode =:idPeriode and u.id.idHotel =:idHotel")
						.setParameter("idPeriode", Long.parseLong(mvtH.getIdPeriode()))
						.setParameter("idHotel", Long.parseLong(mvtH.getIdHotel())).getSingleResult();

				Calendar dateDebut = Calendar.getInstance();
				dateDebut.setTime(dtDebutFinPeriode.getDtDebut());

				while (!(dateFormat.format(dtDebutFinPeriode.getDtDebut())
						.equals(dateFormat.format(dtDebutFinPeriode.getDtFin())))) {
					Boolean trouv = false;
					if (numJour.equals(new BigDecimal(1))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(2))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(3))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(4))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(5))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(6))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(7))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
							trouv = true;
						}
					}

					if (trouv) {

						for (String idTypeChambres : mvtH.getTypeChambres()) {
							// System.out.println("cc type chambre");
							MvmentPrix mvtPrixH = new MvmentPrix();

							mvtPrixH.setIdHotel(Long.parseLong(mvtH.getIdHotel()));

							Jour jour = new Jour();
							jour.setIdJour(Long.parseLong(idJour));
							mvtPrixH.setJour(jour);

							Hotel hotel = new Hotel();
							hotel.setIdHotel(Integer.parseInt(mvtH.getIdHotel()));
							mvtPrixH.setHotel(hotel);

							mvtPrixH.setIdPeriode(Integer.parseInt(mvtH.getIdPeriode()));

							mvtPrixH.setIdArrangement(Integer.parseInt(idArrangement));
							mvtPrixH.setFlag('H');
							mvtPrixH.setActifPrix('O');
							Arrangement arg = new Arrangement();
							ArrangementPK arrangementPK = new ArrangementPK(Integer.parseInt(mvtH.getIdHotel()),
									Integer.parseInt(idArrangement));
							arg.setId(arrangementPK);
							mvtPrixH.setArrangement(arg);
							mvtPrixH.setIdChm(Integer.parseInt(idTypeChambres));
							TypeChambre chambre = new TypeChambre();
							TypeChambrePK chambrePK = new TypeChambrePK(Integer.parseInt(mvtH.getIdHotel()),
									Integer.parseInt(idTypeChambres));
							chambre.setId(chambrePK);
							mvtPrixH.setTypeChambre(chambre);

							mvtPrixH.setPrixAchat(new BigDecimal(mvtH.getPrixAchat()));
							mvtPrixH.setPrixVente(new BigDecimal(mvtH.getPrixVente()));
							mvtPrixH.setNbreChm(new BigDecimal(mvtH.getNbreChm()));
							//calculer la marge 
							
							long mrg = 0;
							try {
								mrg = (Integer.parseInt(mvtH.getPrixAchat()) - Integer.parseInt(mvtH.getPrixVente()));
								}
							catch (Exception e) {
								// TODO: handle exception
							}
							
							//mvtPrixH.setMarge(new BigDecimal(mvtH.getMarge()));
							mvtPrixH.setMarge(new BigDecimal(mrg));
							//calculer le tx
							
							BigDecimal txMrg = new BigDecimal(0);
							try {
								txMrg = (new BigDecimal( (Integer.parseInt(mvtH.getPrixAchat()) * mrg )/100) );
								}
							catch (Exception e) {
								// TODO: handle exception
							}
							mvtPrixH.setTxMarge(txMrg);
							mvtPrixH.setIdPrix(maxIdPrix);
							System.out.println(mvtPrixH);
							mvtPrixH.setDateRes(dtDebutFinPeriode.getDtDebut());
							BigDecimal idPrixn = null;

							try {
								System.out.println("select u.idPrix from MvmentPrix u where u.dateRes ="
										+ dtDebutFinPeriode.getDtDebut().toString()
										+ " and u.arrangement.id.idArrangement =" + arrangementPK.getIdArrangement()
										+ " and u.typeChambre.id.idChm =" + chambrePK.getIdChm()
										+ " and u.hotel.idHotel =" + mvtH.getIdHotel());

								idPrixn = (BigDecimal) em.createQuery(

										"select u.idPrix from MvmentPrix u where u.dateRes =:dtRes and u.arrangement.id.idArrangement =:idArrg "
												+ "and u.typeChambre.id.idChm =:idTC and u.hotel.idHotel =:idHotel")
										.setParameter("dtRes", dtDebutFinPeriode.getDtDebut())
										.setParameter("idArrg", arrangementPK.getIdArrangement())
										// .setParameter("idPer",
										// mvtH.getIdPeriode())
										.setParameter("idTC", chambrePK.getIdChm())
										.setParameter("idHotel", Long.parseLong(mvtH.getIdHotel())).getSingleResult();
								System.out.println(idPrixn);
								mvtPrixH.setIdPrix(idPrixn);
								em.merge(mvtPrixH);
								System.out.println("udate");

							} catch (Exception e) {
								em.persist(mvtPrixH);

								System.out.println("test idprx");
								maxIdPrix = maxIdPrix.add(new BigDecimal(1));
							}

						}
					}
					dateDebut.add(Calendar.DATE, 1);
					dtDebutFinPeriode.setDtDebut(dateDebut.getTime());
				}
			}

		}

	}

	public List<mvtPrixVolModel> findAllMvmentPrixVol(String idavion) {
	       
			Query query = em
					.createQuery( //new mvtPrixVolModel(idavion, prixVente, marge, prixAchat, actifPrix, dateRes, dep, arr, numVol, horrairedepart, dureeVol, idVolSegment, escale, payDest, villDest, nbrP, idClassVol, idPrix)
							"select new com.worldsoft.model.mvtPrixVolModel(u.avion.idAvion , u.prixVente ,u.marge , u.prixAchat ,u.actifPrix , u.dateRes, u.dep, u.arr, u.numVol, u.horraireDepart , u.dureeVol, u.volSegment, u.escale, u.paysDest , u.villeDest , u.nbreChm , u.idClassVol, u.idPrix) from MvmentPrix u where u.avion.idAvion=:idavion")
					.setParameter("idavion", Long.parseLong(idavion));
			System.out.println(query);
			return query.getResultList();
		}

	public void addMvmentPrixVol(mvtPrixVolModel mvtV) {

		System.out.println(mvtV);

		MvmentPrix mvtPrixV = new MvmentPrix();
		BigDecimal maxIdPrix = new BigDecimal(0);
		try {
			maxIdPrix = (BigDecimal) em.createQuery("select max(idPrix) from MvmentPrix").getSingleResult();
			maxIdPrix = maxIdPrix.add(new BigDecimal(1));

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (maxIdPrix == null) {
			maxIdPrix = new BigDecimal(0);
		}
		System.out.println("maxId " + maxIdPrix);
		// maxIdPrix = maxIdPrix.add(new BigDecimal(1));
		mvtPrixV.setIdPrix(maxIdPrix);
		Avion avion = new Avion();
		avion.setIdAvion(Long.parseLong(mvtV.getIdavion()));
		mvtPrixV.setAvion(avion);
		mvtPrixV.setVolSegment(mvtV.getIdVolSegment());
		mvtPrixV.setDureeVol(mvtV.getDureeVol());
		mvtPrixV.setEscale(mvtV.getEscale());
		mvtPrixV.setActifPrix(mvtV.getActifPrix());
		mvtPrixV.setPaysDest(mvtV.getPayDest());
		mvtPrixV.setVilleDest(mvtV.getVillDest());
		mvtPrixV.setNumVol(mvtV.getNumVol());
		
		//calculer la marge 
		
		long mrg = 0;
		try {
			mrg = (Integer.parseInt(mvtV.getPrixAchat()) - Integer.parseInt(mvtV.getPrixVente()));
			}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		//mvtPrixH.setMarge(new BigDecimal(mvtH.getMarge()));
		mvtPrixV.setMarge(new BigDecimal(mrg));
		//calculer le tx
		
		BigDecimal txMrg = new BigDecimal(0);
		try {
			txMrg = (new BigDecimal( (Integer.parseInt(mvtV.getPrixAchat()) * mrg )/100) );
			}
		catch (Exception e) {
			// TODO: handle exception
		}
		mvtPrixV.setTxMarge(txMrg);
		
		mvtPrixV.setFlag('V');
		mvtPrixV.setActifPrix('O');
		try {
			mvtPrixV.setPrixAchat(new BigDecimal(mvtV.getPrixAchat()));

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			mvtPrixV.setPrixVente(new BigDecimal(mvtV.getPrixVente()));

		} catch (Exception e) {
			// TODO: handle exception
		}
		mvtPrixV.setDep(mvtV.getDep());
		mvtPrixV.setArr(mvtV.getArr());
		mvtPrixV.setNbreChm(new BigDecimal(mvtV.getNbrP()));
		Jour jour = new Jour();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			mvtPrixV.setDateRes(dateFormat.parse(mvtV.getDateRes()));
			Calendar dateResS = Calendar.getInstance();
			dateResS.setTime(mvtPrixV.getDateRes());

			if (dateResS.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				jour.setIdJour(1);
			}

			if (dateResS.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
				jour.setIdJour(2);
			}

			if (dateResS.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
				jour.setIdJour(3);
			}

			if (dateResS.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
				jour.setIdJour(4);
			}

			if (dateResS.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				jour.setIdJour(5);
			}

			if (dateResS.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				jour.setIdJour(6);
			}

			if (dateResS.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				jour.setIdJour(7);
			}

			mvtPrixV.setJour(jour);

			mvtPrixV.setHorraireDepart((Integer.parseInt(mvtV.getHorrairedepart().split("T")[1].split(":")[0]) + 1)
					+ ":" + mvtV.getHorrairedepart().split("T")[1].split(":")[1]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
		// try {
		// mvtPrixV.setHorrairedepart(dateFormat1.parse(mvtV.getHorrairedepart()));
		// }
		// catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		mvtPrixV.setIdClassVol(mvtV.getIdClassVol());

		em.persist(mvtPrixV);

	}

	public void addMvmentPrixSejour(mvtPrixSejourModel mvtS) {

		System.out.println(mvtS);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		BigDecimal maxIdPrix = new BigDecimal(0);
		try {
			maxIdPrix = (BigDecimal) em.createQuery("select max(idPrix) from MvmentPrix").getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (maxIdPrix == null) {
			maxIdPrix = new BigDecimal(0);
		}
		System.out.println("maxId " + maxIdPrix);
		maxIdPrix = maxIdPrix.add(new BigDecimal(1));

		for (String idArrangement : mvtS.getArrangements()) {
			for (String idJour : mvtS.getJours()) {
				BigDecimal numJour = (BigDecimal) em.createQuery("select j.numJour from Jour j WHERE j.idJour =:idJour")
						.setParameter("idJour", Long.parseLong(idJour)).getSingleResult();

				DtDebutFinPeriode dtDebutFinPeriode = (DtDebutFinPeriode) em
						.createQuery(
								"Select new com.worldsoft.model.DtDebutFinPeriode(u.dtDebut , u.dtFin) from Periode u where u.id.idPeriode =:idPeriode and u.id.idHotel =:idHotel")
						.setParameter("idPeriode", Long.parseLong(mvtS.getIdPeriode()))
						.setParameter("idHotel", Long.parseLong(mvtS.getIdHotel())).getSingleResult();

				Calendar dateDebut = Calendar.getInstance();
				dateDebut.setTime(dtDebutFinPeriode.getDtDebut());

				while (!(dateFormat.format(dtDebutFinPeriode.getDtDebut())
						.equals(dateFormat.format(dtDebutFinPeriode.getDtFin())))) {
					Boolean trouv = false;
					if (numJour.equals(new BigDecimal(1))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(2))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(3))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(4))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(5))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(6))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
							trouv = true;
						}
					}

					if (numJour.equals(new BigDecimal(7))) {
						if (dateDebut.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
							trouv = true;
						}
					}

					if (trouv) {

						for (String idTypeChambres : mvtS.getTypeChambres()) {
							// System.out.println("cc type chambre");
							MvmentPrix mvtPrixS = new MvmentPrix();

							mvtPrixS.setIdHotel(Long.parseLong(mvtS.getIdHotel()));

							Jour jour = new Jour();
							jour.setIdJour(Long.parseLong(idJour));
							mvtPrixS.setJour(jour);

							Hotel hotel = new Hotel();
							hotel.setIdHotel(Integer.parseInt(mvtS.getIdHotel()));
							mvtPrixS.setHotel(hotel);

							mvtPrixS.setIdPeriode(Integer.parseInt(mvtS.getIdPeriode()));

							mvtPrixS.setIdChm(Integer.parseInt(idTypeChambres));
							mvtPrixS.setIdArrangement(Integer.parseInt(idArrangement));

							Arrangement arg = new Arrangement();
							ArrangementPK arrangementPK = new ArrangementPK(Integer.parseInt(mvtS.getIdHotel()),
									Integer.parseInt(idArrangement));
							arg.setId(arrangementPK);
							mvtPrixS.setArrangement(arg);

							TypeChambre chambre = new TypeChambre();
							TypeChambrePK chambrePK = new TypeChambrePK(Integer.parseInt(mvtS.getIdHotel()),
									Integer.parseInt(idTypeChambres));
							chambre.setId(chambrePK);
							mvtPrixS.setTypeChambre(chambre);

							Avion avion = new Avion();
							avion.setIdAvion(Long.parseLong(mvtS.getIdavion()));
							mvtPrixS.setAvion(avion);
							mvtPrixS.setVolSegment(mvtS.getIdVolSegment());
							mvtPrixS.setDureeVol(mvtS.getDureeVol());
							mvtPrixS.setEscale(mvtS.getEscale());
							mvtPrixS.setActifPrix(mvtS.getActifPrix());
							mvtPrixS.setPaysDest(mvtS.getPayDest());
							mvtPrixS.setVilleDest(mvtS.getVillDest());
							mvtPrixS.setNumVol(mvtS.getNumVol());
							mvtPrixS.setMarge(new BigDecimal(mvtS.getMarge()));
							try {
								mvtPrixS.setPrixAchat(new BigDecimal(mvtS.getPrixAchat()));

							} catch (Exception e) {
								// TODO: handle exception
							}
							try {
								mvtPrixS.setPrixVente(new BigDecimal(mvtS.getPrixVente()));

							} catch (Exception e) {
								// TODO: handle exception
							}
							mvtPrixS.setDep(mvtS.getDep());
							mvtPrixS.setArr(mvtS.getArr());
							mvtPrixS.setNbreChm(new BigDecimal(mvtS.getNbrP()));
							// Jour jour = new Jour();
							// jour.setIdJour(1);
							// mvtPrixS.setJour(jour);
							// SimpleDateFormat dateFormat1 = new
							// SimpleDateFormat("yyyy-MM-dd");

							try {
								mvtPrixS.setDateRes(mvtS.getDateRes());
								mvtPrixS.setHorraireDepart(
										(Integer.parseInt(mvtS.getHorrairedepart().split("T")[1].split(":")[0]) + 1)
												+ ":" + mvtS.getHorrairedepart().split("T")[1].split(":")[1]);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							mvtPrixS.setIdClassVol(mvtS.getIdClassVol());

							mvtPrixS.setPrixAchat(new BigDecimal(mvtS.getPrixAchat()));
							mvtPrixS.setPrixVente(new BigDecimal(mvtS.getPrixVente()));
							mvtPrixS.setNbreChm(new BigDecimal(mvtS.getNbreChm()));
							mvtPrixS.setMarge(new BigDecimal(mvtS.getMarge()));

							mvtPrixS.setIdPrix(maxIdPrix);
							System.out.println(mvtPrixS);
							mvtPrixS.setDateRes(dtDebutFinPeriode.getDtDebut());
							em.persist(mvtPrixS);
							maxIdPrix = maxIdPrix.add(new BigDecimal(1));
						}
					}
					dateDebut.add(Calendar.DATE, 1);
					dtDebutFinPeriode.setDtDebut(dateDebut.getTime());
				}
			}

		}

	}

	public void addMvmentPrixTest(mvtPrixHotelModel mvtH) {

		System.out.println(mvtH);
		MvmentPrix mvtPrixH = new MvmentPrix();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DtDebutFinPeriode dtDebutFinPeriode = (DtDebutFinPeriode) em
				.createQuery(
						"Select new com.worldsoft.model.DtDebutFinPeriode(u.dtDebut , u.dtFin) from Periode u where u.id.idPeriode =:idPeriode and u.id.idHotel =:idHotel")
				.setParameter("idPeriode", Long.parseLong(mvtH.getIdPeriode()))
				.setParameter("idHotel", Long.parseLong(mvtH.getIdHotel())).getSingleResult();

		Calendar dateDebut = Calendar.getInstance();
		dateDebut.setTime(dtDebutFinPeriode.getDtDebut());
		System.out.println(dateDebut + "cc");

		while (!(dateFormat.format(dtDebutFinPeriode.getDtDebut())
				.equals(dateFormat.format(dtDebutFinPeriode.getDtFin())))) {
			BigDecimal maxIdPrix = new BigDecimal(0);
			try {
				maxIdPrix = (BigDecimal) em.createQuery("select max(idPrix) from MvmentPrix").getSingleResult();
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (maxIdPrix == null) {
				maxIdPrix = new BigDecimal(0);
			}
			maxIdPrix = maxIdPrix.add(new BigDecimal(1));

			System.out.println("maxId " + maxIdPrix);
			mvtPrixH.setIdPrix(maxIdPrix);
			mvtPrixH.setDateRes(dtDebutFinPeriode.getDtDebut());
			mvtPrixH.setIdPeriode(Integer.parseInt(mvtH.getIdPeriode()));
			Jour jour = new Jour();
			jour.setIdJour(1);
			mvtPrixH.setJour(jour);
			em.persist(mvtPrixH);
			System.out.println(mvtH);
			maxIdPrix = maxIdPrix.add(new BigDecimal(1));

		}
		dateDebut.add(Calendar.DATE, 1);
		dtDebutFinPeriode.setDtDebut(dateDebut.getTime());

	}

	// public void deletemvtH ( BigDecimal idPrix, long idHotel) {
	// em.createQuery("delete from MvmentPrix m where m.idPrix =:idPrix and
	// m.hotel.idHotel =:idHotel")
	// .setParameter("idPrix", idPrix)
	// .setParameter("idHotel", idHotel).executeUpdate();
	// System.out.println(idHotel+"this my idPrix Vol "+idPrix);
	// }
	public void deletemvtV(long idPrix, long idAvion) {
		em.createQuery("delete from MvmentPrix m where m.idPrix =:idPrix and m.avion.idAvion=:idAvion")
				.setParameter("idPrix", idPrix).setParameter("idAvion", idAvion).executeUpdate();
		System.out.println(idAvion + "this my idPrix Vol  " + idPrix);
	}

	public void editMvtPrixH(mvtPrixHotelModel mvtH) {

		System.out.println("mvtPrix " + mvtH);
		MvmentPrix mvtPrixH = (MvmentPrix) em.createQuery("select u from MvmentPrix u where u.idPrix =:idPrix")
				.setParameter("idPrix", mvtH.getIdPrix()).getSingleResult();
		mvtPrixH.setPrixVente(new BigDecimal(mvtH.getPrixVente()));
		// mvtPrixH.set(ajtArr.getLabArr());
		// ArrangementPK arrangementPK = new
		// ArrangementPK(Integer.parseInt(mvtH.getIdHotel()),
		// Integer.parseInt(mvtH.getIdArrangement()));
		
		mvtPrixH.setIdArrangement(Long.parseLong(mvtH.getIdArrangement()));
		mvtPrixH.setIdChm(Integer.parseInt(mvtH.getIdChm()));
	
		em.merge(mvtPrixH);

	}

	public void deletemvtH(String idprix) {

		em.createQuery("delete from MvmentPrix h where h.idPrix =:idprix ")
				.setParameter("idprix", new BigDecimal(idprix)).executeUpdate();
		System.out.println(idprix);
	}
	
	public void editMvtPrixV(mvtPrixVolModel mvtV) {

		System.out.println("mvtPrix " + mvtV);
		MvmentPrix mvtPrixV = (MvmentPrix) em.createQuery("select u from MvmentPrix u where u.idPrix =:idPrix")
				.setParameter("idPrix", mvtV.getIdPrix()).getSingleResult();
		mvtPrixV.setPrixVente(new BigDecimal(mvtV.getPrixVente()));
		// mvtPrixH.set(ajtArr.getLabArr());
		// ArrangementPK arrangementPK = new
		// ArrangementPK(Integer.parseInt(mvtH.getIdHotel()),
		// Integer.parseInt(mvtH.getIdArrangement()));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try{
		mvtPrixV.setDateRes(dateFormat.parse(mvtV.getDateRes()));}
		catch (Exception e) {
			// TODO: handle exception
		}
		mvtPrixV.setActifPrix(mvtV.getActifPrix());
		mvtPrixV.setHorraireDepart((Integer.parseInt(mvtV.getHorrairedepart().split("T")[1].split(":")[0]) + 1)
				+ ":" + mvtV.getHorrairedepart().split("T")[1].split(":")[1]);
	
		em.merge(mvtPrixV);

	}

	public void deletemvtV(String idprix) {

		em.createQuery("delete from MvmentPrix h where h.idPrix =:idprix ")
				.setParameter("idprix", new BigDecimal(idprix)).executeUpdate();
		System.out.println(idprix);
	}
	public List<mvtPrixVolModel> findAllidSeg() {
		Query query = em.createQuery("select distinct new com.worldsoft.model.mvtPrixVolModel(u.volSegment) from MvmentPrix u");
		return query.getResultList();
	}
	public List<mvtPrixVolModel> findAllnumVol() {
		Query query = em.createQuery("select distinct new com.worldsoft.model.mvtPrixVolModel(u.numVol) from MvmentPrix u");
		return query.getResultList();
	}
	public List<mvtPrixVolModel> findAllbyseg(String idSeg) {
	       
		Query query = em
				.createQuery( //new mvtPrixVolModel(idavion, prixVente, marge, prixAchat, actifPrix, dateRes, dep, arr, numVol, horrairedepart, dureeVol, idVolSegment, escale, payDest, villDest, nbrP, idClassVol, idPrix)
						"select new com.worldsoft.model.mvtPrixVolModel(u.avion.idAvion , u.prixVente ,u.marge , u.prixAchat ,u.actifPrix , u.dateRes, u.dep, u.arr, u.numVol, u.horraireDepart , u.dureeVol, u.volSegment, u.escale, u.paysDest , u.villeDest , u.nbreChm , u.idClassVol, u.idPrix) from MvmentPrix u where u.volSegment=:idSeg")
				.setParameter("idSeg", idSeg);
		System.out.println(query);
		return query.getResultList();
	}
	public List<mvtPrixVolModel> findAllbynumVol(String numV) {
	       
		Query query = em
				.createQuery( //new mvtPrixVolModel(idavion, prixVente, marge, prixAchat, actifPrix, dateRes, dep, arr, numVol, horrairedepart, dureeVol, idVolSegment, escale, payDest, villDest, nbrP, idClassVol, idPrix)
						"select new com.worldsoft.model.mvtPrixVolModel(u.avion.idAvion , u.prixVente ,u.marge , u.prixAchat ,u.actifPrix , u.dateRes, u.dep, u.arr, u.numVol, u.horraireDepart , u.dureeVol, u.volSegment, u.escale, u.paysDest , u.villeDest , u.nbreChm , u.idClassVol, u.idPrix) from MvmentPrix u where u.numVol=:inumV")
				.setParameter("numV", numV);
		System.out.println(query);
		return query.getResultList();
	}

}