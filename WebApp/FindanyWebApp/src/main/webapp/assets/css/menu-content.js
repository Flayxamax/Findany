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