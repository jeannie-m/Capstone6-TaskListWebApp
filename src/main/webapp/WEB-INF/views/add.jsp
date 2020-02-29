<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<!-- Favicon -->
<link rel="icon" type="image/png"
	href="data:image/png;base64,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">
<!-- Bootstrap core CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<!-- Grab a Bootswatch Theme from https://www.bootstrapcdn.com/bootswatch/ -->
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/flatly/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-yrfSO0DBjS56u5M+SjWTyAHujrkiYVtRYh2dtB3yLQtUz3bodOeialO59u5lUCFF"
	crossorigin="anonymous">
<!-- Your custom styles -->
<link rel="stylesheet" href="/style.css">

<title>Task List || Add Task</title>
</head>
<body>
	<%@ include file="partials/navbar.jsp"%>

	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">

			<form method="post" class="border border-light p-5">

				<p class="h4 mb-4 text-center">New Task</p>
				<div>
					<input type="hidden" name="status" value="false">
				</div>
				<%-- 				<div>
					<input type="hidden" name="user" value="${user.id}">
				</div> --%>
				<div>
					<input type="text" name="name" class="form mb-4"
						placeholder="Task Name" required>
				</div>
				<div>
					<input type="text" name="description" class="form mb-4"
						placeholder="Description">
				</div>
				<div>
					<input type="date" name="dueDate" class="form mb-4"
						placeholder="Duedate">
				</div>
				<div class="form-group">
					<select class="custom-select" name="priorityLevel">
						<option selected="">Priority Level</option>
						<option value="Low">Low</option>
						<option value="Medium">Medium</option>
						<option value="High">High</option>
					</select>
				</div>
				<%-- <label>Category</label> <select name="category">
					<c:forEach var="category" items="${user.myTasks}"> <!--.findByCategoryDistinct  -->

						<option value="${category}">${category}</option>

					</c:forEach> --%>
				<!-- </select> -->
				<!-- 				<div>
					<input type="number" name="priorityLevel" class="form mb-4"
						placeholder="PriorityLevel">
				</div> -->
				<!-- 				<div>
					<input type="text" name="Category" class="form mb-4"
						placeholder="Category">
				</div> -->
				<button type="submit" class="btn btn-primary btn-lg btn-block">Add Task</button>


			</form>

		</div>
		<div class="col-md-4"></div>
	</div>




</body>
</html>