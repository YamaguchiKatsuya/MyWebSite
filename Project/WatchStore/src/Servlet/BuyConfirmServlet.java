package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dbmethoddao;
import model.itemdate;

/**
 * Servlet implementation class BuyConfirmServlet
 */
@WebServlet("/BuyConfirmServlet")
public class BuyConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<itemdate> cart = (ArrayList<itemdate>) session.getAttribute("cart");
		if(cart.size()==0){
			response.sendRedirect("CartServlet");
		}else {

		ArrayList<model.dbmethod> dMDBList;
		try {
			dMDBList = dbmethoddao.getAllDeliveryMethodDataBeans();
			request.setAttribute("dmdbList", dMDBList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BuyConfirm.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		}


	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
