$( document ).ready(function() {

    var isNumber = function (n) {
        return !isNaN(parseFloat(n)) && isFinite(n);
    }
    $('#error-message').hide();
    $("#message-one").html("<b></b>");
    $("#message-two").html("<b></b>");
    $("#message-three").html("<b></b>");

    var dicTable = $('#dictionary-entries').DataTable( {
        "pagingType": "full_numbers"
    } );

    var startButtonsPosition = function(changeButtons){

        $("#edit-entry").prop("disabled",changeButtons);
        $("#delete-entry").prop("disabled",changeButtons);
        $("#new-entry").prop("disabled",!( changeButtons ));

    };

    startButtonsPosition(true);

    var dataPage = {};
    var dataDatabase = {};
    var action= "";
    var id  = "";

    $('#dictionary-entries').on('click', 'tbody tr', function() {

        dataPage = dicTable.row( this ).data();

        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
            startButtonsPosition(true);
        }
        else {
            dicTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            startButtonsPosition(false);

        }
        console.log( 'You clicked on '+dataPage[0]+'\'s row' );

    });

    $("#new-entry").click(function() {
        $("#new-edit-title").text("New Entry");
        action = "new";

        $("#word").val("");
        $("#pos").val("");
        $("#desc").val("");
        $("#word-usage").val("");
        $("#right-count").val("");
        $("#total-try-count").val("");

        dataDatabase = {};

    });

    $("#edit-entry").click(function() {
        $("#new-edit-title").text("Edit Entry");
        action = "edit";

        $("#word").val(dataPage[1]);
        $("#pos").val(dataPage[2]);
        $("#desc").val(dataPage[3]);
        $("#word-usage").val(dataPage[4]);
        $("#right-count").val(dataPage[5]);
        $("#total-try-count").val(dataPage[6]);

    });



    $("#delete-entry").click(function() {
        startButtonsPosition(true);
        action = "delete";

        dicTable.row('.selected').remove().draw( false );

        $.ajax({
            type: "POST",
            url: "/delete/" +dataPage[0]
        });

    });

    $("#save").click(function(){

        console.log("ACTION: " + action);

        var right = $("#right-count").val();
        var total = $("#total-try-count").val();

        $('#error-message').hide();
        $("#message-one").html("<b></b>");
        $("#message-two").html("<b></b>");
        $("#message-three").html("<b></b>");


        if(isNumber(right) && isNumber(total) && ( parseFloat(total) !== 0) ) {

            dataDatabase["word"] = $("#word").val();
            dataDatabase["partOfSpeech"] = $("#pos").val();
            dataDatabase["definition"] = $("#desc").val();
            dataDatabase["wordUsage"] = $("#word-usage").val();
            dataDatabase["rightCount"] = $("#right-count").val();
            dataDatabase["totalTryCount"] = $("#total-try-count").val();


            if (action === "edit") {
                dicTable.row('.selected').remove().draw(false);
                dataDatabase["id"] = dataPage[0];
            }

            console.log("DATA being saved in the database: " + Object.values(dataDatabase));

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/save",
                data: JSON.stringify(dataDatabase),
                dataType: 'json',
                timeout: 600000,
                success: function (result) {
                    console.log(result);
                    id = result;

                    dicTable.row.add([
                        id,
                        dataDatabase["word"],
                        dataDatabase["partOfSpeech"],
                        dataDatabase["definition"],
                        dataDatabase["wordUsage"],
                        dataDatabase["rightCount"],
                        dataDatabase["totalTryCount"]
                    ]).draw(false);

                    startButtonsPosition(true);

                    $("#close").click();
                }
            });
        }else{
            $('#error-message').show();

            if(!isNumber(right)){
                $("#message-one").html("<b>Right Answers must be number.</b>");
            }

            if(!isNumber(total)){
                $("#message-two").html("<b>Total Tries must be number.</b>");
            }

            if( parseFloat(total) === 0){
                $("#message-three").html("<b>Total Tries can not be zero.</b>");
            }
        }



    });







});

