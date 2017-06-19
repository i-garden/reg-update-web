/**
 * Sample event
 */
$(function (){
    $("body").on("click", "span#sample01", function() {
        alert("click!");
    });

    $("div").click(function () {
        alert(this.id);
    };
});
