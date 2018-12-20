package Servlet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.Logindao;
import model.userdate;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF//jsp/Login.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // リクエストパラメータの取得
        String userName = request.getParameter("userName");
        String pass = request.getParameter("password");

        //ハッシュを生成したい元の文字列
        String source = pass;
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




	Logindao logindao = new Logindao();
	userdate user = logindao.findById(userName, result);

	/** テーブルに該当のデータが見つからなかった場合 **/
	if(user==null)
	{
		// リクエストスコープにエラーメッセージをセット
		request.setAttribute("errMsg", "ユーザ名またはパスワードが異なります。");

		// ログインjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/** テーブルに該当のデータが見つかった場合 **/
	// セッションにユーザの情報をセット
	HttpSession session = request.getSession();session.setAttribute("userInfo",user);

	if(userName.equals("管理者")){
		response.sendRedirect("adminServlet");
		return;
	}

	// ユーザ一覧のサーブレットにリダイレクト
	response.sendRedirect("TopLoginServlet");

}

}

