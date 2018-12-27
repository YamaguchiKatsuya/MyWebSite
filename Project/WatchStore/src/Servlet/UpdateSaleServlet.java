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
import dao.saledao;
import model.brandDate;
import model.saledate;

/**
 * Servlet implementation class UpdateSaleServlet
 */
@WebServlet("/UpdateSaleServlet")
public class UpdateSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if(session.getAttribute("errMsg")!=null){

			String e=(String)session.getAttribute("errMsg");


			request.setAttribute("errMsg", e);

			session.removeAttribute("errMsg");
		}
			String id = request.getParameter("id");
			saledao saledao = new saledao();
			saledate saledate = saledao.findById(id);

			/** テーブルに該当のデータが見つかった場合 **/
			// セッションにユーザの情報をセット
			request.setAttribute("saledate", saledate);

			Itemdao itemdao = new Itemdao();
			List<brandDate> brandList = itemdao.findBrand();

			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("brandList", brandList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SaleUpdate.jsp");
			dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

        // リクエストパラメータの取得
		String id = request.getParameter("id");
		String brandName = request.getParameter("brand_name");
        String sale = request.getParameter("sale");
        String startDate = request.getParameter("start_date");
        String finishDate = request.getParameter("finish_date");

        if (brandName.equals("")||sale.equals("")||startDate.equals("")||finishDate.equals("")){
			// リクエストスコープにエラーメッセージをセット
		session.setAttribute("errMsg", "入力された内容は正しくありません。");


		response.sendRedirect("NewSaleServlet");
			return;
		}

        saledao saledao=new saledao();
        saledao.updateId(id, brandName, sale, startDate, finishDate);

        response.sendRedirect("SaleListServlet");
	}

}
