$(document).ready(function() {

    $("#take-test").hide();

    $("#startBtn").click(function(){
        $("#take-test").show();
        $("#select-test").hide();
    });

    $("#doneBtn").click(function(){
        $("#take-test").hide();
        $("#select-test").show();
    });

});