$(document).ready(function(){
	var orgName;
	var orgDuty;

	var str   =   window.location.href;
	var orgId = str.substring(str.length,str.lastIndexOf ('orgId=')+6);

	$.getJSON("orgAction!queryOrgById?orgId="+orgId,function(data){
		var org = data.org;
		/*if(org.orgName=="理事会"||org.orgName=="学院领导"){*/

			$("#index3-news-header").append("<span class='part-name'>"+org.orgName+"</span>");
			$("#index3-news-content").prepend("<p class='commonLink' style='margin-left:40px;'>当前位置：首页&nbsp;&gt;&nbsp;"+org.orgName+"</p>");			
		/*	$("#index3-newsContent").append("<span class='department-title-1'>"+org.orgName+"</span><hr><br/>");*/
			$("#index3-newsContent").append("<br/><br/><br/><span'>"+org.orgDuty+"</span><br/>");
			$("#index3-newsContent").append("<br/><br/>");
/*		}else{
			$("#index3-news-header").append("<span class='part-name'>&nbsp;"+org.orgName+"</span>");
			$("#index3-newsContent").append("<p class='commonLink'>当前位置：首页&nbsp;&gt;&nbsp;机构设置&nbsp;&gt;&nbsp;"+org.orgName+"&nbsp;&gt;&nbsp;机构简介</p>");			
			$("#index3-newsContent").append("<span class='department-title-1'>"+org.orgName+"</span><hr><br/>");
			$("#department2-main-content-area").append("<span'>"+org.orgDuty+"</span><br/>");
			$("#index3-newsContent").append("<br/><br/>");
			$("#index3-newsContent").append("<h1 style='front:18px;'>人员配置</h1><br/>");
			if(org.orgName=="学院领导"){
				xyld();	     
			}
			else if(org.orgName=="学院办公室"){
				xybgs();
			}
			else if(org.orgName=="学生工作办公室"){
				xsgzbgs();
			}
			else if(org.orgName=="教学科研办公室"){
				jxkybgs();
			}
		}*/
	});


function xyld(){
	$("##index3-newsContent").append("" +
			"<table><tr><td width='50px'><strong>院长</strong></td><td id='t1' width='500px'></td></tr>"+
					"<tr><td><strong>党委书记</strong><td id='t2'></td></tr>"+
					"<tr><td><strong>副院长</strong><td id='t3'></td></tr>"+
					"<tr><td><strong>院长助理</strong><td id='t4'></td></tr>"+
			"</table> "); 
			
	$.getJSON("tchAction!queryTchesByOrgId?orgId="+orgId,function(data){
		var teacherList = data.tchesList;
		$.each(teacherList,function(i){
			if(teacherList[i].tchDuty==null){}
			else if(teacherList[i].tchDuty=="院长")
				$("#t1").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
			else if(teacherList[i].tchDuty=="党委书记")
				$("#t2").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
			else if(teacherList[i].tchDuty.indexOf("副院长")!=-1)
				$("#t3").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
			else if(teacherList[i].tchDuty=="院长助理")
				$("#t4").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
			
		});	
	});	
}
function xybgs(){
	$("#index3-newsContent").append("" +
			"<table><tr><td width='50px'><strong>主任</strong></td><td id='t1' width='500px'></td></tr>"+
					"<tr><td><strong>成员</strong><td id='t2'></td></tr>"+
			"</table> "); 
	$.getJSON("tchAction!queryTchesByOrgId?orgId="+orgId,function(data){
		var teacherList = data.tchesList;
		$.each(teacherList,function(i){
			
		if(teacherList[i].tchOrgDuty=="学院办公室主任")
				$("#t1").append("&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
			else 
				$("#t2").append("&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
		
			
		});	
	});	
}
function xsgzbgs(){
	$("#index3-newsContent").append("" +
			"<table><tr><td width='50px'><strong>主任</strong></td><td id='t1' width='500px'></td></tr>"+
					"<tr><td><strong>副主任</strong><td id='t2'></td></tr>"+
					"<tr><td><strong>成员</strong><td id='t3'></td></tr>"+
			"</table> "); 
	$.getJSON("tchAction!queryTchesByOrgId?orgId="+orgId,function(data){
		var teacherList = data.tchesList;
		$.each(teacherList,function(i){
			
		if(teacherList[i].tchOrgDuty=="学生工作办公室主任")
				$("#t1").append("&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
		else if(teacherList[i].tchOrgDuty=="学生工作办公室副主任")
				$("#t2").append("&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
		else
				$("#t3").append("&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
			
		});	
	});	
}

function jxkybgs(){
	$("#index3-newsContent").append("" +
			"<table><tr><td width='50px'><strong>主任</strong></td><td id='t1' width='500px'></td></tr>"+
					"<tr><td><strong>副主任</strong><td id='t2'></td></tr>"+
					"<tr><td><strong>成员</strong><td id='t3'></td></tr>"+
			"</table> "); 
	$.getJSON("tchAction!queryTchesByOrgId?orgId="+orgId,function(data){
		var teacherList = data.tchesList;
		$.each(teacherList,function(i){
			
		if(teacherList[i].tchOrgDuty=="教学科研办公室主任")
				$("#t1").append("&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
		else if(teacherList[i].tchOrgDuty=="教学科研办公室副主任")
				$("#t2").append("&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
		else
				$("#t3").append("&nbsp;&nbsp;<a href=tchInfo.jsp?tchId="+teacherList[i].teacherId+" target=_blank>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
			
		});	
	});	
}
		
	
	

	

});