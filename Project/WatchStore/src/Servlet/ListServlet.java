package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Logindao;
import model.userdate;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Logindao loginDao = new Logindao();
		List<userdate> userList = loginDao.findAll();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String userName = request.getParameter("user_name");
        String address = request.getParameter("address");
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");

        Logindao loginDao = new Logindao();
		List<userdate> userList = loginDao.search(userName,address,date1,date2);

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("userList", userList);

RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
dispatcher.forward(request, response);

}

}
