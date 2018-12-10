package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.itemdate;

public class Itemdao {

	public List<itemdate> findAll() {
        Connection conn = null;
        List<itemdate> itemList = new ArrayList<itemdate>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

         // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM w_item ";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String itemName = rs.getString("item_name");
                String detail = rs.getString("detail");
                int price = rs.getInt("price");
                String fileName = rs.getString("file_name");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                itemdate item = new itemdate(id, itemName, detail, price, fileName, createDate, updateDate);

                itemList.add(item);
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
        return itemList;
    }
	public List<itemdate> search(String itemName, String detail,String price1,String price2) {
	    Connection conn = null;
	    List<itemdate> itemList = new ArrayList<itemdate>();

	    try {
	        // データベースへ接続
	        conn = DBManeger.getConnection();



	     // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql = "SELECT * FROM w_item WHERE id<>1 ";

		if (!itemName.isEmpty()) {
			sql += "AND item_name like '%" + itemName + "%' ";

		}
		if (!detail.isEmpty()) {
			sql += "AND detail like '%" + detail + "%' ";

		}
		if (!price1.isEmpty()) {
			sql += "AND price>='" + price1 + "' ";

		}
		if (!price2.isEmpty()) {
			sql += "AND price<='" + price2 + "' ";
		}

	         // SELECTを実行し、結果表を取得
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        // 結果表に格納されたレコードの内容を
	        // Employeeインスタンスに設定し、ArrayListインスタンスに追加
	        while (rs.next()) {
                int id = rs.getInt("id");
                String itemname = rs.getString("item_name");
                String Detail = rs.getString("detail");
                int price = rs.getInt("price");
                String fileName = rs.getString("file_name");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                itemdate item = new itemdate(id, itemname, Detail, price, fileName, createDate, updateDate);

                itemList.add(item);
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
	    return itemList;
	}

	public List<itemdate> searchuser(String searchWord,String price1,String price2) {
	    Connection conn = null;
	    List<itemdate> itemList = new ArrayList<itemdate>();

	    try {
	        // データベースへ接続
	        conn = DBManeger.getConnection();



	     // SELECT文を準備
	        // TODO: 未実装：管理者以外を取得するようSQLを変更する
	        String sql="SELECT*FROM w_item WHERE id<>1 ";

		if (!searchWord.isEmpty()) {
			sql += "AND item_name like '%"+searchWord+"%' OR detail like '%"+searchWord+"%' ";

		}

		if (!price1.isEmpty()) {
			sql += "AND price>='" + price1 + "' ";

		}
		if (!price2.isEmpty()) {
			sql += "AND price<='" + price2 + "' ";
		}

	         // SELECTを実行し、結果表を取得
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        // 結果表に格納されたレコードの内容を
	        // Employeeインスタンスに設定し、ArrayListインスタンスに追加
	        while (rs.next()) {
                int id = rs.getInt("id");
                String itemname = rs.getString("item_name");
                String Detail = rs.getString("detail");
                int price = rs.getInt("price");
                String fileName = rs.getString("file_name");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                itemdate item = new itemdate(id, itemname, Detail, price, fileName, createDate, updateDate);

                itemList.add(item);
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
	    return itemList;
	}
}
