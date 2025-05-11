<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="co.edu.uptc.firstJavaWebApp.model.Order" %>
<html>
<head>
    <title>Buscar Pedidos</title>
    <style>
        <%@include file="../css/empStyle.css" %>
    </style>
</head>
<body>

<div class="topnav">
    <!-- Usa el mismo menú que tienes en showEmployee.jsp -->
    <a href="${pageContext.request.contextPath}/introaddemployee">Crear empleado</a>
    <!-- ... más enlaces ... -->
    <a href="${pageContext.request.contextPath}/introShowOrder">Encontrar mis pedidos</a>
    <a href="${pageContext.request.contextPath}/showOrders">Mostrar todos los pedidos</a>
    <a href="${pageContext.request.contextPath}/menu">Menu principal</a>
</div>

<div class="Content">
    <h2>Buscar Pedidos por ID de Cliente</h2>
    <form method="post" action="${pageContext.request.contextPath}/showOrder">
        <label for="customer_id">ID del Cliente:</label>
        <input type="number" id="customer_id" name="customer_id" required>
        <button type="submit">Buscar</button>
    </form>

    <c:if test="${not empty orders}">
        <h2>Pedidos encontrados</h2>
        <table>
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
</div>

</body>
</html>
