package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.itemdate;


public class NewItemdao {
	public void newItem(String itemName,String detail,int price,String fileName) throws SQLException {

		Connection conn = null;
	    List<itemdate> userList = new ArrayList<itemdate>();

	    try {
	        // データベースへ接続
	        conn = DBManeger.getConnection();

	        // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql = " INSERT INTO w_item (item_name,detail,price,file_name,create_date,update_date) VALUES (?,?,?,?,now(),now())";

	         // SELECTを実行し、結果表を取得
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, itemName);
	        pStmt.setString(2, detail);
	        pStmt.setInt(3, price);
	        pStmt.setString(4, fileName);
	        pStmt.executeUpdate();
	        // 結果表に格納されたレコードの内容を
	        // Employeeインスタンスに設定し、ArrayListインスタンスに追加

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;

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



