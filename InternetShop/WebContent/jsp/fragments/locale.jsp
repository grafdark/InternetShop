<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/jsp/fragments/header.jsp"%>
</head>
<body>
	<table align="right">
		<tr>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="language" /><input
						type="hidden" name="language" value="en" /><input type="submit"
						id="lang_button" value="EN">
				</form>
			</td>
			<td>
				<form action="controller" method="post">
					<input type="hidden" name="page" value="language" /><input
						type="hidden" name="language" value="ru" /><input type="submit"
						id="lang_button" value="RU">
				</form>
			</td>
	</table>
</body>
</html>