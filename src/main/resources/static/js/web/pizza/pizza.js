$(document).on("click","#btnAgregar",function (){
    $("#txtNombre").val("");
    $("#txtDescripcion").val("");
    $("#hddIdPizza").val("0");
    $("#txtPrecio").val("");
    $("#modalPizza").modal("show");
})

$(document).on("click", "#btnGuardar", function(){
    $.ajax({
        type: "POST",
        url: "/Pizza/registrarPizza",
        contentType: "application/json",
        data: JSON.stringify({
            id_pizza: $("#hddIdPizza").val(),
            nombre: $("#txtNombre").val(),
            descripcion: $("#txtDescripcion").val(),
            precio: parseFloat($("#txtPrecio").val())

        }),
        success: function(resultado){
            alert(resultado.mensaje);
            listarPizza();
        }
    });
    $("#modalPizza").modal("hide");
})
function listarPizza(){
    $.ajax({
        type: "GET",
        url: "/Pizza/listarPizzas",
        dataType: "json",
        success: function(resultado){
            //console.log(resultado);
            $("#tblPizza > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblPizza > tbody").append("<tr>"+
                    "<td>"+value.id_pizza+"</td>"+
                    "<td>"+value.nombre+"</td>"+
                    "<td>"+value.descripcion+"</td>"+
                    "<td>"+value.precio+"</td>"+
                    "<td>"+
                    "<button type='button' class='btn btn-success btnActualizar'"+
                    " data-id_pizza='"+value.id_pizza+"'"+
                    " data-nombre='"+value.nombre+"'"+
                    " data-descripcion='"+value.descripcion+"'"+
                    " data-precio='"+value.precio+"'"+
                    "><i class='fas fa-pen'></i></button></td>"+
                    "<td>"+
                    "<button type='button' class='btn btn-danger btnEliminarPizza'"+
                    " data-id_pizza='"+value.id_pizza+"'"+
                    " data-nombre='"+value.nombre+"'"+
                    "><i class='fas fa-trash'></i></button></td>"+
                    "</tr>")
            })


        }
    })
}
$(document).on("click", ".btnActualizar", function(){
    $("#txtNombre").val($(this).attr("data-nombre"));
    $("#txtDescripcion").val($(this).attr("data-descripcion"));
    $("#txtPrecio").val($(this).attr("data-precio"));
    $("#hddIdPizza").val($(this).attr("data-id_pizza"));
    console.log($(this).attr("data-nombre"))
    $("#modalPizza").modal("show");
});
$(document).on("click", "#btnEliminar", function(){
    $.ajax({
        type: "DELETE",
        contentType: 'application/json',
        url: "/Pizza/eliminarPizza",
        data: JSON.stringify({
            id_pizza: $("#hddidEliminarPizza").val()
        }),
        success: function(resultado){
            alert(resultado.mensaje);
            listarPizza();
        }
    })
    $("#modalEliminarPizza").modal("hide");
})

$(document).on("click", ".btnEliminarPizza", function(){
    $("#hddidEliminarPizza").val("");
    $("#hddidEliminarPizza").val($(this).attr("data-id_pizza"));
    $("#mensajeeliminar").text("¿Está seguro de eliminar la "+
        $(this).attr("data-nombre")+"?");
    $("#modalEliminarPizza").modal("show");
})