<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
 	<title>Student Detail Page</title>
</head>
<body>
	<div class="container">
		<h1>Student Details</h1>
		<div>
			<table>
				<thead>
					<tr>
						<th>Student Id</th>
						<th>User Name</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>Date of Joining</th>
						<th>Graduated</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${students}" var="stu">
						<tr>
							<th>${stu.id}</th>
							<th>${stu.userName}</th>
							<th>${stu.fullName}</th>
							<th>${stu.email}</th>
							<th>${stu.doj}</th>
							<th>${stu.isGraduated}</th>
							<th><a href="/delete-student/${stu.id}" class="btn btn-warning">Delete</a></th>
							<th><a href="/update-student/${stu.id}" class="btn btn-primary">Update</a></th>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<a href="/add-student" class="btn btn-success">Add Student</a> 
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>