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

        <div class="row"><h3 class="col-md-12">My Responsibilities</h3></div>
        <c:choose>
            <c:when test="${not empty responsibilities}">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-bordered table-condensed table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Curricula</th>
                                    <th>Credit</th>
                                    <th>Period</th>
                                    <th>Hours/week</th>
                                    <th>Type</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${responsibilities}" var="responsibility" varStatus="status">
                                <tr>
                                    <td>${(page.pageSize * (page.currentIndex-1)) + status.count}</td>
                                    <td>${responsibility.name}</td>
                                    <td>${responsibility.curricula}</td>
                                    <td>${responsibility.credit}</td>
                                    <td>${responsibility.period}</td>
                                    <td>${responsibility.hoursPerWeek}</td>
                                    <td>${responsibility.type}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <h3>There are no responsibilities.</h3>
            </c:otherwise>
        </c:choose>
        <div class="row"><div class="col-md-12"><hr></div></div>

    </div>
	</body>
	
</html>