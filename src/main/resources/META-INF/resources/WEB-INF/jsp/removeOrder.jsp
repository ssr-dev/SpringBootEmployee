<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title> EmployeeApp - Eliminar pedido </title>
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
    <h1> EMPLOYEE APP - ELIMINAR PEDIDO</h1>
    <h2> Hola, por favor ingrese el ID del pedido que desea eliminar </h2>
    <form action="deleteOrder" method="post">
        <table cellspacing="3" cellpadding="3" border="1">
            <tr>
                <td align="right"> ID del pedido: </td>
                <td><input type="text" name="order_id"></td>
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