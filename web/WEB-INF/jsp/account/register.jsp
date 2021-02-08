<%--
  Created by IntelliJ IDEA.
  User: w1507
  Date: 2020/11/19
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="Content">
    <div id="Catalog">

        <form action="write" method="post" name="userInfo" id="userInfo">

            <h3>User Information</h3>

            <table>
                <tr>
                    <td>User ID:</td>
                    <td>
                        <input type="text" name="username" id="username"  onblur="usernameIsExist();"/>
                        <div id="usernameMsg"></div>
                        <script type="text/javascript" src="${pageContext.request.contextPath }/javascript/login.js"></script>
                    </td>
                </tr>
                <tr>
                    <td>New password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>Repeat password:</td>
                    <td><input type="password" name="repeatedPassword"/></td>
                </tr>
            </table>
            <div>
            ${requestScope.message}
            </div>
            <input type="submit" name="newAccount" value="Save Account Information"/>

        </form>
    </div>

</div>
<%@ include file="../common/IncludeBottom.jsp"%>
