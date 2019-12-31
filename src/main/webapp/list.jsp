<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css3/css.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<table>

		<tr>
			<td colspan="6">
				<form action="list" method="post">
					品牌:<input type="text" name="name" value="${name }"> 发布时间:<input
						type="text" name="start">—<input type="text" name="end">
					<input type="submit" value="百度一下">
					<button>
						<a href="addGoods.jsp">添加</a>
					</button>
					<input type="button" onclick="dels()" value="批量删除">
				</form>
			</td>
		</tr>
		<tr>
			<td><input type="checkbox" onclick="fan()"></td>
			<td>编号</td>
			<td>品牌</td>
			<td>分类</td>
			<td>发布时间</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${pp.list }" var="g">
			<tr>
				<td><input type="checkbox" name="ff" value="${g.id }"></td>
				<td>${g.id }</td>
				<td>${g.name }</td>
				<td>${g.type.tname }</td>
				<td>${g.datea }</td>
				<td>
					<button>
						<a href="updGoods.jsp?id=${g.id }">详情编辑</a>
					</button>

					<button>
						<a href="del?id=${g.id }">删除</a>
					</button>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">当前${pp.pageNum }/${pp.pages }页，共有${pp.total }条数据
				<a href="list?pageNum=${pp.firstPage }">首页</a> <a
				href="list?pageNum=${pp.prePage }">上一页</a> <a
				href="list?pageNum=${pp.nextPage }">下一页</a> <a
				href="list?pageNum=${pp.lastPage }">末页</a>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		function fan() {
			$("[name=ff]").each(function() {
				this.checked = !this.checked;
			})
		}
		
		
		
		
		/* var ids = $("[name='id']:checked").map(function(){
			return $(this).val();
		}).get().join(","); */
		function dels() {
			
			var ids = $("[name='ff']:checked").map(function(){
				return $(this).val();
			}).get().join(",");
			
			
			/* var ids= $("[name='ff']:checked").map(function(){
				return $(this).val();
			}).get().join(","); */
			
			
			//alert(ids)
			/* var ids = "";
			$("[name='ff']:checked").each(function() {
				ids += "," + this.value;
			})
			//alert(ids);
			ids = ids.substring(1); */
			$.post("delGoods", {
				"ids" : ids
			}, function(obj) {
				if (obj) {
					alert("删除成功");
					history.go(0);
				}
			}, "json");
		}
	</script>
</body>
</html>