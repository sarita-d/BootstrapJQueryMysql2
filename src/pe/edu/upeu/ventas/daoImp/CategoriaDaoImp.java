package pe.edu.upeu.ventas.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.ventas.dao.CategoriaDao;
import pe.edu.upeu.ventas.entity.Categoria;
import pe.edu.upeu.ventas.util.Conexion;


public class CategoriaDaoImp implements CategoriaDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Categoria u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Categoria u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Categoria read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> readAll() {
		// TODO Auto-generated method stub
		List<Categoria> list = new ArrayList<>();
		String sql = "select *from categoria";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Categoria a = new Categoria();
				a.setIdcategoria(rs.getInt("idcategoria"));
				a.setNombre(rs.getString("nom_categoria"));
			    list.add(a);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
