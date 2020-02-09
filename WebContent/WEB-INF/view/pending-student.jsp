<div id="wrapper">
		<div id="header">
			<h2>Grant Student Permission</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Semester</th>
					<th>Contact</th>
					<th>Permission</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempStudent" items="${students}">
					<c:if test="${!tempStudent.canSubmit}">
						<form:form action="saveStudent" modelAttribute="student" method="POST">
							<tr>
								<td>${tempStudent.id}<form:hidden path="id" value="${tempStudent.id}"></form:hidden></td>
								<td>${tempStudent.firstname}<form:hidden path="firstname" value="${tempStudent.firstname}"></form:hidden></td>
								<td>${tempStudent.lastname}<form:hidden path="lastname" value="${tempStudent.lastname}"></form:hidden></td>
								<td>${tempStudent.semester}<form:hidden path="semester" value="${tempStudent.semester}"></form:hidden></td>
								<td>${tempStudent.phone}<form:hidden path="phone" value="${tempStudent.phone}"></form:hidden></td>
								<td>${tempStudent.canSubmit}<form:hidden path="canSubmit" value="${tempStudent.canSubmit}"></form:hidden></td>
								<td><button type="submit">Grant Permission</button></td>
							</tr>
						</form:form>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>