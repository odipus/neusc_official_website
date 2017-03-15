var leftOrder;
var rightOrder;
var center_leftOrder;
var center_rightOrder;


$(document).ready(function() {

	$('div#index-left').sortable({
		connectWith: '.connectedSortable',
		receive: function(event, ui) {
			var childs = $(this).children("div");
			
			$(this).children("div").each(function(data){
				/*$(this).$("div:eq(0)").attr("class","index-side-header"); 
				$(this).$("div:eq(1)").attr("class","index-side-line"); 
				$(this).$("div:eq(2)").attr("class","index-side-content"); 
				$(this).$("div:eq(3)").attr("class","index-side-bottom"); 
				*/
				
		
//				var ss = $(this).children("div");
//				var kid =$(this);
//				console.log(kid, kid.attr('id'), kid.attr('class'));
//				console.log(ss);
				
				$(this).attr("class","index-side");
				 $(this).children("div").each(function(data){
					 if(data==0){
						 $(this).attr("class","index-side-header");
					 	 $(this).children("span").attr("class","part-name");
					 }
					 if(data==1)
						 $(this).attr("class","index-side-line");
					 if(data==2)
						 $(this).attr("class","index-side-content");
					 if(data==3)
						 $(this).attr("class","index-side-bottom");
					 
				 });
		
				//$("ss:eq(1)").attr("class","index-side-header");
				//$(this).children(".23").attr("class","index-side-header");
				//alert($(this).children(".23").attr("id"));
				//$(this).firstChild().attr("class","index-side-header");x
				//$("div#index-side div:nth-child(1)").attr("class","index-side-header"); 
			});
			
		 },
		 stop:saveLayout 
		 
	});

    $('div#index-right').sortable({
    	connectWith: '.connectedSortable',
    	receive: function(event, ui) {
			$(this).children("div").each(function(){
				$(this).attr("class","index-right-side");
				 $(this).children("div").each(function(data){
					 if(data==0){
						 $(this).attr("class","index-right-header");
					 	 $(this).children("span").attr("class","part-name");
					 }
					 if(data==1)
						 $(this).attr("class","index-right-line");
					 if(data==2)
						 $(this).attr("class","index-right-body");
					 if(data==3)
						 $(this).attr("class","index-right-bottom");
					 
				 });
			});
    	} ,
    	stop:saveLayout 
    
		
    });
    $('div#index-center-left ').sortable({
    	connectWith: '.connectedSortable',
    	receive: function(event, ui) {
			$(this).children("div").each(function(){
				$(this).attr("class","index-center-news");
				 $(this).children("div").each(function(data){
					 if(data==0){
						 $(this).attr("class","index-center-header");
					     $(this).children("span").attr("class","part-name2");
					 }
					 if(data==1)
						 $(this).attr("class","index-center-line");
					 if(data==2)
						 $(this).attr("class","index-center-content");
					 if(data==3)
						 $(this).attr("class","index-center-bottom");
					 
				 });
			});
    	},
    stop:saveLayout 
	});
    $('div#index-center-right').sortable({
    	connectWith: '.connectedSortable',
    	receive: function(event, ui) {
			$(this).children("div").each(function(){
				$(this).attr("class","index-center-news");
				 $(this).children("div").each(function(data){
					 if(data==0){
						 $(this).attr("class","index-center-header");
					     $(this).children("span").attr("class","part-name2");
					 }
					 if(data==1)
						 $(this).attr("class","index-center-line");
					 if(data==2)
						 $(this).attr("class","index-center-content");
					 if(data==3)
						 $(this).attr("class","index-center-bottom");
					 
				 });
			});
    	},
    stop:saveLayout 
    });
    
	function saveLayout() {
	    //该方法, 可以取出排序容器内的元素的顺序. 
	      leftOrder = $("div#index-left").sortable("toArray");
	      rightOrder = $("div#index-right").sortable("toArray");
	      center_leftOrder = $("div#index-center-left").sortable("toArray");
	      center_rightOrder = $("div#index-center-right").sortable("toArray");  

	}

});


function saveSectionPlace(){
	var State =0;

	if(leftOrder==null)
		alert("页面布局没有发生修改！");
	else{
		var amount = leftOrder.length;
		for(i=0;i<amount;i++){	
			var id = leftOrder[i].substring(4,9);
			$.ajax({
				   type: "POST",
				   url: "sectionAction!saveSectionPlace",
				   data: "sectionId="+id+"&place=left&sectionOrder="+(10-i),
				   success: function(){
					  
				   }
				});	
		}
		
		var amount = rightOrder.length;	
		for(i=0;i<amount;i++){	
			var id = rightOrder[i].substring(4,9);
			$.ajax({
				   type: "POST",
				   url: "sectionAction!saveSectionPlace",
				   data: "sectionId="+id+"&place=right&sectionOrder="+(10-i),
				   success: function(){
					   State= State+1;
				   }
				});	
		}
		
		var amount = center_leftOrder.length;	
		for(i=0;i<amount;i++){	
			var id = center_leftOrder[i].substring(4,9);
			$.ajax({
				   type: "POST",
				   url: "sectionAction!saveSectionPlace",
				   data: "sectionId="+id+"&place=center_left&sectionOrder="+(10-i),
				   success: function(){
					   State= State+1;
				   }
				});	
		}
		
		var amount = center_rightOrder.length;	
		for(i=0;i<amount;i++){	
			var id = center_rightOrder[i].substring(4,9);
			$.ajax({
				   type: "POST",
				   url: "sectionAction!saveSectionPlace",
				   data: "sectionId="+id+"&place=center_right&sectionOrder="+(10-i),
				   success: function(){
					   State= State+1;
				   }
				});	
		}
		
		alert("页面布局保存成功！");
		window.location.reload();
	
		
	}
	
}
       