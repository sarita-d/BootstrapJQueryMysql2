package pe.edu.upeu.ventas.test;

import com.google.gson.Gson;

import pe.edu.upeu.ventas.dao.ProductoDao;
import pe.edu.upeu.ventas.daoImp.ProductoDaoImp;

public class Test {
private static ProductoDao pd = new ProductoDaoImp();
private static Gson g = new Gson();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 listarP();
	}
  static void listarP() {
	  System.out.println(g.toJson(pd.readAll()));
  }
}
