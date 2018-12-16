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

import dao.Itemdao;
import dao.buyDetaildao;
import dao.buydao;
import dao.dbmethoddao;
import model.buyDetail;
import model.buydate;
import model.itemdate;
import model.userdate;

/**
 * Servlet implementation class BuyResultServlet
 */
@WebServlet("/BuyResultServlet")
public class BuyResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		System.out.println(id);
		int Id=Integer.parseInt(id);
		try {
			//選択された配送方法IDを取得

			//選択されたIDをもとに配送方法Beansを取得
			model.dbmethod userSelectDMB = dbmethoddao.getDeliveryMethodDataBeansByID(Id);
			request.setAttribute("userSelectDMB", userSelectDMB);

			ArrayList<itemdate> cart = (ArrayList<itemdate>) session.getAttribute("cart");
			//合計金額
			int totalPrice = Itemdao.getTotalItemPrice(cart);
			request.setAttribute("totalPrice", totalPrice);

			userdate u=(userdate) session.getAttribute("userInfo");
			int userId=u.getId();

			buydao buydao=new buydao();
			int buyId=buydao.buyInfo(userId, totalPrice, Id);
			for (itemdate cartInItem : cart) {
				buyDetail bddb = new buyDetail();
				bddb.setBuyId(buyId);
				bddb.setItemId(cartInItem.getId());
				buyDetaildao.insertBuyDetail(bddb);
			}

			buydate resultBDB = buydao.getBuyDataBeansByBuyId(buyId);
			request.setAttribute("resultBDB", resultBDB);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/buyresult.jsp");
			dispatcher.forward(request, response);

			session.removeAttribute("cart");
	} catch (Exception e) {
		e.printStackTrace();

}
	}
}
