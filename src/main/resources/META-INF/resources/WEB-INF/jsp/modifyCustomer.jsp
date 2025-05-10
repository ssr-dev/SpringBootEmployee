<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="co.edu.uptc.firstJavaWebApp.model.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>CustomerApp - Modificar cliente</title>
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
    <h1>CUSTOMER APP - MODIFICAR CLIENTE</h1>

    <form action="introModifyCustomer" method="post">
        <table cellspacing="3" cellpadding="3" border="1">
            <tr>
                <td align="right">Documento de identidad del cliente:</td>
                <td><input type="text" name="cust_id" value="${param.cust_id}"></td>
                <td><input type="submit" value="Buscar"></td>
            </tr>
        </table>
    </form>

    <c:choose>
        <c:when test="${customerFound != null}">
            <h2>Modificar datos del cliente</h2>
            <form action="modifyCustomer" method="post">
                <input type="hidden" name="cust_id" value="${customerFound.id}">
                <table cellspacing="3" cellpadding="3" border="1">
                    <tr>
                        <td align="right">Nombre del cliente:</td>
                        <td><input type="text" name="cust_name" value="${customerFound.name}"></td>
                    </tr>
                    <tr>
                        <td align="right">Email del cliente:</td>
                        <td><input type="text" name="cust_email" value="${customerFound.email}"></td>
                    </tr>
                    <tr>
                        <td align="right">Dirección del empleado:</td>
                        <td><input type="text" name="cust_address" value="${customerFound.address}"></td>
                    </tr>
                </table>
                <input type="submit" value="Enviar">
            </form>
        </c:when>
        <c:otherwise>
            <c:if test ="${customerFound == null}">
            <p style="color: red;">Por favor ingrese un documento de identidad</p>
            </c:if>
            <c:if test="${param.cust_id != null}">
                <p style="color: red;">Cliente no encontrado</p>
            </c:if>
        </c:otherwise>
    </c:choose>
</div>

<div class="footer">
    <p>Footer</p>
</div>

</body>
</html>
