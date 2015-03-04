<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<body>
	<table align="right">
		<tr>
			<td>
				<div id="button">
					<form action="controller" method="post">
						<input  type="hidden" name="page" value="home" /> <input
							type="hidden" name="home" value="home" /> <input id="button_input" type="submit"
							value='<fmt:message key="button.home"></fmt:message>'>
					</form>
				</div>
			</td>
			<td>
				<div id="button">
					<form action="controller" method="post">
						<input type="hidden" name="page" value="profile" /> <input id="button_input"
							type="submit"
							value='<fmt:message key="button.profile"></fmt:message>' />
					</form>
				</div>
			</td>
			<td>
				<div id="button">
					<form action="controller" method="post">
						<input type="hidden" name="page" value="list_user" /> <input id="button_input"
							type="submit"
							value='<fmt:message key="button.user-list"></fmt:message>' />
					</form>
				</div>
			</td>
			<td>
				<div id="button">
					<form action="controller" method="post">
						<input type="hidden" name="page" value="add_goods_page" /> <input id="button_input"
							type="submit"
							value='<fmt:message key="button.add_goods"></fmt:message>' />
					</form>
				</div>
			</td>
			<td>
				<div id="button">
					<form action="controller" method="post">
						<input type="hidden" name="page" value="exit" /> <input
							type="hidden" name="exit" value="exit" /> <input type="submit" id="button_input"
							value='<fmt:message key="button.exit"></fmt:message>' />
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>