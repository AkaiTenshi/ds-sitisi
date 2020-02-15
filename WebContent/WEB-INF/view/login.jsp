
			<div class="container h-100 login-container">
			      <div class="row h-100 justify-content-center align-items-center">
			          <div class="col-md-6 login-form-1">
			          <h3>Login</h3>
			           <form:form action="${pageContext.request.contextPath}/authUser" method="POST">
							<c:if test="${param.error != null}">
								<i>Sorry! Invalid username/password!</i>
							</c:if>		
			
			                  <div class="form-group">
			                      <input name="username" type="text" class="form-control" placeholder="Your Username" value="" />
			                  </div>
			                  <div class="form-group">
			                      <input name="password" type="password" class="form-control" placeholder="Your Password" value="" />
			                  </div>
			                  <div class="form-group">
			                      <input type="submit" class="btnSubmit" value="Login" />
			                  </div>
			                  
			              </form:form>                
			          </div>
			      </div>
			</div>
