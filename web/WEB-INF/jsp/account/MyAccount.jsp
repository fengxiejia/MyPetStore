<%--
  Created by IntelliJ IDEA.
  User: w1507
  Date: 2020/11/19
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.csu.wr.domain.Account" %>
<%@ include file="../common/IncludeTop.jsp"%>
<head>
    <link href="/css/jpetstore.css" rel="stylesheet" type="text/css"/>
</head>
<% Account account = (Account) request.getSession().getAttribute("user");%>
<div id="Content">

    <div id="Catalog">


        <form action="changeInformation" method="post">

            <h3>User Information</h3>

            <table>
                <tbody>
                <tr>
                    <td>User ID:</td>
                    <td>${sessionScope.user.username}</td>
                </tr>
                <tr>
                    <td>New password:</td>
                    <td><input id="stripes--517137302" name="password"
                               type="text"><script type="text/javascript">
                        setTimeout(
                            function() {
                                try {
                                    var z = document
                                        .getElementById('stripes--517137302');
                                    z.focus();
                                    z.select();
                                } catch (e) {
                                }
                            }, 1);
                    </script></td>
                </tr>
                <tr>
                    <td>Repeat password:</td>
                    <td><input name="repeatedPassword" type="text"></td>
                </tr>
                <tr>
                    <td>VerificationCode:</td>
                    <td>
                        <input type="text" name="vCode" size="5" maxlength="4"/>
                        <a href="newAccount"><img border="0" src="verificationCode" name="checkcode"></a>
                    </td>
                </tr>
                </tbody>
            </table>
            <p>${requestScope.message}</p>
            <h3>Account Information</h3>

            <table>
                <tbody>
                <tr>
                    <td>First name:</td>
                    <td><input name="account.firstName" value="${sessionScope.Firstname}" type="text"></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><input name="account.lastName" value="${sessionScope.Lastname}" type="text"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input name="account.email"
                               value="${sessionScope.email}" type="text" size="40"></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input name="account.phone" value="${sessionScope.phone}"
                               type="text"></td>
                </tr>
                <tr>
                    <td>Address 1:</td>
                    <td><input name="account.address1"
                               value="${sessionScope.Address1}" type="text" size="40"></td>
                </tr>
                <tr>
                    <td>Address 2:</td>
                    <td><input name="account.address2" value="${sessionScope.Address2}"
                               type="text" size="40"></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><input name="account.city" value="${sessionScope.city}" type="text"></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td><input name="account.state" value="${sessionScope.state}" type="text"
                               size="4"></td>
                </tr>
                <tr>
                    <td>Zip:</td>
                    <td><input name="account.zip" value="${sessionScope.zip}" type="text"
                               size="10"></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><input name="account.country" value="${sessionScope.country}" type="text"
                               size="15"></td>
                </tr>
                </tbody>
            </table>

            <h3>Profile Information</h3>

            <table>
                <tbody>
                <tr>
                    <td>Language Preference:</td>
                    <td><select name="account.languagePreference">
                        <option selected="selected" value="English">English</option>
                        <option value="Chinese">Chinese</option>
                        <option value="Japanese">Japanese</option>
                    </select></td>
                </tr>
                <tr>
                    <td>Favourite Category:</td>
                    <td><select name="account.favouriteCategoryId">
                        <option value="FISH">FISH</option>
                        <option selected="selected" value="DOGS">DOGS</option>
                        <option value="REPTILES">REPTILES</option>
                        <option value="CATS">CATS</option>
                        <option value="BIRDS">BIRDS</option>
                    </select></td>
                </tr>
                <tr>
                    <td>Enable MyList</td>
                    <td><input name="account.listOption" value="true"
                               type="checkbox" checked="checked"></td>
                </tr>
                <tr>
                    <td>Enable MyBanner</td>
                    <td><input name="account.bannerOption" value="true"
                               type="checkbox" checked="checked"></td>
                </tr>

                </tbody>
            </table>


            <input name="editAccount" value="Save Account Information"
                   type="submit">

        </form>
        <a href="viewListOrder?username=${sessionScope.account.username}">My Orders</a>
    </div>

</div>
<%@ include file="../common/IncludeBottom.jsp"%>