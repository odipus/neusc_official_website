/**
 *
 */
var userName = "";
var showName = "";
var engName = "";
var roleName = "";
var roleId = "";
var topTitle = "";
var moduleName = "";
var moduleCode = "";
var moduleTab = "";
var moduleName_a = "";
var moduleCode_a = "";
var moduleTab_a = "";
var featureTab = "";
var featureTab_a = "";

$.ajax({
			url : 'loginAction!loginPublic',
			async : false,
			success : function(data) {
			    function showResult(btn){
			        
			    };
				if (data == '') {
					alert("请您先登陆！");
					window.location.href = "index.jsp";
				}
				try {
					var json = eval("(" + data + ")");
					userName = json.userName;
					roleName = json.roleName;
					showName = json.showName;
					showPwd=json.showPwd;
					engName = json.engName;
					roleId = json.roleId;
					msg = json.msg;
					day = json.Day;
					if (json.success != 'true') {
						alert("用户名或密码错误！");
						window.location.href = "index.jsp";
					} else {
						if(parseInt(msg)>30){
							alert("您已经"+msg+"天未修改密码了！为保证账户安全及时修改密码");
						}
						topTitle = "欢迎您，" + roleName + " " + showName+ " " +engName;
						
					}
				} catch (err) {
					alert(err);
				}

			}
		});

$.ajax({
			url : 'authPrivilegeAction!authCtrl',
			async : false,
			success : function(data) {
				try {
					var moduleJson = eval("("+ data +")");
					moduleName = moduleJson.moduleName;
					moduleCode = moduleJson.moduleCode;
					moduleTab = moduleJson.moduleTab;
					featureTab = moduleJson.feaTab;
					if (moduleJson.success != 'true') {
						window.location.href = "index.jsp";
					} else {
						moduleName_a = moduleName.split(",");
						moduleCode_a = moduleCode.split(",");
						moduleTab_a = moduleTab.split(",");
						featureTab_a = featureTab.split(",");
					}
				} catch (err) {
					alert(err);
				}

			}
		});





