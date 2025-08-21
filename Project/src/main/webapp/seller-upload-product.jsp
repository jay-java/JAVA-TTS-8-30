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
	<section class="bg0 p-t-104 p-b-116">
		<div class="container">
			<div class="flex-w flex-tr">
				<div
					class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
					<form action="ProductController" method="post" enctype="multipart/form-data">
						<h4 class="mtext-105 cl2 txt-center p-b-30">Seller Upload
							Product</h4>
						<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
							type="hidden" name="sid" value="<%=s.getId()%>">

						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="file" name="image">
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="pname" placeholder="Product Name">
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="pprice" placeholder="Product Price">
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="pcategory" placeholder="Product Category">
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="pdesc" placeholder="Product Description">
						</div>
						

						<button
							class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer"
							name="action" value="upload">Upload</button>
					</form>
				</div>


			</div>
		</div>
	</section>
</body>
</html>