//任务控制器
appmain.controller('adminCtrl', function($scope, $state,httpPostFactory) {
    $scope.menus = [];
    $scope.menus.push({"name":"新建","enable":"false","usemethod":"add"});
    $scope.menus.push({"name":"关闭","enable":"true","usemethod":"close"});
    $scope.menus.push({"name":"暂停","enable":"true","usemethod":"pause"});
    $scope.menus.push({"name":"从新打开","enable":"true","usemethod":"reopen"});
    $scope.menus.push({"name":"冻结","enable":"true","usemethod":"freeze"});

    $scope.opMethod=function(key)
    {
  switch(key)
  {
      case"add":
         $state.go("adminManagement.Add");
          break;
  }


    }



});


//新建项目制器
appmain.controller('adminAddCtrl', function($scope, $state,httpPostFactory) {

    $scope.users=[];
    $scope.userJoin=[];
    $scope.keyPerson;
   $scope.initUsers=function()
   {
       httpPostFactory('getusers.php', "", function(callback) {

           $scope.users=callback;
       });
   }
    $scope.allClick=function(userid)
    {
       for(var i=0;i<$scope.users.length;i++)
       {
          /*var sssw= $scope.users.get(i);*/

           if($scope.users[i].id==userid)
           {

               $scope.userJoin.insertArr($scope.users[i]);
               $scope.users.removeArr(i);
           }
       }
    }
    $scope.joinClick=function(userid)
    {
        for(var i=0;i<$scope.userJoin.length;i++)
        {
            /*var sssw= $scope.users.get(i);*/

            if($scope.userJoin[i].id==userid)
            {
                $scope.users.insertArr($scope.userJoin[i]);
                $scope.userJoin.removeArr(i);
            }
        }
    }
    $scope.projectName;
    $scope.projectContent;


    $scope.save=function()
    {
        var project={projectName:$scope.projectName,projectContent:$scope.projectContent,startTime:$scope.dt,planEndTime:$scope.dt2};
        var p2p=[];
        for(var i=0;i<$scope.userJoin.length;i++)
        {
            var ProjectToPerson={userId:$scope.userJoin[i].id,position:($scope.userJoin[i].name==$scope.keyPerson.name?1:0)};
            p2p.insertArr(ProjectToPerson);
        }
        var cp={token:getCookie("token"),project:project,p2p:p2p};
        httpPostFactory('createproject.php', JSON.stringify(cp), function(callback) {

           $state.go("adminManagement.ProjectList");
        });
    }
    $scope.initUsers();
    //	开始时间设置
    $scope.open = function($event) {
        $scope.status.opened = true;
    };
    $scope.dt = new Date();
    $scope.status = {
        opened : false
    };
    $scope.dateOptions = {
        formatYear : 'yy',
        startingDay : 1
    };
    //完成时间设置
    $scope.open2 = function($event) {
        $scope.status2.opened = true;
    };
    $scope.dt2 = new Date();
    $scope.status2 = {
        opened : false
    };

});
//新建项目制器
appmain.controller('adminProjectListCtrl', function($scope, $state,httpPostFactory) {
    $scope.projects=[]
$scope.getProjects=function(prjType)
{
    var state={prjState:prjType};
    httpPostFactory('getprojects.php', JSON.stringify(state), function(callback) {

       for(var i=0;i<callback.length;i++)
        {

            $scope.projects.insertArr( callback[i]);
        }

    });
}
    $scope.getProjects(0);
});
