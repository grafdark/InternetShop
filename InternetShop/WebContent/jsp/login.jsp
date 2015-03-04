<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<jsp:include page="/jsp/fragments/category.jsp" />
		</div>
		<div id="unit">
			<br>
			<form method="POST" action="controller">
				<input type="hidden" name="page" value="login" />
				<table width=30% align="center">
					<tr align="center">
						<td><fmt:message key="message.login"></fmt:message> <br /> <input
							type="text" name="login" value="" required="required" /> <br />
							<fmt:message key="message.password"></fmt:message> <br /> <input
							type="password" name="password" value="" required="required" />
							<br />
							<p style="color: red;">${userIsBan}</p>${loginMeassage}
							${userNotRegistered}<br /> <input type="submit"
							value='<fmt:message	key="button.login"></fmt:message>' /></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="clearfix"></div>
	</div>
	<div id="footer_section">
		<jsp:include page="/jsp/fragments/footer.jsp" />
	</div>
</body>
</html>