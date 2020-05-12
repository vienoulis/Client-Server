createTable();

function createTable() {
    let parent = document.querySelector("#testtable");
    // parent.empty();
    $.ajax({
        url: "http://localhost:8081/GET/client/user_list",
        success: function (data) {
            data.forEach(el => {
                let tr = document.createElement('tr');
                tr.id= el.id;
                let roles = "";
                el.roleSet.forEach(obj => {
                    roles = roles + " " + obj.role;
                });
                tr.innerHTML = '<td> ' + el.id + '</td>' +
                    '<td> ' + el.name + '</td>' +
                    '<td> ' + el.lastName + '</td>' +
                    '<td> ' + el.age + '</td>' +
                    '<td> ' + el.email + '</td>' +
                    '<td> ' + roles + '</td>' +
                    '<td> <button id ="edit' + el.id + '" class="btn edit-button btn-info" data-toggle="modal" data-target="#editModal" data-whatever="' + el.id + '" > Edit </button></td>' +
                    '<td> <button id ="delete' + el.id + '" class="btn delete-button btn-danger" data-toggle="modal" data-target="#deleteModal" data-whatever="' + el.id + '"> Delete </button></td>';
                parent.appendChild(tr);
            });
        }
    });
}
