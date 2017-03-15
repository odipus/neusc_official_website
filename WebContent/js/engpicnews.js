
$(document).ready(function() {
	   var currentIndex = 0;
        var DEMO; //函数对象
        var currentID = 0; //取得鼠标下方的对象ID
        var pictureID = 0; //索引ID

        
   
      
        $("#picturenews_piclist li").eq(0).show(); //默认
        autoScroll();
        setTimeout(sdsd,1500);
        function sdsd() {
        	$("#picturenews_btn li").hover(function() {
                StopScrolll();
               $("#picturenews_btn li").removeClass("current"); //所有的li去掉当前的样式加上正常的样式
                $(this).addClass("current"); //而本身则加上当前的样式去掉正常的样式
                currentID = $(this).attr("id"); //取当前元素的ID
                pictureID = currentID.substring(currentID.length - 1); //取最后一个字符
                $("#picturenews_piclist li").eq(pictureID).fadeIn("slow"); //本身显示
                $("#picturenews_piclist li").not($("#picturenews_piclist li")[pictureID]).hide(); //除了自身别的全部隐藏
                $("#picturenews_tx li").hide();
                $("#picturenews_tx li").eq(pictureID).show();

            }, function() {
                //当鼠标离开对象的时候获得当前的对象的ID以便能在启动自动时与其同步
                currentID = $(this).attr("id"); //取当前元素的ID
                pictureID = currentID.substring(currentID.length - 1); //取最后一个字符
                currentIndex = pictureID;
                autoScroll();
            });
        }
        /*
        $("#picturenews_btn li").hover(function() {
            StopScrolll();
            $("#picturenews_btn li").removeClass("current"); //所有的li去掉当前的样式加上正常的样式
            $(this).addClass("current"); //而本身则加上当前的样式去掉正常的样式
            currentID = $(this).attr("id"); //取当前元素的ID
            pictureID = currentID.substring(currentID.length - 1); //取最后一个字符
            $("#picturenews_piclist li").eq(pictureID).fadeIn("slow"); //本身显示
            $("#picturenews_piclist li").not($("#picturenews_piclist li")[pictureID]).hide(); //除了自身别的全部隐藏
            $("#picturenews_tx li").hide();
            $("#picturenews_tx li").eq(pictureID).show();

        }, function() {
            //当鼠标离开对象的时候获得当前的对象的ID以便能在启动自动时与其同步
            currentID = $(this).attr("id"); //取当前元素的ID
            pictureID = currentID.substring(currentID.length - 1); //取最后一个字符
            currentIndex = pictureID;
            autoScroll();
        });
        */
        //自动滚动
        function autoScroll() {
            $("#picturenews_btn li:last").removeClass("current");
            $("#picturenews_tx li:last").hide();
            $("#picturenews_btn li").eq(currentIndex).addClass("current");
            $("#picturenews_btn li").eq(currentIndex - 1).removeClass("current");
            $("#picturenews_tx li").eq(currentIndex).show();
            $("#picturenews_tx li").eq(currentIndex - 1).hide();
            $("#picturenews_piclist li").eq(currentIndex).fadeIn("slow");
            $("#picturenews_piclist li").eq(currentIndex - 1).hide();
            currentIndex++; currentIndex = currentIndex >= 4 ? 0 : currentIndex;
            DEMO = setTimeout(autoScroll, 3500);
        }
        function StopScrolll()//当鼠标移动到对象上面的时候停止自动滚动
        {
            clearTimeout(DEMO);
        }
});