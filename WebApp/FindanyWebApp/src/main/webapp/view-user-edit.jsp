
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-en">

    <head>
        <meta charset="UTF-8">
        <title>Findany</title>
        <link rel="stylesheet" href="assets/css/view-user.css">
        <link rel="icon" type="image/png" href="assets/img/f.png">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <header>
                <div class="header-logo">
                    <img src="assets/img/findanylogo.svg" alt="logo" class="imagen-logo">
                </div>
                <div class="header-searchbar">
                    <form action="results.html" method="GET" class="search">
                        <input type="text" name="search" class="search" placeholder="Buscar...">
                        <button type="submit" class="search">🔍</button>
                    </form>
                </div>
                <div class="header-join">
                    <button class="menu-btn">${sessionScope.usuario.nombreCompleto}
                        <div class="menu-content">
                            <a href="feed.jsp">Ver feed</a>
                            <a href="create-post.jsp">Crear post</a>

                            <form action="./auth?action=logout" method="POST" class="form-login">
                                <a href="index.html">Cerrar sesión</a>
                            </form>
                        </div>
                    </button>
                </div>
            </header>

            <div class="main">
                <form class="main-content" method="POST", enctype="multipart/form-data">
                    <div class="main-img">
                        <img id="preview-image" src="assets/img/default.png" alt="Vista previa de la imagen" class="img-post">
                    </div>
                    <div class="main-update-img">
                        <label for="imagen" class="imagen">Actualizar foto de perfil</label>
                        <input type="file" id="imagen" accept="image/*" onchange="previewImage(event)" class="titulo-text">
                    </div>
                    <div class="main-datos">
                        <div class="main-form-group">
                            <label>Nombre completo*
                                <input type="text" name="nombre" placeholder="Ingrese su nombre completo"
                                       class="titulo-text" value="${sessionScope.usuario.nombreCompleto}" required>
                            </label>
                        </div>
                        <div class="main-form-group">
                            <label>Correo*
                                <input type="email" name="correo" placeholder="Ingrese su correo electrónico"
                                       class="titulo-text" value="${sessionScope.usuario.correo}" required>
                            </label>
                        </div>
                        <div class="main-form-group">
                            <label>Telefono*
                                <input type="tel" name="tel" placeholder="Ingrese su telefono" class="titulo-text" value="${sessionScope.usuario.telefono}" required>
                            </label>
                        </div>
                        <div class="main-form-group">
                            <label>Contraseña*
                                <input type="password" name="pass" placeholder="Ingrese su contraseña" class="titulo-text"
                                       required>
                            </label>
                        </div>
                        <div class="main-form-group">
                            <div class="form-genero">
                                <label>Género:</label>
                                <div class="radio-container">
                                    <label for="masculino">
                                        <input type="radio" name="genero" value="masculino" id="masculino" ${sessionScope.usuario.genero.toString() == 'MASCULINO' ? 'checked' : ''}>
                                        Masculino
                                    </label>
                                    <label for="femenino">
                                        <input type="radio" name="genero" value="femenino" id="femenino" ${sessionScope.usuario.genero.toString() == 'FEMENINO' ? 'checked' : ''}>
                                        Femenino
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="main-form-group">
                            <div class="main-form-location">
                                <label>Ciudad*
                                    <input type="text" name="ciudad" placeholder="Ingrese su ciudad" class="titulo-text"
                                           value="${sessionScope.usuario.ciudad}" required>
                                </label>
                                <br>
                                <label>Estado*
                                    <select name="estado" class="select" required>
                                        <option value="">Seleccione un estado</option>
                                        <c:forEach var="estado" items="${estados}">
                                            <option value="${estado.id}" ${estado.nombre eq sessionScope.estado ? 'selected' : ''}>${estado.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                                <label>Municipio*
                                    <select name="municipio" class="select" required>
                                        <option value="">Seleccione un municipio</option>
                                        <c:forEach var="municipio" items="${municipios}">
                                            <option value="${municipio.id}" ${municipio.nombre eq sessionScope.municipio ? 'selected' : ''}>${municipio.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="main-submit">
                        <button type="submit" class="edit-button">Actualizar</button>
                    </div>
                </form>
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

    <script src="assets/css/prev-img.js"></script>
    <script src="assets/css/change-tab.js"></script>

</html>