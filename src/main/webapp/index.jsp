<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>实现web安全之防盗链</title>
<script type="text/javascript" src="static/jquery.min.js"></script>
<script type="text/javascript">
  $(function(){
	  alert("jquery环境成功！");
  });
  function btnClick(){
	//造成跨域请求
    $.ajax({
        type : "POST",//虽然定义请求类型为post，但是通过观察实际请求行可知其为get请求，所以jsonp底层发送的是get请求
        dataType : "jsonp",//数据类型为jsonp  
        jsonp : "jsonpCallback",//服务端用于接收callback调用的function名的参数  
        url : "http://www.chauncywang2.com/B/UserFormServlet",//另一个网站的地址
        data: "userName=张三&sex=male",		
        success : function(data) {
            alert(data.result);
        },
        error : function() {
            alert('fail');
        }
    }); 
  }
</script>
</head>
<body>
    <h1>源图片：</h1>
    <img alt="" width="200px" src="static/man.jpg">
    <button onclick="btnClick();">造成跨域请求</button>
</body>
</html>