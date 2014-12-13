<%@ include file="/views/import.jsp" %>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="/views/headerAssets.jsp" %>
		<title>Admin users page</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row"><div class="col-md-12"><hr></div></div>
        <div class="row"><div class="col-md-12"><hr></div></div>

        <div class="row"><h3 class="col-md-12">Users</h3></div>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-bordered table-condensed table-hover table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Full Name</th>
                            <th>Email</th>
                            <th>Authority</th>
                            <th class="text-center">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.content}" var="user" varStatus="status">
                        <tr>
                            <td>${(page.pageSize * (page.currentIndex-1)) + status.count}</td>
                            <td>${user.userName}</td>
                            <td>${user.emailAdress}</td>
                            
                            <c:set var="authority" value="User"></c:set>
                            <c:forEach items="${author.authorities}" var="role">
                            	<c:if test="${role.authority  == 'ROLE_ADMIN'}">
                            		<c:set var="authority" value="Admin"></c:set>
                            	</c:if>
                            </c:forEach>
                            <c:if test="${empty author.authorities}">
                            	<c:set var="authority" value="Deleted"></c:set>
                            </c:if>
                            <td>${authority}</td>
                            <td class="table-buttons">
                              <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/editUser/${user.id}">Edit</a>
                              <a id="deleteBtn" class="btn btn-danger" href="${pageContext.request.contextPath}/admin/deleteUser/${user.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row"><div class="col-md-12"><hr></div></div>
        <%@ include file="/views/pagination.jsp"%>

    </div>
	</body>
	
</html>