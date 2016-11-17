function redirect(url) {
    $(function() {
        setTimeout(function() {
            window.location.href = url;
        }, 2000);
    })
}