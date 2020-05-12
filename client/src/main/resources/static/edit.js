$('.update-modal').on('show.bs.modal', function (event) {
    const button = $(event.relatedTarget); // Button that triggered the modal
    const id = button.data('whatever'); // Extract info from data-* attributes
    const modal = $(this);
    $.ajax({
        url: "http://localhost:8081/GET/client/user/by_id",
        method: "GET",
        data: 'id='+ id,
        success: function (data) {
            modal.find('.modal-body .user-id').val(data.id);
            modal.find('.modal-body .user-name').val(data.name);
            modal.find('.modal-body .user-last-name').val(data.lastName);
            modal.find('.modal-body .user-age').val(data.age);
            modal.find('.modal-body .user-email').val(data.email);
            modal.find('.modal-body .user-password').val(data.password);
        }
    });
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
});