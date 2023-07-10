<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="es-en">

    <head>
        <meta charset="UTF-8">
        <title>Findany</title>
        <link rel="stylesheet" href="assets/css/view-post.css">
        <link rel="icon" type="image/png" href="assets/img/f.png">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
        <script src="view-post.js" charset="utf-8"></script>
        <!--<script src="comments.js" charset="utf-8"></script>-->

    </head>

    <body>
        <div class="container">
            <header>
                <section class="header-logo">
                    <img src="assets/img/findanylogo.svg" alt="logo" class="imagen-logo">
                </section>
                <section class="header-join">
                    <button class="menu-btn">${sessionScope.usuario.nombreCompleto}
                        <section class="menu-content">
                            <a href="./view-user">Ver perfil</a>
                            <a href="create-post.jsp">Crear post</a>

                            <form action="./auth?action=logout" method="POST" class="form-login">
                                <input type="submit" value="Cerrar sesión">
                            </form>
                            </form>
                        </section>
                    </button>
                </section>
            </header>
            <section class="main">
                <h1 class="post-titulo"></h1>
                <hr class="post-tituloUsuarioSeparator">
                <h3 class="post-nombreUsuario"></h3>
                <h4 class="post-fechaCreacion"></h4>
                <h4 class="post-fechaEdicionTexto"></h4>
                <h4 class="post-fechaEdicion"></h4>
                <hr class="post-dataContentSeparator">
                <h4 class="post-contenido"></h4>
                <!--Imágen próximamente-->
                <hr class="post-contentCommentSeparator">
            </section>
            <section class="post-comments">
                <section class="comment-textarea">
                    <h3 class="comment-titulo">Comentarios</h3>
                    <textarea class="comment-contenido" id="comment-contenido" name="comment-contenido" minlength="1"
                        maxlength="100" rows="3" cols="60" placeholder="Escribe tu comentario"></textarea>
                    <div class="comment-addBtn">
                        <input type="hidden" class="user-email" value="${sessionScope.usuario.correo}">
                        <input type="hidden" id="user-tipo" value="${sessionScope.usuario.tipo}">
                    </div>
                </section>
                <section class="comments" id="comments">
                    <input type="hidden" id="idPost" name="idPost" value="${requestScope.post.id}">

                </section>
            </section>
        </div>
        <!--
        <footer>
            <section class="footer-contacto">
                <h3 class="contacto">CONTACTO</h3>
                <ul class="contacto-lista">
                    <li><img src="assets/img/casa.png"> 644-220-9588</li>
                    <hr class="footer-contacto-separator">
                    <li><img src="assets/img/celular.png"> 644-460-9376</li>
                    <hr class="footer-contacto-separator">
                    <li><img src="assets/img/correo.png"> duran.esteban.cbtis37@gmail.com</li>
                </ul>
            </section>
        </footer>
        -->
        <script src="assets/css/menu-content.js"></script>
    </body>

    </html>