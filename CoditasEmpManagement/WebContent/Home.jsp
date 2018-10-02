<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="">
	<%-- ${dummy}
		${empList} --%>

		<c:forEach var="employee" items="${empList}">
			<!-- create an html table row -->
			<tr>
				<!-- create cells of row -->
				<td>${employee.name}</td>
				<td>${employee.id}</td>
				<td>${employee.contactNo}</td>
				<td>${employee.managerId}</td>
				<td>${employee.date}</td>
				<td>${employee.in_time}</td>
				<td>${employee.out_time}</td>
				<td>${employee.total_hours}</td>
				<td>${employee.status}</td>
				<td>${employee.joining_date}</td>
				<!-- close row -->
			</tr>
			<br>
			<!-- close the loop -->
		</c:forEach>

	</form>


</body>
</html>