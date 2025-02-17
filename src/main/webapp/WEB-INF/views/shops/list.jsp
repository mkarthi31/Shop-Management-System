<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-Type" content="text/html; charset=UTF-8">
    <title>Shop List</title>
</head>
<body>
<c:forEach items="${shops}" var="Shop">
    <p>Name:${Shop.name}, Owner:${Shop.owner} <a href="/products?shop=${Shop.id}">[View Products]</a> </p>
</c:forEach>
</body>
</html>