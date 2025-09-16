<%@page import="dao.ProductDao"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="customer-header.jsp"%>
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
	<div class="bg0 p-t-75 p-b-85">
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
									<th class="column-4">Quantity</th>
									<th class="column-5">Total Price</th>
									<th class="column-5">Remove</th>
								</tr>
								<%
								List<Cart> list = CartDao.getCartByCustId(s.getId());
								%>
								<%
								for (Cart w : list) {
								%>
								<%
								Product p = ProductDao.getProductByPid(w.getPid());
								%>
								<tr class="table_row">
									<td class="column-1">
										<div>
											<img src="pimges/<%=p.getImage()%>" alt="IMG" height="100"
												width="100%">
										</div>
									</td>
									<td class="column-2"><%=p.getPname()%></td>
									<td class="column-3"><%=p.getPprice()%></td>
									<td class="column-4">
										<form>
											<input type="number" name="qty" value="<%=w.getQty()%>">
										</form>
									</td>
									<td class="column-5"><%=w.getTotal_price()%></td>
									<td class="column-5"><a
										href="CartController?action=remove&cartid=<%=w.getCart_id()%>"
										class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">Remove</a>
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
	</div>
</body>
</html>