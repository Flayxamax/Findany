window.onload = function () {

    const mostrarPost = (post) => {
        const postTitulo = document.querySelector(".post-titulo");
        const postNombreUsuario = document.querySelector(".post-nombreUsuario");
        const postFechaCreacion = document.querySelector(".post-fechaCreacion");
        const postFechaEdicion = document.querySelector(".post-fechaEdicion");
        const postFechaEdicionTexto = document.querySelector(".post-fechaEdicionTexto");
        const postContenido = document.querySelector(".post-contenido");
        const secEdit = document.getElementById("editar");
        const userEmail = document.querySelector(".user-email").value;

        if (userEmail === post.usuarioAutor.correo) {
            const editButton = document.createElement('button');
            editButton.classList.add('edit-button');
            editButton.innerHTML = "Editar";
            secEdit.appendChild(editButton);
            
            const servletUrl = new URL("http://localhost:8080/AppWeb/edit-post.jsp");
            servletUrl.searchParams.append("id", post.id.toString());
            editButton.setAttribute('data-url', servletUrl.href);
            editButton.onclick = function () {
                const servletUrl = this.getAttribute('data-url');
                window.location.href = servletUrl;
            };
        }

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

    const cargarPost = () => {

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

    const esAdmin = () => {
        const userTipo = document.getElementById("user-tipo").value;
        if (userTipo === "ADMINISTRADOR") {
            return true;
        }
        return false;
    };


    const crearBoton = () => {
        const divButton = document.querySelector(".comment-addBtn");
        const buttonCrear = document.createElement('button');
        buttonCrear.id = "btn-crear";
        buttonCrear.innerHTML = 'Crear';
        divButton.appendChild(buttonCrear);

        const guardarComentario = () => {
            const buttonCrear = document.getElementById("btn-crear");

            const userEmail = document.querySelector(".user-email").value;
            const contenido = document.querySelector(".comment-contenido").value;
            if (contenido === null || contenido === undefined || contenido === "") {
                alert("¡Ingresa tu comentario!");
                return;
            }
            buttonCrear.disabled = true;
            const fechaHoraCreacion = new Date();
            const usuario = userEmail;
            const comentario = {
                contenido: contenido,
                fechaHoraCreacion: fechaHoraCreacion,
                usuarioAutor: usuario
            };

            const vaciarContenido = () => {
                const commentContenido = document.querySelector(".comment-contenido");
                commentContenido.value = "";
                buttonCrear.disabled = true;
            };

            fetch("http://localhost:8080/AppWeb/comment?action=create", {
                method: "POST",
                body: JSON.stringify(comentario),
                headers: {
                    "content-type": "application/json",
                },
            })
                    .then((response) => response.json())
                    .then((comentario) => {
                        const comentarioId = comentario.id; // Obtener el ID del comentario creado
                        alert("¡Comentario publicado!");
                        vaciarContenido();
                        cargarComentarios();

                    })
                    .catch((err) => {
                        console.error(err);
                    });
        };

        const btnGuardar = document.getElementById("btn-crear");
        if (btnGuardar !== null) {
            btnGuardar.onclick = guardarComentario;
        }
    };


    const eliminarComentario = (comentarioId) => {
        fetch(`http://localhost:8080/AppWeb/comment?action=eliminar&id=${comentarioId}`, {
            method: "POST",
            headers: {
                "content-type": "application/json",
            },
        })
                .then((response) => response.json())
                .then((data) => {
                    // Aquí puedes realizar acciones adicionales después de eliminar el comentario
                    alert("Comentario eliminado");
                    cargarComentarios(); // Vuelve a cargar los comentarios actualizados
                })
                .catch((err) => {
                    console.error(err);
                });
    };

    const mostrarComentarios = (listaComentarios) => {
        const commentsContainer = document.getElementById("comments");
        if (commentsContainer !== null) {
            commentsContainer.innerHTML = ""; // Limpiar el contenido existente
            console.table(listaComentarios);
            listaComentarios.forEach((comentario) => {
                const divMainComentarios = document.createElement("div");
                console.table(comentario);

                const divComentario = document.createElement("div");
                divComentario.classList.add("comentario-individual");

                const autor = document.createElement("p");
                autor.classList.add("comentario-individual-autor");
                autor.textContent = comentario.usuarioAutor.nombreCompleto;

                const fecha = document.createElement("p");
                fecha.classList.add("comentario-individual-fecha");
                fecha.textContent = comentario.fechaHora;

                divComentario.appendChild(autor);
                divComentario.appendChild(fecha);

                const contenido = document.createElement("p");
                contenido.classList.add("comentario-individual-contenido");
                contenido.textContent = comentario.contenido;

                divComentario.appendChild(contenido);

                const isAdmin = esAdmin();
                const btnGuardar = document.getElementById("btn-crear");
                if (btnGuardar !== null) {
                    if (isAdmin) {
                        btnGuardar.disabled = true;

                        const divBotones = document.createElement("div");
                        divBotones.classList.add("comentario-individual-botones");

                        const botonEliminar = document.createElement("button");
                        botonEliminar.textContent = "Eliminar";
                        botonEliminar.addEventListener("click", () => {
                            eliminarComentario(comentario.id);
                        });
                        divBotones.appendChild(botonEliminar);

                        divComentario.appendChild(divBotones);
                    }

                    divMainComentarios.appendChild(divComentario);
                    commentsContainer.appendChild(divMainComentarios);
                }
            });
        }
    };

    const cargarComentarios = () => {
        fetch("http://localhost:8080/AppWeb/comment?action=obtain", {
            method: "GET",
            headers: {
                "content-type": "application/json"
            }
        })
                .then(response => response.json())
                .then(listaComentarios => {
                    mostrarComentarios(listaComentarios);
                })
                .catch(err => {
                    console.error(err);
                });
    };

    cargarPost();
    cargarComentarios();
    crearBoton();
};
