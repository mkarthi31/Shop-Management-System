<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add New Product</title>
</head>
<body>

<form:form action="/addProduct?shop=${shopId}" modelAttribute="product">

    Manufacturer:
    <form:input path="manufacturer"/>
    <form:errors path="manufacturer" cssClass="error"/>
    <br>

    Website:
    <form:input path="website"/>
    <form:errors path="website" cssClass="error"/>
    <br>

    Goods:
    <form:input path="goods"/>
    <form:errors path="goods" cssClass="error"/>
    <br>

    Price:
    <form:input path="price" type="number"/>
    <form:errors path="price" cssClass="error"/>
    <br>

    <input type="submit" value="Add Product">
</form:form>

</body>
</html>
