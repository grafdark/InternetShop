<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resource.pagecontent" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<body>
	<table align="right">
		<tr>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="home" /> <input
						type="hidden" name="home" value="home" /> <input type="submit"
						id="button_input"
						value='<fmt:message key="button.home"></fmt:message>'>
				</form>
			</td>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="profile" /> <input
						id="button_input" type="submit"
						value='<fmt:message key="button.profile"></fmt:message>' />
				</form>
			</td>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="exit" /> <input
						id="button_input" type="hidden" name="exit" value="exit" /> <input
						type="submit"
						value='<fmt:message key="button.exit"></fmt:message>' />
				</form>
			</td>

		</tr>
	</table>
</body>
</html>