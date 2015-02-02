<%@ include file="/views/import.jsp" %>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="/views/headerAssets.jsp" %>
		<title>My Courses</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row"><div class="col-md-12"><hr></div></div>
        <div class="row"><div class="col-md-12"><hr></div></div>

        <div class="row"><h3 class="col-md-12">My Courses</h3></div>
        <c:choose>
            <c:when test="${not empty userCourses}">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-bordered table-condensed table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Course Name</th>
                                    <th>Type</th>
                                    <th>Credit</th>
                                    <th>Hours/week</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${userCourses}" var="course" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${course.name}</td>
                                    <td>${course.type}</td>
                                    <td>${course.credit}</td>
                                    <td>${course.hoursPerWeek}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <h3>There are no courses.</h3>
            </c:otherwise>
        </c:choose>
        <div class="row"><div class="col-md-12"><hr></div></div>

    </div>
	</body>
	
</html>