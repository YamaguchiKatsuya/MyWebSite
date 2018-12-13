package Servlet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.newdao;
import model.userdate;

/**
 * Servlet implementation class NewuserServlet
 */
@WebServlet("/NewuserServlet")
public class NewuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewuserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		userdate u = (userdate) session.getAttribute("user");

		request.setAttribute("u", u);

		session.removeAttribute("user");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF//jsp/newconfirm.jsp");
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
        String MyAction = request.getParameter("MySubmit");

        if(MyAction.equals("action")){

        	//ハッシュを生成したい元の文字列
        String source = "pass";
        //ハッシュ生成前にバイト配列に置き換える際のCharset
        Charset charset = StandardCharsets.UTF_8;
        //ハッシュアルゴリズム
        String algorithm = "MD5";

        //ハッシュ生成処理
        byte[] bytes;
        String result = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));


        result = DatatypeConverter.printHexBinary(bytes);

        //標準出力
        System.out.println(result);
	} catch (NoSuchAlgorithmException e1) {
		// TODO 自動生成された catch ブロック
		e1.printStackTrace();

	}



     // リクエストスコープにエラーメッセージをセット
		newdao newdao = new newdao();
		try {
			newdao.newUser(userName,address,birthDate,result);

		} catch (SQLException e) {

			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userdatenew.jsp");
			dispatcher.forward(request, response);
			return;

		}



        response.sendRedirect("TopLoginServlet");
        }

        if(MyAction.equals("return")){

        	userdate d=new userdate(userName, address, birthDate, pass);

        	HttpSession session = request.getSession();session.setAttribute("d", d);

        	response.sendRedirect("NewConfirmServlet");
        }








}
}

