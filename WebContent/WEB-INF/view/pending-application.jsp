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
					<th>Income</th>
					<th>Siblings</th>
					<th>City</th>
					<th>Documents</th>
					<th>Status</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempApplication" items="${applications}">
					<c:if test="${!tempApplication.approved}">
						<form:form action="saveApplication" modelAttribute="application" method="POST">
							<tr>
								<td>${tempApplication.id}<form:hidden path="id" value="${tempApplication.id}"></form:hidden></td>
								<td>${tempApplication.income}<form:hidden path="income" value="${tempApplication.income}"></form:hidden></td>
								<td>${tempApplication.hasSibling}<form:hidden path="hasSibling" value="${tempApplication.hasSibling}"></form:hidden></td>
								<td>${tempApplication.homeCity}<form:hidden path="homeCity" value="${tempApplication.homeCity}"></form:hidden></td>
								<td>${tempApplication.documents}<form:hidden path="documents" value="${tempApplication.documents}"></form:hidden></td>
								<td>${tempApplication.approved}<form:hidden path="approved" value="${tempApplication.approved}"></form:hidden></td>
								<td><button type="submit">Approve Application</button></td>
							</tr>
						</form:form>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>