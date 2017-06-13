<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/Styles.css" />
<title>Insert title here</title>
</head>
<body>
	<%@include file="/jsp_pages/Home.jsp"%>
	<table>
		<tr>
			<td class="td_1"><div></div></td>
			<td class="td_2"><div><jsp:include
						page="/jsp_pages/Failure_page.jsp"></jsp:include></div></td>
			<td class="td_3"><div></div></td>
		</tr>
	</table>
</body>
</html>