<%@ include file="/views/import.jsp" %>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="/views/headerAssets.jsp" %>
		<title>Default error page</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>
		<br><br><br><br>
		<br><br><br><br>
		<div class="alert alert-danger" role="alert">
			<h2>Default error page</h2><br>
			<strong>Error: </strong> An unexpected error occured, please call the admin.
			<h4>${pageContext.errorData.requestURI}</h4>
			<h4>${pageContext.errorData.throwable.message}</h4>
		</div>
	</body>
</html>