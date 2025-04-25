<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- Delete Modal HTML -->
<div id="deleteBookModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="account-controller?action=delete" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Delete Book</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>

				<div class="modal-body">
					<p>Are you sure you want to delete this Record?</p>

					<p id="title"></p>
					<p class="text-warning">
						<small>This action can be undone</small>
					</p>
				</div>


				<div class="form-group">
					<input type="hidden" id="id" name="id">
				</div>

				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal"
						value="Cancel"> <input type="submit"
						class="btn btn-danger" value="Delete">
				</div>
			</form>
		</div>
	</div>
</div>