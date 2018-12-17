package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewItemdao;
import model.itemdate;

/**
 * Servlet implementation class NewItemConfirmServlet
 */
@WebServlet("/NewItemConfirmServlet")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class NewItemConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewItemConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		itemdate i = (itemdate) session.getAttribute("item");

		request.setAttribute("i", i);

		session.removeAttribute("item");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF//jsp/NewItemConfirm.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String itemName = request.getParameter("item_name");
        String detail = request.getParameter("detail");
        String price = request.getParameter("price");
        String fileName = request.getParameter("file_name");
        String MyAction = request.getParameter("MySubmit");




        if(MyAction.equals("action")){

		NewItemdao newitemdao = new NewItemdao();
		try {
			newitemdao.newItem(itemName,detail,price,fileName);

		} catch (SQLException e) {

			request.setAttribute("errMsg", "その商品名は既に登録されています。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewItemConfirm.jsp");
			dispatcher.forward(request, response);
			return;

		}

		response.sendRedirect("NewItemConnectionServlet");

        }
        if(MyAction.equals("return")){

        	itemdate i=new itemdate(itemName,detail,price,fileName);

        	HttpSession session = request.getSession();session.setAttribute("i", i);

        	response.sendRedirect("NewitemServlet");
        }

	}

}
