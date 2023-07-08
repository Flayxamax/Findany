window.onload = function () {
    
    const getGeneros = () => {
        const checksGenero = document.getElementsByName("chk-genero");
        const generosSeleccionados = [];
        for(let checkbox of checksGenero){
            if(checkbox.checked){
                generosSeleccionados.push(checkbox.value);
            }
        }
        return generosSeleccionados;
    }

    const mostrarFeed = (posts) => {
        const contenedor = document.getElementById("container");
        contenedor.classList.add('container');
        const main = document.getElementById("main");
        main.classList.add('main');

        posts.forEach((post) => {
            const divMainPost = document.createElement('div');
            divMainPost.classList.add('main-post');

            const h2TitlePost = document.createElement('h2');
            h2TitlePost.classList.add('title-post');
            h2TitlePost.innerHTML = post.titulo;
            divMainPost.appendChild(h2TitlePost);

            const divPostUser = document.createElement('div');
            divPostUser.classList.add('post-user');
            const pUser = document.createElement('p');
            pUser.innerHTML = post.usuarioAutor.nombreCompleto;
            divPostUser.appendChild(pUser);
            divMainPost.appendChild(divPostUser);

            const divDatePublished = document.createElement('div');
            divDatePublished.classList.add('date-published');
            const pPublished = document.createElement('p');
            pPublished.innerHTML = 'Fecha publicación:';
            const pPublishedDate = document.createElement('p');
            pPublishedDate.innerHTML = post.fechaHoraCreacion;
            divDatePublished.appendChild(pPublished);
            divDatePublished.appendChild(pPublishedDate);
            divMainPost.appendChild(divDatePublished);

            const divDateEdited = document.createElement('div');
            divDateEdited.classList.add('date-edited');
            if (post.fechaHoraEdicion) {
                const pEdited = document.createElement('p');
                pEdited.innerHTML = 'Ultima edición:';
                const pEditedDate = document.createElement('p');
                pEditedDate.innerHTML = post.fechaHoraEdicion;
                divDateEdited.appendChild(pEdited);
                divDateEdited.appendChild(pEditedDate);
            }
            divMainPost.appendChild(divDateEdited);

            const divPostContent = document.createElement('div');
            divPostContent.classList.add('post-content');
            const pContent = document.createElement('p');
            pContent.innerHTML = post.contenido;
            divPostContent.appendChild(pContent);
            divMainPost.appendChild(divPostContent);

            const divPostView = document.createElement('div');
            divPostView.classList.add('post-view');
            const buttonView = document.createElement('button');
            buttonView.innerHTML = 'Ver';
            divPostView.appendChild(buttonView);
            divMainPost.appendChild(divPostView);

            main.appendChild(divMainPost);
        });
    };

    const cargarFeed = () => {
        fetch("http://localhost:8080/AppWeb/post?action=feed", {
            method: "GET",
            headers: {
                "content-type": "application/json"
            }
        })
                .then(response => response.json())
                .then(posts => {
                    mostrarFeed(posts);
                })
                .catch(err => {
                    console.error(err);
                });
    };

    const guardarPost = () => {
        const btnGuardar = document.getElementById("btn-guardar");
        btnGuardar.disabled = true;

        const titulo = document.getElementById("titulo").value;
        const contenido = document.getElementById("contenido").value;
        const fechaHoraCreacion =  new Date();
        const usuarioAutor = null;
        const tipo = null;
        const post = {
            fechaHoraCreacion,
            titulo: titulo,
            contenido: contenido,
            usuarioAutor,
            tipo
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
                })
                .then(post => {
                    alert("¡Post publicado!");
                })
                .catch(err => {
                    console.error(err);
                });
    }

    const btnGuardar = document.getElementById("btn-guardar");
    if (btnGuardar != null){
        btnGuardar.onclick = guardarPost;
    }

    cargarFeed();
};