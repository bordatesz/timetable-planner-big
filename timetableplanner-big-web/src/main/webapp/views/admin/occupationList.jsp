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

        <div class="row"><h3 class="col-md-12">User Occupations</h3></div>
        <div class="row">
            <div class="col-md-12">
                <c:forEach items="${users}" var="user">
                    <label for="occupations">${user.userName}</label>
                    <table id="occupations" class="table table-bordered table-condensed table-hover table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Occupation Name</th>
                                <th>Date</th>
                                <th class="text-center">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${user.occupations}" var="occupation" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${occupation.name}</td>
                                <td>${occupation.dateTime}</td>
                                <td class="table-buttons">
                                  <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/editOccupation/${occupation.id}">Edit</a>
                                  <a id="deleteBtn" class="btn btn-danger" href="${pageContext.request.contextPath}/admin/deleteOccupation/${occupation.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:forEach>
            </div>
        </div>
        <div class="row"><div class="col-md-12"><hr></div></div>

    </div>
	</body>
	
</html>