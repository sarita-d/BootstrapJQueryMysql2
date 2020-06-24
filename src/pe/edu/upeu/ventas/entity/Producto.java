package pe.edu.upeu.ventas.entity;

public class Producto {
private int idproducto;
private int idcategoria;
private String nom_producto;
private double precio;
private int cantidad;

public Producto() {
}

public Producto(int idproducto, int idcategoria, String nom_producto, double precio, int cantidad) {
	this.idproducto = idproducto;
	this.idcategoria = idcategoria;
	this.nom_producto = nom_producto;
	this.precio = precio;
	this.cantidad = cantidad;
}

public int getIdproducto() {
	return idproducto;
}

public void setIdproducto(int idproducto) {
	this.idproducto = idproducto;
}

public int getIdcategoria() {
	return idcategoria;
}

public void setIdcategoria(int idcategoria) {
	this.idcategoria = idcategoria;
}

public String getNom_producto() {
	return nom_producto;
}

public void setNom_producto(String nom_producto) {
	this.nom_producto = nom_producto;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

}
