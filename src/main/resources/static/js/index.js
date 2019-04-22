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

    $('#diplayWordTotal').text("( " + row_counter +" / " + (rowLength -1) + " )");

    var changeProgressStatus = function(progressCount, progressTotalWordCount){
        var progress = progressCount/ progressTotalWordCount;
        var progressBarLength = 346 * (progress);
        $('#goosander-progress').css('width', progressBarLength +'px');
        $('#goosander-progress').html(Math.ceil(progress*100) + '%');
        $('#diplayWordTotal').text("( " + progressCount +" / " + (rowLength -1) + " )");
    };

    $('#show-block').hide();

    $( "#previousBtn" ).click(function() {

        $('#show-block').hide();

        if(row_counter == 0){
            row_counter = rowLength -1;
        }else{
            row_counter = row_counter -1;
        }
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


    $( "#showBtn" ).click(function() {
        changeProgressStatus(row_counter,rowLength-1);

        $('#show-block').show();
        $('.show-header').show();
        $('#show-word').text( dic[row_counter][1] );
        $('#show-part-speech').text( dic[row_counter][2] );
        $('#show-definition').text( dic[row_counter][3] );
        $('#show-word-usage').text( dic[row_counter][4] );

    });

    $( "#nextBtn" ).click(function() {

        $('#show-block').hide();

        if(row_counter == rowLength -1){
            row_counter = 0;
        }else{
            row_counter = row_counter +1;
        }
    });


});