$(document).ready(function() {

    var dic = [];

    var table = document.getElementById('dictionary-entries');

    var rowLength = table.rows.length;

    for(var x=0; x<rowLength; x+=1){
        var row = table.rows[x];
        dic[x] = [];

        for(var y = 0; y < 7; y++){
            dic[x][y] = row.cells[y].innerText;
        }

    }

});