package pe.edu.upeu.ventas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ventas.dao.CategoriaDao;
import pe.edu.upeu.ventas.dao.ProductoDao;
import pe.edu.upeu.ventas.daoImp.CategoriaDaoImp;
import pe.edu.upeu.ventas.daoImp.ProductoDaoImp;
import pe.edu.upeu.ventas.entity.Producto;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/hc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDao pd1 = new ProductoDaoImp();
	private CategoriaDao cd = new CategoriaDaoImp();
	private Gson g = new Gson();
	int idp, idcat,cant; String prod; double precio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch(op) {
		case 1: //listar categoria
				out.println(g.toJson(cd.readAll()));
				break;
		case 2: //Listar productos
				out.println(g.toJson(pd1.readAll()));
			    break;
		case 3: //registrar producto
				pd1.create(new Producto(0,
				Integer.parseInt(request.getParameter("cat")),request.getParameter("prod"),
				Double.parseDouble(request.getParameter("precio")),Integer.parseInt(request.getParameter("cant"))));
		       out.println(g.toJson("Registro guardado correctamente"));
			         break;
		case 4: //Buscar produto por ID
				out.println(g.toJson(pd1.read(Integer.parseInt(request.getParameter("id")))));
	    break; //Eliminar producto
		case 5: int x = pd1.delete(Integer.parseInt(request.getParameter("id")));
				out.println(g.toJson(x));
	    break;
		case 6: //Modificar producto
				idp = Integer.parseInt(request.getParameter("idp"));
				idcat = Integer.parseInt(request.getParameter("idcat"));
				prod = request.getParameter("prod");
				precio = Double.parseDouble(request.getParameter("precio"));				
				cant = Integer.parseInt(request.getParameter("cant"));				
				out.println(g.toJson(pd1.update(new Producto(idp, idcat, prod, precio, cant))));
	    break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
