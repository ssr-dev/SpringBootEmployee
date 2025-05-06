<%@ page import="co.edu.uptc.firstJavaWebApp.model.Employee" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <a href="${pageContext.request.contextPath}/menu">Menu principal</a>
</div>

<div class="Content">
    <h2>Buscar Empleado por ID</h2>
    <form method="post" action="${pageContext.request.contextPath}/showEmployee">
        <label for="emp_id">ID del empleado:</label>
        <input type="number" id="emp_id" name="emp_id" required>
        <button type="submit">Buscar</button>
    </form>

    <%
        Employee emp = (Employee) request.getAttribute("empleado");
        if (emp != null) {
    %>
    <h2>Información del Empleado</h2>
    <table>
        <tr><td>ID:</td><td><%= emp.getId() %></td></tr>
        <tr><td>Nombre:</td><td><%= emp.getName() %></td></tr>
        <tr><td>Email:</td><td><%= emp.getEmail() %></td></tr>
        <tr><td>Teléfono:</td><td><%= emp.getPhone() %></td></tr>
    </table>
    <% } %>
</div>

</body>
</html>
