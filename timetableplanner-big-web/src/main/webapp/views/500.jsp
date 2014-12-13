<%@ include file="/views/import.jsp" %>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="/views/headerAssets.jsp" %>
		<title>500 Server Error</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>
		<br><br><br><br>
		<br><br><br><br>
		<div class="alert alert-danger" role="alert">
			<h2>500 Internal Server Error</h2><br>
			<strong>Error: </strong> The server encountered an unexpected condition which prevented it from fulfilling the request!
		</div>
	</body>
</html>