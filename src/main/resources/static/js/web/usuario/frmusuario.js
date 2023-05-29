$(document).on("click", "#btnagregar", function(){
	$("#txtnombre").val("");
	$("#txtcorreo").val("");
	$("#txtcontra").val("");
	$("#hddidregistrousuario").val("0");
	$("#modalUsuario").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtnombre").val($(this).attr("data-nombre_usuario"));
	$("#txtcorreo").val($(this).attr("data-correo_usuario"));
	$("#txtcontra").val($(this).attr("data-contrasenia_usuario"));
	$("#hddidregistrousuario").val($(this).attr("data-id_usuario"));
	$("#modalUsuario").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/usuario/registrarUsuario",
		contentType: "application/json",
		data: JSON.stringify({
			id_usuario: $("#hddidregistrousuario").val(),
			nombre_usuario: $("#txtnombre").val(),
			correo_usuario: $("#txtcorreo").val(),
			contrasenia_usuario: $("#txtcontra").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarUsuario();
		}
	});
	$("#modalUsuario").modal("hide");
})

$(document).on("click", ".btneliminarusuario", function(){
	$("#hddideliminarusuario").val("");
	$("#hddideliminarusuario").val($(this).attr("data-id_usuario"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar el "+ 
			$(this).attr("data-nombre_usuario")+"?");
	$("#modalEliminarUsuario").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/usuario/eliminarUsuario",
		data: JSON.stringify({
			idsala: $("#hddideliminarusuario").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarUsuario();
		}
	})
	$("#modalEliminarUsuario").modal("hide");
})

function ListarUsuario(){
	$.ajax({
		type: "GET",
		url: "/usuario/listarUsuarios",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblsala > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblusuario > tbody").append("<tr>"+
						"<td>"+value.id_usuario+"</td>"+
						"<td>"+value.nombre_usuario+"</td>"+
						"<td>"+value.correo_usuario+"</td>"+
						"<td>"+value.contrasenia_usuario+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_usuario='"+value.id_usuario+"'"+
							" data-nombre_usuario='"+value.nombre_usuario+"'"+
							" data-correo_usuario='"+value.correo_usuario+"'"+
							" data-contrasenia_usuario='"+value.contrasenia_usuario+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarusuario'"+	
							" data-id_usuario='"+value.id_usuario+"'"+
							" data-nombre_usuario='"+value.nombre_usuario+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





