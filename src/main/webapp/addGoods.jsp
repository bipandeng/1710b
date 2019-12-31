<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/index_work.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<form action="addGoods" method="post">
		名称:<input type="text" name="name"><br> 分类:<select id="s1"
			name="type.tid">
			<option>请选择</option>
		</select><br> 价格:<input type="text" name="price"><br> 
		发布时间:<input type="text" name="datea"><br>
		<input
			type="submit" value="添加">
	</form>
	<!-- 下拉 -->
	<script type="text/javascript">
		$.post("sellist",function(msg){
			for ( var i in msg) {
				$("#s1").append("<option value="+msg[i].tid+">"+msg[i].tname+"</option>");
			}
		},"json")
	</script>
	
</body>
</html>