//function MyCtrl(authentificationBean) {
//
//	var vm = this;
//
//	vm.authentificationBean = authentificationBean;
//
//};

function MvmPrixCtrl(mvmntPrixBean) {

	var vm = this;

	vm.mvmntPrixBean = mvmntPrixBean;

	vm.addMvtPrix = function() {
		vm.mvmntPrixBean.ajoutermvmnt(vm.mvmntPrixBean.mvtH);
		if (vm.mvmntPrixBean.mvtH.prixVente != null
				&& vm.mvmntPrixBean.mvtH.prixVente != ""
				&& vm.mvmntPrixBean.mvtH.prixVente != undefined) {
			vm.prixError = false;
		} else {
			vm.prixError = true;
		}
		if (vm.mvmntPrixBean.mvtH.prixAchat != null
				&& vm.mvmntPrixBean.mvtH.prixAchat != ""
				&& vm.mvmntPrixBean.mvtH.prixAchat != undefined) {
			vm.prixAError = false;
		} else {
			vm.prixAError = true;
		}
		if (vm.mvmntPrixBean.mvtH.nbreChm != null
				&& vm.mvmntPrixBean.mvtH.nbreChm != ""
				&& vm.mvmntPrixBean.mvtH.nbreChm != undefined) {
			vm.nbrCError = false;
		} else {
			vm.nbrCError = true;
		}
		
		
	}

	vm.addMvmentPrixTest = function() {
		vm.mvmntPrixBean.testMvt(vm.mvmntPrixBean.mvtH);
	}

	vm.findHotelByCategoryermvmnt = function(category) {
		vm.mvmntPrixBean.findHotelByCategoryermvmnt(category);
	}
	vm.findAllMvmentPrixHotel = function(mvtPrixHs) {
		vm.mvmntPrixBean.findAllMvmentPrixHotel(mvtPrixHs)
	}

	vm.findPerideArrangementTypeChambreByHotel = function(hotel) {
		vm.mvmntPrixBean.findPeriodeByHotel(hotel);
		vm.mvmntPrixBean.findArrangementByHotel(hotel);
		vm.mvmntPrixBean.findTypeChambreByHotel(hotel);

	}
	vm.findAllllByHotel = function(hotel) {
		vm.mvmntPrixBean.findPeriodeByHotel(hotel);
		vm.mvmntPrixBean.findArrangementByHotel(hotel);
		vm.mvmntPrixBean.findTypeChambreByHotel(hotel);
		vm.mvmntPrixBean.findAllMvmentPrixHotel(hotel)
	}

	vm.editMvtPrixH = function() {
		vm.mvmntPrixBean.editMvtPrixH(vm.mvmntPrixBean.mvtH);
	}
	vm.getMvtPrixHtoEdit = function(mvtPrixH) {
		vm.mvmntPrixBean.mvtH = angular.copy(mvtPrixH);
	}

	vm.listJour = [];
	vm.listTypemChambre = [];
	vm.listArrangement = [];

	vm.toggleJour = function(item) {
		var idx = vm.listJour.indexOf(item);
		if (idx > -1)
			vm.listJour.splice(idx, 1);
		else
			vm.listJour.push(item);
		vm.mvmntPrixBean.mvtH.jours = vm.listJour;

		console.log(vm.listJour);

	};

	vm.toggleTypehambre = function(item) {
		var idx = vm.listTypemChambre.indexOf(item);
		if (idx > -1)
			vm.listTypemChambre.splice(idx, 1);
		else
			vm.listTypemChambre.push(item);

		vm.mvmntPrixBean.mvtH.typeChambres = vm.listTypemChambre;
		console.log(vm.listTypemChambre);

	};

	vm.toggleArrangement = function(item) {
		var idx = vm.listArrangement.indexOf(item);
		if (idx > -1)
			vm.listArrangement.splice(idx, 1);
		else
			vm.listArrangement.push(item);
		vm.mvmntPrixBean.mvtH.arrangements = vm.listArrangement;
		console.log(vm.listArrangement);

	};
	
	
};

function UserCtrl(userBean) {

	var vm = this;

	vm.userBean = userBean;

	vm.addRefUser = function() {
		vm.userBean.ajouteruser(vm.userBean.user);
		
	}

};
function AcceuilCtrl(authentificationBean, $location, $scope) {
	vm = this;
	vm.authentificationBean = authentificationBean;

	$scope.role = sessionStorage.getItem('role');
	console.log("Role = " + $scope.role);
}
function IndexCtrl(authentificationBean, $location, $scope) {
	vm = this;
	vm.authentificationBean = authentificationBean;

	$scope.role = sessionStorage.getItem('role');
	console.log("Role = " + $scope.role);
}
function AuthentificationCtrl(authentificationBean, $location) {

	var vm = this;

	vm.authentificationBean = authentificationBean;

	vm.authentification = function(login, pwd) {
		vm.authentificationBean.sauthentifier(login, pwd).then(
				function(data) {
					if (authentificationBean.user.idUsers != 0) {
						vm.authentifier = true;
						sessionStorage.setItem('role',
								authentificationBean.user.role.idRole);

						window.location = "/Worldsoft-Travel/admin/#/Acceuil";
					} else {
						vm.authentifier = false;
					}
				});
		if (vm.authentificationBean.user.login != null
				&& vm.authentificationBean.user.login != ""
				&& vm.authentificationBean.user.login != undefined) {
			vm.loginError = false;
		} else {
			vm.loginError = true;
		}
		if (vm.authentificationBean.user.pwd != null
				&& vm.authentificationBean.user.pwd != ""
				&& vm.authentificationBean.user.pwd != undefined) {
			vm.pwdError = false;
		} else {
			vm.pwdError = true;
		}
		

	};
	vm.list = [];

	vm.toggle = function(item) {

		var idx = vm.list.indexOf(item);
		if (idx > -1)
			vm.list.splice(idx, 1);
		else
			vm.list.push(item);

		console.log(vm.list);

	};
};

function MvmntPrixVolCtrl(mvmntPrixVolBean, $location) {
	var vm = this;
	vm.mvmntPrixVolBean = mvmntPrixVolBean;
	vm.addMvmentPrixVol = function() {

		vm.mvmntPrixVolBean.ajoutermvmntVol(vm.mvmntPrixVolBean.mvtV);
		if (vm.mvmntPrixVolBean.mvtV.dateRes != null
				&& vm.mvmntPrixVolBean.mvtV.dateRes != ""
				&& vm.mvmntPrixVolBean.mvtV.dateRes != undefined) {
			vm.dtResError = false;
		} else {
			vm.dtResError = true;
		}
		if (vm.mvmntPrixVolBean.mvtV.horrairedepart != null
				&& vm.mvmntPrixVolBean.mvtV.horrairedepart != ""
				&& vm.mvmntPrixVolBean.mvtV.horrairedepart != undefined) {
			vm.hrdepError = false;
		} else {
			vm.hrdepError = true;
		}
		
		
		if (vm.mvmntPrixVolBean.mvtV.dureeVol != null
				&& vm.mvmntPrixVolBean.mvtV.dureeVol != ""
				&& vm.mvmntPrixVolBean.mvtV.dureeVol != undefined) {
			vm.dureeVolError = false;
		} else {
			vm.dureeVolError = true;
		}
		
		
		if (vm.mvmntPrixVolBean.mvtV.idVolSegment != null
				&& vm.mvmntPrixVolBean.mvtV.idVolSegment != ""
				&& vm.mvmntPrixVolBean.mvtV.idVolSegment != undefined) {
			vm.idVolError = false;
		} else {
			vm.idVolError = true;
		}
		
		if (vm.mvmntPrixVolBean.mvtV.numVol != null
				&& vm.mvmntPrixVolBean.mvtV.numVol != ""
				&& vm.mvmntPrixVolBean.mvtV.numVol != undefined) {
			vm.numVolError = false;
		} else {
			vm.numVolError = true;
		}
		
		if (vm.mvmntPrixVolBean.mvtV.nbrP != null
				&& vm.mvmntPrixVolBean.mvtV.nbrP != ""
				&& vm.mvmntPrixVolBean.mvtV.nbrP != undefined) {
			vm.nbrPError = false;
		} else {
			vm.nbrPError = true;
		}
		
		if (vm.mvmntPrixVolBean.mvtV.prixAchat != null
				&& vm.mvmntPrixVolBean.mvtV.prixAchat != ""
				&& vm.mvmntPrixVolBean.mvtV.prixAchat != undefined) {
			vm.prixAchatError = false;
		} else {
			vm.prixAchatError = true;
		}
		if (vm.mvmntPrixVolBean.mvtV.prixVente != null
				&& vm.mvmntPrixVolBean.mvtV.prixVente != ""
				&& vm.mvmntPrixVolBean.mvtV.prixVente != undefined) {
			vm.prixVenteError = false;
		} else {
			vm.prixVenteError = true;
		}
		if (vm.mvmntPrixVolBean.mvtV.marge != null
				&& vm.mvmntPrixVolBean.mvtV.marge != ""
				&& vm.mvmntPrixVolBean.mvtV.marge != undefined) {
			vm.margeError = false;
		} else {
			vm.margeError = true;
		}
		
	}
	vm.findAllMvmentPrixVol = function(mvtPrixVs) {
		vm.mvtPrixVolModel.findAllMvmentPrixVol(mvtPrixVs)
	}

	vm.findAllavionsByAir = function(airline) {
		vm.mvmntPrixBean.findAllavionsByAir(airline);
	}

};

function MvmntPrixVolCtrl1(testBean) {
	var vm = this;
	vm.testBean = testBean;
	vm.addMvmentPrix22 = function() {
		vm.testBean.ajoutermvmnt2()(vm.testBean.mvtV);

	}
};

function MvmntPrixSejourCtrl(mvmntPrixSejourBean) {
	var vm = this;
	vm.mvmntPrixSejourBean = mvmntPrixSejourBean;
	vm.addMvmentPrixSejour = function() {
		vm.mvmntPrixSejourBean.ajoutermvmntSejour(vm.mvmntPrixSejourBean.mvtS);
	}
	vm.findPerideArrangementTypeChambreByHotel = function(hotel) {
		vm.mvmntPrixBean.findPeriodeByHotel(hotel);
		vm.mvmntPrixBean.findArrangementByHotel(hotel);
		vm.mvmntPrixBean.findTypeChambreByHotel(hotel);

	}

	vm.listJour = [];
	vm.listTypemChambre = [];
	vm.listArrangement = [];

	vm.toggleJour = function(item) {
		var idx = vm.listJour.indexOf(item);
		if (idx > -1)
			vm.listJour.splice(idx, 1);
		else
			vm.listJour.push(item);
		vm.mvmntPrixBean.mvtH.jours = vm.listJour;

		console.log(vm.listJour);

	};

	vm.toggleTypehambre = function(item) {
		var idx = vm.listTypemChambre.indexOf(item);
		if (idx > -1)
			vm.listTypemChambre.splice(idx, 1);
		else
			vm.listTypemChambre.push(item);

		vm.mvmntPrixBean.mvtH.typeChambres = vm.listTypemChambre;
		console.log(vm.listTypemChambre);

	};

	vm.toggleArrangement = function(item) {
		var idx = vm.listArrangement.indexOf(item);
		if (idx > -1)
			vm.listArrangement.splice(idx, 1);
		else
			vm.listArrangement.push(item);
		vm.mvmntPrixBean.mvtH.arrangements = vm.listArrangement;
		console.log(vm.listArrangement);

	};

};
function AjouterHCtrl(ajouterHBean) {

	var vm = this;

	vm.ajouterHBean = ajouterHBean;

	vm.addHotel1 = function() {
		vm.ajouterHBean.ajouterhotel(vm.ajouterHBean.ajtH);
		if (vm.ajouterHBean.ajtH.NomHo != null
				&& vm.ajouterHBean.ajtH.NomHo != ""
				&& vm.ajouterHBean.ajtH.NomHo != undefined) {
			vm.nmError = false;
		} else {
			vm.nmError = true;
		}
		if (vm.ajouterHBean.ajtH.adr != null
				&& vm.ajouterHBean.ajtH.adr != ""
				&& vm.ajouterHBean.ajtH.adr != undefined) {
			vm.adrError = false;
		} else {
			vm.adrError = true;
		}
		if (vm.ajouterHBean.ajtH.abrv != null
				&& vm.ajouterHBean.ajtH.abrv != ""
				&& vm.ajouterHBean.ajtH.abrv != undefined) {
			vm.avrError = false;
		} else {
			vm.avrError = true;
		}
	}

	vm.findHotels = function(hotel) {
		vm.ajouterHBean.findHotels(hotel);
	}
	vm.findAllHotels = function(hotel) {
		vm.ajouterHBean.findAllHotels(hotel);
	}
	vm.findAllHotelsByCategory = function(category) {
		vm.ajouterHBean.findAllHotelsByCategory(category);
	}
	vm.editHotel = function() {
		vm.ajouterHBean.editHotel(vm.ajouterHBean.ajtH);
	}
	vm.getHoteltoEdit = function(hotel) {
		vm.ajouterHBean.ajtH = angular.copy(hotel);
	}

};
function AjouterACtrl(ajouterABean) {

	var vm = this;

	vm.ajouterABean = ajouterABean;

	vm.addAvion1 = function() {
		vm.ajouterABean.ajouterAvion(vm.ajouterABean.ajtA);
		if (vm.ajouterABean.ajtA.nomavion != null
				&& vm.ajouterABean.ajtA.nomavion != ""
				&& vm.ajouterABean.ajtA.nomavion != undefined) {
			vm.avAError = false;
		} else {
			vm.avAError = true;
		}
		
		if (vm.ajouterABean.ajtA.airline != null
				&& vm.ajouterABean.ajtA.airline != ""
				&& vm.ajouterABean.ajtA.airline != undefined) {
			vm.airError = false;
		} else {
			vm.airAError = true;
		}
		if (vm.ajouterABean.ajtA.typeAv != null
				&& vm.ajouterABean.ajtA.typeAv != ""
				&& vm.ajouterABean.ajtA.typeAv != undefined) {
			vm.typeError = false;
		} else {
			vm.typeAError = true;
		}
		
		if (vm.ajouterABean.ajtA.abrvAv != null
				&& vm.ajouterABean.ajtA.abrvAv != ""
				&& vm.ajouterABean.ajtA.abrvAv != undefined) {
			vm.abvError = false;
		} else {
			vm.abvError = true;
		}
	}
	vm.findAllavionsByAir = function(avion) {
		vm.ajouterABean.findAllavionsByAir(avion);
	}
	vm.editAvion = function() {
		vm.ajouterABean.editAvion(vm.ajouterABean.ajtA);
	}
	vm.getAviontoEdit = function(avion) {
		vm.ajouterABean.ajtA = angular.copy(avion);
	}

};
function AjouterArrCtrl(ajouterArrBean) {

	var vm = this;

	vm.ajouterArrBean = ajouterArrBean;

	vm.addArrangementH = function() {
		vm.ajouterArrBean.ajouterArran(vm.ajouterArrBean.ajtArr);
		if (vm.ajouterArrBean.ajtArr.nomarr != null
				&& vm.ajouterArrBean.ajtArr.nomarr != ""
				&& vm.ajouterArrBean.ajtArr.nomarr != undefined) {
			vm.nomAError = false;
		} else {
			vm.nomAError = true;
		}
		if (vm.ajouterArrBean.ajtArr.labArr != null
				&& vm.ajouterArrBean.ajtArr.labArr != ""
				&& vm.ajouterArrBean.ajtArr.labArr != undefined) {
			vm.lblAError = false;
		} else {
			vm.lblAError = true;
		}
	}

	vm.findArrangementByHotell = function(hotel) {
		vm.ajouterArrBean.findArrangementByHotel(hotel);
	}
	vm.editArrangementH = function() {
		vm.ajouterArrBean.editArran(vm.ajouterArrBean.ajtArr);
	}
	vm.getArrangementHtoEdit = function(arrangement) {
		vm.ajouterArrBean.ajtArr = angular.copy(arrangement);
	}

};

function AjouterTypeChmCtrl(ajouterTypeChmBean) {

	var vm = this;

	vm.ajouterTypeChmBean = ajouterTypeChmBean;

	vm.addTypeChmabreH = function() {
		vm.ajouterTypeChmBean.ajouterTC(vm.ajouterTypeChmBean.ajtTypeC);
		if (vm.ajouterTypeChmBean.ajtTypeC.lblTCham != null
				&& vm.ajouterTypeChmBean.ajtTypeC.lblTCham != ""
				&& vm.ajouterTypeChmBean.ajtTypeC.lblTCham != undefined) {
			vm.lblError = false;
		} else {
			vm.lblError = true;
		}
	}
	vm.findAllTypeChambreByHotel = function(hotel) {
		vm.ajouterTypeChmBean.findAllTypeChambreByHotel(hotel);
	}
	vm.editTypeChambre = function() {
		vm.ajouterTypeChmBean.editTypeChambre(vm.ajouterTypeChmBean.ajtTypeC);
	}
	vm.getTypeChmtoEdit = function(typeChambre) {
		vm.ajouterTypeChmBean.ajtTypeC = angular.copy(typeChambre);
	}

};
function AjouterPeriodeCtrl(periodeBean) {

	var vm = this;

	vm.periodeBean = periodeBean;

	vm.addPeriodeH = function() {
		vm.periodeBean.ajouterPer(vm.periodeBean.ajtP);
	}
	vm.findPeriodeByHotels = function(hotel) {
		vm.periodeBean.findPeriodeByHotels(hotel);
	}
	vm.editPeriode = function() {
		vm.periodeBean.editPeriode(vm.periodeBean.ajtP);
	}
	vm.getPeriodeHtoEdit = function(periode) {
		vm.periodeBean.ajtP = angular.copy(periode);
	}
};
function AjouterClassVCtrl(classVolBean) {

	var vm = this;

	vm.classVolBean = classVolBean;

	vm.addClassV = function() {
		vm.classVolBean.ajouterClassV(vm.classVolBean.ajtCV);
		if (vm.classVolBean.ajtCV.lblClass != null
				&& vm.classVolBean.ajtCV.lblClass != ""
				&& vm.classVolBean.ajtCV.lblClass != undefined) {
			vm.lblError = false;
		} else {
			vm.lblError = true;
		}
		if (vm.classVolBean.ajtCV.nomClass != null
				&& vm.classVolBean.ajtCV.nomClass != ""
				&& vm.classVolBean.ajtCV.nomClass != undefined) {
			vm.nomError = false;
		} else {
			vm.nomError = true;
		}
	}

	vm.findClassVolByAvion = function(hotel) {
		vm.classVolBean.findClassVolByAvion(hotel);
	}
	vm.editClass = function() {
		vm.classVolBean.editClass(vm.classVolBean.ajtCV);
	}
	vm.getClasstoEdit = function(classVol) {
		vm.classVolBean.ajtCV = angular.copy(classVol);
	}
};

function UtilisateurCtrl(utilisateurBean) {

	var vm = this;
	vm.utilisateurBean = utilisateurBean;

	vm.addRefUtilisateur = function() {
		vm.utilisateurBean.ajouterutilisateur(vm.utilisateurBean.utilis)
		if (vm.utilisateurBean.utilis.nomRefUtilisateur != null
				&& vm.utilisateurBean.utilis.nomRefUtilisateur != ""
				&& vm.utilisateurBean.utilis.nomRefUtilisateur != undefined) {
			vm.nomError = false;
		} else {
			vm.nomError = true;
		}
		if (vm.utilisateurBean.utilis.logUtilisateur != null
				&& vm.utilisateurBean.utilis.logUtilisateur != ""
				&& vm.utilisateurBean.utilis.logUtilisateur != undefined) {
			vm.logError = false;
		} else {
			vm.logError = true;
		}
		
		if (vm.utilisateurBean.utilis.passwUtilisateur != null
				&& vm.utilisateurBean.utilis.passwUtilisateur != ""
				&& vm.utilisateurBean.utilis.passwUtilisateur != undefined) {
			vm.pwdError = false;
		} else {
			vm.pwdError = true;
		}
		
	}

	vm.findUtilisbyTier = function(refTier) {
		vm.utilisateurBean.findUtilisbyTier(refTier);
	}
};

function PromotionCtrl(promotionBean) {
	var vm = this;
	vm.promotionBean = promotionBean;
	vm.addPromotion = function() {
		vm.promotionBean.ajouterPrm(vm.promotionBean.prm)
	}
	vm.editPromotion = function() {
		vm.promotionBean.editPromotion(vm.promotionBean.prm);
	}
	vm.getPromotionHtoEdit = function(promotion) {
		vm.promotionBean.prm = angular.copy(promotion);
	}
	vm.findAllPromotion = function() {
		vm.promotionBean.findAllPromotion();
	}
};
function ReductionCtrl(reductionBean) {
	var vm = this;
	vm.reductionBean = reductionBean;
	vm.addReduction = function() {
		vm.reductionBean.addReduction(vm.reductionBean.prm)
	}
	vm.editPromotion = function() {
		vm.reductionBean.editReduction(vm.reductionBean.prm);
	}
	vm.getReductionHtoEdit = function(reduction) {
		vm.reductionBean.red = angular.copy(reduction);
	}
	vm.findReductions = function() {
		vm.reductionBean.findReductions();
	}
};
function RefTierCtrl(refTierBean) {
	var vm = this;
	vm.refTierBean = refTierBean;
	vm.addRefTier = function() {
		vm.refTierBean.ajouterTier(vm.refTierBean.refT);
		if (vm.refTierBean.refT.resSocial != null
				&& vm.refTierBean.refT.resSocial != ""
				&& vm.refTierBean.refT.resSocial != undefined) {
			vm.resSError = false;
		} else {
			vm.resSError = true;
		}
		if (vm.refTierBean.refT.emailClient != null
				&& vm.refTierBean.refT.emailClient != ""
				&& vm.refTierBean.refT.emailClient != undefined) {
			vm.mailError = false;
		} else {
			vm.mailError = true;
		}
		if (vm.refTierBean.refT.telTiers != null
				&& vm.refTierBean.refT.telTiers != ""
				&& vm.refTierBean.refT.telTiers != undefined) {
			vm.numError = false;
		} else {
			vm.numError = true;
		}
		if (vm.refTierBean.refT.siteTiers != null
				&& vm.refTierBean.refT.siteTiers != ""
				&& vm.refTierBean.refT.siteTiers != undefined) {
			vm.siteError = false;
		} else {
			vm.siteError = true;
		}
		if (vm.refTierBean.refT.adrTiers != null
				&& vm.refTierBean.refT.adrTiers != ""
				&& vm.refTierBean.refT.adrTiers != undefined) {
			vm.adrError = false;
		} else {
			vm.adrError = true;
		}
		
	}
	vm.editRefTier = function() {
		vm.refTierBean.editTier(vm.refTierBean.refT);
	}
	vm.getRefTiertoEdit = function(refTier) {
		vm.refTierBean.refT = angular.copy(refTier);
	}
	vm.findRefTierActif = function(tiersActif) {
		vm.refTierBean.findRefTiersActif(tiersActif);
	}

};
function ReservationCtrl(reservationBean) {
	var vm = this;
	vm.reservationBean = reservationBean;
	vm.findReservationbyRefTier = function(idRefTier) {
		vm.reservationBean.findReservationbyRefTier(idRefTier);
	}
};