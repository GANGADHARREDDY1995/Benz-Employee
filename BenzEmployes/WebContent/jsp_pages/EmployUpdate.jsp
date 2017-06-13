<%@page import="dto.Employe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<%@include file="/jsp_pages/Home.jsp" %>
<form action="/BenzEmployes/update.do" method="post">
	<%
		Employe employ = (Employe) request.getAttribute("empData");
	%>
		<h1 class="header">Employ Update</h1>
		<div class="html_table">
			<table>
				<tr>
					<td><label>Employ Id</label></td>
					<td><input type="text" name="empId" readonly="readonly"
						placeholder="enter employe id" maxlength="20" value="<%=employ.getEmpId() %>" />
					</td>
				</tr>
				<tr>
					<td><label>Employ Name</label></td>
					<td><input type="text" name="empName"
						placeholder="enter employ name" maxlength="20" value="<%=employ.getEmpName() %>" />
					</td>
				</tr>
				<tr>
					<td><label>Employ Phone Number</label></td>
					<td><input type="number" name="empPhoneNumber"
						placeholder="enter employ phone number" maxlength="10" value="<%=employ.getEmpPhoneNumber()%>" />
				</tr>
				<tr>
					<td><label>Employ Address</label></td>
					<td><input type="text" width="100px" height="250px"
						name="empAddress" placeholder="enter employ address" value="<%=employ.getEmpAddress() %>"></td>
				</tr>
				<tr>
					<td><label>Employ Gender</label></td>
					<td>Male:<input type="checkbox" name="empGender" value="m"></td>
					<td>FeMale:<input type="checkbox" name="empGender" value="f"></td>
					<td>Others:<input type="checkbox" name="empGender" value="o"></td>
				<tr>
					<td><label>Employ Email</label></td>
					<td><input type="email" name="empEmail"
						placeholder="enter employ email" value="<%=employ.getEmpEmail()%>"></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit" width="50px"></td>
					<td><input type="reset" value="reset" width="50px"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>