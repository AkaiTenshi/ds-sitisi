<div id="wrapper">
		<div id="header">
			<h2>Grant Student Permission</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table class="table table-striped">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Semester</th>
					<th scope="col">Contact</th>
					<th scope="col">Permission</th>
				</tr>
				<!-- loop over and print our students -->
				<c:forEach var="tempStudent" items="${students}">
					<c:if test="${!tempStudent.canSubmit}">
						<form:form action="saveStudent" modelAttribute="student" method="POST">
							<tr>
								<th scope="row">${tempStudent.id}<form:hidden path="id" value="${tempStudent.id}"></form:hidden></td>
								<td>${tempStudent.firstname}<form:hidden path="firstname" value="${tempStudent.firstname}"></form:hidden></td>
								<td>${tempStudent.lastname}<form:hidden path="lastname" value="${tempStudent.lastname}"></form:hidden></td>
								<td>${tempStudent.semester}<form:hidden path="semester" value="${tempStudent.semester}"></form:hidden></td>
								<td>${tempStudent.phone}<form:hidden path="phone" value="${tempStudent.phone}"></form:hidden></td>
								<td><button type="submit" class="btn btn-primary">Grant Permission</button></td>
							</tr>
						</form:form>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>