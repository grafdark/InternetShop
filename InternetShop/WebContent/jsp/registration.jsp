<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<div id="user_unit"></div>
			<jsp:include page="/jsp/fragments/category.jsp" />
		</div>
		<div id="unit">
			<br>
			<p>${usernameExist}</p>

			<form action="controller" method="post">
				<input type="hidden" name="page" value="registration" />
				<table width=100%>
					<tr align="center">
						<td><fmt:message key="message.login"></fmt:message><br /> <input
							title='<fmt:message key="message.incorrect_login"></fmt:message>'
							type="text" name="login" value=""
							pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required="required" />
							<p>${incorrectLogin}</p> <br /> <fmt:message
								key="message.password"></fmt:message> <br /> <input
							type="password" name="password" value=""
							title='<fmt:message key="message.incorrect_password"></fmt:message>'
							pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required="required" />
							<p>${incorrectPassword}</p> <br /> <fmt:message
								key="message.first_name"></fmt:message> <br /> <input
							type="text" name="first_name" value=""
							title='<fmt:message key="message.incorrect_firstname"></fmt:message>'
							pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$" required="required" />
							<p>${incorrectFirstName}</p> <br /> <fmt:message
								key="message.last_name"></fmt:message> <br /> <input
							title='<fmt:message key="message.incorrect_lastname"></fmt:message>'
							type="text" name="last_name" value=""
							pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$" required="required" />
							<p>${incorrectLastName}</p> <br /> <fmt:message
								key="message.email"></fmt:message> <br /> <input type="text"
							name="email" value=""
							title='<fmt:message key="message.incorrect_email"></fmt:message>'
							pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$"
							required="required" />
							<p>${incorrectEMail}</p> <br /> <fmt:message key="message.phone"></fmt:message>
							<br /> <input type="text"
							title='<fmt:message key="message.incorrect_telephone"></fmt:message>'
							name="telephone" value=""
							pattern="((-?[0-9][0-9][0-9][0-9][0-9][0-9][0-9]))"
							required="required" />
						<p>${incorrectTelephone}</p> <br /> <input type="submit"
							value='<fmt:message key="button.registration"></fmt:message>' />
						</td>
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