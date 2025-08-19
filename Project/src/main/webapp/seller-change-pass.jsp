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
					<form action="SellerController" method="post">
						<h4 class="mtext-105 cl2 txt-center p-b-30">Seller Profile</h4>
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
						<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="hidden" name="email" value="<%=s.getEmail()%>">
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="password" name="op" placeholder="Old Password">
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="password" name="np" placeholder="New Password">
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="password" name="cnp" placeholder="Confirm New Password">
						</div>

						<button
							class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer"
							name="action" value="cp">Change Password</button>
					</form>
				</div>


			</div>
		</div>
	</section>
</body>
</html>