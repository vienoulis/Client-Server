$("#updateFormInput").click(function () {
    $.ajax({
        url: "http://localhost:8081/POST/client/update",
        type: "POST",
        data: $("#updateForm").serialize(),
        success: function (data) {
            let id= data.id;
            let tr = document.getElementById(id);
            tr.id= id;
            let roles = "";
            data.roleSet.forEach(obj => {
                roles = roles + " " + obj.role;
            });
            tr.innerHTML = '<td> ' + data.id + '</td>' +
            '<td> ' + data.name + '</td>' +
            '<td> ' + data.lastName + '</td>' +
            '<td> ' + data.age + '</td>' +
            '<td> ' + data.email + '</td>' +
            '<td> ' + roles + '</td>' +
            '<td> <button id ="edit' + data.id + '" class="btn edit-button btn-info" data-toggle="modal" data-target="#editModal" data-whatever="' + data.id + '" > Edit </button></td>' +
            '<td> <button id ="delete' + data.id + '" class="btn delete-button btn-danger" data-toggle="modal" data-target="#deleteModal" data-whatever="' + data.id + '"> Delete </button></td>';
        }
    });
});
$("#deleteFormInput").click(function () {
    $.ajax({
        url: "http://localhost:8081/POST/client/delete",
        type: "POST",
        data: $("#deleteForm").serialize(),
        success: function (data) {
            $('#' + data).empty();
        }
    });
});