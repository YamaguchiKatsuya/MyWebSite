package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDetaildao;
import model.itemdate;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/ItemDetailServlet")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailServlet() {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemDetail.jsp");
		dispatcher.forward(request, response);



		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		System.out.println(id);
		ItemDetaildao ItemDetaildao = new ItemDetaildao();
		itemdate item = ItemDetaildao.findById(id);

		ArrayList<itemdate> cart = (ArrayList<itemdate>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<itemdate>();
		}
		//カートに商品を追加。
		cart.add(item);
		//カート情報更新
		session.setAttribute("cart", cart);

		response.sendRedirect("CartServlet");
	}

}
