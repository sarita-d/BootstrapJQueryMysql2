package pe.edu.upeu.ventas.dao;

import java.util.List;

import pe.edu.upeu.ventas.entity.Categoria;


public interface CategoriaDao {
	public int create(Categoria u);
	public int update(Categoria u);
	public int delete(int id);
	public Categoria read(int id);
	public List<Categoria> readAll();

}
