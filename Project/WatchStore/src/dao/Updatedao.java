package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.itemdate;
import model.userdate;

public class Updatedao {
	public void updateId(String id,String address,String pass,String name,String BirthDate) {
        Connection conn = null;
        List<userdate> userList = new ArrayList<userdate>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "UPDATE w_user SET password=?,name=?,birth_date=?,address=? WHERE id = "+id;


             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, pass);
            pStmt.setString(2, name);
            pStmt.setString(3, BirthDate);
            pStmt.setString(4, address);
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


public void passdateId(String id,String name,String BirthDate,String address)  {
    Connection conn = null;
    List<userdate> userList = new ArrayList<userdate>();

    try {
        // データベースへ接続
        conn = DBManeger.getConnection();

        // SELECT文を準備
        // TODO: 未実装：管理者以外を取得するようSQLを変更する
        String sql = "UPDATE w_user SET user_name=?,birth_date=?,address=? WHERE id = "+id;


         // SELECTを実行し、結果表を取得
        PreparedStatement pStmt = conn.prepareStatement(sql);

        pStmt.setString(1, name);
        pStmt.setString(2, BirthDate);
        pStmt.setString(3, address);
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
public void updateItem(String id, String itemName, String detail, int price, String fileName) {
    Connection conn = null;
    List<itemdate> userList = new ArrayList<itemdate>();

    try {
        // データベースへ接続
        conn = DBManeger.getConnection();

        // SELECT文を準備
        // TODO: 未実装：管理者以外を取得するようSQLを変更する
        String sql = "UPDATE w_item SET item_name=?,detail=?,price=?,file_name=? WHERE id = "+id;


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

    public void updateFile(String id, String itemName, String detail, int price) {
        Connection conn = null;
        List<itemdate> userList = new ArrayList<itemdate>();

        try {
            // データベースへ接続
            conn = DBManeger.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "UPDATE w_item SET item_name=?,detail=?,price=? WHERE id = "+id;


             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, itemName);
            pStmt.setString(2, detail);
            pStmt.setInt(3, price);
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





