<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title> EmployeeApp - Crear Empleado</title>
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

<div class="content">
    <h1> EMPLOYEE APP - ELIMINAR EMPLEADO</h1>
    <h2> Hola, por favor ingrese el id de empleado del usuario que desea eliminar </h2>
    <form action="deleteEmployee" method="post">
        <table cellspacing="3" cellpadding="3" border="1">
            <tr>
                <td align="right"> ID Empleado:</td>
                <td><input type="text" name="emp_id"></td>
            </tr>
        </table>
        <input type="submit" value="Eliminar">
    </form>

</div>

<div class="footer">
    <p>Footer</p>
</div>

</body>

</html>