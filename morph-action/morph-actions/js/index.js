var favoriteButton = document.querySelector('#favorite'),
    printButton = document.querySelector('#print'),
    downloadButton = document.querySelector('#download');

TweenMax.set('svg', {
  visibility: 'visible'
});

var tlFavorite = new TimelineMax({paused: true});

tlFavorite
.to('#bike__text', 0.15, {
  opacity: 0
})
.to('#bike__rect', 0.30, {
  morphSVG: '#svg_7',
  ease: Power3.easeOut
})  
.to('#svg_6', 0.00, {
 visibility: 'visible',
  ease: Power3.easeOut
})  
.to('#svg_5', 0.00, {
 visibility: 'visible',
 ease: Power3.easeOut
})  
.to('#BlueCircle', 0.05, {
 visibility: 'visible'
})    
.to('#OuterCircle', 0.05, {
 visibility: 'visible'
});



favoriteButton.addEventListener('mouseenter', function() {
  tlFavorite.play();
});


favoriteButton.addEventListener('mouseleave', function() {
  tlFavorite.reverse();
});

var tlPrint = new TimelineMax({paused: true});

tlPrint
.to('#print__text', 0.15, {
  opacity: 0
})
.to('#print__rect', 0.30, {
  morphSVG: '#print__icon',
  ease: Power3.easeOut
});


printButton.addEventListener('mouseenter', function() {
  tlPrint.play();
});
printButton.addEventListener('mouseleave', function() {
  tlPrint.reverse();
});

var tlDownload = new TimelineMax({paused: true});

tlDownload
.to('#download__text', 0.15, {
  opacity: 0
})
.to('#download__rect', 0.30, {
  morphSVG: '#download__icon',
  ease: Power3.easeOut
});

downloadButton.addEventListener('mouseenter', function() {
  tlDownload.play();
});
downloadButton.addEventListener('mouseleave', function() {
  tlDownload.reverse();
});