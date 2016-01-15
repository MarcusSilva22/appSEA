controllers.controller('PessoaController', function ($scope, PessoaService) {

//    //listar cadastros
//    $scope.getList = function () {
//        PessoaService.get().success(function (response) {
//            if (response == "") {
//                $scope.erroList = true;
//            } else {
//                $scope.list = response;
//            }
//        });
//    };

//Salvar nova pessoa
    $scope.save = function (pessoa) {
        PessoaService.save(pessoa).success(function () {             
            alert("Pessoa cadastrada!");
            window.location.href = "#/home";
            
        });
    };
    //Busca por nome
    $scope.getNome = function (nome) {
        PessoaService.getNome(nome).success(function (response) {
            if (response == "") {
                $scope.erroList = true;                
                $scope.list = response;
            } else {
                $scope.erroList = false;
                $scope.list = response;
            }

        });
    };
    //Busca por SEXO
    $scope.getSexo = function (descricao) {
        PessoaService.getSexo(descricao).success(function (response) {
            if (response == "") {
                $scope.erroList = true;
            } else {
                $scope.list = response;
            }

        });
    };
    //Limpara formulário
    $scope.clearFields = function () {
        $scope.pessoa = {};
    };
//    //Volta para pagina de listagem
//    goHome = function () {
//        $('#alerta').modal('hide');
//        setTimeout(function () {
//                $('#alerta').modal('hide');
//            window.location.href = "#/home";
//        }, 500);
//    };
    $scope.Sexo = [
        {
            "id": 1,
            "descricao": "Masculino"
        },
        {
            "id": 2,
            "descricao": "Feminino"
        }
    ];
    
});
