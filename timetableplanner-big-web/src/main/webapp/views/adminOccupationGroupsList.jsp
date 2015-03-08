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
        <div class="row"><div class="col-md-12"><hr></div></div>
        <div class="row"><div class="col-md-12"><hr></div></div>

        <div class="row"><h3 class="col-md-12">User Occupation Groups</h3></div>
        <c:choose>
            <c:when test="${not empty page.content}">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-bordered table-condensed table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th class="text-center">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${page.content}" var="occupationGroup" varStatus="status">
                                <tr>
                                    <td>${(page.pageSize * (page.currentIndex-1)) + status.count}</td>
                                    <td>${occupationGroup.name}</td>

                                    <td class="table-buttons">
                                      <a class="btn btn-info" href="">Add member</a>
                                      <a id="deleteBtn" class="btn btn-danger" href="${pageContext.request.contextPath}/admin/deleteOccupationGroup/${occupationGroup.id}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <h3>There are no occupation groups.</h3>
            </c:otherwise>
        </c:choose>
        <div class="row"><div class="col-md-12"><hr></div></div>
        <%@ include file="/views/pagination.jsp"%>

    </div>
	</body>
	
</html>