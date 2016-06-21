<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">


<title>Buy_It</title>
</head>
<body dir="rtl">

<form class="form-inline" action="saveCategory" method="get">
  <div class="form-group">
    <label class="sr-only" for="exampleInputEmail3">categoryName</label>
    <input name="categoryName" type="text" class="form-control" id="exampleInputEmail3" placeholder="categoryName">
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form>



	<!-- <form action="saveCategory" method="get">
		<input name="categoryName" type="text"> 
		<input type="submit" value="saveName">
	</form> -->

	<form action="saveCategory" method="get">
		<c:forEach var="category" items="${categories}">
			${category.id} ---- ${category.categoryName}
			<br>
			<a href="/Buy_It/deleteCategory/${category.id}"> delete</a>
			<a href="/Buy_It/updateCategory/${category.id}"> update</a>
		</c:forEach>
	</form>

	<form action="Buy_It/deleteCtagoryByName" method="post">
		<input name="categoryName" type="text"> 
		<input type="submit" value="delete">
	</form>



</body>
</html>