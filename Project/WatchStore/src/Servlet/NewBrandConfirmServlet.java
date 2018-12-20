package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewItemdao;
import model.brandDate;

/**
 * Servlet implementation class NewBrandConfirmServlet
 */
@WebServlet("/NewBrandConfirmServlet")
public class NewBrandConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBrandConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		brandDate b = (brandDate) session.getAttribute("brand");

		request.setAttribute("b", b);

		session.removeAttribute("brand");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF//jsp/newBrandConfirm.jsp");
		dispatcher.forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String brandName = request.getParameter("brand_name");
		String fileName = request.getParameter("file_name2");
        String MyAction = request.getParameter("MySubmit");




        if(MyAction.equals("action")){

		NewItemdao newitemdao = new NewItemdao();
		try {
			newitemdao.newBrand(brandName,fileName );

		} catch (SQLException e) {

			request.setAttribute("errMsg", "その商品名は既に登録されています。");
			brandDate b=new brandDate(brandName);

        	HttpSession session = request.getSession();session.setAttribute("b", b);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newBrand.jsp");
			dispatcher.forward(request, response);
			return;

		}

		response.sendRedirect("NewBrandConnectionServlet");

        }
        if(MyAction.equals("return")){

        	brandDate b=new brandDate(brandName);

        	HttpSession session = request.getSession();session.setAttribute("b", b);

        	response.sendRedirect("NewBrandServlet");
        }

	}


}
