<%--
  Created by IntelliJ IDEA.
  User: huyen
  Date: 03/10/2019
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name:</td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
    <tr>
        <td>Img:</td>
        <td>${requestScope["product"].getImg()}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${requestScope["product"].getDescription()}</td>
    </tr>
    <tr>
        <td>Author:</td>
        <td>${requestScope["product"].getAuthor()}</td>
    </tr>
</table>
</body>
</html>
