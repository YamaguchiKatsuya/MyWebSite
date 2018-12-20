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

import dao.Itemdao;
import dao.UserdateDetaildao;
import model.brandDate;
import model.userdate;

/**
 * Servlet implementation class TopLoginServlet
 */
@WebServlet("/TopLoginServlet")
public class TopLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		if((userdate) session.getAttribute("userInfo")!=null){

		userdate u = (userdate) session.getAttribute("userInfo");

		session.removeAttribute("userInfo");


		String id=Integer.toString(u.getId());

		UserdateDetaildao UserdateDetaildao = new UserdateDetaildao();
		userdate user = UserdateDetaildao.findById(id);

		/** テーブルに該当のデータが見つかった場合 **/
		// セッションにユーザの情報をセット
		session.setAttribute("userInfo", user);
		}

		Itemdao itemdao = new Itemdao();
		List<brandDate> brandList = itemdao.findBrand();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("brandList", brandList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/TopLogin.jsp");
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
