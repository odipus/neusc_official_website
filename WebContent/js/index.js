

var sk;
$(document).ready(function(){
	$("#searchB").click(function(){
		var se = $("#searchI").attr("value");
		se = se.trim().replace(" ","&");
		window.location.href = "jsp/searchPage.jsp";

	});
	
/*	setTimeout(ad , 19000);

	function ad(){
		$("#header-ad").height("0px");
		
	}
*/
	//请求服务器发送验证码
	$('#user_z').blur(function() {  
		var uname=$('#user_z').val();
		$.ajax({
			   type: "POST",
			   url: "codetest!checkUsernameExit",//userAction!login
			   data: "userName="+uname,
			   dataType:'json',

			   success: function(msg){
//  		           alert(msg.user_security.login_random_string);
				   var kcode=msg.user_security.login_random_string;
//				   alert(kcode);
				   key = CryptoJS.enc.Utf8.parse(kcode);   
				   iv  = CryptoJS.enc.Utf8.parse(kcode); 
				   sk=kcode;
				   
//				   var encrypted3 = getAesString(testcode,key,iv);//加密密钥
				   $("#kcode").val(kcode);
				   }
			});

	}); 
	
	
	function Encrypt(word,sKey){  
		 var key = CryptoJS.enc.Utf8.parse(sKey);   
		 var iv  = CryptoJS.enc.Utf8.parse(sKey);   
		 var srcs = CryptoJS.enc.Utf8.parse(word);  
		 var encrypted = CryptoJS.AES.encrypt(srcs, key, { iv: iv,mode:CryptoJS.mode.CBC});  
		 return encrypted.toString();  
	}  
	$("#submitbutton").click(function(){
		var username=$("#user_z").val();
		var userpwd=$("#userPsw").val();
        var encrypted1 =Encrypt(username,sk);//加密用户名
        var encrypted2 = Encrypt(userpwd,sk);;//加密密码
         
         
          $("#new_username").val(encrypted1);
          $("#new_password").val(encrypted2);//这是已经可以使用的
	     
		});
	
	
	
	jQuery(function(){
		jQuery('ul.sf-menu').superfish();
	});
	

	var flashvars = {};
	var params = {};
	params.quality = "high";
	params.bgcolor = "#117390";
	params.play = "true";
	params.loop = "true";
	params.scale = "showall";
	params.menu = "false";
	params.devicefont = "false";
	params.salign = "";
	params.allowscriptaccess = "sameDomain";
	params.wmode = "Opaque";
	swfobject.embedSWF("flash/header-flash.swf", "header-flash-place", "1024px", "137px", "6.0.0", "expressInstall.swf",flashvars,params);
	
	/*
	params.bgcolor = "#FFFFFF";
	swfobject.embedSWF("flash/header-ad.swf", "header-ad", "1024px", "298px", "6.0.0", "expressInstall.swf",flashvars,params);
	*/




});

