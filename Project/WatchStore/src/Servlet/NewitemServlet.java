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

import dao.NewItemdao;

/**
 * Servlet implementation class NewitemServlet
 */
@WebServlet("/NewitemServlet")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class NewitemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewitemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF//jsp/itemnew.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String itemName = request.getParameter("item_name");
        String detail = request.getParameter("detail");
        int price = Integer.parseInt(request.getParameter("price"));
        String fileName = request.getParameter("file_name");

        String Price=Integer.toString(price);

        if (itemName.equals("")||detail.equals("")||Price.equals("")||fileName.equals("")){
			// リクエストスコープにエラーメッセージをセット
		request.setAttribute("errMsg", "入力された内容は正しくありません。");


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemnew.jsp");
			dispatcher.forward(request, response);
			return;
		}
        NewItemdao newitemdao = new NewItemdao();
		try {
			newitemdao.newItem(itemName,detail,price,fileName);

		} catch (SQLException e) {

			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemnew.jsp");
			dispatcher.forward(request, response);
			return;

		}



        response.sendRedirect("NewItemConnectionServlet");


	}

}
