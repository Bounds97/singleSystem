<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<div style="width: 500px; margin: 0px auto; text-align: center">
			<table align="center" border="1" cellspacing="0">
				<tr>
					<th>id</th>
					<th>name</th>
				</tr>
				<c:forEach items="${teacher}" var="teacher">
					<tr>
						<td>${teacher.id}</td>
						<td>${teacher.name}</td>
						<td><a href="teacher/${teacher.id}">编辑</a></td>
						<td><a class="delete" href="teacher/${teacher.id}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div style="text-align: center">
				<a href="?start=0">首 页</a> <a href="?start=${teacherPage.start-teacherPage.count}">上一页</a> <a href="?start=${teacherPage.start+teacherPage.count}">下一页</a>
				<a href="?start=${teacherPage.last}">末 页</a>
			</div>
			<div style="text-align: center; margin-top: 40px">
				<form method="post" action="teacher">
					名称： <input name="name" value="" type="text"> <br>
					<br> <input type="submit" value="增加">
				</form>
			</div>
		</div>
		<form id="formdelete" action="" method="post">
			<input type="hidden" name="_method" value="DELETE">
		</form>
		<script type="text/javascript">
			/*将post method 改变为delete*/
			$(function() {
				$(".delete").click(function() {
					var href = $(this).attr("href");
					$("#formdelete").attr("action", href).submit();
					return false;
				})
			})
		</script>
	</body>
</html>
