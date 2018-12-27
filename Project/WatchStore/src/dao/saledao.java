package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.saledate;

public class saledao {
	public void newSale(String brandName,String sale,String startDate,String finishDate) throws SQLException {

		Connection conn = null;
	    List<saledate> saleList = new ArrayList<saledate>();

	    try {
	        // データベースへ接続
	        conn = DBManeger.getConnection();

	        // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql = " INSERT INTO w_sale (brand_name,sale,start_date,finish_date) VALUES (?,?,?,?)";

	         // SELECTを実行し、結果表を取得
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, brandName);
	        pStmt.setString(2, sale);
	        pStmt.setString(3, startDate);
	        pStmt.setString(4, finishDate);
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
	public List<saledate> findAll() {
        Connection conn = null;
        List<saledate> saleList = new ArrayList<saledate>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

         // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM w_sale where now() <= finish_date ORDER BY start_date asc ";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String brandName = rs.getString("brand_name");
                String sale = rs.getString("sale");
                String startDate = rs.getString("start_date");
                String finishDate = rs.getString("finish_date");

                saledate saledate = new saledate(id,brandName ,sale, startDate, finishDate );

                saleList.add(saledate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return saleList;
    }

		public saledate findById(String Id) {
	        Connection conn = null;
	        try {
	            // データベースへ接続
	            conn = DBManeger.getConnection();

	            // SELECT文を準備
	            String sql = "SELECT * FROM w_sale WHERE id = "+Id ;
	             // SELECTを実行し、結果表を取得
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
	            if (!rs.next()) {
	                return null;
	            }
	                int id = rs.getInt("id");
	                String brandName = rs.getString("brand_name");
	                String sale = rs.getString("sale");
	                String startDate = rs.getString("start_date");
	                String finishDate = rs.getString("finish_date");


	            return new saledate(id,brandName ,sale, startDate, finishDate );


	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            // データベース切断

	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        }
	}

		public void updateId(String id,String brandName,String sale,String startDate,String finishDate) {
	        Connection conn = null;
	        List<saledate> saleList = new ArrayList<saledate>();

	        try {
	            // データベースへ接続
	            conn = DBManeger.getConnection();

	            // SELECT文を準備
	            // TODO: 未実装：管理者以外を取得するようSQLを変更する
	            String sql = "UPDATE w_sale SET brand_name=?,sale=?,start_date=?,finish_date=? WHERE id = "+id;


	             // SELECTを実行し、結果表を取得
	            PreparedStatement pStmt = conn.prepareStatement(sql);

	            pStmt.setString(1, brandName);
	            pStmt.setString(2, sale);
	            pStmt.setString(3, startDate);
	            pStmt.setString(4, finishDate);
	            pStmt.executeUpdate();
	            // 結果表に格納されたレコードの内容を
	            // Employeeインスタンスに設定し、ArrayListインスタンスに追加

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






