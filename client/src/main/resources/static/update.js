$("#updateFormInput").click(function () {
    $.ajax({
        url: "http://localhost:8080/POST/update",
        type: "POST",
        data: $("#updateForm").serialize(),
        success: function (){
            $('#testtable').empty();
            createTable();
        }
    });
});
$("#deleteFormInput").click(function () {
    $.ajax({
        url: "http://localhost:8080/POST/delete",
        type: "POST",
        data: $("#deleteForm").serialize(),
        success: function (){
            $('#testtable').empty();
            createTable();
        }
    });
});