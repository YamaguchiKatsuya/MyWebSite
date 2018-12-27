package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.saledao;
import model.saledate;

/**
 * Servlet implementation class NewSaleConfirmServlet
 */
@WebServlet("/NewSaleConfirmServlet")
public class NewSaleConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSaleConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		saledate s = (saledate) session.getAttribute("saledate");

		request.setAttribute("s", s);

		session.removeAttribute("saledate");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF//jsp/Newsaleconfirm.jsp");
		dispatcher.forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
		String brandName = request.getParameter("brand_name");
        String sale = request.getParameter("sale");
        String startDate = request.getParameter("start_date");
        String finishDate = request.getParameter("finish_date");
        String MyAction = request.getParameter("MySubmit");

        if(MyAction.equals("action")){

        	 saledao saledao=new saledao();
             try {
     			saledao.newSale(brandName, sale, startDate, finishDate);
     		} catch (SQLException e) {
     		// TODO 自動生成された catch ブロック
    			e.printStackTrace();

    			return;

    		}

    		response.sendRedirect("NewSaleConnectionServlet");

            }
            if(MyAction.equals("return")){

            	saledate s=new saledate(brandName,sale,startDate,finishDate);

            	HttpSession session = request.getSession();session.setAttribute("s", s);

            	response.sendRedirect("NewSaleServlet");
            }

    	}

    }



