<%--
  Created by IntelliJ IDEA.
  User: w1507
  Date: 2020/11/22
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="Content">

    <div id="BackLink">
        <a href="main">Return to Main Menu</a>
    </div>

    <div id="Catalog">
        Please confirm the information below and then press continue...

        <table>
            <tbody>
            <tr>
                <th align="center" colspan="2"><font size="4"><b>Order</b></font>
                    <br> <font size="3"><b> 2014/03/23 10:46:43</b></font></th>
            </tr>

            <tr>
                <th colspan="2">Billing Address</th>
            </tr>
            <tr>
                <td>First name:</td>
                <td>${sessionScope.bfirstname}</td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td>${sessionScope.blastname}</td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td>${sessionScope.baddr1}</td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td>${sessionScope.baddr2}</td>
            </tr>
            <tr>
                <td>City:</td>
                <td>${sessionScope.bcity}</td>
            </tr>
            <tr>
                <td>State:</td>
                <td>${sessionScope.bstate}</td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td>${sessionScope.bzip}</td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>${sessionScope.bcountry}</td>
            </tr>
            <tr>
                <th colspan="2">Shipping Address</th>
            </tr>
            <tr>
                <td>First name:</td>
                <td>ABC</td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td>XYX</td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td>901 San Antonio Road</td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td>MS UCUP02-206</td>
            </tr>
            <tr>
                <td>City:</td>
                <td>Palo Alto</td>
            </tr>
            <tr>
                <td>State:</td>
                <td>CA</td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td>94303</td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>USA</td>
            </tr>

            </tbody>
        </table>


        <a class="Button" href="vieworder">Confirm</a>
    </div>

</div>
<%@ include file="../common/IncludeBottom.jsp"%>