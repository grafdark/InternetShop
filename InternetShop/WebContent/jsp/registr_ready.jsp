<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<body>
	<div id="main_unit">
		<div id="buttons_header">
			<ctg:info-role role="${role}" />
		</div>
		<div id="header_section"></div>
		<div id="right_section">
			<jsp:include page="/jsp/fragments/category.jsp" />
		</div>
		<div id="unit">
		<br>
		<fmt:message key="message.registr_ready"></fmt:message>
			<form action="controller" method="post">
				<input type="hidden" name="page" value="home" /> <input
					type="hidden" name="home" value="home" /> <input id="button_link" type="submit"
					value='<fmt:message key="button.go_home"></fmt:message>'>
			</form>
		</div>
		<div id="clearfix"></div>
	</div>
	<div id="footer_section">
		<jsp:include page="/jsp/fragments/footer.jsp" />
	</div>
</body>
</html>