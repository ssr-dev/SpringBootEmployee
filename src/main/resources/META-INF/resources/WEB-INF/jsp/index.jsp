<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EmployeeApp - LogIn</title>
    <style>
        <%@include file="../css/empStyle.css"%>
    </style>
</head>

<body>
<div align="center">
    <h2>Iniciar sesión</h2>
    <form action="index" method="post">
        <label for="username">Nombre de usuario:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Contraseña:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Iniciar Sesión">
    </form>
</div>

</body>
</html>
