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
			<form action="controller" method="post">
				<input type="hidden" name="page" value="add_goods" />
				<p>
					<fmt:message key="button.add_goods"></fmt:message>
				</p>
				<br>
				<p>
					<fmt:message key="message.category"></fmt:message>
				</p>
				<select name="name_category" size="1">
					<c:forEach var="category" items="${category}">
						<option value="${category}">${category}</option>
					</c:forEach>
				</select><br> <br> <br>
				<p>
					<fmt:message key="message.goods"></fmt:message>
				</p>
				<input type="text" id="text_area" name="name_goods" value="">
				<br /> <br> <br>
				<p>
					<fmt:message key="message.image"></fmt:message>
				</p>
				<input type="file" name="img" value="">
				<br />
				<br>
				<p>
					<fmt:message key="message.price"></fmt:message>
				</p>
				<input type=text name="price" id="text_area" value="${goods.price}">
				<br /> <br> <br>
				<p>
					<fmt:message key="message.description"></fmt:message>
				</p>
				<textarea cols="70" rows="7" name="description"></textarea>
				<br> <input type="submit"
					value='<fmt:message key="button.add_goods"></fmt:message>'>
			</form>
		</div>
		<div id="clearfix"></div>
	</div>
	<div id="footer_section">
		<jsp:include page="/jsp/fragments/footer.jsp" />
	</div>
</body>
</html>