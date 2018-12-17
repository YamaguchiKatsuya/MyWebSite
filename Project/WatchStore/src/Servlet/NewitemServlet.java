package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.itemdate;

/**
 * Servlet implementation class NewitemServlet
 */
@WebServlet("/NewitemServlet")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class NewitemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewitemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if(session.getAttribute("i")!=null){
			itemdate d = (itemdate) session.getAttribute("i");

			request.setAttribute("d", d);

			session.removeAttribute("i");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF//jsp/itemnew.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String itemName = request.getParameter("item_name");
        String detail = request.getParameter("detail");
        String price = request.getParameter("price");
        Part part = request.getPart("file_name");

        if (itemName.equals("")||detail.equals("")||price.equals("")||part == null){
			// リクエストスコープにエラーメッセージをセット
		request.setAttribute("errMsg", "入力された内容は正しくありません。");


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemnew.jsp");
			dispatcher.forward(request, response);
			return;
		}

        String name = this.getFileName(part);
        String name2 = new Date().getTime() + name;
        part.write(getServletContext().getRealPath("/img") + "/" + name2);
        System.out.println(getServletContext().getRealPath("/img") + "/" + name2);


		itemdate item=new itemdate(itemName,detail,price,name);


		HttpSession session = request.getSession();session.setAttribute("item", item);


        response.sendRedirect("NewItemConfirmServlet");


	}
	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }

}
