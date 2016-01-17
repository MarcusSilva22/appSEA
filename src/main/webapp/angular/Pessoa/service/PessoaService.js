services.service('PessoaService', function ($http, backend) {

    var url = backend + '/users/';    

    this.getUsers = function () {
        return $http.get(url);
    };

    this.saveUser = function (user) {
        return  $http.post(url, user);
    };
    
    this.updateUser = function(user){
      return $http.put(url,user);
    };
    
    this.removeUser = function(id_User){
        return $http.delete(url+id_User);
    };

    this.getUserbyName = function (name) {
        return $http.get(url+ name);
    };    

});
