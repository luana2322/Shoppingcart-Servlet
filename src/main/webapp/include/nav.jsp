<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>

<nav
	class="navbar navbar-expand-lg navbar-light  navbar navbar-dark bg-primary">
	<a class="navbar-brand" href="#">Shopping card</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link active" href="order.jsp">Order</a>
			</li>
			<li class="nav-item dropdown"><a class="nav-link active"
		
				href="card2.jsp" role="button" aria-expanded="false"> Cards <span style="color:red;position: absolute;transform: translateY(-50%);font-weight: 600; ">${requestScope.pronum}</span>  </a></li>



			<%
			User user = (User) request.getSession().getAttribute("user");
			%>

			<%
			if (user != null) {
			%>
			<li class="nav-item active"><a class="nav-link" href="logout">Logout</a>
			</li>
			<li class="nav-item active"><a class="nav-link " href="#"><%=user.getUsername()%></a>
			</li>

			<%
			} else {
			%>


			<li class="nav-item active"><a class="nav-link "
				href="login.jsp">Login</a></li>
			<%
			}
			%>

			<%--
      Use session
      
      <c:set var="user1" value="${sessionScope.user}" />
      <c:if test="${user1!=null}">
       <li class="nav-item active">
        <a class="nav-link " href="#">${user1.getUsername()}</a>
      </li> 
      </c:if>
      
      
       --%>



		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>