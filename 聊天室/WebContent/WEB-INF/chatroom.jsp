<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Chart Room</title>
<script language="javascript" src="jquery-1.6.2.min.js"></script>
<script language="javascript">
$(document).ready(function(){
	//$.ajaxSetup({ cache: false });
	
	$("#submit").click(function(){
		doSubmit();
	});
	
	//$("#message").bind("keyup",enterEvent);
	setInterval("initGet()",1000);
});

function enterEvent(e){
	if(e.keyCode==13){
		doSubmit();
	}
}

function initGet(){
	$("#log").text("");
	$.getJSON("showchat",function(json){
		if(json.count>0){
			var content = json.content;
			for(i=0;i<json.count;i++){
				var name = content[i][0];
				var c = content[i][1];
		        var con = "<font color='green'>" +name + "说：</font><font color='red'>" + c + "</font><br/>";
		        $("#log").append(con);
		    }
	    }
		$("#log").scrollTop($("#log").height()); 
	});
}


function doSubmit(){
	
	var message = $("#message").val();
	if(message==null || message.length == 0){
		alert("请输入内容.");
		$("#message").focus();
		return false;
	}
	$.ajax({
		type: "POST",
	   	dataType:'json',
	   	url: "chatservlet",
	   	data : {
			"content":message
		},
		success: function(result){
	   		
	   	}
	});
	
	$("#message").focus();
    $("#message").val('');
	
}


</script>
</head>
<body>
<center><h3>欢迎你    <%=session.getAttribute("username") %></h3>     <h4><a href="loginout">退出</a></h4></center>	
	<div id="log" style="width:1000px;height:400px;overflow:auto;border: 1px solid #000">
	
	</div>
	
	<div style="padding: 10px 0px 0px 0px">
	<textarea id="message" rows="5" cols="100"></textarea>
	<input id="submit" type="button" value="提交" />	
	</div>
	
	
</body>
</html>