$(document).ready(function(){
	/*进入介绍页面的链接形式为page.jsp?pageId=1001*/

	$.ajaxSetup ({cache: false});
	$.getJSON("tchAction!queryFullTches",function(data){
		teacherList = data.tchesList;
		var list = new String();
		$.each(teacherList,function(i){
			
			if(i>=1&&(list.indexOf(teacherList[i].tchName)!=-1)){
			}else{
				list = list+" "+teacherList[i].tchName;
				
				if(teacherList[i].tchTitle==null)
				{}
				else if(teacherList[i].tchTitle=="教授")
					$("#t1").append("<a class='teacherName' href='engTeacherInfo.jsp?Id="+teacherList[i].teacherId+"'>"+teacherList[i].tchPinyin+"</a>");
				else if(teacherList[i].tchTitle=="副教授")
					$("#t2").append("<a class='teacherName' href='engTeacherInfo.jsp?Id="+teacherList[i].teacherId+"'>"+teacherList[i].tchPinyin+"</a>");
				else if(teacherList[i].tchTitle.indexOf("讲师")!=-1)
					$("#t3").append("<a class='teacherName' href='engTeacherInfo.jsp?Id="+teacherList[i].teacherId+"'>"+teacherList[i].tchPinyin+"</a>");
				else if(teacherList[i].tchTitle.indexOf("助教")!=-1)
					$("#t4").append("<a class='teacherName' href='engTeacherInfo.jsp?Id="+teacherList[i].teacherId+"'>"+teacherList[i].tchPinyin+"</a>");
			}
					
		});
	});
	
});