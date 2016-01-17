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
            Materialize.toast('Usuario não cadastrado!', 3000, 'rounded');
        }
    };

    $scope.init = function () {
        $scope.user = JSON.parse(window.sessionStorage.getItem('user'));
        window.sessionStorage.removeItem('user');
    };


    //Save user
    $scope.saveUser = function (user) {
        PessoaService.saveUser(user).success(function () {            
            Materialize.toast('Usuario Cadastrado!', 1000, 'rounded');
            window.location.href = "#/home";
        });
    };

    //Update user
    $scope.updateUser = function (user) {
        PessoaService.updateUser(user).success(function () {
            Materialize.toast('Usuario Atualizado!', 1000, 'rounded');
            window.location.href = "#/home";
        });
    };

    //Remove user   
    $scope.removeUser = function (id_User) {
        PessoaService.removeUser(id_User).success(function () {
            Materialize.toast('Usuario Removido!', 1000, 'rounded');
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
    $scope.init();
    //Load list of users
    getUsers();

});
