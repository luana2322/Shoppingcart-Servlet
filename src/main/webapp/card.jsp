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
<c:set var="total" value="${sessionScope.total}" />
	<div class="container">
		<div class="d-flex py-3">
			<h3>Toltal money:${total}</h3>
			<a  class="mx-3 btn btn-primary" href="checkout?id=1" onclick="" >Check-Out</a>
		</div>
		<table class="table table-loght">
		<thead>
			<tr>
				<td scope="col">Name</td>
				<td scope="col">Category</td>
				<td scope="col">Price</td>	
				<td scope="col">Quantity</td>
				<td scope="col">Cancel</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="i" items="${sessionScope.list}">
			<tr>
				<td>${i.getPro().getProName()}</td>
				<td>${i.getPro().getCateID()}</td>
				<td>${i.getPro().getPrice()*i.getQuantity()}</td>
				<td>
					<form action="" method="get" class="form-inline">
					  <input type="hidden" name="id" value="1" class="form-input">
					  <div class="form-group d-fex justify-content-between">
					 <a class="btn btn-sm btn-incre" href="card?action=minus&id=${i.getPro().getProID()}"> <i class="fas fa-minus-square"></i> </a>
					   <input type="text" name="quantity" class="form-control" value="${i.getQuantity()}" readonly>
					  <a class="btn btn-sm btn-incre" href="card?action=plus&id=${i.getPro().getProID()}"> <i class="fas fa-plus-square"></i> </a>
					  </div>
					  
					</form>
				</td>
				<td>
				 <a class="btn btn-sm btn-danger" href="card?action=remove&id=${i.getPro().getProID()}"> Remove </a>
					 
				</td>
			</tr>
</c:forEach>
		</tbody>
		</table>
	</div>
	<script type="text/javascript">
	
	function checkout(){
		if(confirm("CheckOut?")){
			window.location="checkout";
		}
		
	}

	</script>
	<%@include file="include/scipt.jsp"%>
</body>
</html>