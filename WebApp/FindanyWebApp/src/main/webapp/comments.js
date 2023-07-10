window.onload = function () {
    const esAdmin = () => {
        const userTipo = document.getElementById("user-tipo").value;
        if (userTipo === "ADMINISTRADOR") {
            return true;
        }
        return false;
    };

    const crearBoton = () => {
        const divButton = document.querySelector(".comment-addBtn");
        const buttonCrear = document.createElement("button");
        buttonCrear.id = "btn-crear";
        buttonCrear.innerHTML = "Crear";
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
                usuarioAutor: usuario,
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
                .then((response) => {
                    return response.json();
                    console.log(response);
                })
                .then((comentario) => {
                    alert("¡Comentario publicado!");
                    vaciarContenido();
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

                const contenido = document.createElement("p");
                contenido.classList.add("comentario-individual-contenido");
                contenido.textContent = comentario.contenido;

                const btnResponder = document.createElement("button");
                btnResponder.classList.add("comentario-individual-responder");
                btnResponder.textContent = "Responder";
                btnResponder.addEventListener("click", () => {
                    mostrarFormularioRespuesta(comentario.id); // Pasar el id del comentario
                });

                divComentario.appendChild(autor);
                divComentario.appendChild(fecha);
                divComentario.appendChild(contenido);
                divComentario.appendChild(btnResponder);

                divMainComentarios.appendChild(divComentario);
                commentsContainer.appendChild(divMainComentarios);
            });
        }
    };


    const mostrarFormularioRespuesta = (comentarioId) => {
        const respuestaContainer = document.getElementById("comments");
        const formRespuesta = document.createElement("form");
        formRespuesta.classList.add("comentario-individual");

        const inputRespuesta = document.createElement("input");
        inputRespuesta.type = "hidden";
        inputRespuesta.name = "idComentarioPadre";
        inputRespuesta.value = comentarioId;
        formRespuesta.appendChild(inputRespuesta);

        const textareaRespuesta = document.createElement("textarea");
        textareaRespuesta.name = "contenidoRespuesta";
        textareaRespuesta.placeholder = "Escribe tu respuesta...";
        formRespuesta.appendChild(textareaRespuesta);

        const buttonEnviarRespuesta = document.createElement("button");
        buttonEnviarRespuesta.type = "submit";
        buttonEnviarRespuesta.textContent = "Enviar";
        formRespuesta.appendChild(buttonEnviarRespuesta);

        formRespuesta.addEventListener("submit", (event) => {
            event.preventDefault(); // Evitar el envío del formulario
            const contenidoRespuesta = textareaRespuesta.value;
            const comentarioPadreId = comentarioId;

            const userEmail = document.querySelector(".user-email").value;
            const fechaHoraCreacion = new Date();
            const usuario = userEmail;
            const respuesta = {
                contenido: contenidoRespuesta,
                usuarioAutor: usuario,
                comentarioPadreId: comentarioPadreId,
                fechaHoraCreacion: fechaHoraCreacion
            };

            enviarRespuesta(respuesta);
        });

        respuestaContainer.appendChild(formRespuesta);
    };

    const enviarRespuesta = (respuesta) => {
        fetch("http://localhost:8080/AppWeb/comment?action=create", {
            method: "POST",
            body: JSON.stringify(respuesta),
            headers: {
                "content-type": "application/json",
            },
        })
            .then((response) => response.json())

            .then((respuesta) => {
                alert("¡Respuesta enviada!");
                cargarComentarios();
            })
            .catch((err) => {
                console.error(err);
            });
    };

    const cargarComentarios = () => {
        fetch("http://localhost:8080/AppWeb/comment?action=obtain", {
            method: "GET",
            headers: {
                "content-type": "application/json",
            },
        })
            .then((response) => response.json())
            .then((listaComentarios) => {
                mostrarComentarios(listaComentarios);
            })
            .catch((err) => {
                console.error(err);
            });
    };

    const cargarRespuestas = () => {
        const id = obtenerIdComentario(); // Obtén el ID del comentario que deseas obtener

        fetch(`http://localhost:8080/AppWeb/comment?action=respuesta&id=${id}`, {
            method: "GET",
            headers: {
                "content-type": "application/json",
            },
        })
            .then((response) => response.json())
            .then((listaComentarios) => {
                mostrarComentarios(listaComentarios);
            })
            .catch((err) => {
                console.error(err);
            });
    };


    cargarComentarios();
    cargarRespuestas();
    crearBoton();
};
