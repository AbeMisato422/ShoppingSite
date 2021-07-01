function hamburger() {
  //document.getElementById('batsu').classList.toggle('batsu');
  document.getElementById('search').classList.toggle('search');
  document.getElementById('nav').classList.toggle('in');
}
document.getElementById('hamburger').addEventListener('click' , function () {
  hamburger();
} );