Swal.fire({
	title: 'Bienvenido',
	text: 'Sarita Diaz',
	icon: 'success',
	timer: 5000,
	timerProgressBar: true
})

$("#delete-p").click(function (){
			swal({
			  title: "¿Está seguro?",
			  text: "Una vez eliminado, no podrá recuperar este archivo!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				swal("El archivo ha sido eliminado!", {
				  icon: "success",
				});
			  } else {
				swal("Operación cancelada!");
			  }
			});	
		});