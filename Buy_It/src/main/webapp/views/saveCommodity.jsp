<%--
  Created by IntelliJ IDEA.
  User: koko
  Date: 22.05.16
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>saveCommodity</title>
</head>
<body>
    <h1>save commodity</h1>

    <form action="saveCommodity" method="post">
        <label>enter commodity name and price</label>
        <br>
        <input name="commodityName" type="text"/>
        <input name="commodityPrice" type="text"/>
        <select name="subCategoryId">
            <c:forEach items="${subCategories}" var="subCategory">
                <option value="${subCategory.id}">${subCategory.subCategoryName}</option>
            </c:forEach>
        </select>

        <input name="save" type="submit"/>
    </form>

    <form action="deleteCommodity">
        <label>enter commodity name for remove</label>
        <br>
        <input type="text" name="nameCommodity"/>
        <input type="submit" name="delete">
    </form>

    <c:forEach items="${commodities}" var="commodity">
        ${commodity.commodityName} ${commodity.price} ${commodity.subCategory.subCategoryName} ${commodity.subCategory.category.categoryName}
        <br>
    </c:forEach>
</body>
</html>
