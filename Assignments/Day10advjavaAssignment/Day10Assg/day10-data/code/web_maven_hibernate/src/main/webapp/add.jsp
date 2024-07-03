<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product page</title>
</head>
<%--data transfer from request params to JB props --%>
<jsp:setProperty property="*" name="product_bean" />
<body>
	<%--invoke B.L method of java bean to add the product --%>
	
	<c:set var="status"
		value="${sessionScope.product_bean.addNewProduct()}" scope="session" />
	<c:redirect url="/" />
</body>
</html>