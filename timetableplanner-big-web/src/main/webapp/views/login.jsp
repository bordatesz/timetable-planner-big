<%@ include file="/views/import.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="/views/headerAssets.jsp" %>

		<title>Login</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>
		<div class="container">
		<div class="text-left">
		 	<div class="row-fluid"><div class="col-md-12"><hr></div></div>
		 	<div class="row-fluid"><div class="col-md-12"><hr></div></div> 
		
			 <h1 align="center"> Please login! </h1>
			 	<form method="POST" id="loginForm"  action="<c:url value='j_spring_security_check' />">
			 	
			 		<div class="col-sm-4 col-sm-offset-4">
					 	<c:if test="${not empty param.err}">
			                <div class="alert alert-danger">
			                	Sorry, your username and password are incorrect - <strong>please try again.</strong>
			                </div>
			                <div><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></div>
			            </c:if>
			            <c:if test="${not empty param.out}">
			                <div class="alert alert-info"><strong>You are now logged out.</strong></div>
			            </c:if>
			            <c:if test="${not empty param.time}">
			                <div class="alert alert-warning"><strong>You've been logged out due to inactivity.</strong></div>
			            </c:if>
		            </div>

					<div class="col-sm-4 col-sm-offset-4">
					 	<label for="username">Email</label>
					 	<div class="input-group">
					 		<span class="input-group-addon">@</span>
					 		<input id="username" name="j_username" class="form-control" type="email" placeholder="Email"/>
					 	</div>
				 	</div>
				 	<div class="col-sm-4 col-sm-offset-4">
					 	<label for="password">Password</label>
					 	<div class="form-group">
					 		<input id="password" name="j_password" class="form-control" type="password" placeholder="Password"/>
					 	</div>
				 	</div>
				 	<div class="col-sm-4 col-sm-offset-4">
					 	<div class="form-group">
					 		<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user"></span> Login</button>
					 	</div>
				 	</div>
			 	</form>
			</div>
		 </div>
	</body>
</html>