<%@ include file="/views/import.jsp" %>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="/views/headerAssets.jsp" %>
		<title>My Occupations</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row"><div class="col-md-12"><hr></div></div>
        <div class="row"><div class="col-md-12"><hr></div></div>

        <div class="row"><h3 class="col-md-12">My Occupations</h3></div>
        <div class="btn-group" style="margin-bottom:10px;margin-top:10px;">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/addUserOccupation">Add New</a>
        </div>
        <c:choose>
            <c:when test="${not empty userOccupations}">
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
                            <c:forEach items="${userOccupations}" var="occupation" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${occupation.name}</td>
                                    <fmt:formatDate value="${occupation.dateTime}" var="dateTime" pattern="yyyy-MM-dd HH:mm" />
                                    <td>${dateTime}</td>
                                    <td class="table-buttons">
                                      <a class="btn btn-info" href="${pageContext.request.contextPath}/editUserOccupation/${occupation.id}">Edit</a>
                                      <a id="deleteBtn" class="btn btn-danger" href="${pageContext.request.contextPath}/deleteUserOccupation/${occupation.id}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <h3>There are no occupations.</h3>
            </c:otherwise>
        </c:choose>
        <div class="row"><div class="col-md-12"><hr></div></div>

    </div>
	</body>
	
</html>