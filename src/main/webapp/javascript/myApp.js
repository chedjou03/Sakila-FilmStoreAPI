$(function(){
    $("#customerDataGrid").dxDataGrid({
        dataSource: customers,
        columns: ["First Name", "Last Name", "Email"],
        showBorders: true
    });
});