<%@ page import="co.edu.uptc.firstJavaWebApp.model.Customer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Información del pedido</title>
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

    <h2>Buscar pedido por documento de identidad del cliente:</h2>
    <form method="post" action="showOrder">
        <label for="cust_id">Documento de identidad del cliente:</label>
        <input type="number" id="cust_id" name="cust_id" required>
        <button type="submit">Buscar</button>
    </form>

    <c:if test="${not empty orders}">
    <h2>Pedidos encontrados:</h2>
    <table border="1">
            <tr>
                <th>ID Pedido</th>
                <th>Fecha</th>
                <th>Descripción</th>
                <th>Estado</th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.dateOrder}</td>
                    <td>${order.descriptionOrder}</td>
                    <td>${order.orderStatus}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty orders and not empty searched}">
    <p style="color: red;">No se encontraron pedidos para ese cliente.</p>
</c:if>

</div>

</body>
</html>
