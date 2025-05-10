<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title> EmployeeApp - Menu Principal</title>
    <style> <%@include file="../css/empStyle.css" %> </style>
</head>

<body>
<div class="topnav">
    <a href="${pageContext.request.contextPath}/introaddemployee">Crear empleado</a>
    <a href="${pageContext.request.contextPath}/introModifyEmployee">Modificar empleado</a>
    <a href="${pageContext.request.contextPath}/introShowEmployee">Buscar empleado</a>
    <a href="${pageContext.request.contextPath}/showEmployees">Mostrar empleados</a>
    <a href="${pageContext.request.contextPath}/introDeleteEmployee">Borrar Empleado</a>

    <a href="${pageContext.request.contextPath}/introAddCustomer">Crear cliente</a>
         <a href="${pageContext.request.contextPath}/introModifyEmployee">Modificar cliente</a>
         <a href="${pageContext.request.contextPath}/introShowEmployee">Buscar cliente</a>
         <a href="${pageContext.request.contextPath}/showEmployees">Mostrar clientes</a>
         <a href="${pageContext.request.contextPath}/introDeleteEmployee">Borrar clientes</a>
</div>

<div class="content">
    <h1> EMPLOYEE APP </h1>
    <h2> Bienvenido a la aplicacion! </h2>
    <h2> Haga click en cualquiera de las opciones del menu principal! </h2>
</div>

<div class="footer">
    <a href="${pageContext.request.contextPath}/index" class="logout-btn">Cerrar Sesión</a>
</div>

</body>

</html>