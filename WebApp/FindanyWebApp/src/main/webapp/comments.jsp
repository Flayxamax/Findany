<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Comentarios</title>
    </head>
    <body>
        <h1>Comentarios</h1>

        <!-- Mostrar la lista de comentarios -->
        <c:if test="${not empty comentarios}">
            <ul>
                <c:forEach var="comentario" items="${comentarios}">
                    <li>${comentario.usuario.nombreCompleto}</li>
                    <li>${comentario.contenido}</li>
                    </c:forEach>
            </ul>
        </c:if>

        <!-- Formulario para agregar un nuevo comentario -->
        <form action="./comment?action=create" method="POST">
            <textarea name="contenido" rows="3" cols="30" placeholder="Escribe tu comentario"></textarea><br>
            <input type="hidden" name="comentarioPadre" value="${comentarioPadreId}">
            <input type="submit" value="Enviar comentario">
        </form>
    </body>
</html>
