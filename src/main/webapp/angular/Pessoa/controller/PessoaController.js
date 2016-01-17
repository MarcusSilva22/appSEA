controllers.controller('PessoaController', function ($scope, PessoaService) {
        
    $scope.user;
    $scope.users;

    //Search users
    var getUsers = function () {
        PessoaService.getUsers().then(function (response) {
            $scope.users = response.data;
        }, function () {
            console.log("ERROR");
        });
    };

    //Search users - name
    $scope.getUserbyName = function (name) {
        PessoaService.getUserbyName(name).then(function (response) {
            $scope.users = response.data;
        }, function () {
            console.log("ERROR");
        });
    };
    
     //Data lead to another form
    $scope.gerUserForm = function (id_User) {
        var i = 0;
        var a = false;
        
        while (i < $scope.users.length && a === false) {
            if ($scope.users[i].id_User === id_User) {
                a = true;
            } else {
                i++;
            }
        }
        if (i < $scope.users.length) {
            window.sessionStorage.setItem('user', JSON.stringify($scope.users[i]));
            window.location.href = '#/cadastrar';
        } else {
            alert('Usuario nao encontrado');
        }
    };

    $scope.init = function () {
        $scope.user = JSON.parse(window.sessionStorage.getItem('user'));
        window.sessionStorage.removeItem('user');
    };


    //Save user
    $scope.saveUser = function (user) {
        PessoaService.saveUser(user).success(function () {
            alert("Usuário cadastrado!");
            window.location.href = "#/home";
        });
    };

    //Update user
    $scope.updateUser = function (user) {
        PessoaService.updateUser(user).success(function () {
            alert("Usuário alterado!");
            window.location.href = "#/home";
        });
    };

    //Remove user   
    $scope.removeUser = function (id_User) {
        PessoaService.removeUser(id_User).success(function () {
            alert("Usuário excluído!");
            getUsers();
        });
    };

    //Function for choose Save or Update
    $scope.chooseOption = function(user){
        
        if($scope.user.id_User == null){
            $scope.saveUser(user);
        }else{
        $scope.updateUser(user);
        }
    };
    
    //JSON de Estados
    $scope.estados = [{"ID": "1", "Sigla": "AC"}, {"ID": "2", "Sigla": "AL"},
        {"ID": "3", "Sigla": "AM"}, {"ID": "4", "Sigla": "AP"}, {"ID": "5", "Sigla": "BA"},
        {"ID": "6", "Sigla": "CE"}, {"ID": "7", "Sigla": "DF"}, {"ID": "8", "Sigla": "ES"},
        {"ID": "9", "Sigla": "GO"}, {"ID": "10", "Sigla": "MA"}, {"ID": "11", "Sigla": "MG"},
        {"ID": "12", "Sigla": "MS"}, {"ID": "13", "Sigla": "MT"}, {"ID": "14", "Sigla": "PA"},
        {"ID": "15", "Sigla": "PB"}, {"ID": "16", "Sigla": "PE"}, {"ID": "17", "Sigla": "PI"},
        {"ID": "18", "Sigla": "PR"}, {"ID": "19", "Sigla": "RJ"}, {"ID": "20", "Sigla": "RN"},
        {"ID": "21", "Sigla": "RO"}, {"ID": "22", "Sigla": "RR"}, {"ID": "23", "Sigla": "RS"},
        {"ID": "24", "Sigla": "SC"}, {"ID": "25", "Sigla": "SE"}, {"ID": "26", "Sigla": "SP"},
        {"ID": "27", "Sigla": "TO"}];

    $scope.init();
    //Load list of users
    getUsers();

});
