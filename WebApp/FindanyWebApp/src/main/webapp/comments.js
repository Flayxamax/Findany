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
        const buttonCrear = document.createElement('button');
        buttonCrear.id = "btn-crear";
        buttonCrear.innerHTML = 'Crear';
        divButton.appendChild(buttonCrear);

        const guardarComentario = () => {
            const buttonCrear = document.getElementById("btn-crear");
            buttonCrear.disabled = true;

            const userEmail = document.querySelector(".user-email").value;
            const contenido = document.querySelector(".comment-contenido").value;
            const fechaHoraCreacion = new Date();
            const usuario = userEmail;
            const comentario = {
                contenido: contenido,
                fechaHoraCreacion: fechaHoraCreacion,
                usuario: usuario
            };

            fetch("http://localhost:8080/AppWeb/comment?action=create", {
                method: "POST",
                body: JSON.stringify(comentario),
                headers: {
                    "content-type": "application/json"
                }
            })
                .then(response => {
                    return response.json();
                    console.log(response);
                })
                .then(comentario => {
                    alert("¡Comentario publicado!");
                })
                .catch(err => {
                    console.error(err);
                });
        };

        const btnGuardar = document.getElementById("btn-crear");
        if (btnGuardar !== null) {
            btnGuardar.onclick = guardarComentario;
        }

    };

    const mostrarComentarios = (comentarios) => {
        const seccionComentarios = document.getElementById("container");
        if (seccionComentarios !== null) {
            seccionComentarios.classList.add('container');
            const comments = document.getElementById("comments");
            comments.classList.add('comments');

            comentarios.forEach((comentario) => {
                const divMainComentarios = document.createElement('div');
                if (comentario.usuarioAutor.tipoCuenta === "ADMINISTRADOR") {
                    //divMainComentarios.classList.add('main-anchored');
                    //todo botones de admin
                } else {

                }
                const detailsComentarios = document.createElement('details');
                detailsComentarios.classList.add('comentario-individual');
                const summaryAutor = document.createElement('summary');
                summaryAutor.classList.add('comentario-individual-autor');
                summaryAutor.innerHTML = comentario.usuarioAutor.nombreCompleto;
                detailsComentarios.appendChild(summaryAutor);
                const summaryContenido = document.createElement('summary');
                summaryContenido.classList.add('comentario-individual-autor');
                summaryContenido.innerHTML = comentario.contenido;
                detailsComentarios.appendChild(summaryContenido);
                divMainComentarios.appendChild(summaryAutor);
                divMainComentarios.appendChild(summaryContenido);
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
            .then(comentarios => {
                mostrarComentarios(comentarios);
            })
            .catch(err => {
                console.error(err);
            });
    };

    crearBoton();
    cargarComentarios();
}; 
