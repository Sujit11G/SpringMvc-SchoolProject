<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Update Status</h1>


<form:form action="studentupdate" modelAttribute="updateStudent" method="post">
ID: <form:input path="id" type="id" /><br><br>
Name: <form:input path="name" type="text" /><br><br><br>
Email: <form:input path="email" type="email" /><br><br><br>
<form:button >Update</form:button>

</form:form>
</body>
</html>