window.onload = function () {
    var fechaNacimientoInput = document.getElementById("calendar");

    var fechaActual = new Date();

    var fechaLimiteSuperior = new Date(fechaActual.getFullYear() - 15, fechaActual.getMonth(), fechaActual.getDate());
    var fechaLimiteInferior = new Date(fechaActual.getFullYear() - 80, fechaActual.getMonth(), fechaActual.getDate());
    var fechaLimiteSuperiorFormateada = fechaLimiteSuperior.toISOString().split('T')[0];
    var fechaLimiteInferiorFormateada = fechaLimiteInferior.toISOString().split('T')[0];

    fechaNacimientoInput.setAttribute('max', fechaLimiteSuperiorFormateada);
    fechaNacimientoInput.setAttribute('min', fechaLimiteInferiorFormateada);

};