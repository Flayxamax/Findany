window.onload = function () {
    const btnGuardar = document.getElementById("btn-guardar");
    let titulo = "";
    let fechaHoraCreacion = "";
    let fechaHoraEdicion = "";
    let contenido = "";
    let tipo = "";
    let id = "";

    const esAnclado = () => {
        const checkAnclado = document.getElementById("anclado");
        return checkAnclado.checked;
    };

    const actualizarPost = () => {
        btnGuardar.disabled = true;

        titulo = document.getElementById("titulo").value;
        contenido = document.getElementById("contenido").value;
        const tipo = esAnclado();
        const post = {
            id: id,
            titulo: titulo,
            contenido: contenido,
            tipo,
            fechaHoraCreacion: fechaHoraCreacion,
            fechaHoraEdicion: fechaHoraEdicion
        };

        console.log(JSON.stringify(post));
        fetch("http://localhost:8080/AppWeb/post?action=update", {
            method: "POST",
            body: JSON.stringify(post),
            headers: {
                "content-type": "application/json",
            },
        })
                .then((response) => {
                    if (response.ok) {
                        return response.json();
                    } else if (response.status === 400) {
                        return response.json().then((data) => {
                            throw {errorType: "badRequest", message: data};
                        });
                    } else if (response.status === 500) {
                        throw {errorType: "internalServerError", message: "Fallo interno del servidor"};
                    } else {
                        throw {errorType: "unknownError", message: "Error en la solicitud"};
                    }
                })
                .then((post) => {
                    alert("¡Post publicado!");
                    window.location.href = "feed.jsp";
                })
                .catch((error) => {
                    if (error.errorType === "badRequest") {
                        window.location.href = "./error/errorHttp.jsp?message=" + encodeURIComponent(error.message);
                    } else if (error.errorType === "internalServerError") {
                        window.location.href = "./error/errorJava.jsp?message=" + encodeURIComponent(error.message);
                    } else {
                        console.error(error);
                    }
                });
    };

    const mostrarPost = (post) => {
        console.table(post);
        const postTitulo = document.getElementById("titulo");
        const postContenido = document.querySelector(".textarea");
        const postCheck = document.getElementById("anclado");

        titulo = post.titulo;
        nombreUsuario = post.usuarioAutor.nombreCompleto;
        fechaHoraCreacion = post.fechaHoraCreacion;
        fechaHoraEdicion = new Date();
        contenido = post.contenido;
        tipo = post.tipo;
        id = post.id;

        postTitulo.value = titulo;
        postContenido.innerHTML = contenido;
        if (tipo === "ANCLADO") {
            postCheck.checked = true;
        }
    };

    const cargarPost = () => {

        const urlParams = new URLSearchParams(window.location.search);
        const postId = urlParams.get('id');
        const url = new URL("http://localhost:8080/AppWeb/post");
        url.searchParams.append("action", "post");
        url.searchParams.append("id", postId);

        console.log(url);
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

    cargarPost();
    btnGuardar.onclick = actualizarPost;
};
