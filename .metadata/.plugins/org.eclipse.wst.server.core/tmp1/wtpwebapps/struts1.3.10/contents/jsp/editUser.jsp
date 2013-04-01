<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/tags-html" prefix="html" %>
<%@ taglib uri="/tags/tags-bean" prefix="bean" %>
<html>
	<head>
		<link rel="stylesheet" href="<html:rewrite page="/contents/style/common.css"/>" type="text/css"/>
		<link rel="stylesheet" href="<html:rewrite page="/contents/style/editUserInfo.css"/>" type="text/css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<title>ユーザ情報編集画面</title>
	</head>
	<body>
		<header>
			<h1>ユーザ情報編集</h1>
			<html:messages id="msg" message="false"  property="correlation">
				<bean:write name="msg" ignore="true"/>
			</html:messages>
		</header>

		<article>
			<section>
				<html:form target="_self">
					<div class="section">
						<h2 id="section1Label" class="sectionLabel">
							ユーザ情報
						</h2>
						<table>
							<tbody>
								<tr>
									<th><label for="userName">名前：</label></th>
									<td><html:text property="userName" styleId="userName" maxlength="20" /></td>
								</tr>
								<tr>
									<th><label for="address">住所：</label></th>
									<td><html:textarea property="address" styleId="address" cols="40" /></td>
								</tr>
								<tr>
									<th><label for="mail">メール：</label></th>
									<td><html:text property="mail" styleId="mail" size="45" maxlength="30" /></td>
								</tr>
								<tr>
									<th><label for="companyName">会社：</label></th>
									<td><html:text property="companyName" styleId="companyName" size="45" maxlength="100" /></td>
								</tr>
								<tr>
									<th><label for="employeeNo">従業員番号：</label></th>
									<td><html:text property="employeeNo" styleId="employeeNo" size="20" maxlength="10" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<html:submit property="" value="登録"/>
					<html:cancel property="" value="キャンセル"/>
				</html:form>
			</section>
		</article>

		<footer>
		</footer>

		<script type="text/javascript">
			j$ = jQuery.noConflict();
			j$(function() {
				
			});
		</script>
	</body>
</html>