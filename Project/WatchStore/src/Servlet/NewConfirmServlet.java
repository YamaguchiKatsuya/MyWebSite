package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.userdate;

/**
 * Servlet implementation class NewConfirmServlet
 */
@WebServlet("/NewConfirmServlet")
public class NewConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if(session.getAttribute("d")!=null){
			userdate d = (userdate) session.getAttribute("d");

			request.setAttribute("d", d);

			session.removeAttribute("d");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF//jsp/userdatenew.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String userName = request.getParameter("userName");
        String address = request.getParameter("address");
        String birthDate = request.getParameter("birthDate");
        String pass = request.getParameter("pass");
        String passk = request.getParameter("passk");
        if (!pass.equals(passk)) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力された内容は正しくありません。");


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdatenew.jsp");
			dispatcher.forward(request, response);
			return;
		}

        if (userName.equals("")||pass.equals("")||passk.equals("")||address.equals("")||birthDate.equals("")){
			// リクエストスコープにエラーメッセージをセット
		request.setAttribute("errMsg", "入力された内容は正しくありません。");


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdatenew.jsp");
			dispatcher.forward(request, response);
			return;
		}

     // リクエストスコープにエラーメッセージをセット
		userdate user=new userdate(userName,address,birthDate,pass);
		System.out.println(user.getUser_name());

		HttpSession session = request.getSession();session.setAttribute("user", user);
		System.out.println(request.getAttribute("user"));



        response.sendRedirect("NewuserServlet");

	}

}
