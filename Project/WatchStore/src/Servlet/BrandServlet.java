package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Itemdao;
import model.brandDate;
import model.itemdate;

/**
 * Servlet implementation class BrandServlet
 */
@WebServlet("/BrandServlet")
public class BrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Itemdao itemdao = new Itemdao();
		String id = request.getParameter("id");
		brandDate date=itemdao.findBrand(id);
		request.setAttribute("date", date);

		List<itemdate> brand=itemdao.brand(id);
		for(itemdate b:brand){
		System.out.println(b.getFileName2());
		System.out.println(b.getFileName());
		}

		request.setAttribute("brand", brand);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Brand.jsp");
		dispatcher.forward(request, response);



		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
