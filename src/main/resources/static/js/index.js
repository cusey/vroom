$(document).ready(function() {

    var dic = [];
    var row_counter = 0;

    var table = document.getElementById('dictionary-entries');

    var rowLength = table.rows.length;

    for(var x=0; x<rowLength; x+=1){
        var row = table.rows[x];
        dic[x] = [];

        for(var y = 0; y < 7; y++){
            dic[x][y] = row.cells[y].innerText;
        }

    }

    $( "#previousBtn" ).click(function() {
        alert( "Handler for .click() called." );
    });

    $( "#sayBtn" ).click(function() {
        var word = dic[row_counter][1]

        if('speechSynthesis' in window){
            var speech = new SpeechSynthesisUtterance(word);
            speech.lang = 'en-US';
            window.speechSynthesis.speak(speech);
        }
    });

    $( "#checkBtn" ).click(function() {
        alert( "Handler for .click() called." );
    });

    $( "#nextBtn" ).click(function() {
        alert( "Handler for .click() called." );
    });


});