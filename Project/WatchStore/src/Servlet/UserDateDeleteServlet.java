package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Deletedao;
import dao.UserdateDetaildao;
import model.userdate;

/**
 * Servlet implementation class UserDateDeleteServlet
 */
@WebServlet("/UserDateDeleteServlet")
public class UserDateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDateDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		UserdateDetaildao UserdateDetaildao = new UserdateDetaildao();
			userdate user = UserdateDetaildao.findById(id);

			/** テーブルに該当のデータが見つかった場合 **/
			// セッションにユーザの情報をセット
			request.setAttribute("userDate", user);

		Deletedao deletedao = new Deletedao();
		deletedao.deleteId(id);

		response.sendRedirect("ListServlet");

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Deletedao deletedao = new Deletedao();
		deletedao.deleteId(id);

		response.sendRedirect("ListServlet");

	}

}
