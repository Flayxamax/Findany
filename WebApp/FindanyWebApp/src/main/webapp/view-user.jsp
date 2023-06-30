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
                        <button type="submit" class="search">????</button>
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
                <div class="main-content">
                    <div class="main-img">
                        <img id="preview-image" src="assets/img/default.png" alt="Vista previa de la imagen" class="img-post">
                    </div>
                    <div class="main-datos">
                        <p><strong>Misael Marchena</strong></p>
                        <p>Correo: misael.marchena233418@potros.itson.edu.mx</p>
                        <p>Teléfono: 6441234567</p>
                        <p>Dirección: Ciudad Obregón, Cajeme, Sonora.</p>
                        <p>Fecha de nacimiento: 29 de febrero 2004</p>
                        <p>Género: Masculino</p>
                    </div>
                    <div class="main-submit">
                        <button class="edit-button">Editar información</button>
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

    <script src="assets/css/menu-content.js"></script>

</html>