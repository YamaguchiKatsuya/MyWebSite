package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.userdate;

public class newdao {
public void newUser(String userName,String address,String birthDate,String password) throws SQLException {

	Connection conn = null;
    List<userdate> userList = new ArrayList<userdate>();

    try {
        // データベースへ接続
        conn = DBManeger.getConnection();

        // SELECT文を準備
        // TODO: 未実装：管理者以外を取得するようSQLを変更する
        String sql = " INSERT INTO w_user (user_name,address,birth_date,password,create_date,update_date) VALUES (?,?,?,?,now(),now())";

         // SELECTを実行し、結果表を取得
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, userName);
        pStmt.setString(2, address);
        pStmt.setString(3, birthDate);
        pStmt.setString(4, password);
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


