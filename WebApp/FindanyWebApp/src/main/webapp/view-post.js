window.onload = function () {

    const mostrarPost = (post) => {
        const postTitulo = document.querySelector(".post-titulo");
        const postNombreUsuario = document.querySelector(".post-nombreUsuario");
        const postFechaCreacion = document.querySelector(".post-fechaCreacion");
        const postFechaEdicion = document.querySelector(".post-fechaEdicion");
        const postFechaEdicionTexto = document.querySelector(".post-fechaEdicionTexto");
        const postContenido = document.querySelector(".post-contenido");

        const titulo = post.titulo;
        const nombreUsuario = post.usuarioAutor.nombreCompleto;
        const fechaCreacion = post.fechaHoraCreacion;
        const fechaEdicion = post.fechaHoraEdicion;
        const contenido = post.contenido;

        postTitulo.innerHTML = titulo;
        postNombreUsuario.innerHTML = nombreUsuario;
        postFechaCreacion.innerHTML = fechaCreacion;
        postContenido.innerHTML = contenido;
        if (fechaEdicion === undefined || fechaEdicion === null || fechaEdicion === "") {
            
        } else {
            postFechaEdicion.innerHTML = fechaEdicion;
            const fechaEdicionTextito = "Fecha Edición: ";
            postFechaEdicionTexto.innerHTML = fechaEdicionTextito;
        }
    };

    const cargarFeed = () => {

        const urlParams = new URLSearchParams(window.location.search);
        const postId = urlParams.get('id');
        const url = new URL("http://localhost:8080/AppWeb/post");
        url.searchParams.append("action", "post");
        url.searchParams.append("id", postId);

        fetch(url, {
            method: "GET",
            headers: {
                "content-type": "application/json"
            }
        })
            .then(response => response.json())
            .then(post => {
                mostrarPost(post);
            })
            .catch(err => {
                console.error(err);
            });
    };
    cargarFeed();
};