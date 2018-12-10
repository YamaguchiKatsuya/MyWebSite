package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserdateDetaildao;
import model.userdate;

/**
 * Servlet implementation class UserdateDetailServlet
 */
@WebServlet("/UserdateDetailServlet")
public class UserdateDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserdateDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();


		String id = request.getParameter("id");
		System.out.println(id);
		UserdateDetaildao UserdateDetaildao = new UserdateDetaildao();
			userdate user = UserdateDetaildao.findById(id);

			/** テーブルに該当のデータが見つかった場合 **/
			// セッションにユーザの情報をセット
			request.setAttribute("userDate", user);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdatedetail.jsp");
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
