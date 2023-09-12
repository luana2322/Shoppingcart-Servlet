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
<style>
  .card {
    width: 18rem;
    /* Add your desired styles for the card */
  }

  .card-img-top {
    width: 100%;
    height: 200px; /* Adjust the height as per your requirement */
    object-fit: cover; /* Ensure the image fills the container without distortion */
  }

.list {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr 1fr;
}
</style>
</head>
<body>
	<%@include file="include/nav.jsp"%>

	<%
	ProDAO dao = new ProDAO();
	List<Product> list = new ArrayList<>();
	list = dao.getall();
	%>
	<p style="color: red;">${requestScope.error}</p>
	<div class="list">

		<%
		for (Product i : list) {
		%>



		<div class="card" style="width: 18rem;">
			<img class="card-img-top" src="images/<%=i.getImage()%>"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title"><%=i.getProName()%></h5>
				<p class="card-text"><%=i.getProInfor()%></p>
				<p class="card-text"><%=i.getPromanufacturer()%></p>

				<a href="card?action=add&id=<%=i.getProID()%>" class="btn btn-primary">Add To Card</a>
			</div>
		
		</div>

		<%
		}
		%>



	</div>



	<%@include file="include/scipt.jsp"%>
</body>
</html>