<%@page import="dao.ProductDao"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="seller-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<!-- Shoping Cart -->
	<form class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-12 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<tr class="table_head">
									<th class="column-1">Image</th>
									<th class="column-2">Product Name</th>
									<th class="column-3">Price</th>
									<th class="column-4">Category</th>
									<th class="column-5">Description</th>
									<th class="column-5">Edit</th>
									<th class="column-5">Delete</th>
								</tr>
								<%
								List<Product> list = ProductDao.getProductsBySid(s.getId());
								%>
								<%
								for (Product p : list) {
								%>
								<tr class="table_row">
									<td class="column-1">
										<div>
											<img src="pimges/<%=p.getImage()%>" alt="IMG" height="100" width="100%">
										</div>
									</td>
									<td class="column-2"><%=p.getPname()%></td>
									<td class="column-3"><%=p.getPprice()%></td>
									<td class="column-4"><%=p.getPcategory()%></td>
									<td class="column-5"><%=p.getPdesc()%></td>
									<td class="column-5">
										<button
											class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
											Edit</button>
									</td>
									<td class="column-5">
										<button
											class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
											Delete</button>
									</td>
								</tr>
								<%
								}
								%>
							</table>
						</div>

					</div>
				</div>


			</div>
		</div>
	</form>
</body>
</html>