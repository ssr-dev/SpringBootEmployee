<%@ page import="co.edu.uptc.firstJavaWebApp.model.Employee" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Información del Empleado</title>
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
    <a href="${pageContext.request.contextPath}/menu">Menu principal</a>
</div>

<div class="Content">
    <h2>Buscar Empleado por ID</h2>
    <form method="post" action="${pageContext.request.contextPath}/showEmployee">
        <label for="emp_id">ID del empleado:</label>
        <input type="number" id="emp_id" name="emp_id" required>
        <button type="submit">Buscar</button>
    </form>

    <c:if test="${empleado != null}">
        <h2>Información del Empleado</h2>
        <table>
            <tr><td>ID:</td><td>${empleado.id}</td></tr>
            <tr><td>Nombre:</td><td>${empleado.name}</td></tr>
            <tr><td>Email:</td><td>${empleado.email}</td></tr>
            <tr><td>Teléfono:</td><td>${empleado.phone}</td></tr>
        </table>
    </c:if>
</div>

</body>
</html>
