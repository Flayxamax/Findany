var bannerImg = document.querySelector('.banner .imagen-lulu');
var startPosition = bannerImg.offsetHeight;
var currentPosition = startPosition;
var targetPosition = startPosition / 2;

function slideImage() {
  currentPosition -= 5;
  if (currentPosition <= targetPosition) {
    currentPosition = targetPosition;
    clearInterval(slideInterval);
  }
  bannerImg.style.transform = 'translate(-50%, -' + currentPosition + 'px)';
}

var slideInterval;

function startSlide() {
  slideInterval = setInterval(slideImage, 10);
}

window.onload = function() {
  var slide = document.querySelector('.banner');
  slide.style.opacity = "0";
  setTimeout(function() {
    slide.style.transition = "all 0.8s ease-out";
    slide.style.opacity = "1";
    slide.style.display = "flex";
    startSlide();
  }, 500);
};
