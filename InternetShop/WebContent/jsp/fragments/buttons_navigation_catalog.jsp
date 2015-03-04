<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resource.pagecontent" />
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<body>
	<table border="1" width="100%">
		<tr>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="home" /> <input
						type="hidden" name="home" value="home" /> <input type="submit"
						value='<fmt:message key="button.home"></fmt:message>' />
				</form>
			</td>
			<td align="right">
				<form method="POST" action="controller">
					<input type="hidden" name="page" value="home" /> <input
						type="hidden" name="registr" value="registr" /> <input
						type="submit"
						value='<fmt:message key="button.registration"></fmt:message>' />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>