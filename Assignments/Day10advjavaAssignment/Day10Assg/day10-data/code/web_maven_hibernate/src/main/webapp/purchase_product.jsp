<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="purchase.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Choose Product</td>
				<td><select name="productId">
						<c:forEach var="product"
							items="${sessionScope.product_bean.allProducts}">
							<option value="${product.id}">${product.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter Quantity</td>
				<td><input type="number" name="quantity" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Purchase Product" /></td>
			</tr>
		</table>
	</form>
</body>
</html>