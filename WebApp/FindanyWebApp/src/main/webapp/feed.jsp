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
                    <p class="header-user">${sessionScope.usuario.nombreCompleto}</p>
                </div>
            </header>

            <div class="main">
                <div class="main-post">
                    <h2 class="title-post">Buenos días a todos!!!!</h2>
                    <div class="post-user">
                        <p>Esteban Durán</p>
                    </div>
                    <div class="date-published">
                        <p>Fecha publicación:</p>
                        <p>20/06/2023</p>
                    </div>
                    <div class="date-edited">
                        <p>Ultima edición:</p>
                        <p>21/06/2023</p>
                    </div>
                    <div class="post-content">
                        <p>Me gusta madrugar porque así puedo ser la primera persona en darte los buenos días.</p>
                    </div>
                    <div class="post-img">
                        <img src="assets/img/img-post.jpg">
                    </div>
                    <div class="post-view">
                        <button>Ver</button>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>