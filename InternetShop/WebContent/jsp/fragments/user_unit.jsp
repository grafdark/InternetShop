<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/jsp/fragments/header.jsp"%>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		var offset = $("#fixed").offset();
		var topPadding = 15;
		$(window).scroll(function() {
			if ($(window).scrollTop() > offset.top) {
				$("#fixed").stop().animate({
					marginTop : $(window).scrollTop() - offset.top + topPadding
				});
			} else {
				$("#fixed").stop().animate({
					marginTop : 0
				});
			}
			;
		});
	});
</script>
</head>
<body>
	<div id="fixed">
		<c:if test="${not empty login}">
			<b><fmt:message key="message.hello"></fmt:message></b>
			<c:out value="${login}" />
		</c:if>
	</div>
</body>
</html>