<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<body>
	<div id="main_unit">
		<div id="header_section"></div>
		<center>
			<br />
			<fmt:message key="error.message" />
			<br />
			<fmt:message key="error.code" />${pageContext.errorData.statusCode}
			<br />
			<fmt:message key="error.message_error" />${pageContext.exception}
			<br />
		</center>
		<div id="clearfix"></div>
	</div>
	<div id="footer_section"></div>
</body>
</html>