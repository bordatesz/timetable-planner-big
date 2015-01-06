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
		<jsp:include page="header.jsp"/>
    <div class="container">
        <a class="btn btn-info" href="${pageContext.request.contextPath}/addUserOccupation">Edit</a>
        <div class="row"><div class="col-md-12"><hr></div></div>
        <div class="row"><div class="col-md-12"><hr></div></div>

        <div class="row"><h3 class="col-md-12">Users</h3></div>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-bordered table-condensed table-hover table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Occupation Name</th>
                            <th>Date</th>
                            <th class="text-center">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.content}" var="occupation" varStatus="status">
                        <tr>
                            <td>${(page.pageSize * (page.currentIndex-1)) + status.count}</td>
                            <td>${occupation.name}</td>
                            <td>${occupation.dateTime}</td>
                            <td class="table-buttons">
                              <a class="btn btn-info" href="${pageContext.request.contextPath}/editOccupation/${occupation.id}">Edit</a>
                              <a id="deleteBtn" class="btn btn-danger" href="${pageContext.request.contextPath}/deleteOccupation/${occupation.id}">Delete</a>
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