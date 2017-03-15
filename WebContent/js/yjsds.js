$(document).ready(function(){
	var teacherList;

		$("#index3-news-content-area").append("<br/><p class='department2-orgTitle'><b>教授</b></p><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> "+
				"<br/><p class='department2-orgTitle'><b>副教授</b></p><p id='t2' class='department2-teacher'></p><hr class='tchHr'/> "+
				"<br/><p class='department2-orgTitle'><b>讲师</b></p><p id='t3' class='department2-teacher'></p><br/><hr class='tchHr'/> "+
				"<br/><p class='department2-orgTitle'><b>助教</b></p><p id='t4' class='department2-teacher'></p><br/><hr class='tchHr'/> "+
				"<br/><p class='department2-orgTitle'><b>行政人员</b></p><p id='t5' class='department2-teacher'></p><br/><hr class='tchHr'/> ");
		$.getJSON("tchAction!queryAllTches?",function(data){
			teacherList = data.tchesList;
			var list = new String();
			$.each(teacherList,function(i){
				
				if(i>=2&&(list.indexOf(teacherList[i].tchName)!=-1)){
					//用于去掉表中重复的老师
				}
				else{
					list = list+" "+teacherList[i].tchName;
				if(teacherList[i].tchTitle==null)
					$("#t5").append("<a class='tchLink' href='tchInfo.jsp?tchId="+teacherList[i].teacherId+"'>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
				else if(teacherList[i].tchTitle=="教授")
					$("#t1").append("<a class='tchLink' href='tchInfo.jsp?tchId="+teacherList[i].teacherId+"'>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
				else if(teacherList[i].tchTitle=="副教授")
					$("#t2").append("<a class='tchLink' href='tchInfo.jsp?tchId="+teacherList[i].teacherId+"'>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
				else if(teacherList[i].tchTitle.indexOf("讲师")!=-1)
					$("#t3").append("<a class='tchLink' href='tchInfo.jsp?tchId="+teacherList[i].teacherId+"'>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
				else if(teacherList[i].tchTitle.indexOf("助教")!=-1)
					$("#t4").append("<a class='tchLink' href='teacherInfo.jsp?tchId="+teacherList[i].teacherId+"'>"+teacherList[i].tchName+"</a>&nbsp;&nbsp;");
				}
			});
			
		});
		
});