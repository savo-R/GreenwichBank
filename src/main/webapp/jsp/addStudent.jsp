<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- Add Modal HTML -->
<div id="addStudentModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="student-controller?action=add" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Add Student</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Name</label> 
						<input name="name" type="text"	class="form-control" required> 
						<label>PostalAddress</label>
						<input name="postalAddress" type="text" class="form-control" required>
						<label>Email</label>
						<input name="email" type="text" class="form-control" required>
						<label>Telephone</label>
						<input name="telephone" type="text" class="form-control" required>
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
