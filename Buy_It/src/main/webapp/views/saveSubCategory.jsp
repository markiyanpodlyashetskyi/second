<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 25.05.16
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:forEach items="${subCategories}" var="subCategory">
        ${subCategory.subCategoryName} -> ${subCategory.category.categoryName}
        <a href="deleteSubCategory/${subCategory.id}">delete</a>
        <br>
    </c:forEach>

    <sf:form modelAttribute="subCategory" method="post" action="/saveSubCategory">
        <%--<sf:select path="category">
            <c:forEach items="${subCategories}" var="subCategory">
                <sf:option value="${subCategory.id}">${subCategory.subCategoryName}</sf:option>
            </c:forEach>
        </sf:select>--%>
        <sf:input path="subCategoryName"></sf:input>
        <%--<sf:select path="category">
            <c:forEach var="category" items="${categories}">
                <sf:option value="${category.categoryName}">${category.categoryName}</sf:option>
            </c:forEach>
        </sf:select>--%>

        <select name="categoryName">
            <c:forEach items="${categories}" var="category">
                <option value="${category.categoryName}">${category.categoryName}</option>
            </c:forEach>
        </select>
        <input type="submit" value="save subcategory">

    </sf:form>



</body>
</html>
