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
	<h5 align="center">${sessionScope.message}</h5>
	<h5>Hello Blogger , ${sessionScope.user_details.firstName}
		${sessionScope.user_details.lastName}</h5>
	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>All Blog Posts</caption>
		<c:forEach var="post" items="${requestScope.posts}">
			<tr>
				<td>${post.id}</td>
				<td>${post.title}</td>
				<td>${post.description}</td>
				<td>${post.content}</td>
				<c:url var="url" value="/blogger/delete_post?postId=${post.id}" />
				<td><a href="${url}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<h5>
		<c:url var="url" value="/user/logout" />
		<a href="${url}">Log Me Out</a>
	</h5>

</body>
</html>