$(document).ready(function(){
listarProducto();
listarCat(0)
limpiar();
$("#cant").numeric();
jQuery('#precio').keyup(function () { this.value = this.value.replace(/[^0-9\.]/g,''); });

});
$("#boton").click(function(){
	var cat= $("#cat").val();	
	var prod= $("#prod").val();
	var precio= $("#precio").val();
	var cant = $("#cant").val();
	var id = $("#id").val();
	if(id==0){
		$.post( "hc", {cat :cat,prod:prod,precio:precio,cant:cant, opc:3}).done(function(data){
			limpiar();
			listarCat(0)
			listarProducto();
			});
	}else{
		bootbox.confirm("Desea Modificar?", function(result) {
		if(result){
		 	bootbox.alert("Registro Modificado Correctamente...!", function() {		
			$.post( "hc", {idcat :cat, prod:prod, precio:precio, cant:cant, idp:id, opc:6}).done(function(data){
				$("#id").val(0);
				limpiar();
				listarCat(0)
				listarProducto();			
			});
		 	});
		}else{
	    	bootbox.alert("El registro no se Modifico...!");
	    	limpiar();
			listarCat(0)
			listarProducto();
	    }});		
	}
});
function listarCat(x){
	var i, c =1;
	$("#cat").empty().append('<option selected="selected" value="test">Seleccione Escuela</option>')
		$.get("hc", {opc : "1"}, 
		function(data) {
		var d = JSON.parse(data);
		for (i = 0; i < d.length; i++) {
			if (x == d[i].idcategoria) {
				$("#cat").append(
						"<option selected='selected' value='" + d[i].idcategoria + "'>"
								+ d[i].nombre + "</option>");
			} else {
				$("#cat").append(
						"<option value='" + d[i].idcategoria + "'>"
								+ d[i].nombre + "</option>");
			}
		}
	});	
}

function listarProducto(){
	var i, c =1;
	$.get("hc",{opc:"2"},function(data){	
		var d = JSON.parse(data);
		$('#tablita tbody').empty();
		for(i=0;i<d.length;i++){
			$("#tablita tbody").append("<tr><td style='color:blue'>"+c+"</td><td>"+d[i].nom_categoria+"</td><td>"+d[i].nom_producto+"</td><td>"+d[i].precio+"</td><td>"+d[i].cantidad+
			"</td><td><a href='#' style='color:green' onclick='modificar("+d[i].idproducto+")'><i class='far fa-edit'></i></a></td><td><a href='#' style='color:red' onclick='eliminar("+d[i].idproducto+")'><i class='far fa-trash-alt'></i></a></td></tr>")
			c++;
		}
	});
}

function eliminar(id){	
	bootbox.confirm("Desea Eliminar?", function(result) {
    if(result){
    	bootbox.alert("Registro Eliminado Correctamente...!", function() {
    		$.get("hc",{id:id,opc:5},function(data){
     			limpiar();
    			listarCat(0);
    			listarProducto();
		});
    	});
		 
    }else{
    	bootbox.alert("El registro no se Elimino...!")
    }});
}
function modificar(id){	
	$.post("hc",{id:id,opc:4},function(data){
		var x = JSON.parse(data);
		$("#prod").val(x[0].nom_producto);
		$("#precio").val(x[0].precio);
		$("#cant").val(x[0].cantidad);
		$("#id").val(x[0].idproducto);		
		listarCat(x[0].idcategoria);
	});
}
function limpiar(){
	$("#prod").val("");
	$("#precio").val("");
	$("#cant").val("");
	$("#prod").focus();
}
