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
            fechaHoraCreacion: fechaHoraCreacion
        };

        console.log(JSON.stringify(post));
        fetch("http://localhost:8080/AppWeb/post?action=create", {
            method: "POST",
            body: JSON.stringify(post),
            headers: {
                "content-type": "application/json"
            }
        })
                .then(response => {
                    return response.json();
                    console.log(response);
                })
                .then(post => {
                    alert("¡Post publicado!");
                    window.location.href = "feed.jsp";
                })
                .catch(err => {
                    console.error(err);
                });
    };

    const btnGuardar = document.getElementById("btn-guardar");
    btnGuardar.onclick = guardarPost;
};