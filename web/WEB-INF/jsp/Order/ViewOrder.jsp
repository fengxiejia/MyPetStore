<%--
  Created by IntelliJ IDEA.
  User: w1507
  Date: 2020/11/22
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="Content">
    <ul class="messages">
        <li>Thank you, your order has been submitted.</li>
    </ul>
    <div id="BackLink">
        <a href="main">Return to Main Menu</a>
    </div>

    <div id="Catalog">

        <table>
            <tbody>
            <tr>
                <th align="center" colspan="2">Order #1000 2014/03/23 10:46:43</th>
            </tr>
            <tr>
                <th colspan="2">Payment Details</th>
            </tr>
            <tr>
                <td>Card Type:</td>
                <td>${sessionScope.cardtype}</td>
            </tr>
            <tr>
                <td>Card Number:</td>
                <td>${sessionScope.cardnum} * Fake number!</td>
            </tr>
            <tr>
                <td>Expiry Date (MM/YYYY):</td>
                <td>${sessionScope.date}</td>
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
            <tr>
                <td>Courier:</td>
                <td>UPS</td>
            </tr>
            <tr>
                <td colspan="2">Status: P</td>
            </tr>
            <tr>
                <td colspan="2">
                    <table>
                        <tbody>
                        <tr>
                            <th>Item ID</th>
                            <th>Description</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total Cost</th>
                        </tr>

                        <tr>
                            <td><a href="viewCategory">EST-4</a></td>
                            <td>Spotted Koi</td>

                            <td>1</td>
                            <td>$18.50</td>
                            <td></td>
                        </tr>

                        <tr>
                            <th colspan="5">Total: $18.50</th>
                        </tr>
                        </tbody>
                    </table>
                </td>
            </tr>

            </tbody>
        </table>

    </div>

</div>
<%@ include file="../common/IncludeBottom.jsp"%>