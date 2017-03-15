$(document).ready(function(){
//链接的参数形式为tchId=111
    var teacherId;
    var teacher;
	var str   =   window.location.href;
	teacherId = str.substring(str.length,str.lastIndexOf('tchId=')+6);
	
	$.getJSON("tchAction!queryTchById?tchId="+teacherId,function(data){
		teacher = data.tch;
		$("#teacherPic").attr({ src:"../"+teacher.tchImage});
		$("#teacherInfo-left").append("<br/><p class='teacherInfo-style1'>"+teacher.tchName+"&nbsp;&nbsp;&nbsp;&nbsp;"+teacher.tchTitle+"</p>"+
				"<br/><a target='_blank' href='"+teacher.tchHomepage+"'><p class='teacherInfo-style1'>个人主页</p></a>");
		if(teacher.tchInfo==null)
		$("#teacherInfo-right").append("对不起，教师信息还在添加中");
		else
		$("#teacherInfo-right").append(""+teacher.tchInfo);
	});
}); 
