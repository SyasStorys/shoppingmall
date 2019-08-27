<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	<div class="row">
	
	<c:if test="${not empty message }">
	
		<div class="col-xs-12">
			
			<div class="alert  alert-success alert-dismissible">
				<button type="button" class="close" data-dimiss="alert">&times;</button>
				
				${message }
			</div>
			
		</div>
	
	</c:if>
	
	
	
	
		<div class="com-md-offset-2 col-md-8">
			<div class="panel panel-primary">
			
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				
				<div class="panel-body">
					<!-- FORM ELEMENT -->
					<sf:form action="${contextRoot }/manage/products" class="form-horizontal" modelAttribute="product" method="POST">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control" />
								<em class="help-block">
									Please enter Product Name!
								</em>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control" />
								<em class="help-block">
									Please enter Brand Name!
								</em>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product Description: </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4" placeholder="Write a description for the product!" class="form-control"></sf:textarea>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter Unit Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Unit Price In &#8377" class="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Quantity Available: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Select Category: </label>
							<div class="col-md-8">
								<sf:select path="categoryId" id="categoryId" class="form-control" 
									items="${categories }"
									itemLabel="name"
									itemValue="id"
								/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit" placeholder="Brand Name" class="btn btn-primary" />
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>