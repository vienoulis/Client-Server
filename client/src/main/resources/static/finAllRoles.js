$.ajax({
    url: "http://localhost:8080/GET/role/list",
    success: function (data) {
        const selectorEdit = document.querySelector(".user-roles-edit");
        const selectorDelete = document.querySelector(".user-roles-delete");
        const selectorNew = document.querySelector(".user-roles-new");
        data.forEach( el=>{
            let option = document.createElement('option');
            option.innerHTML = el;
            selectorDelete.appendChild(option);
        });
        data.forEach(el=>{
            let option = document.createElement('option');
            option.innerHTML = el;
            selectorEdit.appendChild(option);
        });
        data.forEach(el=>{
            let option = document.createElement('option');
            option.innerHTML = el;
            selectorNew.appendChild(option);
        });
    }
});
