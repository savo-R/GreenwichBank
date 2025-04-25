<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COMP1610 Greenwich Bank</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- RAFA. This is modal code  -->
<link rel="stylesheet" href="css/modal.css">
<!-- RAFA. This is menu navigator  -->
<link rel="stylesheet" href="css/topnav.css">
<!-- RAFA. This is jQuery/script code -->
<script type="text/javascript"> 
/* For edit */
	$(document).on("click", ".edit", function() {
		var myStudentId = $(this).data('id');
		var name = $(this).data('name');
		var postalAddress = $(this).data('postaladdress');
		var email = $(this).data('email');
		var telephone = $(this).data('telephone');
		/* alert(myStudentId + "  " + name + "  " + postalAddress + " " + email); */
		$(".form-group #id").val(myStudentId);
		$(".form-group #newName").val(name);
		$(".form-group #newPostalAddress").val(postalAddress);
		$(".form-group #newEmail").val(email);
		$(".form-group #newTelephone").val(telephone);
	});

	$(document).on(
			"click",
			".delete",
			function() {
				var myStudentId = $(this).data('id');
				var name = $(this).data('name');
				 /* alert(myStudentId + name ); */ 
				$(".form-group #id").val(myStudentId);
				$(".modal-body #student").html(
						"<center>" + myStudentId + " " + name + " "
								+ "</center>");
			});
</script>


</head>
<body>

	<div class="topnav">
		<a href="student-controller" class="btn btn-success">Students</span></a>
		 <a	href="account-controller" class="btn btn-success"><span>Accounts</span></a>
	</div>

	<div class="container">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2>
								Manage <b>Students</b>
							</h2>
						</div>
						<div class="col-xs-6">
							<a href="#addStudentModal" class="btn btn-success"
								data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
									New Student</span></a>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Postal Address</th>
							<th>Email</th>
							<th>Telephone</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="student" items="${students}">
							<tr>
								<td>${student.id}</td>
								<td>${student.name}</td>
								<td>${student.postalAddress}</td>
								<td>${student.email}</td>
								<td>${student.telephone}</td>
								<td> <a href="#editStudentModal" class="edit" data-toggle="modal" 
                    data-id="${student.id}" data-name="${student.name}"
                    data-postaladdress="${student.postalAddress}" 
                    data-email="${student.email}" 
                    data-telephone="${student.telephone}">
                    <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                </a>
                <a href="#deleteStudentModal" class="delete" data-toggle="modal" 
                    data-id="${student.id}" data-name="${student.name}">
                    <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                </a>
            </td>
        </tr>
    </c:forEach>
</tbody>
						
							
							
							<tr>
								<td>2</td>
								<td>Mohammed Ibrahim</td>
								<td>Benidorm</td>
								<td>foo@email2.com34</td>
								<td>234562</td>
								<td><a href="#editStudentModal" class="edit"
									data-toggle="modal" data-name="Mohammed Ibrahim"
									data-postaladdress="Benidorm"
									data-email="foo@email2.com34"
									data-telephone="234562" data-id="2">
										<i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
								</a> 
								<a href="#deleteStudentModal" class="delete"
									data-toggle="modal" data-name="Mohammed Ibrahim"
									data-id=${student.id }
									data-postaladdress="Benidorm"
									data-email="foo@email2.com34"
									data-telephone="234562" data-id="2">
										<i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
								</a></td>
							</tr>
					</tbody>
				</table>

			</div>
		</div>
	</div>

	<jsp:include page="addStudent.jsp"></jsp:include>

	<jsp:include page="editStudent.jsp"></jsp:include>

	<jsp:include page="deleteStudent.jsp"></jsp:include>

</body>
</html>