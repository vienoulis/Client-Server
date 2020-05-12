$.ajax({
    url: "http://localhost:8081/GET/client/role/list",
    success: function (data) {
        const selectorEdit = document.querySelector(".user-roles-edit");
        const selectorDelete = document.querySelector(".user-roles-delete");
        const selectorNew = document.querySelector(".user-roles-new");
        data.forEach( el=>{
            let option = document.createElement('option');
            option.innerHTML = el.role;
            selectorDelete.appendChild(option);
        });
        data.forEach(el=>{
            let option = document.createElement('option');
            option.innerHTML = el.role;
            selectorEdit.appendChild(option);
        });
        data.forEach(el=>{
            let option = document.createElement('option');
            option.innerHTML = el.role;
            selectorNew.appendChild(option);
        });
    }
});
