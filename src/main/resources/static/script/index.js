document.addEventListener('DOMContentLoaded', (event) => {
    // src: https://stackoverflow.com/questions/569357/clear-all-html-fields-using-javascript
    // we are not proud of this hack, but it will make the screen look cleaner for the user
    // when the forms load for the first time
    if (document.getElementById("is-empty").value == "true") {
        var elements = document.getElementsByTagName("input");
        for (var ii=0; ii < elements.length; ii++) {
            elements[ii].value = "";
            if(ii == 0) {
                elements[ii].focus(); // put cursor
            }
        }
    }
})