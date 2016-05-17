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

        <div class="row"><h3 class="col-md-12">Courses</h3></div>
        <div class="btn-group" style="margin-bottom:10px;margin-top:10px;">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/createCourse">Add New</a>
        </div>
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
                            <th>Responsible</th>
                            <th class="text-center">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.content}" var="course" varStatus="status">
                        <tr>
                            <td>${(page.pageSize * (page.currentIndex-1)) + status.count}</td>
                            <td>${course.name}</td>
                            <td>${course.curricula}</td>
                            <td>${course.credit}</td>
                            <td>${course.period}</td>
                            <td>${course.hoursPerWeek}</td>
                            <td>${course.type}</td>
                            <td>${course.responsible.userName}</td>
                            <td class="table-buttons">
                              <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/editCourse/${course.id}">Edit</a>
                              <a id="deleteBtn" class="btn btn-danger" href="${pageContext.request.contextPath}/admin/deleteCourse/${course.id}">Delete</a>
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