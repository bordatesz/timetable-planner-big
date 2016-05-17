<%@ include file="/views/import.jsp" %>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="/views/headerAssets.jsp" %>
		<title>Permission violation</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>
		<br><br><br><br>
		<br><br><br><br>
		<div class="jumbotron">
            <div class="alert alert-danger" role="alert">
                <h2>You don't have permission to access this page.</h2><br>
                <p>You must log in as an administrator to access this page.</p>
            </div>
		</div>
	</body>
</html>