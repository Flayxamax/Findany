<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Findany</title>
        <link rel="stylesheet" href="assets/css/feed.css">
        <link rel="icon" type="image/png" href="assets/img/f.png">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
        <script src="feed.js" charset="utf-8"></script>
    </head>

    <body>
        <div id="container">
            <input type="hidden" id="user-tipo" value="${sessionScope.usuario.tipo.toString()}">
            <header>
                <div class="header-logo">
                    <img src="assets/img/findanylogo.svg" alt="logo" class="imagen-logo">
                </div>
                <div class="header-searchbar">
                    <form class="search">
                        <input type="text" name="search" id="search" class="search" placeholder="Buscar...">
                        <button type="button" id="btn-buscar" class="search">🔍︎</button>
                    </form>
                </div>
                <div class="header-join">
                    <button class="menu-btn">${sessionScope.usuario.nombreCompleto}
                        <div class="menu-content">
                            <a href="./view-user">Ver perfil</a>
                            <a href="create-post.jsp">Crear post</a>

                            <form action="./auth?action=logout" method="POST" class="form-login">
                                <input type="submit" value="Cerrar sesión">
                            </form>
                        </div>
                    </button>
                </div>
            </header>

            <div id="main">
            </div>
        </div>
    </body>

    <script src="assets/css/menu-content.js"></script>

</html>