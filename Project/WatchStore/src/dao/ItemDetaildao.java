package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.itemdate;


public class ItemDetaildao {
	public itemdate findById(String Id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM w_item WHERE id = "+Id ;
             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }
            int id = rs.getInt("id");
            String itemName = rs.getString("item_name");
            String detail = rs.getString("detail");
            String price = rs.getString("price");
            String fileName = rs.getString("file_name");
            String createDate = rs.getString("create_date");
            Date updateDate = rs.getDate("update_date");
            return new itemdate(id, itemName, detail, price, fileName, createDate, updateDate);


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

}
