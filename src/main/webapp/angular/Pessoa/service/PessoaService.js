services.service('PessoaService', function ($http, backend) {

    var url = backend + '/pessoas';    

    this.get = function () {
        return $http.get(url);
    };

    this.save = function (pessoa) {
        return  $http.post(url, pessoa);
    };

    this.getNome = function (id) {
        return $http.get(url + "/buscaNome/" + id);
    };

    this.getSexo = function (id) {
        return $http.get(url + "/buscaSexo/" + id);
    };    

});
