
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
                            <label>Telefono*
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
                                <label>Género:</label>
                                <div class="radio-container">
                                    <label for="masculino"><input type="radio" name="genero" value="masculino"
                                                                  id="masculino">Masculino</label>
                                    <label for="femenino"><input type="radio" name="genero" value="femenino"
                                                                 id="femenino">Femenino</label>
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
                    <p>¿Ya tienes una cuenta? <a href="login.html" title="Inicia sesión aqui">Inicia sesión aquí</a></p>
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
