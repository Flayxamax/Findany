const dropdowns = document.getElementsByClassName('header-join');

Array.from(dropdowns).forEach(dropdown => {
    const button = dropdown.querySelector('.menu-btn');
    const content = dropdown.querySelector('.menu-content');

    button.addEventListener('click', () => {
        dropdown.classList.toggle('open');
    });

    window.addEventListener('click', event => {
        if (!dropdown.contains(event.target)) {
            dropdown.classList.remove('open');
        }
    });
});

function formatearFecha(fechaString) {
    const fecha = new Date(fechaString);
    const dia = fecha.getDate();
    const mes = fecha.getMonth() + 1;
    const año = fecha.getFullYear();
    return `${dia}/${mes}/${año}`;
}

const fechaNacimiento = document.getElementById('fechaNacimiento').textContent;
if (fechaNacimiento) {
    const fechaFormateada = formatearFecha(fechaNacimiento);
    spanFecha = document.getElementById('fechaNacimiento');
    spanFecha.innerHTML = fechaFormateada;
}

