<%--
  Created by IntelliJ IDEA.
  User: huyen
  Date: 04/10/2019
  Time: 08:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/products">Back to customer list</a>
</p>
<form method="post" action="/products?action=search">
    <input type="text" name="search">
    <input type="submit" value="Search">
</form>

<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Img</td>
        <td>Description</td>
        <td>Author</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getImg()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getAuthor()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

