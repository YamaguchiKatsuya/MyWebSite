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

import dao.ItemDetaildao;
import dao.Updatedao;
import model.itemdate;

/**
 * Servlet implementation class ItemUpdateServlet
 */
@WebServlet("/ItemUpdateServlet")
@MultipartConfig(location="C:\\Users\\山口　勝也\\Documents\\GitHub\\MyWebSite\\Project\\WatchStore\\WebContent\\img", maxFileSize=1048576)
public class ItemUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		ItemDetaildao ItemDetaildao = new ItemDetaildao();
		itemdate item = ItemDetaildao.findById(id);

		/** テーブルに該当のデータが見つかった場合 **/
		// セッションにユーザの情報をセット
		request.setAttribute("itemDate", item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemUpdate.jsp");
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
        int price = Integer.parseInt(request.getParameter("price"));
        Part part = request.getPart("file_name");
        String id = request.getParameter("id");

        String Price=Integer.toString(price);

        if (itemName.equals("")||detail.equals("")||Price.equals("")){
			// リクエストスコープにエラーメッセージをセット
		request.setAttribute("errMsg", "入力された内容は正しくありません。");

		HttpSession session = request.getSession();

		String Id = request.getParameter("id");
		ItemDetaildao ItemDetaildao = new ItemDetaildao();
		itemdate item = ItemDetaildao.findById(Id);

		/** テーブルに該当のデータが見つかった場合 **/
		// セッションにユーザの情報をセット
		request.setAttribute("itemDate", item);



			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}
        Updatedao updatedao = new Updatedao();

        if (part.getSubmittedFileName().isEmpty()) {

        	updatedao.updateFile(id, itemName, detail, price);

		}

        else{

        	String name = this.getFileName(part);
            String name2 = new Date().getTime() + name;
            part.write(name2);
            System.out.println(getServletContext().getRealPath("/img") + "/" + name2);


			updatedao.updateItem(id, itemName, detail, price,name2);

		}




			 response.sendRedirect("ItemListServlet");
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


