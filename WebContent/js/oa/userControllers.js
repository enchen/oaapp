//任务控制器
appmain.controller('userManagementCtrl', function ($scope, $state, httpPostFactory) {
    $scope.chargeProjects = [];
    $scope.selectedProject;
    $scope.getChargeProjects = function () {
        var state = {token: getCookie("token")};
        httpPostFactory('getchargeprojects.php', JSON.stringify(state), function (callback) {

            $scope.chargeProjects = callback;

        });
    }
    $scope.projectChange=function() {
        if ($scope.selectedProject != null)
        {

        $state.go("userManagement.TaskList", {pid: $scope.selectedProject.projectId});
    }
    }
    $scope.createTask = function () {
        if ($scope.selectedProject == null) {
            alert("请选择任务所属项目");
            return;
        }
        $state.go("userManagement.AddTask", {pid: $scope.selectedProject.projectId});
    }

    $scope.getChargeProjects();//初始化关联项目

});
appmain.controller('userManagementAddCtrl', function ($scope, $state, httpPostFactory, $stateParams) {

    $scope.persons = [];
    $scope.taskName;
    $scope.taskContent;
    $scope.planUseTime;
    $scope.selectedPerson;


    $scope.getProjectPersons = function () {
        var state = {token: getCookie("token"), state: $stateParams.pid};
        httpPostFactory('getprojectpersons.php', JSON.stringify(state), function (callback) {

            $scope.persons = callback;

        });
    }
    $scope.getProjectPersons();
    //初始化项目相关人员

    //新建任务保存
    $scope.saveNewTask = function () {
        var task = {
            projectId: $stateParams.pid,
            planEndTime: $scope.dt,
            planUseTime: $scope.planUseTime,
            taskName: $scope.taskName,
            taskContent: $scope.taskContent,
            userId: $scope.selectedPerson.id
        };
        var ct = {token: getCookie("token"), task: task};
        httpPostFactory('createtask.php', JSON.stringify(ct), function (callback) {
            if (callback!=null&&callback.state == 1) {
                $state.go("userManagement.TaskList",{pid:$stateParams.pid});
            }
            else {
                alert("创建失败");
            }

        });
    }
    //时间设置
    $scope.open = function ($event) {
        $scope.status.opened = true;
    };
    $scope.dt = new Date();
    $scope.status = {
        opened: false
    };
    $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
    };
});
appmain.controller('userManagementTaskListCtrl', function ($scope, $state, httpPostFactory, $stateParams) {
    $scope.lists = [];
    $scope.getList = function () {
        var state = {state: $stateParams.pid, token: getCookie("token")};
        httpPostFactory('getprojecttask.php', JSON.stringify(state), function (callback) {

            $scope.lists = callback;

        });
    }
    $scope.getList();
    $scope.taskClik=function(task)
    {
        alert(task.taskName);
    }

});
appmain.controller('userManagementTaskDetailCtrl', function ($scope, $state, httpPostFactory, $stateParams) {

});