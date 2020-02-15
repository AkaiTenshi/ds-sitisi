<div id="wrapper">
		<div id="header">
			<h2>Grant Student Permission</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table class="table table-striped">
				<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Income</th>
					<th scope="col">Siblings</th>
					<th scope="col">City</th>
					<th scope="col">Documents</th>
					<th scope="col">Status</th>
				</tr>
				</thead>
				<tbody>
				<!-- loop over and print our customers -->
				<c:forEach var="tempApplication" items="${applications}">
					<c:if test="${!tempApplication.approved}">
						<form:form action="saveApplication" modelAttribute="application" method="POST">
							<tr>
								<th scope="row">${tempApplication.id}<form:hidden path="id" value="${tempApplication.id}"></form:hidden></td>
								<td>${tempApplication.income}<form:hidden path="income" value="${tempApplication.income}"></form:hidden></td>
								<td>${tempApplication.sibling}<form:hidden path="sibling" value="${tempApplication.sibling}"></form:hidden></td>
								<td>${tempApplication.homeCity}<form:hidden path="homeCity" value="${tempApplication.homeCity}"></form:hidden></td>
								<td>${tempApplication.documents}<form:hidden path="documents" value="${tempApplication.documents}"></form:hidden></td>
								<td><button type="submit" class="btn btn-primary">Approve Application</button></td>
							</tr>
						</form:form>
					</c:if>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>