<%String errorMessage = request.getParameter("message");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Findany</title>
        <link rel="stylesheet" href="/AppWeb/assets/css/error.css">
        <link rel="icon" type="image/png" href="/AppWeb/assets/img/f.png">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR | Error Java</title>
    </head>
    <body>
        <div class="container">
            <header>
                <div class="header-logo">
                    <img src="/AppWeb/assets/img/findanylogo.svg" alt="logo" class="imagen-logo">
                </div>
            </header>

            <div class="main">
                <h1>¡Algo salio mal!</h1>
                <span><%= errorMessage%></span>
            </div>

            <footer>
                <div class="footer-contacto">
                    <h3 class="contacto">CONTACTO</h3>
                    <ul class="contacto-lista">
                        <li><img src="/AppWeb/assets/img/casa.png"> 644-220-9588</li>
                        <hr class="footer-contacto-separator">
                        <li><img src="/AppWeb/assets/img/celular.png"> 644-460-9376</li>
                        <hr class="footer-contacto-separator">
                        <li><img src="/AppWeb/assets/img/correo.png"> duran.esteban.cbtis37@gmail.com</li>
                    </ul>
                </div>
            </footer>
        </div>
    </body>
</html>