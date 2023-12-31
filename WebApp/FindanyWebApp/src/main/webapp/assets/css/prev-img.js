function previewImage(event) {
    let input = event.target;
    let image = document.getElementById('preview-image');
  
    if (input.files && input.files[0]) {
      let reader = new FileReader();
  
      reader.onload = function(e) {
        image.src = e.target.result;
      };
  
      reader.readAsDataURL(input.files[0]);
    }
  }