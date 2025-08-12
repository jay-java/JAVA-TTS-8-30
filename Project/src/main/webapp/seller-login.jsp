<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
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
					<form action="SellerController" method="post">
						<h4 class="mtext-105 cl2 txt-center p-b-30">Seller Login</h4>
						<%
						String msg = (String) request.getAttribute("msg");
						%>
						<%
						if (msg != null) {
						%>
						<h5 class="mtext-105 cl2 txt-center p-b-30">
							<%
							out.print(msg);
							%>
						</h5>
						<%
						}
						%>

						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="email" name="email" placeholder="Your Email">
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="password" name="password" placeholder="Your Password">
						</div>


						<button
							class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer"
							name="action" value="login">Login</button>
					</form>


					<div class="size-212 p-t-2">

						<p class="stext-115 cl1 size-213 p-t-18">
							<a href="seller-forgot-password.jsp" class="__cf_email__"
								data-cfemail="1b7874756f7a786f5b7e637a766b777e35787476">Forgot
								Password?</a>
						</p>
					</div>
				</div>



			</div>
		</div>
	</section>
</body>
</html>