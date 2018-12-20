package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.itemdate;


public class NewItemdao {
	public void newItem(String brandName,String itemName,String detail,String price,String fileName) throws SQLException {

		Connection conn = null;
	    List<itemdate> userList = new ArrayList<itemdate>();

	    try {
	        // データベースへ接続
	        conn = DBManeger.getConnection();

	        // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql = " INSERT INTO w_item (brand_name,item_name,detail,price,file_name,create_date,update_date) VALUES (?,?,?,?,?,now(),now())";

	         // SELECTを実行し、結果表を取得
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, brandName);
	        pStmt.setString(2, itemName);
	        pStmt.setString(3, detail);
	        pStmt.setString(4, price);
	        pStmt.setString(5, fileName);
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
	public void newBrand(String brandName,String fileName) throws SQLException {

		Connection conn = null;
	    List<itemdate> userList = new ArrayList<itemdate>();

	    try {
	        // データベースへ接続
	        conn = DBManeger.getConnection();

	        // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql = " INSERT INTO w_brand (brand_name,file_name) VALUES (?,?)";

	         // SELECTを実行し、結果表を取得
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, brandName);
	        pStmt.setString(2, fileName);
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



