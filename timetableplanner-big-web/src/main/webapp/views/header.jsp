<%@ include file="/views/import.jsp"%>

<nav class="navbar navbar-inverse navbar-fixed-top " role="navigation">
	<div class="container-fluid">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/"> <c:out value="TEST" /></a>
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	    </div>

	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-right">
	        <sec:authorize ifAnyGranted="ROLE_ADMIN">
	          <li class="dropdown">
	            <a href="#" id="drop" role="button" class="dropdown-toggle" data-toggle="dropdown">Admin page <span class="caret"></span></a>
	            <ul class="dropdown-menu" role="menu" aria-labelledby="drop">
	                <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/admin/createuser">Create users</a></li>
	                <li role="presentation" class="divider"></li>
	                <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/admin/users/1">List Authors</a></li>
	            </ul>
	          </li>
	        </sec:authorize>
	        <sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER">
	        	<li><a href="${pageContext.request.contextPath}/login">Login<br></a></li>
	        </sec:authorize>
	
	        <sec:authorize ifAnyGranted="ROLE_USER">
	        	<li><a href="<c:url value="${pageContext.request.contextPath}/j_spring_security_logout" />">Logout<br></a></li>
	        </sec:authorize>
	      </ul>
	    </div>
  </div>
</nav>
