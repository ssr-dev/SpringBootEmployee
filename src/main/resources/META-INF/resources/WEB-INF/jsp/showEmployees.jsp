<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="co.edu.uptc.firstJavaWebApp.model.Employee" %>
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
    <a href="${pageContext.request.contextPath}/menu">Menu principal</a>
</div>

<div class="Content">
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("empleados");
        if (employees == null || employees.isEmpty()) {
    %>
    <h2>Lista de empleados vacía</h2>
    <%
    } else {
    %>
    <h2>Lista de Empleados</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Teléfono</th>
        </tr>
        <%
            for (Employee e : employees) {
        %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getName() %></td>
            <td><%= e.getEmail() %></td>
            <td><%= e.getPhone() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        }
    %>
</div>

</body>
</html>
