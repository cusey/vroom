$( document ).ready(function() {

    var dicTable = $('#dictionary-entries').DataTable( {
        "pagingType": "full_numbers"
    } );


    $("#edit-entry").prop("disabled",true);
    $("#delete-entry").prop("disabled",true);

    var data;

    $('#dictionary-entries').on('click', 'tbody tr', function() {

        data = dicTable.row( this ).data();

        if ( $(this).hasClass('selected') ) {

            $(this).removeClass('selected');

            $("#edit-entry").prop("disabled",true);
            $("#delete-entry").prop("disabled",true);
            $("#new-entry").prop("disabled",false);

        }
        else {
            dicTable.$('tr.selected').removeClass('selected');

            $(this).addClass('selected');
            $("#edit-entry").prop("disabled",false);
            $("#delete-entry").prop("disabled",false);
            $("#new-entry").prop("disabled",true);
        }

        console.log( 'You clicked on '+data[0]+'\'s row' );


    });

    $("#new-entry").click(function() {

    });

    $("#edit-entry").click(function() {

    });

    $("#delete-entry").click(function() {

        $("#edit-entry").prop("disabled",true);
        $("#delete-entry").prop("disabled",true);
        $("#new-entry").prop("disabled",false);

        dicTable.row('.selected').remove().draw( false );
    });


});

