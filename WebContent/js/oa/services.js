appmain.factory('httpPostFactory', function ($http) {
    return function (file, data, callback) {
        $http({
            url: file,
            method: "POST",
            data: data,
            contentType:"application/json"

        }).success(function (data) {
            callback(data);
        });
    };
});