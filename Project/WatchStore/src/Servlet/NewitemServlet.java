package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.itemdate;

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
		HttpSession session = request.getSession();

		if(session.getAttribute("i")!=null){
			itemdate d = (itemdate) session.getAttribute("i");

			request.setAttribute("d", d);

			session.removeAttribute("i");
		}

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
        String price = request.getParameter("price");
        String fileName = request.getParameter("file_name");


        if (itemName.equals("")||detail.equals("")||price.equals("")||fileName.equals("")){
			// リクエストスコープにエラーメッセージをセット
		request.setAttribute("errMsg", "入力された内容は正しくありません。");


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemnew.jsp");
			dispatcher.forward(request, response);
			return;
		}

		itemdate item=new itemdate(itemName,detail,price,fileName);


		HttpSession session = request.getSession();session.setAttribute("item", item);


        response.sendRedirect("NewItemConfirmServlet");


	}

}
