<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Product"%>
<%@ page import="DAO.ProDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="include/bootrap.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<%@include file="include/nav.jsp"%>
<c:set var="total" value="${sessionScope.totalorder}" />
	<div class="container">
		<table class="table table-loght">
		<thead>
			<tr>
				<td scope="col">Date</td>
				<td scope="col">Name</td>
				<td scope="col">Category</td>	
				<td scope="col">Quantity</td>
				<td scope="col">Price</td>
				<td scope="col">Cancel</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="i" items="${sessionScope.listh}">
			<tr>
				<td>${i.getDate()}</td>
				<td>${i.getId_user()}</td>
				<td>${i.getMa_san_pham()}</td>
				<td>${i.getQuantity()}</td>
				<td>${i.getTotal()}</td>
				<td>
				 <a class="btn btn-sm btn-danger" href="#"> Cancel </a>
					 
				</td>
			</tr>
</c:forEach>
		</tbody>
		</table>
	</div>
	
	<%@include file="include/scipt.jsp"%>
</body>
</html>