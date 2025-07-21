<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Welcome to Simple E-Commerce</h1>
    <a href="cart">View Cart</a>
    <h2>Available Products</h2>
    <c:forEach var="product" items="${products}">
        <div class="product">
            <h3>${product.name}</h3>
            <p>${product.description} - $${product.price}</p>
            <form action="addToCart" method="post">
                <input type="hidden" name="productId" value="${product.id}">
                <button type="submit">Add to Cart</button>
            </form>
        </div>
    </c:forEach>
</body>
</html>
