<%@ include file="/views/import.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/views/headerAssets.jsp" %>

<title>Create user</title>

</head>
<body>
 <jsp:include page="header.jsp"/>
 <div class="container">
	 
	 <div class="text-left">
		<div class="row-fluid"><div class="col-md-12"><hr></div></div>
	 	<div class="row-fluid"><div class="col-md-12"><hr></div></div> 
	 	<form:form method="POST" id="editUser" commandName="editUser" action="${pageContext.request.contextPath}/admin/editUser/${user.id}">
	 	<p class="text-warning col-sm-4 col-sm-offset-4" id="message">${errorMessage}</p>
	 	
		 	<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
			 	<label for="userName">Full name</label>
			 	<div class="form-group">
			 		<form:input id="userName" path="userName" class="form-control" type="text"  value="${user.userName}" />
			 	</div>
		 	</div>
			<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
			 	<label for="emailAdress">Email</label>		 			 		
			 	<div class="input-group">
			 		<span class="input-group-addon">@</span>
			 		<form:input readonly="true" id="emailAdress" path="emailAdress" class="form-control" type="email" value="${user.emailAdress}" />		 			
			 	</div>
		 	</div>
		 	<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
			 	<label for="newPassword">New Password</label>
			 	<div class="form-group">
			 		<form:input id="newPassword" path="newPassword" class="form-control" type="password"/>
			 	</div>
		 	</div>
		 	<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
			 	<label for="retypePassword">Retype password</label>
			 	<div class="form-group">
			 		<form:input id="retypePassword" path="retypePassword" class="form-control" type="password"/>
			 	</div>
		 	</div>
		 	<div class="form-group col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
                <div class="col-sm-8 col-sm-offset-2"><form:label path="lecturer" class="control-label"> Lecturer role</form:label></div>
                <div class="col-sm-offset-6"><label><form:checkbox path="lecturer"/></label></div>
             </div>
	          <div class="form-group col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
	            <div class="col-sm-8 col-sm-offset-2"><form:label path="admin" class="control-label"> Admin role</form:label></div>
	            <div class="col-sm-offset-6"><label><form:checkbox path="admin"/></label></div>
	          </div>
		 	
		 	
		 	<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 col-lg-4 col-lg-offset-4">
			 	<div class="form-group">
			 		<button id="submitButton" type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user"></span> Save</button>
			 	</div>
		 	</div>
	 	</form:form>
	 </div>
	 
 </div>
 

 <script type="text/javascript">
 $(document).ready(function(){
     $("#submitButton").click(function(){
         var new1 = $("#newPassword").val();
         var new2 = $("#retypePassword").val();
           if( new1 === new2 ){
        	   if(new1.length == 0){
        		   $("#form").submit();
        	   }else{
                   if (new1.length > 7){
                       if (new1.match(/(^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[-?#!_])[a-zA-Z0-9-?#!_]{3,}$)/)){
                         $("#form").submit();
                       }
                       else{
                         $("#message").html("Your password is too weak, please enter a new one! The password should contain letters, at least one digit and special character: [-?#!_]");
                       }
                     }
                     else{
                       $("#message").html("Your password length must be at least 8 characters!");
                     }
        	   }
           }
           else{
             $("#message").html("Your retype password must match your new password!");
           }
       });
     });

 </script>
 
</body>
</html>