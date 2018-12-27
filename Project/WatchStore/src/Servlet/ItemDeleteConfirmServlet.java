package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDetaildao;
import model.saledate;

/**
 * Servlet implementation class ItemDeleteConfirmServlet
 */
@WebServlet("/ItemDeleteConfirmServlet")
public class ItemDeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDeleteConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		ItemDetaildao ItemDetaildao = new ItemDetaildao();
		saledate item = ItemDetaildao.findById(id);

		/** テーブルに該当のデータが見つかった場合 **/
		// セッションにユーザの情報をセット
		request.setAttribute("itemDate", item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemDelete.jsp");
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
