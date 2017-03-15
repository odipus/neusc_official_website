$(document).ready(function(){

	var str   =   window.location.href;
	var id = str.substring(str.length,str.lastIndexOf ('Id=')+3);
	$.ajaxSetup ({cache: false});
	$.getJSON("tchAction!queryTchById?tchId="+id,function(data){
		var teacher = data.tch;
		$("#tchPic").append("<img id='teacherPic' width='175px' height='240px' src='../"+teacher.tchImage+"'>");
		if(teacher.tchTitle=="教授")
			$("#tchTitle").append("Professor");
		else if(teacher.tchTitle=="副教授")
			$("#tchTitle").append("Associate Professor");
		else if(teacher.tchTitle=="讲师")
			$("#tchTitle").append("Lecturers");
		else if(teacher.tchTitle=="助教")
			$("#tchTitle").append("Assistants");
			
		$("#tchName").append(teacher.tchPinyin);
		$("#tchInfo").append(teacher.tchEngInfo);
	
	});
});