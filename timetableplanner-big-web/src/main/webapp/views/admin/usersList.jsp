<%@ include file="/views/import.jsp" %>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="/views/headerAssets.jsp" %>
		<title>Admin page</title>
	</head>

	<body>
		<jsp:include page="/views/header.jsp"/>
    <div class="container">
        <div class="row"><div class="col-md-12"><hr></div></div>
        <div class="row"><div class="col-md-12"><hr></div></div>

        <div class="row"><h3 class="col-md-12">Users</h3></div>
        <div class="btn-group" style="margin-bottom:10px;margin-top:10px;">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/createUser">Add New</a>
        </div>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-bordered table-condensed table-hover table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Full Name</th>
                            <th>Email</th>
                            <th>Lecturer</th>
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
                            <td>${user.lecturer}</td>

                            <c:set var="authority" value=""></c:set>
                            <c:forEach items="${user.authorities}" var="role">
                            	<c:if test="${role.authority  == 'ROLE_ADMIN'}">
                            		<c:set var="authority" value="${authority} Admin"></c:set>
                            	</c:if>
                            	<c:if test="${role.authority  == 'ROLE_LECTURER'}">
                                    <c:set var="authority" value="${authority} Lecturer"></c:set>
                                </c:if>
                            </c:forEach>
                            <c:if test="${empty user.authorities}">
                            	<c:set var="authority" value=""></c:set>
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