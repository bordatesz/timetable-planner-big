<%@ include file="/views/import.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/views/headerAssets.jsp" %>

<title>Create course</title>

</head>
<body>
 <jsp:include page="/views/header.jsp"/>
 <div class="container">
	 
	 <div class="text-left">
		<div class="row-fluid"><div class="col-md-12"><hr></div></div>
	 	<div class="row-fluid"><div class="col-md-12"><hr></div></div> 
	 	<form:form method="POST" id="form" commandName="form" action="${pageContext.request.contextPath}/admin/createCourse">
	 	<p class="text-warning col-sm-4 col-sm-offset-4" id="message">${errorMessage}</p>
	 	
		 	<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
			 	<label for="name">Course name</label>
			 	<div class="form-group">
			 		<form:input id="name" path="name" class="form-control" type="text" placeholder="name"/>
			 	</div>
		 	</div>
            <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
            	<label for="curricula">Curricula</label>
            	<div class="form-group">
            		<form:input id="curricula" path="curricula" class="form-control" type="text" placeholder="eg.: 2011"/>
            	</div>
            </div>
            <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
                <label for="credit">Credit</label>
                <div class="form-group">
                    <form:input id="credit" path="credit" class="form-control" type="text" placeholder="eg.: 4"/>
                </div>
            </div>
            <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
                <label for="period">Period</label>
                <div class="form-group">
                    <form:input id="period" path="period" class="form-control" type="text" placeholder="eg.: 2"/>
                </div>
            </div>
            <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
                <label for="hoursPerWeek">Hours/week</label>
                <div class="form-group">
                    <form:input id="hoursPerWeek" path="hoursPerWeek" class="form-control" type="text" placeholder="eg.: 4"/>
                </div>
            </div>
            <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
                <label for="type">Type</label>
                <div class="form-group">
                    <form:input id="type" path="type" class="form-control" type="text" placeholder="kotelezo/szabadon valaszthato"/>
                </div>
            </div>
            <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
                 <label for="responsible">Responsible</label>
                 <div class="form-group">
                     <form:select class="form-control" path="responsible">
                         <form:option value="NONE" label="--- Select ---"/>
                         <form:options items="${lecturers}" itemValue="emailAddress" itemLabel="userName"/>
                     </form:select>
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