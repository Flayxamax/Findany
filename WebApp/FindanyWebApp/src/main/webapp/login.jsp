
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-en">

    <head>
        <meta charset="UTF-8">
        <title>Findany</title>
        <link rel="stylesheet" href="assets/css/login.css">
        <link rel="icon" type="image/png" href="assets/img/f.png">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
    </head>

    <body>

        <script>
            // Función para obtener los mensajes de alerta del objeto request
            function getAlertMessages() {
                var messages = [];
            <c:forEach var="entry" items="${requestScope}">
                var key = "${entry.key}";
                var value = "${entry.value}";
                // Filtra los mensajes de alerta con la clave "mensaje"
                if (key === "mensaje") {
                    messages.push(value);
                }
            </c:forEach>
                return messages;
            }

            // Muestra los mensajes de alerta si existen
            window.onload = function () {
                var alertMessages = getAlertMessages();
                if (alertMessages.length > 0) {
                    alert(alertMessages.join('\\n'));
                    // Redirige a la página de inicio de sesión después de cerrar la alerta
                    window.location.href = "/AppWeb/login.jsp";
                }
            };
        </script>

        <div class="container">
            <header>
                <div class="header-logo">
                    <img src="assets/img/findanylogo.svg" alt="logo" class="imagen-logo">
                </div>
                <div class="header-searchbar">
                </div>
            </header>

            <div class="main">
                <div class="main-form">
                    <img src="assets/img/icono.png" alt="logo findany" class="form-icon">
                    <h3 class="form-LoginText">Iniciar Sesión</h3>
                    <form action="./auth?action=login" method="POST" class="form-login">
                        <input type="email" id="email" name="correo" placeholder="Correo" required>
                        <br>
                        <input type="password" id="password" name="pass" placeholder="Contraseña" required>
                        <br>
                        <input type="submit" value="Iniciar Sesión" class="form-login-button">
                    </form>
                    <hr class="form-divisor">
                    <div class="redirect-register">
                        <p>¿Nuevo en Findany?</p>
                        <a href="./register">Crea una cuenta</a>
                    </div>
                </div>
            </div>

            <footer>
                <div class="footer-contacto">
                    <h3 class="contacto">CONTACTO</h3>
                    <ul class="contacto-lista">
                        <li><img src="assets/img/casa.png"> 644-220-9588</li>
                        <hr class="footer-contacto-separator">
                        <li><img src="assets/img/celular.png"> 644-460-9376</li>
                        <hr class="footer-contacto-separator">
                        <li><img src="assets/img/correo.png"> duran.esteban.cbtis37@gmail.com</li>
                    </ul>
                </div>
            </footer>
        </div>
    </body>

    <script src="slide-lulu.js"></script>

</html>
