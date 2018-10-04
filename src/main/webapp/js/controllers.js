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
		vm.mvmntPrixBean.ajoutermvmnt();
	}
	
vm.list = [];
	
	vm.toggle = function(item) {
console.log(item);
		var idx = vm.list.indexOf(item);
		if (idx > -1)
			vm.list.splice(idx, 1);
		else
			vm.list.push(item);

		console.log(vm.list);
		
	};

};

function UserCtrl(userBean) {

	var vm = this;

	vm.userBean = userBean;

	vm.addRefUser = function() {

		vm.userBean.ajouteruser(vm.userBean.user);
	}

};
function AuthentificationCtrl(authentificationBean, $location) {

	var vm = this;

	vm.authentificationBean = authentificationBean;

	vm.authentification = function(login, pwd) {
		vm.authentificationBean.sauthentifier(login, pwd).then(
				function(value) {
					if (vm.authentificationBean.user != null
							&& vm.authentificationBean.user != undefined
							&& vm.authentificationBean.user != "") {
						vm.authentifier = true;
						window.location = "index.html"
					} else {
						vm.authentifier = false;
					}
				});
	}

};


function MvmPrixCtrl2(testBean) {

	var vm = this;

	vm.testBean = testBean;

	vm.addMvmentPrix2 = function() {
		vm.testBean.ajoutermvmnt2();
	}};