<%--
  Created by IntelliJ IDEA.
  User: giliev
  Date: 12.12.2019 г.
  Time: 16:15
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Home</title>
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><a href="${createLink(controller: 'administrativeStructures',action: 'index')}"><g:message code="default.home.administrativeStructures.label"/></a></li>
        <li><a href="${createLink(controller: 'bankDetails',action: 'index')}"><g:message code="default.home.bankDetails.label"/></a></li>
        <li><a href="${createLink(controller: 'municipalities',action: 'index')}"><g:message code="default.home.municipalities.label"/></a></li>
        <li><a href="${createLink(controller: 'paymentTransactions',action: 'index')}"><g:message code="default.home.paymentTransactions.label"/></a></li>
        <li><a href="${createLink(controller: 'services',action: 'index')}"><g:message code="default.home.services.label"/></a></li>
        <li><a href="${createLink(controller: 'serviceType',action: 'index')}"><g:message code="default.home.serviceType.label"/></a></li>
        <li><a href="${createLink(controller: 'logout')}"><g:message code="default.home.logout.label"/></a></li>



    </ul>
</div>
<div id="list-municipalities" class="content scaffold-list" role="main">
    <H1>HELLO!</H1>
</div>
</body>
</html>
