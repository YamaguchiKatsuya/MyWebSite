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

import dao.buydao;
import model.buydate;
import model.itemdate;

/**
 * Servlet implementation class UserBuyHistoryDetailServlet
 */
@WebServlet("/UserBuyHistoryDetailServlet")
public class UserBuyHistoryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBuyHistoryDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();


		String id = request.getParameter("id");

		buydao buy=new buydao();
		List<buydate> buyList=buy.findbuy(id);
		List<itemdate> itemList=buy.findData(id);

		session.setAttribute("buyList", buyList);
		request.setAttribute("itemList", itemList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userbuyhistory.jsp");
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
