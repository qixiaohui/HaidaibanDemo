app.factory('imageService',function($http){
    return $http.get("http://stage.haidaiban.com/api/sitemessages");
});