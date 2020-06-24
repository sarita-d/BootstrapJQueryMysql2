package pe.edu.upeu.ventas.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.dao.ProductoDao;
import pe.edu.upeu.ventas.entity.Categoria;
import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.util.Conexion;

public class ProductoDaoImp implements ProductoDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Producto u) {
		// TODO Auto-generated method stub
		int x = 0;
		String sql ="INSERT INTO producto (idproducto, idcategoria, nom_producto, precio, cantidad) VALUES (NULL, ?, ?, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdcategoria());
			ps.setString(2, u.getNom_producto());
			ps.setDouble(3, u.getPrecio());
			ps.setInt(4, u.getCantidad());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int update(Producto u) {
		// TODO Auto-generated method stub
		int x = 0;
		String sql = "UPDATE producto SET idcategoria = ?, nom_producto = ?, precio = ?, cantidad = ? WHERE idproducto = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdcategoria());
			ps.setString(2, u.getNom_producto());
			ps.setDouble(3, u.getPrecio());
			ps.setInt(4, u.getCantidad());
			ps.setInt(5, u.getIdproducto());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		int x = 0;
		// TODO Auto-generated method stub
		String sql= "DELETE FROM producto WHERE idproducto= ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return x;
	}

	@Override
	public List<Map<String,Object>> read(int id) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = "select c.idcategoria, c.nom_categoria, "+
		             "p.idproducto, p.nom_producto, "+ 
				     "p.precio, p.cantidad from producto as p,"+
		             " categoria as c where c.idcategoria= p.idcategoria and p.idproducto=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>();
                map.put("idcategoria", rs.getInt("idcategoria"));
                map.put("nom_categoria", rs.getString("nom_categoria"));
                map.put("idproducto", rs.getInt("idproducto"));
                map.put("nom_producto", rs.getString("nom_producto"));
                map.put("precio", rs.getDouble("precio"));
                map.put("cantidad", rs.getInt("cantidad"));
			    list.add(map);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<Map<String,Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = "select c.idcategoria, c.nom_categoria, "+
		             "p.idproducto, p.nom_producto, "+ 
				     "p.precio, p.cantidad from producto as p,"+
		             " categoria as c where c.idcategoria= p.idcategoria";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>();
                map.put("idcategoria", rs.getInt("idcategoria"));
                map.put("nom_categoria", rs.getString("nom_categoria"));
                map.put("idproducto", rs.getInt("idproducto"));
                map.put("nom_producto", rs.getString("nom_producto"));
                map.put("precio", rs.getDouble("precio"));
                map.put("cantidad", rs.getInt("cantidad"));
			    list.add(map);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
