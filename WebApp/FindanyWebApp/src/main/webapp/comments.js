// Función para obtener los comentarios del servidor
function obtenerComentarios() {
    fetch('/comment?action=obtener', {
        method: 'GET'
    })
            .then(response => response.json())
            .then(data => {
                // Manejar la respuesta del servidor
                mostrarComentarios(data);
            })
            .catch(error => {
                // Manejar errores de la solicitud
                console.error('Error al obtener los comentarios:', error);
            });
}

// Función para mostrar los comentarios en el DOM
function mostrarComentarios(comentarios) {
    var comentariosList = document.getElementById('comentariosList');
    comentariosList.innerHTML = '';

    comentarios.forEach(comentario => {
        var liUsuario = document.createElement('li');
        liUsuario.textContent = comentario.usuario.nombreCompleto;
        comentariosList.appendChild(liUsuario);

        var liContenido = document.createElement('li');
        liContenido.textContent = comentario.contenido;
        comentariosList.appendChild(liContenido);
    });
}

// Función para enviar un nuevo comentario al servidor
function enviarComentario() {
    var contenidoInput = document.getElementById('contenidoInput');
    var comentarioPadreInput = document.getElementById('comentarioPadreInput');

    var contenido = contenidoInput.value;
    var comentarioPadre = comentarioPadreInput.value;

    fetch('/comment?action=create', {
        method: 'POST',
        body: JSON.stringify({contenido, comentarioPadre}),
        headers: {
            'Content-Type': 'application/json'
        }
    })
            .then(response => response.json())
            .then(data => {
                // Manejar la respuesta del servidor
                console.log('Comentario guardado:', data);
                // Actualizar la lista de comentarios llamando a obtenerComentarios()
                obtenerComentarios();
            })
            .catch(error => {
                // Manejar errores de la solicitud
                console.error('Error al enviar el comentario:', error);
            });
}

// Manejar el evento de envío del formulario
var comentarioForm = document.getElementById('comentarioForm');
comentarioForm.addEventListener('submit', function (event) {
    event.preventDefault();
    enviarComentario();
});

// Obtener los comentarios iniciales al cargar la página
obtenerComentarios();

