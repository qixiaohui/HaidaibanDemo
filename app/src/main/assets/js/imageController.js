var app = angular.module('image',['ngAnimate']);
app.controller("ImageController",function($scope,imageService){

    var width = $( window ).width();
    var height = $( window ).height();
    console.log('width'+width);
    console.log('height'+height);
    $( ".size" ).css({'width':width+"px"});
    $( ".size" ).css({'height':height+"px"});

//    imageService.success(function(data){
//
//        $scope.imageUrls = data;
//    });

    $scope.imageUrls = [
    {'result':'file:///android_asset/img/image1.gif'}
    ,{'result':'file:///android_asset/img/image2.gif'}
    ,{'result':'file:///android_asset/img/image3.png'}
    ];

    $("#slideshow > div:gt(0)").hide();

    setInterval(function() {
      $('#slideshow > div:first')
        .fadeOut(1000)
        .next()
        .fadeIn(1000)
        .end()
        .appendTo('#slideshow');
    },  3000);

});
