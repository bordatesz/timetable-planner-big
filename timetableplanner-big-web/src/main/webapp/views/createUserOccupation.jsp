<%@ include file="/views/import.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/views/headerAssets.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/datetimepicker-plugin/css/jquery.datetimepicker.css">
<script src="${pageContext.request.contextPath}/resources/datetimepicker-plugin/js/jquery.datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/datetimepicker-plugin/js/jquery.datetimeformat.js"></script>

<title>Create user occupation</title>

</head>
<body>
 <jsp:include page="header.jsp"/>
 <div class="container">
	 
	 <div class="text-left">
		<div class="row-fluid"><div class="col-md-12"><hr></div></div>
	 	<div class="row-fluid"><div class="col-md-12"><hr></div></div> 
	 	<form:form method="POST" id="form" commandName="form" action="${pageContext.request.contextPath}/addUserOccupation">
	 	<p class="text-warning col-sm-4 col-sm-offset-4" id="message">${errorMessage}</p>
	 	
		 	<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
			 	<label for="name">Occupation name</label>
			 	<div class="form-group">
			 		<form:input id="name" path="name" class="form-control" type="text" placeholder="Occupation name"/>
			 	</div>
		 	</div>
            <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
                <label for="dateTime">Date and Time</label>
                <div class="form-group input-group">
                    <form:input id="dateTime" name="dateTime" path="dateTime" class="form-control" type="text"/>
                    <label for="dateTime" class="input-group-addon btn"><span class="glyphicon glyphicon-calendar"></span>
                    </label>
                </div>
            </div>

		 	<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
			 	<div class="form-group">
			 		<button id="submitButton" type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user"></span> Create</button>
			 	</div>
		 	</div>
	 	</form:form>
	 </div>
	 
 </div>
</body>
</html>