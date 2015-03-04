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
			<c:if test="${not empty goods}">
				<table>
					<tr>
						<td>
							<form action="controller" method="post">
								<input type="hidden" name="page" value="edit_goods" /> <input
									type="hidden" name="id" value="${goods.numberGoods}" />
								<p>
									<fmt:message key="message.goods"></fmt:message>
								</p>
								<input type="text" id="text_area" name="name_goods"
									value="${goods.nameGoods}"> <br /> <br />
								<p>
									<fmt:message key="message.image"></fmt:message>
								</p>
								<input type="file" id="text_area" name="img"
									value="${goods.imgGoods}"> <br />
								<p>
									<fmt:message key="message.description"></fmt:message>
								</p>
								<textarea style="width: 600px; height: 100px;"
									name="description">${goods.description}</textarea>
								<p>
									<fmt:message key="message.price"></fmt:message>
								</p>
								<input type=text name="price" value="${goods.price}"> <br />
								<br /> <input type="submit"
									value='<fmt:message key="button.edit"></fmt:message>' />
							</form>
						</td>
					</tr>
				</table>
			</c:if>
		</div>
		<div id="clearfix"></div>
	</div>
	<div id="footer_section">
		<jsp:include page="/jsp/fragments/footer.jsp" />
	</div>
</body>
</html>