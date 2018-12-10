package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.itemdate;
import model.userdate;

public class Deletedao {

	public void deleteId(String Id)  {
		Connection conn = null;
		List<userdate> userList = new ArrayList<userdate>();

		try {
			// データベースへ接続
			conn = DBManeger.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = " DELETE FROM w_user WHERE id=" + Id;

			Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(sql);

		 } catch (SQLException e) {
	            e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}

	}
	public void deleteItem(String Id)  {
		Connection conn = null;
		List<itemdate> itemList = new ArrayList<itemdate>();

		try {
			// データベースへ接続
			conn = DBManeger.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = " DELETE FROM w_item WHERE id=" + Id;

			Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(sql);

		 } catch (SQLException e) {
	            e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}

	}
}


