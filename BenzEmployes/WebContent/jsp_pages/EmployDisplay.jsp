<%@page import="java.util.List"%>
<%@page import="dto.Employe"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.EmployService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/Styles.css" />
<title>Employ Display</title>
</head>
<body>
	<form method="post" >
		<%@include file="/jsp_pages/Home.jsp"%>
		<table >
			<tr>
				<th></th>
				<th>Emp_ID</th>
				<th>Emp_Name</th>
				<th>Emp_Phone Number</th>
				<th>Emp_Address</th>
				<th>Emp_Gender</th>
				<th>Emp_Email</th>
				<th></th>
				<th></th>
			</tr>
			<%
				List<Employe> list = (List) request.getAttribute("employData");
				for (Employe employe : list) {
			%>

			<tr>
				<td><input type="radio" name="emp_id" id="emp_id"
					value="<%=employe.getEmpId()%>" /></td>
				<td><%=employe.getEmpId()%></td>
				<td><%=employe.getEmpName()%></td>
				<td><%=employe.getEmpPhoneNumber()%></td>
				<td><%=employe.getEmpAddress()%></td>
				<td><%=employe.getEmpGender()%></td>
				<td><%=employe.getEmpEmail()%></td>
				
				<td colspan="3"><a href="/BenzEmployes/delete.do?empid=<%=employe.getEmpId()%>">Delete</a></td>
				<td colspan="4"><a href="/BenzEmployes/empfetching.do?empid=<%=employe.getEmpId()%>">Update</a></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="3"><a href="/BenzEmployes/delete.do">Delete</a></td>
				<td colspan="4"><a href="/BenzEmployes/update.do">Update</a></td>
			</tr>
		</table>
	</form>
</body>
</html>