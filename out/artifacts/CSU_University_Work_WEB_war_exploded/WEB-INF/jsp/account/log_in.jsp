<%--
  Created by IntelliJ IDEA.
  User: w1507
  Date: 2020/11/19
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="Content">

    <script>
        function reloadImage() {
            //document.getElementById("btn").disabled=true;
            document.getElementById("imgservlet").src = 'validation';
        }
    </script>


    <div id="Catalog">
        <form action="loginto" method="post">
            <p>Please enter your username and password.</p>
            </p>
            <p>
                Username:<input type="text" name="username" /><br /> Password:<input
                    type="password" name="password" /><br />
                <!--  Validation Code:<input type="text" name="validationCode"/>
        <img src="validation" id="imgservlet" onclick="reloadImage()"/>
        -->
                <!--  <input type="button" value="changeImage" onclick="reloadImage()" id="btn">-->
                VerificationCode:<input type="text" name="vCode" size="5" maxlength="4"/>
                <a href="loginto"><img border="0" src="verificationCode" name="checkcode"></a>
            </p>

            <input type="submit" name="signon" value="Login" />
            <p>
                ${requestScope.message}
            </p>
        </form>

        Need a user name and password? <a href="register">Register
        Now!</a>

    </div>

</div>
<%@ include file="../common/IncludeBottom.jsp"%>
