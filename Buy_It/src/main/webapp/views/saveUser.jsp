<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 24.05.16
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
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
<title>save user</title>
</head>
<body>

<sf:form modelAttribute="user" method="post">
  <div class="form-group">
   
    <label for="exampleInputName1">User Name</label>
    <div class="col-sm-10 col-lg-8 col-md-8">
   		<sf:input path="userName" type="text" class="form-control" id="exampleInputEmail1" placeholder="User Name" required="required"/>
 	</div>
  </div>
 
  <div class="form-group">
  
    <label for="exampleInputPassword1">Password</label>
    
    <sf:input  path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required="required"/>
  
  </div>
  
  <div class="form-group">
  
    <label for="exampleInputEmail1">Email</label>
    
    <sf:input  path="email" type="text" class="form-control" id="exampleInputPassword1" placeholder="email" required="required"/>
  
  </div>
  
  <div class="form-group">
  
    <label for="exampleInputPhone1">Phone</label>
    
    <sf:input  path="phone" type="text" class="form-control" id="exampleInputPassword1" placeholder="phone" required="required"/>
  
  </div>
  
  
  <button type="submit" class="btn btn-default">Submit</button>
</sf:form>





	<%-- <sf:form modelAttribute="user" method="post">
		<label>user name</label>
		<sf:input path="userName" size="5" />
		<label>password</label>
		<sf:input path="password" size="5" />
		<label>email</label>
		<sf:input path="email" size="5" />
		<label>phone</label>
		<sf:input path="phone" size="5" />
		<input type="submit">
	</sf:form>
 --%>

	<form action="deleteUsers" method="post">
		<input name="usernames" type="text"> <input
			value="delete user" type="submit">
	</form>

	<c:forEach items="${users}" var="user">
        ${user.userName} -> ${user.email}
        <br>
	</c:forEach>

</body>
</html>
