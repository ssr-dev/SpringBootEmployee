<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="co.edu.uptc.firstJavaWebApp.model.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>CustomerApp - Modificar el pedido</title>
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

<div class="content">
    <h1>CUSTOMER APP - MODIFICAR EL PEDIDO</h1>

    <form action="introModifyOrder" method="post">
        <table cellspacing="3" cellpadding="3" border="1">
            <tr>
                <td align="right">ID del pedido:</td>
                <td><input type="text" name="order_id" value="${param.order_id}"></td>
                <td><input type="submit" value="Buscar"></td>
            </tr>
        </table>
    </form>

    <c:choose>
        <c:when test="${orderFound != null}">
            <h2>Modificar los datos del pedido</h2>
            <form action="modifyOrder" method="post">
                <input type="hidden" name="order_id" value="${orderFound.id}"/>
                    <table cellspacing="3" cellpadding="3" border="1">
                        <tr>
                              <td align="right"> Estado del pedido: </td>
                              <td> <input type="text" name="order_status" value="${orderFound.orderStatus}"> </td>
                         </tr>
                         <tr>
                              <td align="right"> Descripción del pedido: </td>
                              <td> <input type="text" name="order_description" value="${orderFound.descriptionOrder}"> </td>
                         </tr>

                    </table>
                    <input type="submit" value="Enviar">
            </form>
        </c:when>
        <c:otherwise>
            <c:if test ="${orderFound == null}">
            <p style="color: red;">Por favor ingrese el ID de un pedido</p>
            </c:if>
            <c:if test="${orderFound != null}">
                <p style="color: red;">Pedido no encontrado</p>
            </c:if>
        </c:otherwise>
    </c:choose>
</div>

<div class="footer">
    <p>Footer</p>
</div>

</body>
</html>
