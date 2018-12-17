<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width: 500px; margin: 0px auto; text-align: center">


	<div style="text-align: center; margin-top: 40px">

		<form method="post" action="../teacher/${teacher.id}">
			名称： <input name="name" value="${teacher.name}" type="text"> <br>
			<br> <input type="hidden" name="_method" value="PUT"> <input
				type="submit" value="修改">
		</form>

	</div>
</div>
