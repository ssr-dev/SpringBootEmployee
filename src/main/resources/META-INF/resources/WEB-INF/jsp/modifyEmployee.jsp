<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="co.edu.uptc.firstJavaWebApp.model.Employee" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>EmployeeApp - Modificar Empleado</title>
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

<div class="content">
    <h1>EMPLOYEE APP - MODIFICAR EMPLEADO</h1>

    <form action="introModifyEmployee" method="post">
        <table cellspacing="3" cellpadding="3" border="1">
            <tr>
                <td align="right">ID Empleado:</td>
                <td><input type="text" name="emp_id" value="${param.emp_id}"></td>
                <td><input type="submit" value="Buscar"></td>
            </tr>
        </table>
    </form>

    <c:choose>
        <c:when test="${employeeFound != null}">
            <h2>Modificar datos del empleado</h2>
            <form action="modifyEmployee" method="post">
                <input type="hidden" name="emp_id" value="${employeeFound.id}">
                <table cellspacing="3" cellpadding="3" border="1">
                    <tr>
                        <td align="right">Nombre Empleado:</td>
                        <td><input type="text" name="emp_name" value="${employeeFound.name}"></td>
                    </tr>
                    <tr>
                        <td align="right">Email empleado:</td>
                        <td><input type="text" name="emp_email" value="${employeeFound.email}"></td>
                    </tr>
                    <tr>
                        <td align="right">Teléfono empleado:</td>
                        <td><input type="text" name="emp_phone" value="${employeeFound.phone}"></td>
                    </tr>
                </table>
                <input type="submit" value="Enviar">
            </form>
        </c:when>
        <c:otherwise>
            <c:if test ="${employeeFound == null}">
            <p style="color: red;">Por favor ingrese un id</p>
            </c:if>
            <c:if test="${param.emp_id != null}">
                <p style="color: red;">Empleado no encontrado</p>
            </c:if>


        </c:otherwise>
    </c:choose>
</div>

<div class="footer">
    <p>Footer</p>
</div>

</body>
</html>
