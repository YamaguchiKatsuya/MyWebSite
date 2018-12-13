package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.userdate;



public class UserdateDetaildao {

	public userdate findById(String Id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM w_user WHERE id = "+Id ;
             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }
                int id = rs.getInt("id");
                String userName = rs.getString("user_name");
                String address = rs.getString("address");
                String birthDate = rs.getString("birth_date");
                String Password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");

                return new userdate(id, userName, address, birthDate, Password, createDate, updateDate);



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
