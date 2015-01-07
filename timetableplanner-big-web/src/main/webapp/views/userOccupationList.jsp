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
        <div class="btn-group" style="margin-bottom:10px;">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/addUserOccupation">Add New</a>
        </div>
        <br>
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
                            <td>${(page.pageSize * (page.currentIndex-1)) + status.count}</td>
                            <td>${occupation.name}</td>
                            <td>${occupation.dateTime}</td>
                            <td class="table-buttons">
                              <a class="btn btn-info" href="${pageContext.request.contextPath}/editOccupation/${occupation.id}">Edit</a>
                              <a id="deleteBtn" class="btn btn-danger" href="${pageContext.request.contextPath}/removeUserOccupation/${occupation.id}">Remove</a>
                              <a id="deleteBtn" class="btn btn-danger" href="${pageContext.request.contextPath}/deleteUserOccupation/${occupation.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row"><div class="col-md-12"><hr></div></div>

    </div>
	</body>
	
</html>