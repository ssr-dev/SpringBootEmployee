<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        <%@include file="../css/empStyle.css" %>
    </style>
    <title>Error en la operación</title>
</head>
<body>
<div class="content">
    <h1>EMPLOYEE APP</h1>
    <h2>${errorMessage}</h2>
    <a href="${homePage}" class="button-link">Volver a la página principal</a>

</div>
</body>
</html>
