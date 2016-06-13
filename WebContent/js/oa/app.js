
//angular.module("bootstrap.fileField",[]).directive("fileField",function(){return{require:"ngModel",restrict:"E",link:function(scope,element,attrs,ngModel){if(!attrs.class&&!attrs.ngClass){element.addClass("btn")}var fileField=element.find("input");fileField.bind("change",function(event){scope.$evalAsync(function(){ngModel.$setViewValue(event.target.files[0]);if(attrs.preview){var reader=new FileReader;reader.onload=function(e){scope.$evalAsync(function(){scope[attrs.preview]=e.target.result})};reader.readAsDataURL(event.target.files[0])}})});fileField.bind("click",function(e){e.stopPropagation()});element.bind("click",function(e){e.preventDefault();fileField[0].click()})},template:'<button type="button"><ng-transclude></ng-transclude><input type="file" style="display:none"></button>',replace:true,transclude:true}});
var appmain=angular.module('oa.main', ['ngAnimate', 'ui.bootstrap','ui.router','ui.scrollpoint']);

//文字部分
appmain.config(function($stateProvider,$urlRouterProvider) {

    $urlRouterProvider.otherwise("/oa/login");
    $stateProvider
        .state('task', {
            url: "/oa/tasks",
            views:{
                "main":{
                    url:"",
                    templateUrl: "pages/oa/task.html",
                    controller: "taskCtrl"
                }
                }

        })
        .state('login', {
            url: "/oa/login",
            views: {
                "main": { url:"",
                    templateUrl: "pages/oa/login.html",
                    controller: "loginCtrl"
                }
            }

        })
        .state('userManagement', {
            url: "/oa/user",
            views: {
                "main": {url:"",
                    templateUrl: "pages/oa/userManagement.html",
                    controller: "userManagementCtrl"
                }
            }
        })
        .state('userManagement.AddTask', {
            url: "/addtask:pid",
            views: {
                "userStage": {url:"",
                    templateUrl: "pages/oa/userManagementTaskAdd.html",
                    controller: "userManagementAddCtrl"
                }
            }
        })
        .state('userManagement.TaskList', {
            url: "/tasks:pid",
            views: {
                "userStage": {url:"",
                    templateUrl: "pages/oa/userManagementTaskList.html",
                    controller: "userManagementTaskListCtrl"
                }
            }
        })
        .state('userManagement.TaskDetail', {
            url: "/tasksDetail:tid",
            views: {
                "userStage": {url:"",
                    templateUrl: "pages/oa/userManagementTaskDetail.html",
                    controller: "userManagementTaskDetailCtrl"
                }
            }
        })
    .state('adminManagement', {
        url: "/oa/admin",
            views: {
                "main": {url:"",
                    templateUrl: "pages/oa/adminManagement.html",
                    controller: "adminCtrl"
                }
            }
    }).state('adminManagement.Add', {
            url: "/add",
            views: {
                "adminLeft": {url:"",
                    templateUrl: "pages/oa/adminManagementAdd.html",
                    controller: "adminAddCtrl"
                }
            }
        }).state('adminManagement.ProjectList', {
            url: "/list",
            views: {
                "adminLeft@adminManagement": {url:"",
                    templateUrl: "pages/oa/adminManagementProjectList.html",
                    controller: "adminProjectListCtrl"
                }
            }
        });

});


