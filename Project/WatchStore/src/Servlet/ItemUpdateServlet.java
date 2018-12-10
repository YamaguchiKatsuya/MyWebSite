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
import dao.Updatedao;
import model.itemdate;

/**
 * Servlet implementation class ItemUpdateServlet
 */
@WebServlet("/ItemUpdateServlet")
public class ItemUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemUpdateServlet() {
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
		itemdate item = ItemDetaildao.findById(id);

		/** テーブルに該当のデータが見つかった場合 **/
		// セッションにユーザの情報をセット
		request.setAttribute("itemDate", item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemUpdate.jsp");
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
        String id = request.getParameter("id");

        String Price=Integer.toString(price);

        if (itemName.equals("")||detail.equals("")||Price.equals("")||fileName.equals("")){
			// リクエストスコープにエラーメッセージをセット
		request.setAttribute("errMsg", "入力された内容は正しくありません。");


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}
        Updatedao updatedao = new Updatedao();

			updatedao.updateItem(id, itemName, detail, price,fileName);


			 response.sendRedirect("ItemListServlet");
	}
	}


