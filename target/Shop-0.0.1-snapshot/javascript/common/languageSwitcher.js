function switchLanguage(language) {
    document.cookie = '';
    $.cookie("language", language);
    location.reload(true);
}

