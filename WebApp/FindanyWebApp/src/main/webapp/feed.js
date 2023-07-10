window.onload = function () {
    const btnBuscar = document.getElementById('btn-buscar');
    const inputSearch = document.getElementById('search');
    const main = document.getElementById('main');

    const mostrarFeed = (posts) => {
        const contenedor = document.getElementById("container");
        if (contenedor) {
            contenedor.classList.add('container');
            const main = document.createElement('div');
            main.classList.add('main');
            contenedor.appendChild(main);

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
                pPublished.innerHTML = "Fecha publicación:";
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
                const servletUrl = new URL("http://localhost:8080/AppWeb/view-post.jsp");
                servletUrl.searchParams.append("id", post.id.toString());
                buttonView.setAttribute('data-url', servletUrl.href);
                buttonView.addEventListener('click', function () {
                    const servletUrl = this.getAttribute('data-url');
                    window.location.href = servletUrl;
                });
                divPostView.appendChild(buttonView);
                divMainPost.appendChild(divPostView);

                if (esAdmin()) {
                    const divDeleteButton = document.createElement('div');
                    divDeleteButton.classList.add('delete-button');
                    const buttonDelete = document.createElement('button');
                    buttonDelete.innerHTML = 'Borrar';
                    const servletUrlD = new URL("http://localhost:8080/AppWeb/delete-post-admin");
                    servletUrlD.searchParams.append("id", post.id.toString());
                    buttonDelete.setAttribute('data-url', servletUrlD.href);
                    buttonDelete.addEventListener('click', function () {
                        const servletUrl = this.getAttribute('data-url');
                        window.location.href = servletUrl;
                    });
                    divDeleteButton.appendChild(buttonDelete);
                    divMainPost.appendChild(divDeleteButton);
                }

                main.appendChild(divMainPost);
            });
        }
    };

    const esAdmin = () => {
        const userTipo = document.getElementById("user-tipo").value;
        return userTipo === "ADMINISTRADOR";
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

    const realizarBusqueda = (texto) => {
        const busqueda = {termino: texto};

        fetch("http://localhost:8080/AppWeb/post?action=search", {
            method: "POST",
            body: JSON.stringify(busqueda),
            headers: {
                "Content-Type": "application/json"
            }
        })
                .then(response => response.json())
                .then(posts => {
                    main.innerHTML = '';
                    mostrarFeed(posts);
                })
                .catch(err => {
                    console.error(err);
                });
    };

    const obtenerBusqueda = () => {
        const searchTerm = inputSearch.value.trim();
        if (searchTerm !== '') {
            realizarBusqueda(searchTerm);
        }
    }

    btnBuscar.onclick = obtenerBusqueda;
    cargarFeed();
};