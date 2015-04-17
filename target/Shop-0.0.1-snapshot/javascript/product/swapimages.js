var oldsrc = $(".productMainImage").attr('src');
$('.productSecondaryImage').hover(function () {
    var newsrc = $(this).attr('src');
    $(".productMainImage").attr('src', newsrc);
}, function () {
    $(".productMainImage").attr('src', oldsrc);
});

$('.productSecondaryImage').click(function () {
    var newsrc = $(this).attr('src');
    $(".productMainImage").attr('src', newsrc);
    oldsrc = newsrc;
});