
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-en">

    <head>
        <meta charset="UTF-8">
        <title>Findany | Registrar</title>
        <link rel="stylesheet" href="assets/css/register.css">
        <link rel="icon" type="image/png" href="assets/img/f.png">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
        <script src="assets/css/dateLimit.js"></script>
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
                    alert(alertMessages.join('\n'));
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
            </header>

            <div class="main">
                <div class="main-register">
                    <h3>Crea una cuenta</h3>
                    <hr>
                    <form action="" method="POST">
                        <div class="main-form-group">
                            <label>Nombre completo*
                                <input type="text" name="nombre" placeholder="Ingrese su nombre completo" required>
                            </label>
                        </div>
                        <div class="main-form-group">
                            <label>Correo*
                                <input type="email" name="correo" placeholder="Ingrese su correo electrónico" required>
                            </label>
                        </div>
                        <div class="main-form-group">
                            <label>Telefono* (Incluir código país ejem. +52)
                                <input type="text" name="tel" placeholder="Ingrese su telefono" required>
                            </label>
                        </div>
                        <div class="main-form-group">
                            <label>Contraseña*
                                <input type="password" name="pass" placeholder="Ingrese su contraseña" required>
                            </label>
                        </div>
                        <div class="main-form-group">
                            <div class="form-genero">
                                <label>Género*</label>
                                <div class="radio-container">
                                    <label for="masculino"><input type="radio" name="genero" value="masculino"
                                                                  id="masculino" required>Masculino</label>
                                    <label for="femenino"><input type="radio" name="genero" value="femenino"
                                                                 id="femenino" required>Femenino</label>
                                </div>
                            </div>
                        </div>
                        <div class="main-form-group">
                            <div class="main-form-location">
                                <label>Ciudad*
                                    <input type="text" name="ciudad" placeholder="Ingrese su ciudad" class="titulo-text"
                                           required>
                                </label>
                                <label>Estado*
                                    <select name="estado" class="select" required>
                                        <option value="">Seleccione un estado</option>
                                        <c:forEach var="estado" items="${estados}">
                                            <option value="${estado.id}">${estado.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                                <label>Municipio*
                                    <select name="municipio" class="select" required>
                                        <option value="">Seleccione un municipio</option>
                                        <c:forEach var="municipio" items="${municipios}">
                                            <option value="${municipio.id}">${municipio.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </div>
                        </div>
                        <div class="main-form-group">
                            <label>Fecha de nacimiento*
                                <input type="date" id="calendar" name="fechaNacimiento" placeholder="Ingrese su fecha de nacimiento"
                                       required>
                            </label>
                        </div>
                        <button type="submit" class="form-login-button">Crea mi cuenta</button>
                    </form>
                </div>

                <div class="main-login">
                    <h3>Iniciar sesión</h3>
                    <hr>
                    <p>¿Ya tienes una cuenta? <a href="login.jsp" title="Inicia sesión aqui">Inicia sesión aquí</a></p>
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

</html>
