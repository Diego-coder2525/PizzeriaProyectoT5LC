$(document).on("click", "#btnagregar", function(){
    $("#cbousuario").empty();
    $("#cbomesa").empty();
    $("#txtfecha").empty();
    $("#txtestado").val("");
    $("#hddidregistrosala").val("0");
    $.ajax({
        type: "GET",
        url: "/reserva/listarReservas",
        dataType: "json",
        success: function(resultado){
            //console.log(resultado);
            if(resultado.length > 0){
                $.each(resultado, function(index, value){
                    $("#cbousuario").append(
                        `<option value="${value.idusuario.idusuario}">
								${value.idusuario.nombre_usuario}</option>`
                    );
                    $("#cbomesa").append(
                        `<option value="${value.idmesa.id_mesa}">
								${value.idmesa.id_mesa}</option>`
                    );
                })
            }
        }
    })
    $("#modalReserva").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#cbousuario").val($(this).attr("data-usuario_reserva"));
    $("#cbomesa").val($(this).attr("data-mesa-reserva"));
    $("#txtfecha").val($(this).attr("data-fecha-reserva"));
    $("#txtestado").val($(this).attr("data-estado-reserva"));
    $("#hddidregistroreserva").val($(this).attr("data-id_reserva"));
    $.ajax({
        type: "GET",
        url: "/reserva/listarReservas",
        dataType: "json",
        success: function(resultado){
            //console.log(resultado);
            if(resultado.length > 0){
                $.each(resultado, function(index, value){
                    $("#cbousuario").append(
                        `<option value="${value.idusuario.idusuario}">
								${value.idusuario.nombre_usuario}</option>`
                    );
                    $("#cbomesa").append(
                        `<option value="${value.idmesa.id_mesa}">
								${value.idmesa.id_mesa}</option>`
                    );
                })
            }
        }
    })
    $("#modalReserva").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/reserva/registrarReserva",
        contentType: "application/json",
        data: JSON.stringify({
            id_reserva: $("#hddidregistroreserva").val(),
            usuario_reserva: $("#cbousuario").val(),
            mesa_reserva: $("#cbomesa").val(),
            fecha_reserva: $("#txtfecha").val(),
            estado_reserva: $("#txtestado").val()
        }),
        success: function(resultado){
            alert(resultado.mensaje);
            ListarReserva();
        }
    });
    $("#modalReserva").modal("hide");
})

$(document).on("click", ".btneliminarreserva", function(){
    $("#hddideliminarreserva").val("");
    $("#hddideliminarreserva").val($(this).attr("data-id_reserva"));
    $("#mensajeeliminar").text("¿Está seguro de eliminar la reserva ?");
    $("#modalEliminarReserva").modal("show");
})
$(document).on("click", "#btneliminar", function(){
    $.ajax({
        type: "DELETE",
        contentType: 'application/json',
        url: "/reserva/eliminarReserva",
        data: JSON.stringify({
            idreserva: $("#hddideliminarreserva").val()
        }),
        success: function(resultado){
            alert(resultado.mensaje);
            ListarReserva();
        }
    })
    $("#modalEliminarReserva").modal("hide");
})

function ListarReserva(){
    $.ajax({
        type: "GET",
        url: "/reserva/listarReservas",
        dataType: "json",
        success: function(resultado){
            //console.log(resultado);
            $("#tblreserva > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblreserva > tbody").append("<tr>"+
                    "<td>"+value.id_reserva+"</td>"+
                    "<td>"+value.usuario_reserva+"</td>"+
                    "<td>"+value.mesa_reserva+"</td>"+
                    "<td>"+value.fecha_reserva+"</td>"+
                    "<td>"+value.estado_reserva+"</td>"+
                    "<td>"+
                    "<button type='button' class='btn btn-success btnactualizar'"+
                    " data-id_reserva='"+value.id_usuario+"'"+
                    " data-usuario_reserva='"+value.usuario_reserva+"'"+
                    " data-mesa_reserva='"+value.mesa_reserva+"'"+
                    " data-fecha_reserva='"+value.fecha_reserva+"'"+
                    " data-estado_reserva='"+value.estado_reserva+"'"+
                    "><i class='fas fa-pen'></i></button></td>"+
                    "<td>"+
                    "<button type='button' class='btn btn-danger btneliminarreserva'"+
                    " data-id_reserva='"+value.id_reserva+"'"+
                    "><i class='fas fa-trash'></i></button></td>"+
                    "</tr>")
            })


        }
    })
}





