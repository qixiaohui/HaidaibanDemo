var app = angular.module('image',['ngAnimate']);
app.controller("ImageController",function($scope,imageService){

    var width = $( window ).width();
    var height = $( window ).height();
    console.log('width'+width);
    console.log('height'+height);
    $( ".size" ).css({'width':width+"px"});
    $( ".size" ).css({'height':height+"px"});

    $scope.imageUrls = [
    {'result':'file:///android_asset/img/image1.gif'}
    ,{'result':'file:///android_asset/img/image2.gif'}
    ,{'result':'file:///android_asset/img/image3.png'}
    ];

    $scope.currentIndex = 0;

    $scope.setCurrentIndex = function(index){
        $scope.currentIndex = index;
    }

    $scope.isCurrentSliderIndex = function(index){
        console.log(index)
        return $scope.currentIndex === index;
    }

});
