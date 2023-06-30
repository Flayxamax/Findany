<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es-en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Findany</title>
        <link rel="stylesheet" href="assets/css/feed.css">
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
                        <button type="submit" class="search">???</button>
                    </form>
                </div>
                <div class="header-join">
                    <button class="menu-btn">${sessionScope.usuario.nombreCompleto}
                        <div class="menu-content">
                            <a href="view-user.jsp">Ver perfil</a>
                            <a href="create-post.jsp">Crear post</a>

                            <form action="./auth?action=logout" method="POST" class="form-login">
                                <a href="index.html">Cerrar sesión</a>
                            </form>
                        </div>
                    </button>
                </div>
            </header>

            <div class="main">
                <c:forEach var="post" items="${posts}">
                    <div class="main-post">
                        <h2 class="title-post">${post.titulo}</h2>
                        <div class="post-user">
                            <p>${post.usuarioAutor.nombreCompleto}</p>
                        </div>
                        <div class="date-published">
                            <p>Fecha publicación:</p>
                            <p>${post.fechaHoraCreacion}</p>
                        </div>
                        <div class="date-edited">
                            <c:if test="${post.fechaHoraEdicion != null}">
                                <p>Ultima edición:</p>
                                <p>${post.fechaHoraEdicion}</p>
                            </c:if>                          
                        </div>
                        <div class="post-content">
                            <p>${post.contenido}</p>
                        </div>
                        <!--<div class="post-img">
                            <img src="assets/img/img-post.jpg">
                        </div>-->
                        <div class="post-view">
                            <button>Ver</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>

    <script src="assets/css/menu-content.js"></script>

</html>