<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
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
			<br>
			<table width="95%" align="right">
				<tr align="left">
					<c:if test="${not empty user }">
						<td><fmt:message key="message.user"></fmt:message>${user.login}<br />
							<fmt:message key="message.name"></fmt:message>${user.firstName}
							${user.lastName} <br /> <fmt:message key="message.email"></fmt:message>${user.email}
							<br /> <fmt:message key="message.phone"></fmt:message>${user.telephone}</td>
						<c:if test="${not empty user_banned}">
						</c:if>
					</c:if>
				</tr>
			</table>
			<div id="hid_head" >
				<fmt:message key="message.orders"></fmt:message>
			</div>
			<c:forEach var="order" items="${order}">
				<div class="hidd">
					<fmt:message key="message.order_number"></fmt:message>
					${order.numberOrder}
				</div>
				<div class="sly">
					<br>
					<fmt:message key="message.goods"></fmt:message>
					${order.nameGoods}<br>
					<fmt:message key="message.order_sum"></fmt:message>${order.sum}<br>
					<fmt:message key="message.quantity"></fmt:message>${order.quantityGoods}<br>
					<fmt:message key="message.order_date"></fmt:message>${order.dateOrder}<br>
					<fmt:message key="message.payment"></fmt:message>${order.paymentOrder}<br>
					<br>
					<c:if test="${order.paymentOrder eq 'N' }">
						<form action="controller" method="post">
							<input type="hidden" name="page" value="pay" /> <input
								type="hidden" name="numberOrder" value="${order.numberOrder}" />
							<input type="submit"
								value='<fmt:message key="button.pay"></fmt:message>'>
						</form>
					</c:if>
					<c:if test="${order.paymentOrder eq 'Y' }">
						<form action="controller" method="post">
							<input type="hidden" name="page" value="delivered" /> <input
								type="hidden" name="numberOrder" value="${order.numberOrder}" />
							<input type="submit"
								value='<fmt:message key="button.delivered"></fmt:message>'>
						</form>
					</c:if>
				</div>
			</c:forEach>
			${paid}
		</div>
		<div id="clearfix"></div>
	</div>
	<div id="footer_section">
		<jsp:include page="/jsp/fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
		$('.hidd').click(
				function() {
					$(this).toggleClass('active').next()[$(this).next().is(
							':hidden') ? "slideDown" : "fadeOut"](400);
				});
	</script>
</body>
</html>