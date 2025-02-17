<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Products List</title>
</head>
<body>
<h1>Products for Shop: ${shopName}</h1>
<table border="1">
    <tr>
        <th>Manufacturer</th>
        <th>Website</th>
        <th>Goods</th>
        <th>Price</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.manufacturer}</td>
            <td>${product.website}</td>
            <td>${product.goods}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
<a href="/newProduct?shop=${shopId}">Add New Product</a>
</body>
</html>
