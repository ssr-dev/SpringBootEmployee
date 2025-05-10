<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>CustomerApp - Crear cliente</title>
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
         <a href="${pageContext.request.contextPath}/introModifyEmployee">Modificar cliente</a>
         <a href="${pageContext.request.contextPath}/introShowEmployee">Buscar cliente</a>
         <a href="${pageContext.request.contextPath}/showEmployees">Mostrar clientes</a>
         <a href="${pageContext.request.contextPath}/introDeleteEmployee">Borrar clientes</a>
         <a href="${pageContext.request.contextPath}/menu">Menu principal</a>
     </div>

     <div class="content">
     <h1> EMPLOYEE APP - CREAR CLIENTES </h1>
     <h2> Hola, por favor ingrese los datos del cliente </h2>
          <form action="addCustomer" method ="post">
               <table cellspacing ="3" celpadding="3" border="1">
                    <tr>
                         <td align ="right"> Documento de identidad del cliente: </td>
                         <td><input type="text" name="cust_id"> </td>
                    </tr>
                    <tr>
                         <td align="right"> Nombre del cliente:</td>
                         <td> <input type="text" name="cust_name"> </td>
                    </tr>
                    <tr>
                         <td align = "right"> Email del cliente: </td>
                         <td> <input type="text" name="cust_email"></td>
                    </tr>
                    <tr>
                         <td align = "right"> Dirección del cliente: </td>
                         <td> <input type="text" name="cust_address"></td>
                    </tr>
               </table>
               <input type="submit" value="Enviar">
          </form>     
     </div>
     
</body>
</html>