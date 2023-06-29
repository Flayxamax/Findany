let bannerImg = document.querySelector('.banner .imagen-lulu');
let startPosition = bannerImg.offsetHeight;
let currentPosition = startPosition;
let targetPosition = startPosition / 2;

function slideImage() {
  currentPosition -= 5;
  if (currentPosition <= targetPosition) {
    currentPosition = targetPosition;
    clearInterval(slideInterval);
  }
  bannerImg.style.transform = 'translate(-50%, -' + currentPosition + 'px)';
}

let slideInterval;

function startSlide() {
  slideInterval = setInterval(slideImage, 10);
}

window.onload = function() {
  let slide = document.querySelector('.banner');
  slide.style.opacity = "0";
  setTimeout(function() {
    slide.style.transition = "all 0.8s ease-out";
    slide.style.opacity = "1";
    slide.style.display = "flex";
    startSlide();
  }, 500);
};
