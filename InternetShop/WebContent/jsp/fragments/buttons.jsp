<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<body>
	<table align="right">
		<tr>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="home" /> <input
						type="hidden" name="home" value="home" /> <input type="submit" id="button_input"
						value='<fmt:message key="button.home"></fmt:message>' />
				</form>
			</td>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="home" /> <input
						type="hidden" name="login" value="login" /> <input type="submit" id="button_input"
						value='<fmt:message key="button.login"></fmt:message>' />
				</form>
			</td>
			<td>
				<form method="POST" action="controller">
					<input type="hidden" name="page" value="home" /> <input
						type="hidden" name="registr" value="registr" /> <input id="button_input"
						type="submit"
						value='<fmt:message key="button.registration"></fmt:message>' />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>