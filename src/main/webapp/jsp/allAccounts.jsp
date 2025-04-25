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
	$(document).on("click", ".edit", function() {
		var myAccountId= $(this).data('id');
		var balance = $(this).data('balance');
		var alias = $(this).data('alias');
		/* 		alert(myAccountId + balance); */
		$(".form-group #id").val(myAccountId);
		$(".form-group #newAlias").val(alias);
		$(".form-group #newBalance").val(balance);
	});

	$(document).on(
			"click",
			".delete",
			function() {
				var myAccountId = $(this).data('id');
				var balance = $(this).data('balance');
				var alias = $(this).data('alias');
				/* alert(myAccountId +" "+ balance + " " +  myAccountId	); */ 
				$(".form-group #id").val(myAccountId);
				$(".modal-body #alias").html(
						"<center>" + myAccountId + " " + " " + alias + "   " + balance + "</center>");
			});
</script>


</head>
<body>

<div class="topnav">
    <a href="${pageContext.request.contextPath}/student-controller" class="btn btn-success">Students</a>
    <a href="${pageContext.request.contextPath}/account-controller" class="btn btn-success">Accounts</a>
</div>



	<div class="container">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2>
								Manage <b>Accounts</b>
							</h2>
						</div>
						<div class="col-xs-6">
							<a href="#addAccountModal" class="btn btn-success"
								data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
									New Account</span></a>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Owner's ID</th>
							<th>Owner's name</th>
							<th>Alias</th>
							<th>Balance</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="account" items="${accounts}">
	                        <tr>
                            <td>${account.id}</td>
                            <td>${account.student.id}</td>
                            <td>${account.student.name}</td>
                            <td>${account.alias}</td>
                            <td>${account.balance}</td>
                            <td>
                                <a href="#editAccountModal"
                                   class="edit"
                                   data-toggle="modal"
                                   data-id="${account.id}"
                                   data-alias="${account.alias}"
                                   data-balance="${account.balance}">
                                    <i class="material-icons" title="Edit">&#xE254;</i>
                                </a>
                                <a href="#deleteAccountModal"
                                   class="delete"
                                   data-toggle="modal"
                                   data-id="${account.id}"
                                   data-alias="${account.alias}"
                                   data-balance="${account.balance}">
                                    <i class="material-icons" title="Delete">&#xE872;</i>
                                </a>
                            </td>
                        </tr>
                      </c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>



<jsp:include page="addAccount.jsp"></jsp:include>

<jsp:include page="editAccount.jsp"></jsp:include>

<jsp:include page="deleteAccount.jsp"></jsp:include>


</body>
</html>