<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<div id="user_unit">
				<jsp:include page="/jsp/fragments/user_unit.jsp" />
			</div>
			<jsp:include page="/jsp/fragments/category.jsp" />
		</div>
		<div id="unit">
			<br>
			<center>
				<fmt:message key="message.list_user"></fmt:message>
			</center>
			<br>
			<table id="list_user">
				<c:forEach var="user" items="${userList}">
					<tr>
						<td align="justify">
							<form action="controller" method="post">
								<input type="hidden" name="page" value="user_info" /> <input
									type="hidden" name="login" value="${user}" />
								<button class="link" type="submit" id="button_link">${user}</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="clearfix"></div>
	</div>
	<div id="footer_section">
		<jsp:include page="/jsp/fragments/footer.jsp" />
	</div>
</body>
</html>