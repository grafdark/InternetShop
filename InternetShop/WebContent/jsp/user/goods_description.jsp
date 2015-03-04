<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<body>
	<div id="main_unit">
		<div id="buttons_header">
			<ctg:info-role role="${role}" />
		</div>
		<div id="header_section"></div>
		<div id="right_section">
			<div id="user_unit">
				<jsp:include page="/jsp/fragments/user_unit.jsp" />
			</div>
			<jsp:include page="/jsp/fragments/category.jsp" />
		</div>
		<div id="unit">
			<table width="100%" align="center">
				<c:if test="${not empty goods}">
					<tr>
						<td align="center" colspan="2"><br>${goods.nameGoods}</td>
					</tr>
					<tr>
						<td width="200" align="center"><br> <img
							alt="${goods.imgGoods}"
							src="http://localhost:8080/InternetShop/${goods.imgGoods}"
							width="150px"></td>
						<td>${goods.description}</td>
					</tr>
					<tr>
						<td align="center"><br> <fmt:message key="message.price"></fmt:message>
							${goods.price} $</td>
					</tr>
					<tr>
						<td colspan="2" >
							<form action="controller" method="post">
								<input type="hidden" name="page" value="order" /> <input
									type="hidden" name="sum" value="${goods.price}" /> <input
									type="hidden" name="name_goods" value="${goods.nameGoods}" />
								<input type="hidden" name="id" value="${goods.numberGoods}" />
								<br>
								<fmt:message key="message.quantity"></fmt:message>
								<input type="text"  name="quantity" value="1" pattern="(-?[0-9]{1,3})"><br> <br>
								<p>
									<input type="radio" name="payment" value="1" checked>
									<fmt:message key="message.pay_now"></fmt:message>
								</p>
								<br> <input type="radio" name="payment" value="2">
								<fmt:message key="message.pay_later"></fmt:message>
								<br> <br> <input type="submit"
									value='<fmt:message key="button.order"></fmt:message>'>
							</form>
						</td>
					</tr>
				</c:if>
			</table>
		</div>
		<div id="clearfix"></div>
	</div>
	<div id="footer_section">
		<jsp:include page="/jsp/fragments/footer.jsp" />
	</div>
</body>
</html>