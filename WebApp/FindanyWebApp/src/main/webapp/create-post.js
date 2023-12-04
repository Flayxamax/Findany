window.onload = function () {
    const esAnclado = () => {
        const checkAnclado = document.getElementById("anclado");
        return checkAnclado.checked;
    };

    const guardarPost = () => {
        const btnGuardar = document.getElementById("btn-guardar");
        btnGuardar.disabled = true;

        const titulo = document.getElementById("titulo").value;
        const contenido = document.getElementById("contenido").value;
        const fechaHoraCreacion = new Date();
        const tipo = esAnclado();
        const post = {
            titulo: titulo,
            contenido: contenido,
            tipo,
            fechaHoraCreacion: fechaHoraCreacion,
        };

        console.log(JSON.stringify(post));
        fetch("http://localhost:8080/AppWeb/post?action=create", {
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
                        //window.location.href = "./error/errorHttp.jsp?message=" + encodeURIComponent(error.message);
                        window.alert(error.message+". \nSolo se pueden ingresar letras, caracteres de modificación (como acentos), y espacios en blanco. Debe tener una longitud entre 1 y 20 caracteres.");
                        location.reload();
                    } else if (error.errorType === "internalServerError") {
                        //window.location.href = "./error/errorJava.jsp?message=" + encodeURIComponent(error.message);
                        window.alert(error.message+". \nSolo se pueden ingresar letras, caracteres de modificación (como acentos), y espacios en blanco. Debe tener una longitud entre 1 y 200 caracteres.");
                        window.reload();
                    } else {
                        console.error(error);
                    }
                });
    };


    const btnGuardar = document.getElementById("btn-guardar");
    btnGuardar.onclick = guardarPost;
};
