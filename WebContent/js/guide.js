$(document).ready(function(){
	var guideTitle = new Array();
  	var guideLevel = new Array();
	var guidePath = new Array();
	var guideId = new Array();
	var guideLower = new Array();
	var guideUpper = new Array();
	var isSection = new Array();
	var upperLevel = new Array();
	
	/*——————————————————————————————————————显示导航条——————————————————————————*/
	
		var count = 0;
		$("div#menu").append("<ul class='menu'></ul>");
		//遍历一级导航栏
		$.getJSON("guideAction!queryAllGuides",function(data){
			var list = data.guideList;
			$.each(list,function(i){
				guideTitle[i] = list[i].guideTitle;
				guideLevel[i] = list[i].guideLevel;
				guidePath[i] = list[i].guidePath;
				guideId[i] = list[i].guideId;
				guideLower[i] = list[i].lowerLevel;
				guideUpper[i] = list[i].upperLevel; 
				isSection[i] = list[i].isSection;
				
				if(guideLevel[i]==1)
					creatGuide(i);
				if(guideLevel[i]==2)
					creatSubGuide(i);
				else
					creatSubGuide(i);
					
			});
		});
		
		//输出一级导航条
		function creatGuide(i){		
			if(guideTitle[i]=="学院首页"){
				$(".menu").append("<div class='menu-line'><img src='../images/menu-line.png'></div>");
				$(".menu").append("<li><a href=../"+guidePath[i]+" class='parent'><span>"+guideTitle[i]+"</span></a></li>");
				$(".menu").append("<div class='menu-line'><img src='../images/menu-line.png'></div>");
			}
			else{
				if(guideLower[i]==1){
					var liId = "guideLi"+guideId[i];
					$(".menu").append("<li><a class='parent'><span>"+guideTitle[i]+"</span></a><div><ul id="+liId+"></ul></div></li>");
					$(".menu").append("<div class='menu-line'><img src='../images/menu-line.png'></div>");
				}else{
					
					$(".menu").append("<li><a href=../jsp/"+guidePath[i]+" class='parent'><span>"+guideTitle[i]+"</span></a></li>");	
					$(".menu").append("<div class='menu-line'><img src='../images/menu-line.png'></div>");
				}		
			}
		}
									

		function creatSubGuide(i){
			var liId = "guideLi"+guideId[i];
			if(guideLower[i]==1){
				$("#guideLi"+guideUpper[i]+"").append("<li><a class='parent'><span>"+guideTitle[i]+"</span></a><div><ul id="+liId+"></ul></div></li>");		
			}
			else{
				
				if(upperLevel[i]==3||guideTitle[i]=="学院领导"||guideTitle[i]=="理事会"){
					$("#guideLi"+guideUpper[i]+"").append("<li><a href=../jsp/"+guidePath[i]+" target=_blank><span>"+guideTitle[i]+"</span></a></li>");
				}
				else{
					$("#guideLi"+guideUpper[i]+"").append("<li><a href=../jsp/"+guidePath[i]+"><span>"+guideTitle[i]+"</span></a></li>");
				}
				
				
			}
		}

		
});
