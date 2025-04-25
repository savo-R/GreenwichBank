<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- Add Modal HTML -->
<div id="addAccountModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="account-controller?action=add" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Add Account</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Alias</label> 
						<input name="alias" type="text"
							class="form-control" required>
						<label>Balance</label> 
						<input
							name="balance" type="text" class="form-control" required>
						<label>Owner Id</label>
						 <select name="ownerId" class="form-control" required>
							 <c:forEach var="student" items="${students}">
                          		<option value="${student.id}">${student.name}</option>
        					</c:forEach>
						 </select>			
					</div>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal"
						value="Cancel"> <input type="submit"
						class="btn btn-success" value="Add">
				</div>
			</form>
		</div>
	</div>
</div>



