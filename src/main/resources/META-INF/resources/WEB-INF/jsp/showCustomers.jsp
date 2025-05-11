<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="co.edu.uptc.firstJavaWebApp.model.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Lista de Empleados</title>
    <style>
        <%@include file="../css/empStyle.css" %>
    </style>
</head>
<body>

<div class="topnav">
    <a href="${pageContext.request.contextPath}/introaddemployee">Crear empleado</a>
    <a href="${pageContext.request.contextPath}/introModifyEmployee">Modificar empleado</a>
    <a href="${pageContext.request.contextPath}/introShowEmployee">Buscar empleado</a>
    <a href="${pageContext.request.contextPath}/showEmployees">Mostrar empleados</a>
    <a href="${pageContext.request.contextPath}/introDeleteEmployee">Borrar Empleado</a>

    <a href="${pageContext.request.contextPath}/introAddCustomer">Crear cliente</a>
    <a href="${pageContext.request.contextPath}/introModifyCustomer">Modificar cliente</a>
    <a href="${pageContext.request.contextPath}/introShowCustomer">Buscar cliente</a>
    <a href="${pageContext.request.contextPath}/showCustomers">Mostrar clientes</a>
    <a href="${pageContext.request.contextPath}/introDeleteCustomer">Borrar clientes</a>

    <a href="${pageContext.request.contextPath}/introAddOrder">Agregar un pedido</a>
          <a href="${pageContext.request.contextPath}/introModifyOrder">Editar un pedido</a>
          <a href="${pageContext.request.contextPath}/introDeleteOrder">Eliminar un pedido</a>
          <a href="${pageContext.request.contextPath}/introShowOrder">Encontrar mis pedidos</a>
          <a href="${pageContext.request.contextPath}/showOrders">Mostrar todos los pedidos</a>
    <a href="${pageContext.request.contextPath}/menu">Menu principal</a>
</div>

<div class="Content">

    <c:choose>
    <c:when test="${empty customers}">
        <h2>Lista de clientes vacía</h2>
    </c:when>
    <c:otherwise>
        <h2>Lista de Empleados</h2>
        <table>
            <tr>
                <th>Documento de identidad</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Dirección</th>
            </tr>
            <c:forEach items="${customers}" var="cust">
                <tr>
                    <td>${cust.id}</td>
                    <td>${cust.name}</td>
                    <td>${cust.email}</td>
                    <td>${cust.address}</td>
                </tr>
            </c:forEach>
        </table>
         </c:otherwise>
        </c:choose>
</div>

</body>
</html>
