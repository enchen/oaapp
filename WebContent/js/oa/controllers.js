//登陆控制器
appmain.controller('loginCtrl', function($scope, $state,httpPostFactory) {
	$scope.entity = {};

	$scope.login = function(valid) {

		if(valid)
		{
			var user = {name:$scope.entity.userName,pass:$scope.entity.passWord};
			httpPostFactory('login.php', JSON.stringify(user), function(callback) {
				//alert(callback.toString());
				if(callback.login==0)
				{
					$scope.entity.userName="";
					$scope.entity.passWord="";
				}
				else if(callback.login==1) {
					if (callback.isadmin == 1) {
						setCookie("token", callback.key + "1");
					}
					else
					{
						setCookie("token", callback.key );
					}
					var sssd=getCookie("token");
					//alert("开始跳转");
					$state.go("task");
				}
			});
		}
	};
});

//任务控制器
appmain.controller('taskCtrl', function($scope, $state,httpPostFactory) {
	$scope.entity = {};
});

//主页面控制器
appmain.controller('mainCtrl', function($scope, $state,httpPostFactory) {
	$scope.management=function()
	{
      if(getCookie("token")!=null&&getCookie("token").length==33)
	  {

		  $state.go("adminManagement");
	  }
		if(getCookie("token")!=null&&getCookie("token").length==32)
		{

			$state.go("userManagement");
		}
	}
	$scope.quit=function()
	{
		setCookie("token","");
		$state.go("login");
	}

});





/*Cookie操作*/
function setCookie(name,value)
{
	var Days = 1;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

function getCookie(name)
{
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
		return unescape(arr[2]);
	else
		return null;
}
function delCookie(name)
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval=getCookie(name);
	if(cval!=null)
		document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}

/*
 *  删除数组元素:Array.removeArr(index)
 */
Array.prototype.removeArr = function (index) {
	if (isNaN(index) || index>= this.length) { return false; }
	this.splice(index, 1);
}
/*
 *  插入数组元素:Array.insertArr(dx)
 */
Array.prototype.insertArr = function ( item) {
	this.splice(0, 0, item);
};
/*
视角转换*/
function date(format, timestamp) {
	var a, jsdate = ((timestamp) ? new Date(timestamp * 1000) : new Date());
	var pad = function (n, c) {
		if ((n = n + "").length < c) {
			return new Array(++c - n.length).join("0") + n;
		} else {
			return n;
		}
	}
};
