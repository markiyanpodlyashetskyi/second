<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>buy_it</title>
</head>
<body>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<sec:authentication property="name" />

	
		<a href="saveCommodity">save commodity</a> -

	<a href="saveCategory">save category</a> -

	<a href="saveSubCategory">save subcategory</a> -
</sec:authorize>
	<a href="saveUser">registration</a> -

	<!--  <form action="login">
		<input name="userName" type="text" size="3">
		<input name="password" type="text" size="3">
		<input value="login" type="submit">
	</form> -->

	<a href="login">login</a>
	<a href="logout">logout</a>


	<h1 align="center">some commodity from shop</h1>

	<c:forEach var="commodity" items="${commodities}">
        ${commodity.commodityName} -> ${commodity.price}
        <br>
	</c:forEach>

</body>
</html>