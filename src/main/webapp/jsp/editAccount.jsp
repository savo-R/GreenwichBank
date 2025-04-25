<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- Edit Modal HTML -->
<div id="editAccountModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="account-controller?action=update" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Edit Account</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>ID</label> 
						<input name="id" id="id" type="text"
							class="form-control" required> 
						<label>Alias</label>
						<input name="newAlias" id="newAlias"
							type="text" class="form-control" required>
						<label>Balance</label>
						<input name="newBalance" id="newBalance"
							type="text" class="form-control" required>
					</div>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal"
						value="Cancel"> <input type="submit" class="btn btn-info"
						value="Save">
				</div>
			</form>
		</div>
	</div>
</div>
