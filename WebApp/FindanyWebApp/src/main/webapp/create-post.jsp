<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <title>Findany</title>
        <link rel="stylesheet" href="assets/css/create-post.css">
        <link rel="icon" type="image/png" href="assets/img/f.png">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
        <script src="create-post.js" charset="UTF-8"></script>
    </head>

    <body>
        <div class="container">
            <header>
                <div class="header-logo">
                    <img src="assets/img/findanylogo.svg" alt="logo" class="imagen-logo">
                </div>
                <div class="header-searchbar">
                </div>
                <div class="header-join">
                    <button class="menu-btn">${sessionScope.usuario.nombreCompleto}
                        <div class="menu-content">
                            <a href="feed.jsp">Ver feed</a>
                            <a href="view-user.jsp">Ver perfil</a>

                            <form action="./auth?action=logout" method="POST" class="form-login">
                                <a href="index.html">Cerrar sesión</a>
                            </form>
                        </div>
                    </button>
                </div>
            </header>

            <div class="main">
                <div class="main-ad">
                    <div class="arriba">
                        <h2>- CREAR PUBLICACIÓN -</h2>
                    </div>
                </div>
                <form class="main-form">
                    <div class="main-data">
                        <label for="titulo" class="titulo">Título</label>
                        <input type="text" id="titulo" name="titulo" class="titulo-text" placeholder="Un título interesante"
                               required="required">
                        <!-- <label for="imagen" class="imagen">Imagen</label>
                        <input type="file" id="imagen" accept="image/png, image/jpeg"  onchange="previewImage(event)" class="titulo-text">-->
                        <label for="anclado">Anclado</label>
                        <input type="checkbox" id="anclado" name="anclado" class="checkbox">
                    </div>
                    <div class="main-content">
                        <label for="contenido" class="titulo">Contenido</label>
                        <textarea id="contenido" class="textarea" name="contenido" placeholder="Tu contenido aquí" rows="20"
                                  required="required"></textarea>
                    </div>
                    <!-- <div class="main-img">
                        <img id="preview-image" src="assets/img/default.png" alt="Vista previa de la imagen" class="img-post">
                    </div>-->
                    <div class="main-submit">
                        <button class="form-login-button" type="button" id="btn-guardar">Publicar</button>
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

        <script src="assets/css/prev-img.js"></script>
        <script src="assets/css/menu-content.js"></script>
    </body>

</html>