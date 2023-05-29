$(document).on("click", "#btnagregar", function(){
	$("#txtcapacidad").val("");
	$("#txtdisponibilidad").val("");
	$("#hddidregistromesa").val("0");
	$("#modalMesa").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtcapacidad").val($(this).attr("data-capacidad"));
	$("#txtdisponibilidad").val($(this).attr("data-disponible"));
	$("#hddidregistromesa").val($(this).attr("data-id_mesa"));
	$("#modalMesa").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/mesa/registrarMesa",
		contentType: "application/json",
		data: JSON.stringify({
			id_mesa: $("#hddidregistromesa").val(),
			capacidad: $("#txtcapacidad").val(),
			disponible: $("#txtdisponibilidad").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarMesa();
		}
	});
	$("#modalMesa").modal("hide");
})

$(document).on("click", ".btneliminarmesa", function(){
	$("#hddideliminarmesa").val("");
	$("#hddideliminarmesa").val($(this).attr("data-id_mesa"));
	$("#mensajeeliminar").text("¿Está seguro de la mesa número"+ 
			$(this).attr("data-id_mesa")+"?");
	$("#modalEliminarMesa").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/mesa/eliminarMesa",
		data: JSON.stringify({
			id_mesa: $("#hddideliminarmesa").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarMesa();
		}
	})
	$("#modalEliminarMesa").modal("hide");
})

function ListarMesa(){
	$.ajax({
		type: "GET",
		url: "/mesa/listarMesas",
		dataType: "json",
		success: function(resultado){
			$("#tblmesa > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblmesa > tbody").append("<tr>"+
						"<td>"+value.id_mesa+"</td>"+
						"<td>"+value.capacidad+"</td>"+
						"<td>"+value.disponible+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_mesa='"+value.id_mesa+"'"+
							" data-capacidad='"+value.capacidad+"'"+
							" data-disponible='"+value.disponible+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarmesa'"+	
							" data-id_mesa='"+value.id_mesa+"'"+
							" data-capacidad='"+value.capacidad+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}
